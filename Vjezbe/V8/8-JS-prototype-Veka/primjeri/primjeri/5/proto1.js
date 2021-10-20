
function Korisnik(ime,prezime,lozinka)  {
    this.ime=ime;
    this.prezime=prezime;
    this.lozinka=lozinka;
    this.punoIme=function() {
        return this.ime + " " + this.prezime;
    }
}
//funkcija se pravi za sa puno imena,a ne kao u prethodnom
//ali sad ce tu funkciju imati svi korisnici,uzima dosta memorije
// treba samo mozda referanca na tu funkciju
window.addEventListener('load',function()
{
    var korisnik1= new Korisnik("Pera","Peric","pera");
    var korisnik2=new Korisnik("Mika","Mikic","mika");
    


    alert("Prvo ime je" + korisnik1.ime);
    alert("Drugo ime je" + korisnik2.ime);
    alert("Puno prvo ime je" + korisnik1.punoIme());
    alert("Puno drugo ime je" + korisnik2.punoIme());
   
   
});