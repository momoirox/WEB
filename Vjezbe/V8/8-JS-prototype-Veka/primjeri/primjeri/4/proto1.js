function Korisnik(ime,prezime,lozinka)  {
    this.ime=ime;
    this.prezime=prezime;
    this.lozinka=lozinka;
}



window.addEventListener('load',function()
{
    var korisnik1= new Korisnik("Pera","Peric","pera");
    var korisnik2=new Korisnik("Mika","Mikic","mika");
    
    korisnik1.punoIme=function() {
        return this.ime + " " + this.prezime; 
    }

    alert("Prvo ime je" + korisnik1.ime);
    alert("Drugo ime je" + korisnik2.ime);
    alert("Puno prvo ime je" + korisnik1.punoIme());
   

});