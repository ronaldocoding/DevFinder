addFooter();
function addFooter(){
    document.getElementById("footer").innerHTML+=" <link rel=\"stylesheet\" type=\"text/css\" href=\"footer.css\">"+
            "<div class=\"container pt-5 border-bottom\">"+
    "<div class=\"row\">"+
      "<div class=\"col-md-3 col-sm-12 mb-3 text-center\">"+
          "<img class=\"img-fluid\" src=\"imgs/logo.png\"></img>"+
      "</div>"+
        "<div class=\"col-md-9 col-sm-12\">"+
        "<div class=\"col-md-3 col-sm-6 col-6 p-0 float-left mb-3\">"+
          "<h5 class=\"mb-4 font-weight-bold text-uppercase\">Equipe</h5>"+
        "<ul class=\"list-group\">"+
          "<li class=\"list-group-item bg-transparent border-0 p-0 mb-2\">Erica Medeiros</li>"+
          "<li class=\"list-group-item bg-transparent border-0 p-0 mb-2\">Marlon Faria</li>"+
          "<li class=\"list-group-item bg-transparent border-0 p-0 mb-2\">Monike Freitas</li>"+
          "<li class=\"list-group-item bg-transparent border-0 p-0 mb-2\">Ronaldo Costa</li>"+         
        "</ul>"+
        "</div>"+
        "<div class=\"col-md-3 col-sm-6 col-6 p-0 mb-3 float-left\">"+
          "<h5 class=\"mb-4 font-weight-bold text-uppercase\">Endereço</h5>"+
        "<ul class=\"list-group\">"+
          "<li class=\"list-group-item bg-transparent border-0 p-0 mb-2\">Av. Sete de Setembro, 1975, IFAM, Manaus, AM - Brasil</li>"+
        "</ul>"+
        "</div>"+
        "<div class=\"col-md-3 col-sm-6 col-6 mb-3 p-0 float-left\">"+
          "<h5 class=\"mb-4 font-weight-bold text-uppercase\">Contato</h5>"+
        "<ul class=\"list-group\">"+
          "<li class=\"list-group-item bg-transparent border-0 p-0 mb-2\">devfinder@gmail.com</li>"+
        "</ul>"+
        "</div>"+
         "</div>"+
    "</div>";
}

