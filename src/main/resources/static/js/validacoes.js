var ret;
function validate(el){
  console.log(el.name)
  if(el.name == 'nome')
	  if(el.id="nameDesafio")
		 return testeFrase(el.value)
	  else
        return testeString(el.value);
  
  if(el.id == 'cpf')
    return testeCPF(el.value);

  if(el.name == 'url')
    return testeURL(el.value);

  if(el.name == 'email')
    return testeEmail(el.value);

  if(el.id == 'CNPJ'){
    return testeCNPJ(el.value);
  }
  if(el.name == 'desafioName'){
	  return testeFrase(el.value);
  }

  if(el.name == 'tel')
    return testeTelefone(el.value);
  if(el.name == 'senhaConfirm')
    return el.value == $('#senha').val();
  if(el.name == 'cep')
      return testeCEP();
  return true
}



function validateCheck(check){
    var inputs = check.getElementsByTagName("input");
    var checks = [];
    for(var i = 0; i < inputs.length; i++){
      if(inputs[i].checked){
        checks.push(inputs[i].value);
      }
    }
    console.log(checks);
    if(checks.length == 0){
      return false;
    }
    else
      return checks;
}

function testeString(string){
  var exp = /[A-Z][a-z]* [A-Z][a-z]*/;
  match = exp.test(string)
  return match;
}

function testeFrase(string){
	console.log('entrou')
	char = '!@#$%¨&*(),.<>;:}{][ªº'
	for(var i = 0; i < char.length; i++){
		if(string.indexOf(char[i]) != -1)
			return false
	}
	return true;
	
}

function testeCEP(string){
  return getEndereco();
}

function testeTelefone(tel){
  var exp = /^1\d\d(\d\d)?$|^0800 ?\d{3} ?\d{4}$|^(\(0?([1-9a-zA-Z][0-9a-zA-Z])?[1-9]\d\) ?|0?([1-9a-zA-Z][0-9a-zA-Z])?[1-9]\d[ .-]?)?(9|9[ .-])?[2-9]\d{3}[ .-]?\d{4}$/;
  match = exp.test(tel)
  return match;
}

function testeURL(url){
  console.log('entruo')
  var exp = /(https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]+\.[^\s]{2,}|www\.[a-zA-Z0-9]+\.[^\s]{2,})/gi; 
  match = exp.test(url);

  return match || url=='';
}

function testeCPF(cpf) {
  cpf = cpf.replace(/[^\d]+/g,'');  
  if(cpf == '') return false; 
  // Elimina CPFs invalidos conhecidos  
  if (cpf.length != 11 || 
    cpf == "00000000000" || 
    cpf == "11111111111" || 
    cpf == "22222222222" || 
    cpf == "33333333333" || 
    cpf == "44444444444" || 
    cpf == "55555555555" || 
    cpf == "66666666666" || 
    cpf == "77777777777" || 
    cpf == "88888888888" || 
    cpf == "99999999999")
      return false;   
  // Valida 1o digito 
  add = 0;  
  for (i=0; i < 9; i ++)    
    add += parseInt(cpf.charAt(i)) * (10 - i);  
    rev = 11 - (add % 11);  
    if (rev == 10 || rev == 11)   
      rev = 0;  
    if (rev != parseInt(cpf.charAt(9)))   
      return false;   
  // Valida 2o digito 
  add = 0;  
  for (i = 0; i < 10; i ++)   
    add += parseInt(cpf.charAt(i)) * (11 - i);  
  rev = 11 - (add % 11);  
  if (rev == 10 || rev == 11) 
    rev = 0;  
  if (rev != parseInt(cpf.charAt(10)))
    return false;   
  return true;
}

function getEndereco() {
  // Se o campo CEP não estiver vazio     
   
  $.getScript("http://cep.republicavirtual.com.br/web_cep.php?formato=javascript&cep="+$("#CEP").val(),
  function(){
    console.log(resultadoCEP["resultado"])
    if(  resultadoCEP["resultado"] == 1){
      /* troca o valor dos elementos*/
      $("#bairro").val(unescape(resultadoCEP["bairro"]))
      $('#cidade').val(unescape(resultadoCEP["cidade"]));
      $('#estado').val(unescape(resultadoCEP["uf"]));
      $('#numero').focus();
      
      $("#rua").val(unescape(resultadoCEP["tipo_logradouro"])+" "+unescape(resultadoCEP["logradouro"]));
      ret = true;
      return true;
    }else{
        ret = false;
        return false;
    }
  });
  console.log('retornou: '+ret);
  return ret;
}

function testeEmail(email) {
  usuario = email.substring(0, email.indexOf("@"));
  dominio = email.substring(email.indexOf("@")+ 1, email.length);
   
  if ((usuario.length >=1) &&
      (dominio.length >=3) && 
      (usuario.search("@")==-1) && 
      (dominio.search("@")==-1) &&
      (usuario.search(" ")==-1) && 
      (dominio.search(" ")==-1) &&
      (dominio.search(".")!=-1) &&      
      (dominio.indexOf(".") >=1)&& 
      (dominio.lastIndexOf(".") < dominio.length - 1)) {
    console.log('email válido')
    return true
  }
  else{
    console.log('email inválido')
    return false;
  }
}


function testeCNPJ(cnpj) {
 
    cnpj = cnpj.replace(/[^\d]+/g,'');
 
    if(cnpj == '') return false;
     
    if (cnpj.length != 14)
        return false;
 
    // Elimina CNPJs invalidos conhecidos
    if (cnpj == "00000000000000" || 
        cnpj == "11111111111111" || 
        cnpj == "22222222222222" || 
        cnpj == "33333333333333" || 
        cnpj == "44444444444444" || 
        cnpj == "55555555555555" || 
        cnpj == "66666666666666" || 
        cnpj == "77777777777777" || 
        cnpj == "88888888888888" || 
        cnpj == "99999999999999")
        return false;
         
    // Valida DVs
    tamanho = cnpj.length - 2
    numeros = cnpj.substring(0,tamanho);
    digitos = cnpj.substring(tamanho);
    soma = 0;
    pos = tamanho - 7;
    for (i = tamanho; i >= 1; i--) {
      soma += numeros.charAt(tamanho - i) * pos--;
      if (pos < 2)
            pos = 9;
    }
    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado != digitos.charAt(0))
        return false;
         
    tamanho = tamanho + 1;
    numeros = cnpj.substring(0,tamanho);
    soma = 0;
    pos = tamanho - 7;
    for (i = tamanho; i >= 1; i--) {
      soma += numeros.charAt(tamanho - i) * pos--;
      if (pos < 2)
            pos = 9;
    }
    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado != digitos.charAt(1))
          return false;
           
    return true;
}

function testaSenha(){

  var passwordTextBox = document.getElementById("senha");
  var password = passwordTextBox.value;
  console.log(password);
  var caracteresEspeciais = "!£$%^&*_@#~?";
  var passwordPontos = 0;
  // Contém caracteres especiais
  for (var i = 0; i < password.length; i++)
  {
      if (caracteresEspeciais.indexOf(password.charAt(i)) > -1)
      {
            passwordPontos += 20;
            break;
      }
  }
  // Contém numeros
  if (/\d/.test(password))
      passwordPontos += 20;
  // Contém letras minúsculas
  if (/[a-z]/.test(password))
      passwordPontos += 20;
  // Contém letras maiúsculas
  if (/[A-Z]/.test(password))
      passwordPontos += 20;
  if (password.length >= 8)
      passwordPontos += 20;
  return passwordPontos;
  
}
