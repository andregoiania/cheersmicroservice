package br.com.agsouza.cheersmicroservice.dto;

public class Health {

	private String status;
	private DiskSpace diskSpace;
	private Db db;
	private String nomeMs;
	private String url;
	private Jms jms;
		
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public DiskSpace getDiskSpace() {		
		return diskSpace == null ? new DiskSpace() : diskSpace;
	}
	public void setDiskSpace(DiskSpace diskSpace) {
		this.diskSpace = diskSpace;
	}
	public Db getDb() {
		return db == null ? new Db() : db;
	}
	public void setDb(Db db) {
		this.db = db;
	}
	public String getNomeMs() {
		return nomeMs;
	}
	public void setNomeMs(String nomeMs) {
		this.nomeMs = nomeMs;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Jms getJms() {
		return jms == null ? new Jms() : jms;
	}
	public void setJms(Jms jms) {
		this.jms = jms;
	}


}
