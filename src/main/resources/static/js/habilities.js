var habilities = [ "Javascript", "React", "Node.js", "Java (Android)", "Java",
		"AWS Elastic Beanstalk", "AWS", "Totvs", "ExpressJS", "Bdd",
		"AdonisJS", "Delphi", "Spring Boot", "BigData", "DJango",
		"Data Mining", "C#", "Python", "EJB", "Haskell", "Backbone.js",
		"Programação orientada a Objeto", "Governança de TI",
		"Testes Funcionais", "Ajax", "C", "Scala", "PostgreSQL",
		"Design Responsivo", "Polymer", "Testes automatizados", "WebGL",
		"Media Services", "Bower", "Perl", "Ember.js", "Hibernate", "Fortran",
		"Dart", "Unity", ];

var areas = [ 'Front-end', 'Back-end', 'Full-stack', 'Data Science', 'Mobile' ]

habilities.sort()

function multisearch(habilities) {

	$('.multiselect').each(function(index) {
		if (!$(this).hasClass('area'))
			$(this).addClass('habilities')
	})
	habilities.forEach(function(item, id) {
		$(".habilities .dropdown-menu").append(
				'<div class="dropdown-item habilities" id="drop' + id + '">'
						+ item + '</div>')
		$(".multiselect.habilities").prepend(
				'<span id="span' + id + '" class="selected">' + item
						+ '  <i class="fas fa-times"></i></span>')
	})
	$('.selected').hide()
	$('.multisearch').on('input', function() {
		var str = $(this).val().toLowerCase()
		var none = true
		$(".dropdown-item").each(function(index) {

			if ($(this).text().toLowerCase().includes(str)) {
				$(this).show()
				none = false
			} else
				$(this).hide()
		})

		if (none)
			$('.habilities .dropdown-menu span').show()
		else
			$('.habilities .dropdown-menu span').hide()

	});
	areas.forEach(function(item, id) {
		const index = id + habilities.length
		$(".area .dropdown-menu").append(
				'<div class="dropdown-item area" id="drop' + index + '">'
						+ item + '</div>')
		$(".multiselect.area").prepend(
				'<span id="span' + index + '" class="selected">' + item
						+ '  <i class="fas fa-times"></i></span>')
	})
	$('.area .selected').hide()
	$('.area .multisearch').on('input', function() {
		var str = $(this).val().toLowerCase()
		var none = true
		$(".area .dropdown-item").each(function(index) {

			if ($(this).text().toLowerCase().includes(str)) {
				$(this).show()
				none = false
			} else
				$(this).hide()
		})

		if (none)
			$('.area .dropdown-menu span').show()
		else
			$('.area .dropdown-menu span').hide()

	});
}

function selectHab(habId) {
	const str = habId.substring(4)
	if(str >= habilities.length){
		
		$('#areas').val($('#areas').val() + areas[str-habilities.length] + " ")
		
	}
	else{
		$('#habilidades').val($('#habilidades').val() + habilities[str] + " ")
	}
	$('#' + habId).addClass("disabled")
	$("#span" + str).show()
	$("#span" + str + " i").css("opacity", "1")
	resize()
}
function removeHab(habId) {
	const str = habId.substring(4)
	
	if(str >= habilities.length){
		
	    var currentValue = $('#areas').val()
	    var currentHab = areas[str-habilities.length]
	    currentValue = currentValue.replace(currentHab+" ", "");

	    $('#areas').val(currentValue)
	}
	else{
	    var currentValue = $('#habilidades').val()
	    var currentHab = habilities[str]
	    currentValue = currentValue.replace(currentHab+" ", "");

	    $('#habilidades').val(currentValue)
	}
    $("#drop" + str).removeClass("disabled")
    $('#'+habId).hide();
    resize()
}

$(document).ready(function() {
	$(".multisearch").attr("readonly", false);

	$('.dropdown-item').click(function() {
		var str = $(this).attr('id')
		selectHab(str)
	})
	$('.multiselect .selected i').click(function() {
		var id = $(this).parent().attr('id')
		removeHab(id)
	})
	$('.multisearch').click(function() {
		$(this).focus();
		$(this).attr("readonly", false);

	})

});

multisearch(habilities)
