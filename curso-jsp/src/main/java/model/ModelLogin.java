package model;

import java.io.Serializable;

public class ModelLogin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String login;
	private String Senha;
	
	
	public void setSenha(String senha) {
		Senha = senha;
	}
	
	public String getSenha() {
		return Senha;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	

}
