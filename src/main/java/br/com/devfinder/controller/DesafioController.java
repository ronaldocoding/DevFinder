package br.com.devfinder.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.DesafioHabilidade;
import br.com.devfinder.model.ids.DesafioId;
import br.com.devfinder.service.DesafioHabilidadeService;
import br.com.devfinder.service.DesafioService;

/**
 * @author Ronaldo Costa
 *
 */
@Controller
public class DesafioController {

	@Autowired
	private DesafioService service;
	private DesafioHabilidadeService serviceH;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("desafio", new Desafio());
		model.addAttribute("habilidade", new String());
		return "empInicio";
	}
	
	@GetMapping("/addDesafio")
	public String formDesafio(Model model) {
        return "formDesafio";
    }
	
	@PostMapping("/addDesafio")
	public String formDesafio(@ModelAttribute Desafio desafio, @RequestParam("habilidade") String hab) {
        desafio.setEmailEmpresa("aaa@gmail.com");
        service.saveDesafio(desafio);
        
        String habilidades[] = hab.split(" ");
        
        DesafioHabilidade desafiohabilidade = new DesafioHabilidade();
        desafiohabilidade.setEmailEmpresa(desafio.getEmailEmpresa());
        desafiohabilidade.setIdDesafio(desafio.getId());
        
        for(int i = 0; i < habilidades.length; i++) {
        	desafiohabilidade.setHabilidade(habilidades[i]);
        	
        	serviceH.saveHabilidade(desafiohabilidade); 
        }
        
		return "empMeusDesafios";
    }
	
	@PostMapping("/teste")
	public String teste(
			@RequestParam(required=false, value="meusDesafios") String meusDesafios,
			@RequestParam(required=false, value="inicio") String inicio,
			@RequestParam(required=false, value="config") String config,
			@RequestParam(required=false, value="sair") String sair,
			Model model
			) {
		if(meusDesafios != null) {
			model.addAttribute("desafios", service.getDesafios("aaa@gmail.com"));
			return "empMeusDesafios";
		}
		if(inicio != null)
			return "empInicio";
		if(config != null)
			return "devConfiguracoes";
		else
			return "homepage";
	}
	
	@PostMapping("/addDesafios")
	public List<Desafio> addDesafios(@RequestBody List<Desafio> desafios) {
		return service.saveDesafios(desafios);
	}

	@GetMapping("/desafiosByEmpresa/{emailEmpresa}")
	public String findAllDesafiosByEmpresa(@PathVariable String emailEmpresa, Model model) {
		model.addAttribute("desafios", service.getDesafios(emailEmpresa));
		return "empMeusDesafios";
	}

	@GetMapping("/desafioById/{emailEmpresa}/{id}")
	public Desafio findDesafioById(@PathVariable String emailEmpresa, @PathVariable int id) {
		DesafioId desafioId = new DesafioId(emailEmpresa, id);
		return service.getDesafioById(desafioId);
	}

	@GetMapping("/desafioByNome/{nome}")
	public Desafio findDesafioByNome(@PathVariable String nome) {
		return service.getDesafioByNome(nome);
	}

	@PutMapping("/updateDesafio")
	public Desafio updateDesafio(@RequestBody Desafio desafio) {
		return service.updateDesafio(desafio);
	}

	@DeleteMapping("/deleteDesafio/{emailEmpresa}/{id}")
	public String deleteEmpresa(@PathVariable String emailEmpresa, int id) {
		DesafioId desafioId = new DesafioId(emailEmpresa, id);
		return service.deleteDesafio(desafioId);
	}
}
