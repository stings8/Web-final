package com.ufc.br.service;
import com.ufc.br.model.Produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ufc.br.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto>findAll(){
		return repository.findAll();
	}
	
	public Produto getOne(Long id) {
		return repository.getOne(id);
	}
	
	public List<Produto>findByTipo(String tipo){
		return repository.findByTipo(tipo);
	}
	
	public List<Produto>findByNome(String nome){
		return repository.findByNome(nome);
	}
	
	public List<Produto>findByFabricante(String fabricante){
		return repository.findByFabricante(fabricante);
	}
	
	public Produto save(Produto produto) {
		return repository.saveAndFlush(produto);
	}
	
	public void delete(Long id) {
		Produto p = repository.getOne(id);
		repository.delete(p);
	}
}
