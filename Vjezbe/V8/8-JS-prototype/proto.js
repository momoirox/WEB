function Korisnik(ime , prezime, lozinka){
    this.ime = ime;
    this.prezime = prezime;
    this.lozinka = lozinka;

}

Korisnik.prototype.ispis = function(tekst){
    var p = document.querySelector('#poruka'); // daje nam prvi element koji ima ID 'poruka', da gadjamo klasu stavili
    p.innerText = tekst;
}
Korisnik.prototype.punoIme = function(){
  return this.ime + " " + this.prezime;
}
function VeleprodajniKorisnik(ime, prezime, lozinka){
    Korisnik.call(this, ime , prezime, lozinka);
}
//da bismo preuzeli sve etode prototipa super klase
VeleprodajniKorisnik.prototype = Object.create(Korisnik.prototype);
VeleprodajniKorisnik.prototype.constructor = VeleprodajniKorisnik;

