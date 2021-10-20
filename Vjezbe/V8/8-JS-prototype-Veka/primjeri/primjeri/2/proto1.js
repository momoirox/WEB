window.addEventListener('load',function()
{
    var korisnik1 = {
        ime:"Pera",
        prezime: "Peric",
        lozinka: "pera"
    }


    var korisnik2 = korisnik1;
    korisnik2.ime = "Mika";

    alert("Moje ime je" + korisnik1.ime);
    if(korisnik2 == korisnik1)  {
        console.log("== poredi objekte po referenci")
    }

    if(korisnik2 === korisnik1) {
        console.log("=== poredi objekte po referenci")
    }
});