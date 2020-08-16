package br.com.devfinder.controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.Desenvolvedor;
import br.com.devfinder.model.DesenvolvedorAreaAtuacao;
import br.com.devfinder.model.DesenvolvedorHabilidade;
import br.com.devfinder.model.Empresa;
import br.com.devfinder.model.Endereco;
import br.com.devfinder.model.Solucao;
import br.com.devfinder.model.TokenDesenvolvedor;
import br.com.devfinder.model.TokenEmpresa;
import br.com.devfinder.model.ids.SolucaoId;
import br.com.devfinder.model.ids.TokenDesenvolvedorId;
import br.com.devfinder.model.ids.TokenEmpresaId;
import br.com.devfinder.service.DesafioHabilidadeService;
import br.com.devfinder.service.DesafioService;
import br.com.devfinder.service.DesenvolvedorDesafioService;
import br.com.devfinder.service.DesenvolvedorService;
import br.com.devfinder.service.EmpresaService;
import br.com.devfinder.service.SolucaoService;
import br.com.devfinder.service.TokenDesenvolvedorService;
import br.com.devfinder.service.TokenEmpresaService;

/**
 * @author Ronaldo Costa
 *
 */
@Controller
public class TokenController {

	@Autowired
	private TokenEmpresaService serviceEmpresa;
	
	@Autowired
	private TokenDesenvolvedorService serviceDesenvolvedor;
	
	@Autowired
	private EmpresaService serviceEmp;
	
	@Autowired
	private DesafioService serviceDe;
	
	@Autowired
	private DesafioHabilidadeService serviceDH;
	
	
	@Autowired
	private DesenvolvedorDesafioService serviceDD;
	
	@Autowired
	private DesenvolvedorService serviceDev;	
	
	@Autowired
	private TokenEmpresaService serviceTokenEmpresa;	
	
	@Autowired
	private TokenDesenvolvedorService serviceTokenDesenvolvedor;
	
	@GetMapping("/addToken/{email}")
	public String addToken(@PathVariable String email) throws AddressException, MessagingException {
		Random rand = new Random();
        BigInteger result = new BigInteger(16, rand);//String generatedString = new String(array, Charset.forName("UTF-8"));
        
        if(serviceEmp.getEmpresaById(email) != null) {
     	    serviceEmpresa.saveToken(new TokenEmpresa(email, true, result.toString()));
        }
        else if(serviceDev.getDesenvolvedorById(email) != null){
        	serviceDesenvolvedor.saveToken(new TokenDesenvolvedor(email, true, result.toString()));
        }
        else {
        	return "error";
        }
	    
	    /*Envia no e-mail selecionado*/
	   Properties props = new Properties();
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.port", "587");
	   
	   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {
	         return new PasswordAuthentication("suporte.devfinder@gmail.com", "site2020");
	      }
	   });
	   Message msg = new MimeMessage(session);
	   msg.setFrom(new InternetAddress(email, false));
	   msg.setHeader("Content-Type", "text/html");
	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
	   msg.setSubject("Recuperar Senha");
	   String html = "<p>Acesse o link abaixo para redefinir sua senha <br/><a href='http://localhost:8080/redefinirSenha/"+result.toString()+"'>link</a></p>";
	   msg.setContent(html, "text/html");

	   
	   msg.setSentDate(new Date());

	   //MimeBodyPart messageBodyPart = new MimeBodyPart();
	   //messageBodyPart.setContent("Esse email é para recuperar sua conta", "text/html");
	   //messageBodyPart.setContent("Esse email é para recuperar sua conta\neaefeofe\naosijdaer", "text/html");
	   
	   Transport.send(msg);   
    
		return "redirect:/emailSend";		
	}
	
	@GetMapping("/emailSend")
	public String getToken() {
		return "recuperacaoDeSenhaSend";		
	}


	@GetMapping("/getToken/{email}")
	public String getToken(@PathVariable String email) {
        if(serviceEmp.getEmpresaById(email) != null) {
     	    return serviceEmpresa.getTokenEmpresaById(new TokenEmpresaId(email)).getToken();
        }
        else if(serviceDev.getDesenvolvedorById(email) != null){
        	return serviceDesenvolvedor.getTokenDesenvolvedorById(new TokenDesenvolvedorId(email)).getToken();
        };		
        return "hm";
	}
	
	@GetMapping("/recuperarSenha")
	public String redirectPerfil(Model model,HttpSession session) {
		model.addAttribute("email", new String());
		return "recuperacaoDeSenha";
	}

	@GetMapping("/redefinirSenha/{token}")
	public String redefinirSenha(Model model, HttpSession session, @PathVariable String token) {
		if(serviceTokenEmpresa.getTokenEmpresaByToken(token) != null) {
			model.addAttribute("email", serviceTokenEmpresa.getTokenEmpresaByToken(token).getEmpresa().getEmail());
		}
		else if(serviceTokenDesenvolvedor.getTokenDesenvolvedorByToken(token) != null){
			model.addAttribute("email", serviceTokenDesenvolvedor.getTokenDesenvolvedorByToken(token).getDesenvolvedor().getEmail());
		}
		
		return "novaSenha";
	}
	@PostMapping("/recuperarSenha")
	public String sendEmail(Model model,HttpSession session, HttpServletRequest request) {
		String email = request.getParameter("email");
		return "redirect:/addToken/"+email;
	}
	
	@PostMapping("/changeSenha")
	public String changeSenha(Model model,HttpSession session, HttpServletRequest request) {
		//return (String) model.getAttribute("email");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		if(serviceEmp.getEmpresaById(email) != null) {
			Empresa emp=  serviceEmp.getEmpresaById(email);
			emp.setSenha(senha);
			
			serviceEmp.updateEmpresa(emp);
			
			session.setAttribute("perfil", serviceEmp.getEmpresaById(email));
			return "redirect:/empDashboard";
			
		}
		else if(serviceDev.getDesenvolvedorById(email) != null) {
			Desenvolvedor dev=  serviceDev.getDesenvolvedorById(email);
			dev.setSenha(senha);
			serviceDev.updateDesenvolvedor(dev);
			session.setAttribute("perfil", dev);
			return "redirect:/devDashboard";
		
		}
			
		return "foi";
	}

}
