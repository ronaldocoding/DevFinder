var valores = {
	tempo : 'Recentes',
	estado : 'Todos',
	area : 'Todos',
}

var data = new Date();

$('.filtro-area').click(function() {
	// alert("opa")
	var option = $(this).val()
	valores.area = option

	filtro(valores.tempo, valores.estado, valores.area)
})
$('.filtro-estado').click(function() {
	// alert("opa")
	console.log(desafios)
	var option = $(this).val()
	valores.estado = option

	filtro(valores.tempo, valores.estado, valores.area)
})
$(".none-result").hide()

function filtroTexto(texto) {
	var none = true
	
	arraydesafios.forEach(function(item) {
		
		var index = item.id

		$("#desafio" + item.id).show()
		if (item.nome.indexOf(texto) == -1 && item.descricao.indexOf(texto) == -1) {
			$("#desafio" + index).hide()
		}

		if ($("#desafio" + index).css("display") !== "none")
			none = false
	})
	console.log(none)
	if (none)
		$(".none-result").show()

}
function filtro(tempo, estado, area) {
	var none = true

	console.log(desafios)
	// alert("aiai")
	desafios.forEach(function(item) {
		console.log(item)
		var index = item.id
		$("#desafio" + item.id).show()
		var limiteData = item.dataFim.split('-')
		var limiteHora = item.horarioFim.split(':')
		var passou = false

		if (parseInt(limiteData[0]) < data.getFullYear()) {
			passou = true
		} else if (parseInt(limiteData[1]) < data.getMonth() + 1) {
			passou = true
		} else if (parseInt(limiteData[2]) < data.getDate()
				&& parseInt(limiteData[1]) === data.getMonth() + 1) {
			passou = true
		} else if (parseInt(limiteData[2]) === data.getDate()
				&& parseInt(limiteHora[0]) < data.getHours()) {
			passou = true
		} else if (parseInt(limiteData[2]) === data.getDate()
				&& parseInt(limiteHora[0]) === data.getHours()
				&& parseInt(limiteHora[1]) <= data.getMinutes()) {
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
		if (area !== item.areaDesenvolvimento && area !== 'Todos') {
			$("#desafio" + index).hide()
		}

		if ($("#desafio" + index).css("display") !== "none")
			none = false
	})
	console.log(none)
	if (none)
		$(".none-result").show()

}
