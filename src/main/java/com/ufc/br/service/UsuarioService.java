package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.br.model.Usuario;
import com.ufc.br.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;


	
	public List<Usuario> findAll() {
		return repository.findAll();
		
	}
	
	public Usuario getOne (Long id) {
		return repository.getOne(id);
	}
	
	public List<Usuario> findByNome(String nome) {
		return repository.findByNome(nome);
	}
	
	public Usuario save(Usuario usuario) {
		return repository.saveAndFlush(usuario);
	}
	
	public void delete(Long id) {
		Usuario user = getOne(id);
		repository.delete(user);
	}
	
	
	
}
