package br.com.agsouza.cheersmicroservice.controller;

import java.util.LinkedList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.agsouza.cheersmicroservice.dto.Health;
import br.com.agsouza.cheersmicroservice.dto.HomeDTO;
import br.com.agsouza.cheersmicroservice.service.StatusApisService;

@Controller
public class DefaultController {

	@Autowired
	private StatusApisService statusApiService; 
	
    @GetMapping("/")
    public ModelAndView home1() {
    	Iterable<Health> listaStatus = statusApiService.listaStatus("DEV", "Rio"); 
    	if (listaStatus == null) {		
    		listaStatus = new LinkedList<Health>();
    	}    	
    	
    	HomeDTO homeDto = new HomeDTO();
    	homeDto.setAmbiente("DEV");
    	homeDto.setTerminal("Rio");
    	homeDto.setListaStatus(listaStatus);
    	
    	return new ModelAndView("home","homeDto",homeDto);
    }
    
    @GetMapping("/home")
    public ModelAndView home() {
    	Iterable<Health> listaStatus = statusApiService.listaStatus("DEV", "Rio"); 
    	if (listaStatus == null) {		
    		listaStatus = new LinkedList<Health>();
    	}    	
    	
    	HomeDTO homeDto = new HomeDTO();
    	homeDto.setAmbiente("DEV");
    	homeDto.setTerminal("Rio");
    	homeDto.setListaStatus(listaStatus);
    	
    	return new ModelAndView("home","homeDto",homeDto);
    }
  
    @RequestMapping(value="/home", params="form",  method=RequestMethod.POST)
    public ModelAndView home(@Valid HomeDTO homeDto, BindingResult result,RedirectAttributes redirect) {
    	Iterable<Health> listaStatus = statusApiService.listaStatus(homeDto.getAmbiente(), homeDto.getTerminal()); 
    	if (listaStatus == null) {		
    		listaStatus = new LinkedList<Health>();
    	}
    
    	homeDto.setListaStatus(listaStatus);    	
    	
		return new ModelAndView("home","homeDto",homeDto);
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
    	return "user";
    }

    @GetMapping("/about")
    public String about() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }

}
