function Korisnik(ime,prezime,lozinka)  {
    this.ime=ime;
    this.prezime=prezime;
    this.lozinka=lozinka;
   
}

Korisnik.prototype.punoIme=function() {
    return this.ime + " " + this.prezime;
}

function MaloprodajaKorisnik(ime,prezime,lozinka) {
    Korisnik.call(this,ime,prezime,lozinka);
}

//nasljedjivanje sa svim metodama 
MaloprodajaKorisnik.prototype=Object.create(Korisnik.prototype);
MaloprodajaKorisnik.prototype.construktor=MaloprodajaKorisnik;


MaloprodajaKorisnik.prototype.punoIme=function() {
    return "Maloprodajni korisnik," + this.ime + " " + this.prezime;//+ Korisnik.prototype.punoIme.call(this);
}

window.addEventListener('load',function()
{
    var korisnik1= new Korisnik("Pera","Peric","pera");
    var korisnik2=new MaloprodajaKorisnik("Mika","Mikic","mika");
    


    alert("Prvo ime je" + korisnik1.ime);
    alert("Drugo ime je" + korisnik2.ime);
    alert("Puno prvo ime je" + korisnik1.punoIme());
    alert("Puno drugo ime je" + korisnik2.punoIme());
    });