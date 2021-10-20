$(document).ready(function(){


    $("input").focusin(function(){

        $(this).css('background','cyan');
        if( $(this).val() == "" ){
            //$(this) -->input
            //input.parent --> <td>
            $(this).parent().append('<span>Morate unijeti ovo polje! </span>').css('color', 'red');
        }

    });

    $("input").focusout(function(){

        $(this).css('background','white');
    
        $(this).parent().children('span').remove();
    

    });

    $("form").submit(function(event){

        let valid = true;
        $("input").each(function(){

           
        //     if(! $(this).val()){

        //         $(this).parent().append('<span>Morate unijeti ovo polje! </span>').css('color', 'red');
        //         return false;
        //     }else{
        //         $(this).parent().children('span').remove();
    
        //     }
         });
        

            if(valid){

                let data = {
                    "firstName" : $("input[name=ime]").val(),
                    "lastName": $("input[name=prezime]").val(),
                    "username" : $("input[name=korisnickoIme]").val(),
                    "password" : $("input[name=lozinka]").val(),
                    "email" : $("input[name=email]").val(),
                    "phoneNumber" : $("input[name=brojTelefona]").val()
                }
    

                $.post("/OnlineService/UserServlet",
                    JSON.stringify(data),
                    function(data, status){
                        console.log(data);
                        console.log(status);
                        alert("Korisnik" + $("input[name = korisnickoIme]").val() + "je uspjesno registrovan " );
                    } 
                );
            }
            
            event.preventDefault();

       


    });



 });
     