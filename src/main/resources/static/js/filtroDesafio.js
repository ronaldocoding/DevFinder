var valores = {
    tempo: 'Recentes',
    estado: 'Todos',
    area: 'Todos',
}

var data = new Date();


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

}
