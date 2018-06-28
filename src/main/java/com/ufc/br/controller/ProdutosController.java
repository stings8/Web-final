package com.ufc.br.controller;


import com.ufc.br.model.Produto;
import com.ufc.br.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProdutosController {

    @Autowired
    ProdutoService pservice;

    @GetMapping("/cadastrarproduto")
    public ModelAndView cadastrarProduto(){
        ModelAndView mv = new ModelAndView("paginas/cadastrarproduto");
        mv.addObject("produto", new Produto());
        return mv;
    }

    @PostMapping(value = "/saveP")
    public ModelAndView salvarProduto(Produto produto){
        pservice.saveP(produto);
        ModelAndView mv = new ModelAndView("redirect:/");

        return mv;
    }

}
