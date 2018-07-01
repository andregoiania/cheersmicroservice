package br.com.agsouza.cheersmicroservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "MICROSERVICE_SEQ", sequenceName = "MICROSERVICE_SEQ", initialValue = 1, allocationSize = 1)
public class Microservice {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MICROSERVICE_SEQ")
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String dominio;
	@NotNull
	private Long springBootVesion;	
	private String descricao;
	@NotNull
	private String terminal;
	@NotNull
	private String ambiente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	public Long getSpringBootVesion() {
		return springBootVesion;
	}
	public void setSpringBootVesion(Long springBootVesion) {
		this.springBootVesion = springBootVesion;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ambiente == null) ? 0 : ambiente.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dominio == null) ? 0 : dominio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((springBootVesion == null) ? 0 : springBootVesion.hashCode());
		result = prime * result + ((terminal == null) ? 0 : terminal.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Microservice other = (Microservice) obj;
		if (ambiente == null) {
			if (other.ambiente != null)
				return false;
		} else if (!ambiente.equals(other.ambiente))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dominio == null) {
			if (other.dominio != null)
				return false;
		} else if (!dominio.equals(other.dominio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (springBootVesion == null) {
			if (other.springBootVesion != null)
				return false;
		} else if (!springBootVesion.equals(other.springBootVesion))
			return false;
		if (terminal == null) {
			if (other.terminal != null)
				return false;
		} else if (!terminal.equals(other.terminal))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Microservice [id=" + id + ", nome=" + nome + ", dominio=" + dominio + ", springBootVesion="
				+ springBootVesion + ", descricao=" + descricao + ", terminal=" + terminal + ", ambiente=" + ambiente
				+ "]";
	}
	
	
}
