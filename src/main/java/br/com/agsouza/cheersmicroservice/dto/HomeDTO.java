package br.com.agsouza.cheersmicroservice.dto;

public class HomeDTO {
	Iterable<Health> listaStatus;
	String terminal;
	String ambiente;
	
	
	public Iterable<Health> getListaStatus() {
		return listaStatus;
	}
	public void setListaStatus(Iterable<Health> listaStatus) {
		this.listaStatus = listaStatus;
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
	
	
}
