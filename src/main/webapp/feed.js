$(document).ready(function(){
	$(".hamburger-side").click(function(){
	   $(".wrapper-side").toggleClass("collapse-side");
	});

    $('.dropdown-menu').mCustomScrollbar({
        theme: "minimal-dark",
    });

	var add_notification = function(type, name){
		str =  '<p class="notification">'
		if(type == 1)
			str += 'A empresa ' + name + ' demonstrou interesse em seu trabalho'
		else
			str += 'O Desafio ' + name + ' já acabou!'
		str += '</p>'
		$('#mCSB_1_container').append(str);
	}
	
	var active = 0
	
	add_notification(1, 'lalala')
	add_notification(2, 'desafio 1')
	add_notification(2, 'desafio2')
});
