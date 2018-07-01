package br.com.agsouza.cheersmicroservice.dto;

public class Db {
	private String status;
	private DataSource dataSource;
	private N4DataSource n4DataSource;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public DataSource getDataSource() {
		return dataSource == null ? new DataSource() : dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public N4DataSource getN4DataSource() {
		return n4DataSource == null ? new N4DataSource() : n4DataSource;
	}
	public void setN4DataSource(N4DataSource n4DataSource) {
		this.n4DataSource = n4DataSource;
	}
	
}
