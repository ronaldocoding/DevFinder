var currentTab = 0; 
showTab(0);

function showTab(n) {
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Cadastrar";
    $("#nextBtn").on('click', function(){
      if(n == (x.length-1)&& validateForm())
    	  ('#regFormCad').submit()
    });
      
  } else {
    document.getElementById("nextBtn").innerHTML = "Proximo";
  }
  fixStepIndicator(n)
}


$('#CEP').on('change', function() {
  getEndereco($('#CEP').val());
});

window.onload = function(){
	
	$("#senha").keyup(function() {
		  var f = testaSenha();
		  var strong = '';
		  $('.passwordStrong').css('display', 'block');
		  $('.passwordStrong').html('');
		  console.log(f);
		  if(f < 30)
		    strong = 'muito fraca'
		  else if(f < 80)
		    strong = 'fraca'
		  else if(f < 100)
		    strong = 'média'
		  else
		    strong = 'forte'

		  $('.passwordStrong').append('Senha '+strong);
		});

	
}

function nextPrev(n) {

  var x = document.getElementsByClassName("tab");
  
  for (var i = 0; i < document.getElementsByTagName("small").length; i++) { 
    //document.getElementsByTagName("small")[i].style.display = "none";
  }

  if (n == 1 && !validateForm()) return false;
  x[currentTab].style.display = "none";
  currentTab = currentTab + n;

  if (currentTab >= x.length) {
    document.getElementById("regFormCad").submit();
    return false;
  }
  showTab(currentTab);
}

function validateForm() {
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByClassName("form-group");
  
  for (i = 0; i < y.length; i++){
    var small = y[i].getElementsByTagName("small");
    if(y[i].className == 'form-group check'){
      if(!validateCheck(y[i])){
        small[0].style.display = "block";
        valid = false;
        console.log('falso');
      }
      else{
        small[0].style.display = "none";
      }
    }

    if(y[i].className == 'form-group select-esp'){
      if(escolhido)
        small[0].style.display = "none";
      else{
        valid = false;
        small[0].style.display = "block";

      }
    }
    if(y[i].className == 'form-group desc'){
    	var input = y[i].getElementsByTagName('textarea')[0];
        if(input.value == ''){
          small[0].style.display = "block";
          valid=false;
        }
        else{
          small[0].style.display = "none";
        }
      }


    if(y[i].className == 'form-group select'){
      var select = y[i].getElementsByTagName('select');
      console.log(select[0].selectedIndex)
      if(select[0].selectedIndex == 0){
        valid = false

        select[0].className += " invalid";
        small[0].style.display = "block";
      }
      else
        small[0].style.display = "none";
    }
    if(y[i].className == 'form-group number'){
      var input = y[i].getElementsByTagName('input');
      console.log('mds: '+input[0].value)
      if(input[0].value == ''){
        valid = false
        input[0].className += " invalid"
        small[0].style.display = "block";
      }
      else
        small[0].style.display = "none";
    }
    
    if(y[i].className == 'form-group date'){
        var input = y[i].getElementsByTagName('input');
        console.log('mds: '+input[0].value)
        if(input[0].value == ''){
          valid = false
          input[0].className += " invalid"
          small[0].style.display = "block";
        }
        else
          small[0].style.display = "none";
      }
    if(y[i].className == 'form-group'){
      var input = y[i].getElementsByTagName("input")[0];
      
      if (input.value == "" && !input.disabled && !input.required) { 
        input.className += " invalid";
        if(small.length > 0){
          small[0].style.display = "block";
          small[1].style.display = "none";
        }
        valid = false;
      }
      else if(!validate(input) && !input.disabled){
        
        input.className += " invalid";
        if(small.length > 0){
          small[1].style.display = "block";
          small[0].style.display = "none";
        }
        valid = false;
        if(input.name!='senha')
        input.value = "";
      }
      else if(small.length > 0 && !input.disabled){
        console.log(small);
        small[1].style.display = "none";
        small[0].style.display = "none";
      }
    }
  }
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; 
}

function fixStepIndicator(n) {
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  x[n].className += " active";
}
