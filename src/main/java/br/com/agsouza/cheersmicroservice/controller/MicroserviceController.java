package br.com.agsouza.cheersmicroservice.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.agsouza.cheersmicroservice.domain.Microservice;
import br.com.agsouza.cheersmicroservice.repository.MicroserviceRepository;

@Controller
@RequestMapping("/microservice")
public class MicroserviceController {
	private final MicroserviceRepository microserviceRepository;
	private final String MICRO_SERVICE_URI = "microservice/";

	public MicroserviceController(MicroserviceRepository clienteRepository) {
		this.microserviceRepository = clienteRepository;
	}

	@GetMapping("/")
	public ModelAndView list() {
		Iterable<Microservice> microservices = this.microserviceRepository.findAll();
		return new ModelAndView(MICRO_SERVICE_URI + "list","microservices",microservices);
	}

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Microservice microservice) {
		return new ModelAndView(MICRO_SERVICE_URI + "view","microservice",microservice);
	}

	@GetMapping("/novo")
	public String createForm(@ModelAttribute Microservice microservice) {
		return MICRO_SERVICE_URI + "form";
	}

	@PostMapping(params = "form")
	public ModelAndView create(@Valid Microservice microservice,BindingResult result,RedirectAttributes redirect) {
		if (result.hasErrors()) { 
			return new ModelAndView(MICRO_SERVICE_URI + "form","formErrors",result.getAllErrors()); 
		}
		microservice = this.microserviceRepository.save(microservice);
		redirect.addFlashAttribute("globalMessage","Microservice gravado com sucesso");
		return new ModelAndView("redirect:/" + MICRO_SERVICE_URI + "{microservice.id}","microservice.id",microservice.getId());
	}

	@GetMapping(value = "remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id,RedirectAttributes redirect) {
		this.microserviceRepository.delete(id);
		Iterable<Microservice> microservices = this.microserviceRepository.findAll();		
		ModelAndView mv = new ModelAndView(MICRO_SERVICE_URI + "list","microservices",microservices);
		mv.addObject("globalMessage","Microservice removido com sucesso");
	
		return mv;
	}

	@GetMapping(value = "alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Microservice microservice) {
		return new ModelAndView(MICRO_SERVICE_URI + "form","microservice",microservice);
	}

}
