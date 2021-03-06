package com.ufc.br.controller;


import com.ufc.br.model.Produto;
import com.ufc.br.model.Usuario;
import com.ufc.br.repository.UsuarioRepository;
import com.ufc.br.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    List<Produto>produtos = new ArrayList<Produto>();
    Double total = 0.0;

    @Autowired
    UsuarioRepository uservice;

    @Autowired
    ProdutoService pservice;



    @GetMapping("/carrinho")
    public ModelAndView carrinho(){
        Produto produto = pservice.getOne(1l);
        ModelAndView mv = new ModelAndView( "paginas/carrinho");
        mv.addObject("produtosCarrinho", produtos);

        mv.addObject("precoTotal", total);

        return mv;
    }

    @GetMapping("/login")
    public ModelAndView logar(){
        ModelAndView mv = new ModelAndView("paginas/login");
        return mv;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastrarUsuario(){
        ModelAndView mv = new ModelAndView("paginas/cadastro");
        mv.addObject("usuario", new Usuario());
        return mv;
    }

    @PostMapping(value = "/save")
    public ModelAndView salvarUsuario(Usuario usuario){
        System.out.println(usuario);
        uservice.save(usuario);
        ModelAndView mv = new ModelAndView("redirect:/login");

        return mv;
    }

    @GetMapping("/pagamento")
    public ModelAndView finalizar(){
        ModelAndView mv = new ModelAndView( "paginas/pagamento");
        mv.addObject("produtosCarrinho", produtos);
        mv.addObject("precoTotal", total);
        return mv;

    }
    @PostMapping("/finalizar")
    public ModelAndView salvarPagamento(@PathVariable Long id){
        Usuario user = uservice.getOne(id);
        user.getProdutos().addAll(produtos);
        uservice.save(user);
        ModelAndView mv = new ModelAndView("redirect:/listaproduto");
        mv.addObject("produtos", user.getProdutos());
        return mv;
    }

//   @GetMapping(value ="/listaproduto")
//    public ModelAndView listarProdutos(){
//
//        ModelAndView mv = new ModelAndView("/listaproduto");
//        mv.addObject("produtos", user.getProdutos());
//        return mv;
//
//
//    }

    @GetMapping(value ="/comprar/{id}")
    public ModelAndView adicionarCompra(@PathVariable Long id){
        Produto produto = pservice.getOne(id);
        produtos.add(produto);
        total += produto.getValor();

        ModelAndView mv = new ModelAndView("redirect:/");
//        mv.addObject("produtosCliente", produtos);
//        mv.addObject("valorToral", total);
        return mv;
    }







}
