var area=["Front-end", "Back-end", "Full Stack"];

criaSelect(area, "area-atuacao-select", "area-atuacao-tabela");

function criaSelect(lista, idSelect, idTabela){
	lista.forEach(item=>{
		document.getElementById(idSelect).innerHTML+="<option>" + item +"</option>";
	});

  	for (i = 0; i < lista.length; i++) {
		document.getElementById(idSelect).innerHTML+="<option onclick=\"showOption("+i+")\">" + lista[i] +"</option>";
    		addOption(lista[i], idTabela);
 	}
}

function addOption(novoItem, idTabela){
	var botaoX = "<button type=\"button\" class=\"close\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>";
	document.getElementById(idTabela).innerHTML += "<tr><td>" + novoItem + "</td><td>" + botaoX+"</td></tr>";
}

function showOption(index){

}



