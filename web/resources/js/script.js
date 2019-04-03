//
// $(function(){
//     $('.addToCart').click(function(){
//         console.log($(this).attr('href'));
//         $.post($(this).attr('href')).done(function(data){
//             console.log(data);
//             $("#num-of-items").text(data);
//         });
//         return false;
//     })
// })


$(function(){
    $('.addToCart').click(function(){
        console.log($(this).attr('href'));
        $.post($(this).attr('href')).done(function(data){
            console.log(data);
            //it will print the number in the car view
            $("#num-of-items").text(data);
        });
        return false;
    })
})




$(function(){
    $('#searchBtn').click(searchProduct);

    function searchProduct(){
        var customerEmail = $('#email').val();
        //var cusomer = {email:customerEmail};
        $.post('reception',{email: customerEmail}, processData, "text")
    }

    function processData(data){
        console.log(data);
        data = JSON.parse(data);
        var td0=$('<td>').text(data.id);
        var td1 = $('<td>').text(data.email);
        var td2 = $('<td>').text(data.fullname);
        var td3 = $('<td>').text(data.telephone);
        var td4 = $('<td>').text(data.address);
        var tr = $('<tr>').append(td0).append(td1).append(td2).append(td3).append(td4);
        $('#custbody > tbody').append(tr);
    }
})