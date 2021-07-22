// funcao controla quantidade de caracteres
$(document).ready(function(){ 
    $('#characterLeft').text('Limite de ate 140 caracteres');
    $('#message').keydown(function () {
        var max = 140;
        var len = $(this).val().length;
        if (len >= max) {
            $('#characterLeft').text('Você ultrapassou o limite de caracteres');
            $('#characterLeft').addClass('red');
            $('#btnSubmit').addClass('disabled');            
        } 
        else {
            var ch = max - len;
            $('#characterLeft').text(ch + ' caracteres restantes');
            $('#btnSubmit').removeClass('disabled');
            $('#characterLeft').removeClass('red');            
        }
    });    
});

// Funcao botao enviar contato
function enviar(){
    alert("mensagem enviada com sucesso!");
}

// Funcao cadastrar com conta da google
function google(){
        alert("voce será redirecionado para: www.gmail.com.br");
        window.open('https://www.google.com/');
}


// Funcao cadastrar com conta facebook
function facebook(){
    alert("voce será redirecionado para: www.facebook.com.br");
    window.open('https://www.facebook.com/');
}