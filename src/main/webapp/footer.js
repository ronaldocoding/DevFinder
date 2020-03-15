addFooter();
function addFooter(){
    document.getElementById("footer").innerHTML+=
        '<link rel="stylesheet" type="text/css" href="footer.css">'+
        '<footer class="container py-5 px-5">'+
          '<div class="row">'+
            '<div class="col-12 col-md text-center">'+
                    '<img class="img-fluid noturno" src="imgs/logoNoturna.png">'+
            '</div>'+
            '<div class="col-6 col-md">'+
              '<h5>Desenvolvedores</h5>'+
              '<ul class="list-unstyled text-small">'+
                '<li><a href="#">Erica Medeiros</a></li>'+
                '<li><a href="#">Marlon Faria</a></li>'+
                '<li><a href="#">Monike Freitas</a></li>'+
                '<li><a href="#">Ronaldo Costa</a></li>'+
              '</ul>'+
            '</div>'+
            '<div class="col-6 col-md">'+
              '<h5>Endereço</h5>'+
              '<ul class="list-unstyled text-small">'+
                '<li><a href="#">Av. Sete de Setembro, 1975, IFAM, Manaus, AM - Brasil</a></li>'+
              '</ul>'+
            '</div>'+
            '<div class="col-6 col-md">'+
              '<h5>Contato</h5>'+
              '<ul class="list-unstyled text-small">'+
                '<li><a href="#">devfinder@gmail.com</a></li>'+
              '</ul>'+
            '</div>'+
            '</div>'+
        '</footer>';
}

