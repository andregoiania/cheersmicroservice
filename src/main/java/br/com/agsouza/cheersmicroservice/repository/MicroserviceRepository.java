package br.com.agsouza.cheersmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agsouza.cheersmicroservice.domain.Microservice;

public interface MicroserviceRepository extends JpaRepository<Microservice, Long> {

	List<Microservice> findByAmbienteAndTerminal(String ambiente, String terminal);

}
