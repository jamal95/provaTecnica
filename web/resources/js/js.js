$(document).ready(function () {

    $('.register-form-link').click(function (e) {
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        $('.login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('.login-form-link').click(function (e) {
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('.register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

    $('.generatecodes').click(function (e) {
        $.ajax({
            type: "POST",
            url: "generateCode",
            success: function (data) {
                alert("Añadido nuevo codigo en la lista!!");
            },
            error: function (e) {
            }
        });
    });
    $('.deleteCode').click(function () {
        var id = $(this).attr('id');
        var c = confirm("Seguro desea eliminar el código?");
        if (c) {
            $.ajax({
                type: "POST",
                url: "deleteCode/" + id,
                success: function (data) {
                    location.reload();
                },
                error: function (e) {
                    alert("Error al intentar eliminar el código");
                }
            });
        }
    });
    $('.redeemCode').click(function () {
        var id = $(this).attr('id');
        var c = confirm("Seguro desea bescambiar el código?");
        if (c) {
            $.ajax({
                type: "POST",
                url: "redeemCode/" + id,
                success: function (data) {
                    location.reload();
                },
                error: function (e) {
                    alert("Error al intentar bescambiar el código!!");
                }
            });
        }
    });
    $(function (){
        $(".ocultar").slideUp( 5000 );
    });
});



