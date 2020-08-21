package br.com.devfinder.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.Desenvolvedor;
import br.com.devfinder.model.DesenvolvedorAreaAtuacao;
import br.com.devfinder.model.DesenvolvedorHabilidade;
import br.com.devfinder.model.Empresa;
import br.com.devfinder.model.Endereco;
import br.com.devfinder.model.Solucao;
import br.com.devfinder.model.ids.SolucaoId;
import br.com.devfinder.service.SolucaoService;

/**
 * @author Ronaldo Costa
 *
 */
@Controller
public class SolucaoController {

	@Autowired
	private SolucaoService service;

	
	@PostMapping("/addSolucao")
	public String addDesenvolvedor(
			@RequestParam("documentacao") MultipartFile file,
			HttpServletRequest request, HttpSession session) {
		Desenvolvedor user = (Desenvolvedor) session.getAttribute("perfil");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		SimpleDateFormat formatoTime = new SimpleDateFormat("HH:mm"); 
		
		try {
			byte[] inputStream = file.getBytes();	
			
			Solucao s = new Solucao(
						user.getEmail(), 
						request.getParameter("emailEmpresa"), 
						Integer.parseInt(request.getParameter("id")), 
						request.getParameter("link"), 
						request.getParameter("descricao"),
						formato.format(new Date()), 
						formatoTime.format(new Date()), inputStream);
			service.saveSolucao(s);
			return "redirect:/devMeusDesafios";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file.getOriginalFilename();
				
		
	}


	@PostMapping("/addSolucoes")
	public List<Solucao> addSolucoes(@RequestBody List<Solucao> solucoes) {
		return service.saveSolucoes(solucoes);
	}

	@GetMapping("/solucoesByDesafio/{emailEmpresa}/{idDesafio}")
	@ResponseBody
	public List<Solucao> findAllHabilidadesByDesafio(@PathVariable String emailEmpresa, @PathVariable int idDesafio) {
		return service.getSolucoesByDesafio(emailEmpresa, idDesafio);
	}

	@GetMapping("/solucoesByDesenvolvedor/{emailDesenvolvedor}")
	public List<Solucao> findAllHabilidadesByDesenvolvedor(@PathVariable String emailDesenvolvedor) {
		return service.getSolucoesByDesenvolvedor(emailDesenvolvedor);
	}

	@GetMapping("/solucaoById/{emailEmpresa}/{emailDesenvolvedor}/{idDesafio}")
	public Solucao findSolucaoById(@PathVariable String emailEmpresa, @PathVariable String emailDesenvolvedor,
			@PathVariable int idDesafio) {
		SolucaoId solucaoId = new SolucaoId(emailDesenvolvedor, emailEmpresa, idDesafio);
		return service.getSolucaoById(solucaoId);
	}

	@DeleteMapping("/deleteSolucao/{id}")
	public String deleteSolucao(@PathVariable String emailEmpresa, @PathVariable String emailDesenvolvedor,
			@PathVariable int idDesafio) {
		SolucaoId solucaoId = new SolucaoId(emailDesenvolvedor, emailEmpresa, idDesafio);
		return service.deleteSolucao(solucaoId);
	}
}
