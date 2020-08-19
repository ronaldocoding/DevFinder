var valores = {
    tempo: 'Recentes',
    estado: 'Todos',
    area: 'Todos',
}

var data = new Date();
var desafios = [
    {
        nome: 'Ensinar programação',
        empresa: 'IFAM-CMC',
        area: 'Full-stack',
        descricao: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur aliquet fermentum rutrum. Nam non consectetur risus. Nam gravida ut est sed consequat. Quisque vitae felis vitae elit mollis malesuada quis in mauris. Ut at diam vitae purus aliquet molestie. Morbi condimentum non mauris vitae mattis. Donec rhoncus ante ut maximus bibendum. Vestibulum volutpat lacinia rutrum. Integer ut diam porta, suscipit odio malesuada, facilisis dui.',
        habilidades: ['HTML', 'CSS', 'React', 'Java', 'Javascript', 'SQL'],
        dataTermino: '01/08/2020',
        horaTermino: '12:00',
    },
    {
        nome: 'Ensinar programação',
        empresa: 'IFAM-CMC',
        area: 'Back-end',
        descricao: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur aliquet fermentum rutrum. Nam non consectetur risus. Nam gravida ut est sed consequat. Quisque vitae felis vitae elit mollis malesuada quis in mauris. Ut at diam vitae purus aliquet molestie. Morbi condimentum non mauris vitae mattis. Donec rhoncus ante ut maximus bibendum. Vestibulum volutpat lacinia rutrum. Integer ut diam porta, suscipit odio malesuada, facilisis dui.',
        habilidades: ['HTML', 'CSS', 'React', 'Java', 'Javascript', 'SQL'],
        dataTermino: '22/08/2020',
        horaTermino: '12:00',
    },
    {
        nome: 'Ensinar programação',
        empresa: 'IFAM-CMC',
        area: 'Full-stack',
        descricao: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur aliquet fermentum rutrum. Nam non consectetur risus. Nam gravida ut est sed consequat. Quisque vitae felis vitae elit mollis malesuada quis in mauris. Ut at diam vitae purus aliquet molestie. Morbi condimentum non mauris vitae mattis. Donec rhoncus ante ut maximus bibendum. Vestibulum volutpat lacinia rutrum. Integer ut diam porta, suscipit odio malesuada, facilisis dui.',
        habilidades: ['HTML', 'CSS', 'React', 'Java', 'Javascript', 'SQL'],
        dataTermino: '18/08/2020',
        horaTermino: '23:59',
    },
]

function criarDesafio(index, nome, empresa, area, descricao, habilidades, dataTermino, horaTermino) {
    var habs = ''
    habilidades.forEach(function (item) {
        habs = habs + ' <span>' + item + '</span>'
    })
    console.log(index)
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
        '<div class="col edit"><a href="#">Visualizar</a></div>' +
        '</div></div>')
}
desafios.forEach(function (item, index) {
    criarDesafio(index, item.nome, item.empresa, item.area, item.descricao, item.habilidades, item.dataTermino, item.horaTermino)
})

$('.filtro-area').click(function () {
    var option = $(this).val()
    valores.area = option

    filtro(valores.tempo, valores.estado, valores.area)
})
$('.filtro-estado').click(function () {
    var option = $(this).val()
    valores.estado = option

    filtro(valores.tempo, valores.estado, valores.area)
})

$(".none-result").hide()

function filtro(tempo, estado, area) {
    var none = true
    desafios.forEach(function (item, index) {
        $("#desafio" + index).show()
        var limiteData = item.dataTermino.split('/')
        var limiteHora = item.horaTermino.split(':')
        var passou = false

        if (parseInt(limiteData[2]) < data.getFullYear()) {
            passou = true
        } else if (parseInt(limiteData[1]) < data.getMonth() + 1) {
            passou = true
        } else if (parseInt(limiteData[0]) < data.getDate() && parseInt(limiteData[1]) === data.getMonth() + 1) {
            passou = true
        } else if (parseInt(limiteData[0]) === data.getDate() &&
            parseInt(limiteHora[0]) < data.getHours()) {
            passou = true
        } else if (parseInt(limiteData[0]) === data.getDate() &&
            parseInt(limiteHora[0]) === data.getHours() &&
            parseInt(limiteHora[1]) <= data.getMinutes()) {
            passou = true
        }


        if (valores.estado === 'Finalizados') {
            if (!passou)
                $("#desafio" + index).hide()

        }
        if (valores.estado === 'Em andamento') {
            if (passou)
                $("#desafio" + index).hide()
        }
        if (area !== item.area && area !== 'Todos') {
            $("#desafio" + index).hide()
        }

        if ($("#desafio" + index).css("display") !== "none")
            none = false
    })
    console.log(none)
    if (none)
        $(".none-result").show()

    else
        $(".none-result").hide()

}
