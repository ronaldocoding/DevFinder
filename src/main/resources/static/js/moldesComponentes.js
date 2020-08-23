function criarEmpresaPesquisa(obj){
	$('#ulEmps').append('<li class="col-xs-6 col-sm-3 col-md-2 col-lg-1">'+
		'<img src="/imageEmp/'+obj.email+'">'+
		'<a href="empresaById/'+obj.email+'">'+
		'<h6>'+obj.razaoSocial+'</h6></a></li>'
)	
}

function criarDesenvolvedorPesquisa(obj){
	$('#ulDevs').append('<li class="col-xs-6 col-sm-3 col-md-2 col-lg-1">'+
		'<img src="/imageDev/'+obj.email+'">'+
		'<a href="desenvolvedorById/'+obj.email+'">'+
		'<h6>'+obj.nome+'</h6></a></li>'
)	
}

function criarDesafioDesenvolvedor(index, nome, empresa, area, descricao, habilidades, dataTermino, horaTermino) {
    var habs = ''
    habilidades.forEach(function (item) {
        habs = habs + ' <span>' + item + '</span>'
    })
    $(".desafios").append('<div id="desafio' + index + '" class="box white"">' +
        '<div class="row">' +
        '<div class="col-sm-4 col-md-3 ml-3">' +
        '<div class="icon m-auto"></div>' +
        '</div>' +
        '<div class="col-sm">' +
        '<div class="col-sm-12 title">' +
        '<h5>' + nome + '<span>' + '<i class="fas fa-briefcase"></i> ' + empresa + '</span>' + '</h5>' +
        '</div>' +
        '<div class="col-sm-12 descricao">' +

        '<div>' + '<span>' + area + '</span>' + descricao + '</div>' +
        ' </div>' +

        '<div class="col-sm-12 habilidades">' +
        habs +
        '</div>' +
        '</div>' +
        '</div>' +
        '<div class="row">' +
        '<div class="col-6 data">' +
        '<i class="far fa-clock"></i> ' + dataTermino + ' ' + horaTermino +
        '</div>' +
        '</div></div>')
}

function criarDesafioEmpresa(index, nome, empresa, area, descricao, habilidades, dataTermino, horaTermino) {
    var habs = ''
    habilidades.forEach(function (item) {
        habs = habs + ' <span>' + item + '</span>'
    })

    $(".desafios").append('<div id="desafio' + index + '" class="box white  mx-1">' +
        '<div class="row">' +
        '<div class="col-sm-4 col-md-3 ml-3">' +
        '<div class="icon m-auto"></div>' +
        '</div>' +
        '<div class="col-sm">' +
        '<div class="col-sm-12 title">' +
        '<h5>' + nome + '<span>' + '<i class="fas fa-briefcase"></i> ' + empresa + '</span>' + '</h5>' +
        '</div>' +
        '<div class="col-sm-12 descricao">' +

        '<div>' + '<span>' + area + '</span>' + descricao + '</div>' +
        ' </div>' +

        '<div class="col-sm-12 habilidades">' +
        habs +
        '</div>' +
        '</div>' +
        '</div>' +
        '<div class="row">' +
        '<div class="col-6 data">' +
        '<i class="far fa-clock"></i> ' + dataTermino + ' ' + horaTermino +
        '</div>' +
        '<div class="col edit"><a href="viewDesafio/'+index+'">Visualizar</a></div>' +
        '</div></div>')
}


