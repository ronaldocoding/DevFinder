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
import br.com.devfinder.model.Empresa;
import br.com.devfinder.model.ids.DesafioHabilidadeId;
import br.com.devfinder.model.ids.DesafioId;
import br.com.devfinder.service.DesafioHabilidadeService;
import br.com.devfinder.service.DesafioService;
import br.com.devfinder.service.EmpresaService;

/**
 * @author Ronaldo Costa
 *
 */
@Controller
public class DesafioController {

	@Autowired
	private DesafioService service;	

	@Autowired
	private EmpresaService serviceEmpresa;
	
	@Autowired
	private DesafioHabilidadeService serviceDH;

	@GetMapping("/addDesafio")
	public String formDesafio(Model model) {
		model.addAttribute("desafio", new Desafio());
        return "formDesafio";
    }
	
	@PostMapping("/addDesafio")
	public String formDesafio(@ModelAttribute Desafio desafio, @RequestParam("habilidade") String hab) {
        desafio.setEmailEmpresa("marlonfleite50@gmail.com");
        service.saveDesafio(desafio);
        desafio = service.getDesafioByNome(desafio.getNome());
        String habilidades[] = hab.split(" ");
        
        DesafioHabilidade desafiohabilidade = new DesafioHabilidade();
        desafiohabilidade.setEmailEmpresa(desafio.getEmailEmpresa());
        desafiohabilidade.setIdDesafio(desafio.getId());
        
        for(int i = 0; i < habilidades.length; i++) {
        	desafiohabilidade.setHabilidade(habilidades[i]);
        	//return desafiohabilidade.getEmailEmpresa()+desafiohabilidade.getHabilidade()+desafiohabilidade.getIdDesafio();
        	serviceDH.saveHabilidade(desafiohabilidade);
        	//.saveHabilidade(desafiohabilidade); 
        }
        
		return "empMeusDesafios";
    }
	
	@PostMapping("/addDesafios")
	public List<Desafio> addDesafios(@RequestBody List<Desafio> desafios) {
		return service.saveDesafios(desafios);
	}

	@GetMapping("/desafiosByEmpresa/{emailEmpresa}")
	public String findAllDesafiosByEmpresa(@PathVariable String emailEmpresa, Model model) {
		model.addAttribute("desafios", service.getDesafios(emailEmpresa));
		model.addAttribute("empresa", serviceEmpresa.getEmpresaById(emailEmpresa));
		model.addAttribute("service", serviceDH);
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
	@GetMapping("/deleteDesafio/{emailEmpresa}/{id}")
	public String deleteEmpresa(@PathVariable String emailEmpresa, @PathVariable int id, Model model) {
		DesafioId desafioId = new DesafioId(emailEmpresa, id);
		for(DesafioHabilidade d: serviceDH.getHabilidades(emailEmpresa)){
			if(id == d.getIdDesafio()) {
				serviceDH.deleteHabilidade(new DesafioHabilidadeId(emailEmpresa, id, d.getHabilidade()));
		
			}
		}
		service.deleteDesafio(desafioId);
		model.addAttribute("desafios", service.getDesafios(emailEmpresa));
		model.addAttribute("empresa", serviceEmpresa.getEmpresaById(emailEmpresa));
		return "empMeusDesafios";
	}
}
