window.onload = function(event){ //zelimo da se ucita cijela html stranica i za nju se kreira dom stablo pa tek onda f - ja


    let users = [{'ime':'Petar','prezime':'Petrovic','jmbg':'1234432'},
                {'ime':'Ivan','prezime':'Blagic','jmbg':'9676876'},
                {'ime':'Marija','prezime':'Stevic','jmbg':'145765432'},
                {'ime':'Ines','prezime':'Petrovic','jmbg':'45764432'},
                {'ime':'Barbara','prezime':'Sims','jmbg':'127652'}    
            ];

            let tabela = document.getElementsByTagName('table')[0];

            for (user of users){

                let userTr = document.createElement('tr');

                let imeTd = document.createElement('td');
                let prezimeTd = document.createElement('td');            
                let jmbgTd = document.createElement('td');

                //dodaj tekst u svako polje
                imeTd.appendChild(document.createTextNode(user.ime));
                prezimeTd.appendChild(document.createTextNode(user.prezime));
                jmbgTd.appendChild(document.createTextNode(user.jmbg));

                userTr.appendChild(imeTd);
                userTr.appendChild(prezimeTd);
                userTr.appendChild(jmbgTd);

                tabela.appendChild(userTr);
            }

 };