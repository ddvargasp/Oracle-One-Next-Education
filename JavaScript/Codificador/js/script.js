/*
La letra "e" es convertida para "enter"
La letra "i" es convertida para "imes"
La letra "a" es convertida para "ai"
La letra "o" es convertida para "ober"
La letra "u" es convertida para "ufat"
*/

function encriptar()
{
    var texto = document.getElementById("inputTexto").value.toLowerCase();
    //g realiza un reemplazo global en la linea u oración
    //i realiza un reemplazo que no distingue entre mayusculas o minusculas
    //m afecta a multiples lineas o párrafos
    var txtCifrado = texto.replace(/e/gim,"enter");
    var txtCifrado = txtCifrado.replace(/i/gim,"imes");
    var txtCifrado = txtCifrado.replace(/a/gim,"ai");
    var txtCifrado = txtCifrado.replace(/o/gim,"ober");
    var txtCifrado = txtCifrado.replace(/u/gim,"ufat");

    document.getElementById("muñeco-img").style.display = "none";
    document.getElementById("img-texto1").style.display = "none";
    document.getElementById("img-texto2").innerHTML  = txtCifrado;
    document.getElementById("copiar").style.display = "show";
    document.getElementById("copiar").style.display = "inherit";
}

function desencriptar()
{
    var texto = document.getElementById("inputTexto").value.toLowerCase();
    //g realiza un reemplazo global en la linea u oración
    //i realiza un reemplazo que no distingue entre mayusculas o minusculas
    //m afecta a multiples lineas o párrafos
    var txtCifrado = texto.replace(/enter/gim,"e");
    var txtCifrado = txtCifrado.replace(/imes/gim,"i");
    var txtCifrado = txtCifrado.replace(/ai/gim,"a");
    var txtCifrado = txtCifrado.replace(/ober/gim,"o");
    var txtCifrado = txtCifrado.replace(/ufat/gim,"u");

    document.getElementById("muñeco-img").style.display = "none";
    document.getElementById("img-texto1").style.display = "none";
    document.getElementById("img-texto2").innerHTML  = txtCifrado;
    document.getElementById("copiar").style.display = "show";
    document.getElementById("copiar").style.display = "inherit";
}

function copiar()
{
    var contenido = document.querySelector("#img-texto2");
    contenido.select();
    contenido.setSelectionRange(0, 99999);
    navigator.clipboard.writeText(contenido.value);
    alert("Se copió el texto con exito");
}