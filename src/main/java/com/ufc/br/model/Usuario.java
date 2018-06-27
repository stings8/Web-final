package com.ufc.br.model;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;


@Entity(name = "usuario")
public  class Usuario implements Serializable {


	private static final long serialVersionUID = 1L;


    @Id
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private long id;
	
	@OneToMany
	private List<Produto>produtos;
	
	@Column(name = "nome" )
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "senha")
	private String senha;


	public  Usuario (){}
	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Usuario)) return false;
		Usuario usuario = (Usuario) o;
		return getId() == usuario.getId() &&
				Objects.equals(getNome(), usuario.getNome());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getId(), getNome());
	}


}
