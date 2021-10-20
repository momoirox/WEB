window.onload = function(){
	let queryParams = window.location.search;
	// TODO 2.1: Ukoliko u URLu na stranici webshop.html ne postoje podaci o korisniku, prebaciti se login.html
	if(!queryParams){
		window.location = 'login.html';
	}
	let korisnik = null;
	//ime=Maja&lozinka=Bajaa


	let param1 = queryParams.split('&')[0];
	let ime = param1.split('=')[1];
	// Ubaciti logiku za kreiranje korisnika
	if(ime === 'pera'){
		korisnik = new VeleprodajniKorisnik('Pera','Peric');
	}else if(ime === 'mika'){
		korisnik = new VeleprodajniKorisnik('Mika', 'Mikic');
	}else{
		window.location.href="login.html";
	}



	if (korisnik) {
		korisnik.stampaj();
	}
}