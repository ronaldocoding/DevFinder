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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@PostMapping("/addDesafioRedirect")
	public String formDesafio(Model model,@RequestParam("email") String emailEmpresa) {
		model.addAttribute("desafio", new Desafio());
		model.addAttribute("email", emailEmpresa);
		serviceEmpresa.getEmpresas();
        return "formDesafio";
    }
	
	@PostMapping("/addDesafio")
	public String formDesafio(RedirectAttributes redirectAttributes, 
			@ModelAttribute Desafio desafio, @RequestParam("habilidade") String hab,
			@RequestParam("email") String emailEmpresa) {
		
        desafio.setEmailEmpresa(emailEmpresa);
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
      
        redirectAttributes.addFlashAttribute("page", 2);
        redirectAttributes.addFlashAttribute("email", emailEmpresa);
		return "redirect:/redirectLogin";
    }
	
	@PostMapping("/addDesafios")
	public List<Desafio> addDesafios(@RequestBody List<Desafio> desafios) {
		return service.saveDesafios(desafios);
	}

	@RequestMapping(value = "/empMeusDesafios", method = RequestMethod.GET)
	public String getDesafios(Model model, @RequestParam("email") String emailEmpresa) {
		model.addAttribute("desafios", service.getDesafios(emailEmpresa));
		
		model.addAttribute("empresa", serviceEmpresa.getEmpresaById(emailEmpresa));
		model.addAttribute("service", serviceDH);
		return "empMeusDesafios";
	}

	@GetMapping("/desafioById/{emailEmpresa}/{id}")
	public Desafio findDesafioById(Model model, @PathVariable String emailEmpresa, @PathVariable int id) {
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
	public String deleteEmpresa(@PathVariable String emailEmpresa, @PathVariable int id, RedirectAttributes redirectAttributes) {
		DesafioId desafioId = new DesafioId(emailEmpresa, id);
		for(DesafioHabilidade d: serviceDH.getHabilidades(emailEmpresa)){
			if(id == d.getIdDesafio()) {
				serviceDH.deleteHabilidade(new DesafioHabilidadeId(emailEmpresa, id, d.getHabilidade()));
		
			}
		}
		service.deleteDesafio(desafioId);

        redirectAttributes.addFlashAttribute("page", 2);
        redirectAttributes.addFlashAttribute("email", emailEmpresa);
		return "redirect:/redirectLogin";
	}
}
