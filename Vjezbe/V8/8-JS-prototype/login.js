
//TODO 1: Na stranici login.html omoguciti logovanje dva korisnika (lozinke proizvoljne):  
// - Pera Peric 
// - Mika Mikic
var usersMap = {
   "pera" : new VeleprodajniKorisnik("Pera","Peric","pera"),
   "mika" : new VeleprodajniKorisnik("Mika","Mikic","mika")
};

function findUser(ime, lozinka){
       // //provjerimo da li korisnik postoji
       var valid = true;
       let message = document.querySelector('#poruka');
       message.innerText="";
       if(!(ime in usersMap)){
        message.innerText +="Ne postoji korisnik sa unesenim korisnickim imenom. \n";
        valid = false;
        }

        let kor = usersMap[ime];
        if(kor){

                if(!(kor.lozinka === lozinka)){
                    message.innerText +=" Neispravna lozinka.";
                    valid = false;
                }
            }
     return valid;
}
function validacija(forma) {
  
    let message = document.querySelector('#poruka');
    message.innerText="";
    var valid = true;
          
    let imeEl = document.getElementsByName('ime')[0];
    let ime = imeEl.value;
  

    if(!ime ){
        //|| !isNaN(ime)
        valid = false;
        imeEl.style.background = 'red';
        message.innerText += "Morate unijeti korisnicko ime. \n";
    }


    let lozEl = document.getElementsByName('lozinka')[0];
    let lozinka = lozEl.value;
    if(!lozinka){
        lozEl.style.background = 'red';
        valid = false;
        message.innerText += " Morate unijeti lozinku!\n";
    }
    if(valid){
        valid = findUser(ime,lozinka);
    }
    return valid;  
}
