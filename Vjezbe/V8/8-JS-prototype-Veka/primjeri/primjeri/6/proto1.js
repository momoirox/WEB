

function Korisnik(ime,prezime,lozinka)  {
    this.ime=ime;
    this.prezime=prezime;
    this.lozinka=lozinka;
   
}

Korisnik.prototype.punoIme=function() {
    return this.ime + " " + this.prezime;
}
window.addEventListener('load',function()
{
    var korisnik1= new Korisnik("Pera","Peric","pera");
    var korisnik2=new Korisnik("Mika","Mikic","mika");
    


    alert("Prvo ime je" + korisnik1.ime);
    alert("Drugo ime je" + korisnik2.ime);
    alert("Puno prvo ime je" + korisnik1.punoIme());
    alert("Puno drugo ime je" + korisnik2.punoIme());
   
   });