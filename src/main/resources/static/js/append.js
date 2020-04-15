var $footer = $('<footer class="container py-5 px-5"><div class="row">'+
                '<div class="col-12 col-md text-center"><img class="img-fluid noturno" th:src="@{/imgs/logoNoturna.png}"></div>'+
                '<div class="col-6 col-md"><h5>Desenvolvedores</h5>'+
                '<ul class="list-unstyled text-small">'+ 
                '<li><a href="https://github.com/Erigoddess">Erica Medeiros</a></li>'+
                '<li><a href="https://github.com/MarlonFL15">Marlon de Faria</a></li>'+
                '<li><a href="https://github.com/mnik3007">Monike Freitas</a></li>'+
                '<li><a href="https://github.com/Ronaldo64">Ronaldo Costa</a></li></ul></div>'+
                '<div class="col-6 col-md"><h5>Endereço</h5><ul class="list-unstyled text-small">'+
                '<li><a href="https://goo.gl/maps/hEkmvv2gVBFypU7g6">Av. Sete de Setembro, 1975, IFAM, Manaus, AM - Brasil</a></li></ul></div>'+
                '<div class="col-6 col-md"><h5>Contato</h5><ul class="list-unstyled text-small">'+
                '<li><a href="#">devfinder@gmail.com</a></li></ul></div></div></footer>');

var $topnav=$('<script> var logo= function(){if($( window ).width()<=710){$(".logsdo").addClass("small");$(".buscar").hide();}else{$(".logo").removeClass("small");$(".buscar").show();}};$(window).on("resize", logo);$(window).on("load", logo);</script>'+
              '<div class="container demo"><div class="top_navbar-side"><div class="top_menu-side">'+
              '<ul><li><div class="hamburger-side btn-degrade azul" data-toggle="modal" data-target="#sidebar">'+
              '<div class="one"></div><div class="two"></div><div class="three"></div></div></li><li>'+
              '<img th:src="@{/imgs/logo.png}"  class="logo"></li></ul>'+
              '<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"'+ 
              'aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">'+
              '<span class="navbar-toggler-icon"></span></button>'+
              '<ul><li class="buscar"><div class="buscar-caja"><input type="text" name="" class="buscar-txt" placeholder="Buscar..."/>'+
              '<a class="buscar-btn  btn-azul"><i class="fas fa-search"></i></a></div></li>'+
              '<li><div class="dropdown show"><a class="dropdown-togggle btn-degrade azul redondo" id="dropdownMenuLink"data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">'+
              '<i class="fa fa-bell"></i></a>'+
              '<div class="dropdown-menu" aria-labelledby="dropdownMenuLink"><h5>Notificações</h5></div></div></li>'+    
              '<li><a href="#" class="btn-degrade azul redondo"><i class="fas fa-user"></i></a></li>'+
              '</ul></div></div></div>');
var $sidebar_dev=$('<div class="modal left fade" id="sidebar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">'+
                   '<div class="modal-dialog" role="document"><div class="modal-content"><div class="modal-body">'+
                   '<ul id="menu-nav"><li><div class="hamburger-side btn-degrade azul" data-toggle="modal" data-target="#sidebar">'+
              '<div class="one"></div><div class="two"></div><div class="three"></div></div></li><li>'+
              '<img th:src="@{/imgs/logo.png}"  class="logo"></li></ul>'+
                   '<ul id="menu-list">'+
                   '<li><a href="devInicio.html"><span class="icon"><i class="fa fa-home" aria-hidden="true"></i></span><span class="title">Início</span></a></li>'+
                   '<li><a href="devDesafiosInscritos.html"><span class="icon"><i class="fa fa-code"></i></span><span class="title">Desafios Inscritos</span></a></li><li><a href="devConfiguracoes.html">'+
                   '<span class="icon"><i class="fa fa-cog" aria-hidden="true"></i></span>'+
                   '<span class="title">Configurações</span>'+
                   '</a></li><li><a href="homepage.html">'+
                   '<span class="icon"><i class="fas fa-sign-out-alt"></i></span>'+
                   '<span class="title">Sair</span>'+
                   '</a>'+
                   '</ul></div></div></div></div>');

var $defaultnav=$('<script> var logo= function(){if($( window ).width()<=690){$(".logsdo").addClass("small");$(".buscar").hide();}else{$(".logo").removeClass("small");$(".buscar").show();}};$(window).on("resize", logo);$(window).on("load", logo);</script>'+
                  '<nav class="top_navbar-side">'+
                  '<div class="top_menu-side">'+
                  '<div><a href="homepage.html"><img src="../static/imgs/logo.png" class="logo"></a></div><ul><li class="buscar">'+
                  '<div class="buscar-caja"><input type="text" name="" class="buscar-txt" placeholder="Buscar..."/>'+
                  '<a class="buscar-btn"><i class="fas fa-search"></i></a></div></li>'+
                  '<li><a href="#linkLogin" data-toggle="modal" data-target="#modalExemplo" class="btn-azul">Entrar</a></li><li>'+
                  '<div class="dropdown show"><a class="dropdown-togggle btn-degrade azul" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Cadastrar</a>'+
                  '<div class="dropdown-menu p-2 text-center" aria-labelledby="dropdownMenuLink"><a href="formEmpresa.html"><h4>Empresa</h4></a><h4>Desenvolvedor</h4></div></div>'+
                  '</li></ul></div></nav>');
$( ".footer" ).append($footer);
$( ".topnav" ).append($topnav);
$(".defaultnav").append($defaultnav);
$(".sidebardev").append($sidebar_dev);
$(".sidebaremp").append($sidebar_emp);