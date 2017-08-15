package br.edu.facear.model;

public class Cliente {
	private Integer id;
	private String nome;
	private String cpf;
	private String email, senha;
	
	public Cliente(Integer id, String nome,String cpf,String email,String senha){
		this.setId(id);
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setSenha(senha);
	}
	public Cliente(String nome,String cpf,String email,String senha){
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setSenha(senha);
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
