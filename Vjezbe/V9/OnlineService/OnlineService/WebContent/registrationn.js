$(document).ready(function(){

    let inputElems = $("input");

    let inputNames = $("input[name = ime]");
    let forma = $("form"); //samo jedan form tag
    inputNames.focus(function(){
      
        inputNames.css("background-color","cyan");
      //  let allTds = $('td');
        let nameTd =  $("#nametd");
        $(nameTd).append('<span id="liked_txt"> Morate unijeti ime .</span>').css('color','red');

     });
     inputNames.blur(function(){
        inputNames.css("background-color","white");
        $("#liked_txt").remove();

     });
     
  
    
    forma.submit(function(event){

        let name = inputNames.val(); //preuzmemo vrijednost
        console.log(name);

        //treba da uzmem ime
        //  <td><input type="text" name="ime"/></td>,1
        let allTds = $('td');
        let nameTd = allTds[1];

        if(name ==''){
            $(nameTd).append("<p id='parag'> Morate unijeti ime. </p>");
           $( allTds[0]).css("color","red");
            
        }else{
            $('#parag').remove(); 
        }

        
        event.preventDefault();
    });
});