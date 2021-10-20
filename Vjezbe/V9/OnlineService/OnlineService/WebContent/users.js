$(document).ready(function(){

    $('th').css('background','lightblue').css('font-weight','bold');
    $.get({

        url:'/OnlineService/UserServlet',
        success: function(data){
            //Odogovor se nalazi u data
            //Posot ocekujemo JSON listu , mozemo da iteriramo kroz data
            for (let user of data){
                let tbody = $('#korisnici tbody')//id tabele i njen element

                let firstname = $('<td>' + user.firstName + '</td>');
                let lastname = $('<td>' + user.lastName + '</td>');
                let username = $('<td>' + user.username + '</td>');
                let email = $('<td>' + user.email + '</td>');
                let phonenumber = $('<td>' + user.phoneNumber + '</td>');

                let tr = $('<tr></tr>');
                tr.append(firstname)
                    .append(lastname)
                    .append(username)
                    .append(email)
                    .append(phonenumber);

                tbody.append(tr);

            }

        }
    });

});