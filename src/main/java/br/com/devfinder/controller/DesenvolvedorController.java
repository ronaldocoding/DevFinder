package br.com.devfinder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.devfinder.model.Desenvolvedor;
import br.com.devfinder.model.DesenvolvedorAreaAtuacao;
import br.com.devfinder.model.DesenvolvedorHabilidade;
import br.com.devfinder.model.Empresa;
import br.com.devfinder.model.Endereco;
import br.com.devfinder.service.DesenvolvedorAreaAtuacaoService;
import br.com.devfinder.service.DesenvolvedorHabilidadeService;
import br.com.devfinder.service.DesenvolvedorService;

/**
 * @author Ronaldo Costa
 *
 */
@Controller
public class DesenvolvedorController {

	@Autowired
	private DesenvolvedorService service;

	@Autowired
	private DesenvolvedorHabilidadeService serviceH;
	
	@Autowired
	private DesenvolvedorAreaAtuacaoService serviceA;
	
	@GetMapping("/formDev")
	public String addFormDev(Model model) {
		
		model.addAttribute("dev", new Desenvolvedor());
		model.addAttribute("endereco", new Endereco());
		
		return "formDesenvolvedor";
	}
	@PostMapping("/addDev")
	public String addDesenvolvedor(@ModelAttribute Desenvolvedor dev, 
			@ModelAttribute Endereco endereco, @RequestParam("area") ArrayList<String> areas,
			Model model, @RequestParam("habilidade") String hab) {
		
		DesenvolvedorAreaAtuacao area = new DesenvolvedorAreaAtuacao(); 
		DesenvolvedorHabilidade habilidade = new DesenvolvedorHabilidade();
		
		service.saveDesenvolvedor(dev);
		
		area.setEmailDesenvolvedor(dev.getEmail());
		habilidade.setEmailDesenvolvedor(dev.getEmail());
		String habilidades[] = hab.split(" ");
		
		//adiciona as areas de atuação
		for(String a: areas) {
			area.setAreaAtuacao(a);
			serviceA.saveArea(area);
		}
		
		for(String h: habilidades) {
			habilidade.setHabilidade(h);
			serviceH.saveHabilidade(habilidade);
		}

		model.addAttribute("page", 1);
		model.addAttribute("dev",dev);
		return "devInicio";
		
	}

	@RequestMapping(value = "/dashboardDev", method = RequestMethod.GET)
	public String dashboard(Model model, @RequestParam("email") String email) {
		model.addAttribute("dev", service.getDesenvolvedorById(email));
		return "devDashboard";
	}
	
	@RequestMapping(value = "/devConfiguracoes", method = RequestMethod.GET)
	public String config(Model model, @RequestParam("email") String email) {
		model.addAttribute("dev", service.getDesenvolvedorById(email));
		return "devConfiguracoes";
	}
	
	@PostMapping("/addDesenvolvedores")
	public List<Desenvolvedor> addEmpresas(List<Desenvolvedor> desenvolvedores) {
		return service.saveDesenvolvedores(desenvolvedores);
	}

	@GetMapping("/desenvolvedores")
	public List<Desenvolvedor> findAllDesenvolvedores() {
		return service.getDesenvolvedores();
	}

	@GetMapping("/desenvolvedorById/{email}")
	public Desenvolvedor findDesenvolvedorById(@PathVariable String email) {
		return service.getDesenvolvedorById(email);
	}

	@GetMapping("/desenvolvedorByNome/{nome}")
	public Desenvolvedor findDesenvolvedorByNome(@PathVariable String nome) {
		return service.getDesenvolvedorByNome(nome);
	}

	@PutMapping("/updateDesenvolvedor")
	public Desenvolvedor updateDesenvolvedor(@RequestBody Desenvolvedor desenvolvedor) {
		return service.updateDesenvolvedor(desenvolvedor);
	}

	@DeleteMapping("/deleteDesenvolvedor/{email}")
	public String deleteDesenvolvedor(@PathVariable String email) {
		return service.deleteDesenvolvedor(email);
	}
}
