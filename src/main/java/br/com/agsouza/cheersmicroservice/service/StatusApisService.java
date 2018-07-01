package br.com.agsouza.cheersmicroservice.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.agsouza.cheersmicroservice.domain.Microservice;
import br.com.agsouza.cheersmicroservice.dto.Health;
import br.com.agsouza.cheersmicroservice.repository.MicroserviceRepository;

@Service("StatusApisService")
public class StatusApisService {

	@Autowired
	MicroserviceRepository microserviceRepository;

	public List<Health> listaStatus() {
		return listaStatus("PROD", "Rio");
	}
	

	public List<Health> listaStatus(String ambiente, String terminal) {
		List<Microservice> microservices = microserviceRepository.findByAmbienteAndTerminal(ambiente, terminal);
		List<Health> Healths = new LinkedList<>();
		
		for (Microservice microservice : microservices) {
			Health health = new Health();
			
			String healthStr = microservice.getSpringBootVesion() == 1 ? "/health" : "/actuator/health"; 
			String url = microservice.getDominio() + healthStr;
			
			try {
				RestTemplate restTemplate = new RestTemplate(); 
				health = restTemplate.getForObject(url, Health.class);
			} catch (Exception e) {
				health.setStatus("FALL");
				// TODO Auto-generated catch block
				e.printStackTrace();				
			}
			health.setNomeMs(microservice.getNome());
			health.setUrl(microservice.getDominio());
			Healths.add(health);			
		}
		
		return Healths;
	}
}
