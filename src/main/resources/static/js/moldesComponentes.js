function criarEmpresaPesquisa(obj){
	var foto = '<span><svg width="50" height="50"> <circle cx="25" cy="25" r="25"fill="blue" /></svg></span>'
	
	$('#ulEmpresas').append('<li><span>'+foto+'</span>'+
	'<a href="empresaById/'+obj.email+'">'+
	'<h5>'+obj.razaoSocial+'</h5></a></li>')	
}

function criarDesenvolvedorPesquisa(obj){
	var foto = '<span><svg width="50" height="50"> <circle cx="25" cy="25" r="25"fill="red" /></svg></span>'
	console.log('objetos: ')
	console.log(obj)
	$('#ulDevs').append('<li><span>'+foto+'</span>'+
	'<a href="desenvolvedorById/'+obj.email+'">'+
	'<h5>'+obj.nome+'</h5></a></li>')	
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


