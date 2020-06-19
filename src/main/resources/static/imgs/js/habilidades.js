let hab = ["C", "C++", "C#", "JavaScript", "MySQL", "Java", "Python"];
let idSelect = "habilidades-select";
let idTabela = "habilidades-tabela";
var escolhido = 0;
cria(hab);
adEventos();
function cria(){
    var botaoX = "<button type=\"button\" class=\"close\" aria-label=\"Close\"> <span aria-hidden=\"true\">&times;</span></button>"; 

    hab.forEach(function(item, index){
        document.getElementById(idSelect).innerHTML += "<option>" +item+"</option>";
        document.getElementById(idTabela).innerHTML += "<tr value=\""+item+"\""+ "id = \"op"+index+"\"><td>"+item+"</td><td>"+botaoX+"</td></tr>";
    });  
}

function adEventos(){
    var tab = document.getElementById(idTabela).getElementsByTagName("tr");
    
    let i;
    for(i=0;i<hab.length;i++){
        console.log(tab[i]);
        tab[i].onclick=function(){
        	var h = $('#habilidades').val()
            this.style.display="none";
        	h = h.replace(this.getAttribute("value")+' ','')
        	$('#habilidades').val(h)
        };
    }
}
function adiciona(index){
    if(index >= -1){
        var tab = document.getElementById(idTabela).getElementsByTagName("tr");
        var h = $('#habilidades').val()
        if(tab[index].style.display!="inline-block"){
          tab[index].style.display="inline-block";
          console.log(tab[index].getAttribute("value"))
          h = h+tab[index].getAttribute("value")+' ';
          $('#habilidades').val(h)
          escolhido += 1;
        }
    }
}
function deleta(index){
    if(index >= -1){
        var tab = document.getElementById(idTabela).getElementsByTagName("tr");
        tab[index].style.display="none";
        escolhido -= 1;
    }
}

$('#habilidades-select').change(function(){
    adiciona($('#habilidades-select').prop('selectedIndex')-1)
});

/*$('#habilidades-tabela').click(function(){
    console.log('uau');
    deleta($('#habilidades-select').prop('selectedIndex'))
});
*/