import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server
{
    private int port;
    private ServerSocket serverSocket;
    private static List<User> users = new ArrayList<User>();


    public Server(int port)
            throws IOException
    {
        this.port = port;
        this.serverSocket = new ServerSocket(this.port);
    }


    public void run()
    {
        System.out.println("Web server running on port: " + port);
        System.out.println("Document root is: " + new File("/static").getAbsolutePath() + "\n");

        Socket socket;

        while (true)
        {
            try
            {
                // prihvataj zahteve
                socket = serverSocket.accept();
                InetAddress addr = socket.getInetAddress();

                // dobavi resurs zahteva
                String resource = this.getResource(socket.getInputStream());
                
                // fail-safe
                if (resource == null)
                    continue;

                if (resource.equals(""))
                    resource = "static/index.html";

                System.out.println("Request from " + addr.getHostName() + ": " +  resource);

                // posalji odgovor
                this.sendResponse(resource, socket.getOutputStream());
                socket.close();
                socket = null;
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }


    private String getResource(InputStream is)
            throws IOException
    {
        BufferedReader dis = new BufferedReader(new InputStreamReader(is));
        String s = dis.readLine();

        // fail-safe
        if (s == null)
            return null;

        String[] tokens = s.split(" ");

        // prva linija HTTP zahteva: METOD /resurs HTTP/verzija
        // obradjujemo samo GET metodu
        String method = tokens[0];
        if (!method.equals("GET"))
            return null;

        // String resursa
        String resource = tokens[1];

        // izbacimo znak '/' sa pocetka
        resource = resource.substring(1);

        // ignorisemo ostatak zaglavlja
        String s1;
        while (!(s1 = dis.readLine()).equals(""))
            System.out.println(s1);

        return resource;
    }


    private void sendResponse(String resource, OutputStream os)
            throws IOException
    {
        PrintStream ps = new PrintStream(os);

    
        //CASE: Register
     	System.out.println("XXXXXXXXXX: " + resource);
    	if(resource.startsWith("registracija")) {
    		
    		registrujKorisnika(resource,ps);
    		return;	
    	
    	}
    	// GET/pretraga?ime=Maja&prezime=Blagi
    	
    	if(resource.startsWith("pretraga")) {
    		pretrazujKorisnika(resource,ps);
    		return;
    	}
        //prihvati?broj=" + u.getBroj()
    	if(resource.startsWith("prihvati")) {
    		String [] parts = resource.split("\\?");
    		
    		String broj = parts[1].split("=")[1];
    		int Broj = Integer.parseInt(broj);
    		System.out.println("OVJD JE BROJ: "+broj);
    		for (User u : users) {
    			if(u.getBroj() == Broj ) {
    				u.setOdobreno(true);
    			}
    		}
    		izlistajRegistracije(ps); 
    		
    		return;
    	}
        
        // zamenimo web separator sistemskim separatorom
        resource = resource.replace('/', File.separatorChar);
        File file = new File(resource);

    
        
        
        //Ovo je za iscitavanje datoteke
        if (!file.exists())
        {
            // ako datoteka ne postoji, vratimo kod za gresku
            String errorCode = "HTTP/1.0 404 File not found\r\n"
                    + "Content-type: text/html; charset=UTF-8\r\n\r\n<b>404 Not found:"
                    + file.getName() + "</b>";

            ps.print(errorCode);

//            ps.flush();
            System.out.println("Could not find resource: " + file);
            return;
        }

        // ispisemo zaglavlje HTTP odgovora
        ps.print("HTTP/1.0 200 OK\r\n\r\n");

        // a, zatim datoteku
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[8192];
        int len;

        while ((len = fis.read(data)) != -1)
            ps.write(data, 0, len);

        ps.flush();
        fis.close();
    }


	private void pretrazujKorisnika(String resource, PrintStream ps) {
		// TODO Auto-generated method stub
		String[] parts = resource.split("\\?");
		String params = parts[1]; 
		 
		String[] paramParts = params.split("&");
		
		for (String s : paramParts) {
			System.out.println("EVO EVO :"+ s + "\n"); 				 
		}
		
		
		
		String[] ime = paramParts[0].split("=");
		String Ime = ime[1];
		System.out.println(Ime);
		
		String[] prezime = paramParts[1].split("=");
		String Prezime = prezime[1];
		System.out.println(Prezime);
		
		prikaziPretragu(Ime, Prezime,ps);
		return;
		
		
	}


	private void prikaziPretragu(String ime, String prezime, PrintStream ps) {
		ps.print("HTTP/1.0 200 OK\r\n" + "Content-type: text/html; charset=UTF-8\r\n\r\n");

		StringBuilder listing = new StringBuilder(
				"<!DOCTYPE html><html><head><meta http-equiv='Content-Type' content='text/html' charset='UTF - 8'>");
		listing.append("<title>Registracije</title>");	
		listing.append("<body><h1>Korisnici koji zadovoljavaju kriterijum</h1>");
		
		listing.append("<table border='1'><tr><th>Broj registracije</th><th>Ime</th><th>Prezime</th><th>Strucna sprema</th><th>Zanimanje</th><th>"
				+ "Godiste</th><td>" + "..." + "</td></tr>");
		for (User u : users) {
			if(u.getIme().toUpperCase().startsWith(ime.toUpperCase()) && u.getPrezime().toUpperCase().startsWith(prezime.toUpperCase())) {
	
				if(u.getOdobreno() == false) {
					listing.append("<tr style=\"background-color:#ff4000\"><td>" + u.getBroj()+ "</td><td>" + u.getIme() + "</td><td>" + u.getPrezime() + 
							"</td><td>" + u.getSprema() + "</td><td>" + u.getZanimanje() + "</td><td>" + u.getGodiste() +"</td><td>" + "<a href=\"http://localhost:8014/prihvati?broj=" + u.getBroj() + "\">Prihvati</a></td></tr>");
					
				}
				else
				{//:#ff6347 zelena
					listing.append("<tr style=\"background-color:#bfff00\"><td>" + u.getBroj()+ "</td><td>" + u.getIme() + "</td><td>" + u.getPrezime() + "</td><td>" + u.getSprema() + "</td><td>" + u.getZanimanje() + "</td><td>" + u.getGodiste() + "</td></tr>");
				}
			
		}
		listing.append("</table><p><a href='../'>Povratak na pocetnu stranicu</a></p></body></html>");

		ps.print(listing.toString());
		
		}
	}

	private void registrujKorisnika(String resource, PrintStream ps) {
		String[] parts = resource.split("\\?");
		String params = parts[1]; 
		 
		String[] paramParts = params.split("&");
		
		for (String s : paramParts) {
			System.out.println("EVO EVO :"+ s + "\n"); 				 
		}
		
		String[] broj = paramParts[0].split("=");
		int Broj = Integer.parseInt(broj[1]);
		System.out.println(Broj);
		
		
		String[] ime = paramParts[1].split("=");
		String Ime = ime[1];
		System.out.println(Ime);
		
		String[] prezime = paramParts[2].split("=");
		String Prezime = prezime[1];
		System.out.println(Prezime);
		
		String[] sprema = paramParts[3].split("=");
		String Sprema = sprema[1];
		System.out.println(Sprema);
		
		String[] zanimanje = paramParts[4].split("=");
		String Zanimanje = zanimanje[1];
		System.out.println(Zanimanje);
		
		String[] godiste = paramParts[5].split("=");
		int Godiste = Integer.parseInt(godiste[1]);
		System.out.println(Godiste);
		
		
		users.add(new User(Broj,Ime,Prezime,Sprema,Zanimanje,Godiste));
		//pravimo str koja ispisuje sve to 
		// ps.print("HTTP/1.0 200 OK\r\n\r\n");
		 izlistajRegistracije(ps);
		
		
		 	
	}


	private void izlistajRegistracije(PrintStream ps) {
		// TODO Auto-generated method stub
		ps.print("HTTP/1.0 200 OK\r\n" + "Content-type: text/html; charset=UTF-8\r\n\r\n");
		StringBuilder listing = new StringBuilder(
				"<!DOCTYPE html><html><head><meta http-equiv='Content-Type' content='text/html' charset='UTF - 8'>");
		listing.append("<title> Registracije </title>");	
		listing.append("<body><h1>HTTP. Prikaz registracije</h1>");

		listing.append("<table border='1'><tr><th>Broj registracije</th><th>Ime</th><th>Prezime</th><th>Strucna sprema</th><th>Zanimanje</th><th>"
				+ "Godiste</th><td>" + "..." + "</td></tr>");
		for (User u : users) {
				if(u.getOdobreno() == false) {
					listing.append("<tr style=\"background-color:#ff4000\"><td>" + u.getBroj()+ "</td><td>" + u.getIme() + "</td><td>" + u.getPrezime() + 
							"</td><td>" + u.getSprema() + "</td><td>" + u.getZanimanje() + "</td><td>" + u.getGodiste() +"</td><td>" + "<a href=\"http://localhost:8014/prihvati?broj=" + u.getBroj() + "\">Prihvati</a></td></tr>");
					
				}
				else
				{//:#ff6347 zelena
					listing.append("<tr style=\"background-color:#bfff00\"><td>" + u.getBroj()+ "</td><td>" + u.getIme() + "</td><td>" + u.getPrezime() + "</td><td>" + u.getSprema() + "</td><td>" + u.getZanimanje() + "</td><td>" + u.getGodiste() + "</td></tr>");
				}
		}
		listing.append("</table><br/><form action=\"pretraga\" method=\"GET\"><Label>Ime:</Label> <input type=\"text\" name=\"ime\"/><Label>Prezime </Label> <input type=\"text\" name=\"prezime\"/><input type=\"submit\" value=\"Pretrazi\" /></form>");
										// GET/pretraga?ime=Maja&prezime=Blagi
	
	
	

	listing.append("<p><a href='../'>Povratak na pocetnu stranicu</a></p></body></html>");

	ps.print(listing.toString());
	
	}	


}
