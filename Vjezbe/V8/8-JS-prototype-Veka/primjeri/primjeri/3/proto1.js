function Korisnik(ime,prezime,lozinka)  {
    this.ime = ime;
    this.prezime = prezime;
    this.lozinka = lozinka;
}

function Korisnik2(korisnik) {
    this.ime = korisnik.ime;
    this.prezime = korisnik.prezime;
    this.lozinka = korisnik.lozinka;

}

window.addEventListener('load',function()
{
   var korisnik1 = new Korisnik("Pera","Peric","pera");
   var korisnik2 = new Korisnik("Mika","Mikic","mika");
   var korisnik3 = new Korisnik2(korisnik2);
   korisnik3.ime = "Sima";


   var korisnik4={...korisnik1};  //Jason notacija

   korisnik4.ime="Djura";
    alert("Prvo ime je" + korisnik1.ime);
    alert("Drugo ime je" + korisnik2.ime);
    alert("Trece ime je" + korisnik3.ime);
    alert("Cetvrto ime je" + korisnik4.ime);


});