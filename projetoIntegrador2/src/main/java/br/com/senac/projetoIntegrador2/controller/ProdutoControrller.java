/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.projetoIntegrador2.controller;

import br.com.senac.projetoIntegrador2.entity.CompraEntity;
import br.com.senac.projetoIntegrador2.entity.FornecedorEntity;
import br.com.senac.projetoIntegrador2.entity.ProdutoCompradoEntity;
import br.com.senac.projetoIntegrador2.entity.ProdutoEntity;
import br.com.senac.projetoIntegrador2.entity.ProdutoVendidoEntity;
import br.com.senac.projetoIntegrador2.entity.VendaEntity;
import br.com.senac.projetoIntegrador2.service.CompraService;
import br.com.senac.projetoIntegrador2.service.FornecedorService;
import br.com.senac.projetoIntegrador2.service.ProdutoCompradoService;
import br.com.senac.projetoIntegrador2.service.ProdutoService;
import br.com.senac.projetoIntegrador2.service.ProdutoVendidoService;
import br.com.senac.projetoIntegrador2.service.UsuarioService;
import br.com.senac.projetoIntegrador2.service.VendaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin(origins = "*")

public class ProdutoControrller {

    @Autowired
    ProdutoService ps;
    @Autowired
    VendaService vs;
    @Autowired
    ProdutoVendidoService pvs;
    @Autowired
    UsuarioService us;
    @Autowired
    FornecedorService fs;
    @Autowired
    CompraService cs;
    @Autowired
    ProdutoCompradoService pcs;

    @GetMapping("/pesquisaid")
    public ModelAndView pesquisaPorId(@RequestParam(name = "id", defaultValue = "0") int id, HttpServletRequest request) {
        HttpSession sessao = request.getSession();
        if (sessao != null && sessao.getAttribute("usuario") != null && sessao.getAttribute("autorizado").equals(true)) {
            ModelAndView mv = new ModelAndView("main");
            List<ProdutoEntity> estoque = new ArrayList<>();

            ProdutoEntity resultado = ps.buscaProdutoPorId(id);
            if (resultado == null) {
                resultado = new ProdutoEntity(0, "PRODUTO", "NÃO", "ENCONTRADO", 0);
            }
            estoque.add(resultado);

            mv.addObject("estoque", estoque);

            return mv;
        }

        return new ModelAndView("login");
    }

    @GetMapping("/pesquisa/produto/")
    public ProdutoEntity getProdutoId(@RequestParam(name = "id", defaultValue = "0") int id, HttpServletRequest request) {
HttpSession sessao = request.getSession();
        if (sessao != null && sessao.getAttribute("usuario") != null && sessao.getAttribute("autorizado").equals(true)) {
            return ps.buscaProdutoPorId(id);
        }
        return null;
    }

    @GetMapping("/pesquisanome")
    public ModelAndView pesquisaPorNome(@RequestParam(name = "nome", defaultValue = "") String nome, HttpServletRequest request) {

        HttpSession sessao = request.getSession();
        if (sessao != null && sessao.getAttribute("usuario") != null && sessao.getAttribute("autorizado").equals(true)) {
            ModelAndView mv = new ModelAndView("main");
            List<ProdutoEntity> estoque = ps.buscaPorNome(nome);
            if (estoque.isEmpty()) {
                estoque.add(new ProdutoEntity(0, "PRODUTO", "NÃO", "ENCONTRADO", 0));
            }

            mv.addObject("estoque", estoque);

            return mv;
        }
        return new ModelAndView("login");
    }

    @PostMapping("/saidaproduto")
    public ProdutoVendidoEntity saidaProduto(@RequestParam(name = "id") int id, @RequestBody ProdutoVendidoEntity produtoVendido, HttpServletRequest request) {

        HttpSession sessao = request.getSession();
  
        if (sessao != null && sessao.getAttribute("usuario") != null && sessao.getAttribute("autorizado").equals(true)) {

        ProdutoEntity produto = ps.buscaProdutoPorId(id);
        int quantidadeProduto = produto.getQuantidade() - produtoVendido.getQuantidade_vendida();
        double total = produtoVendido.getQuantidade_vendida() * produtoVendido.getPreco();

        produtoVendido.setProdutoVendido(produto);
        produto.setQuantidade(quantidadeProduto);
        VendaEntity venda = new VendaEntity();
        venda.setData_venda(new Date());
        venda.setForma_pagamento("dinheiro");
        venda.setQuantidadeParcelas(1);
        venda.setTotal(total);

        produtoVendido.setVenda(venda);

        vs.salvaVenda(venda);
        ps.salvarProduto(produto);
        pvs.salvarProdutoVendido(produtoVendido);

        return produtoVendido;
        }
return null;
    }

    @PostMapping("/entradaproduto")
    public ProdutoCompradoEntity entradaProduto(@RequestParam(name = "id") int idFornecedor, @RequestBody ProdutoCompradoEntity produtoComprado, HttpServletRequest request) {

        HttpSession sessao = request.getSession();
if (sessao != null && sessao.getAttribute("usuario") != null && sessao.getAttribute("autorizado").equals(true)) {
        ProdutoEntity produto = produtoComprado.getProdutoComprado();
        produto.setQuantidade(produto.getQuantidade() + produtoComprado.getQuantidade_comprada());

        FornecedorEntity fornecedor = fs.buscaFornecedorPorId(idFornecedor);
        double total = produtoComprado.getPreco() * produtoComprado.getQuantidade_comprada();

        CompraEntity compra = new CompraEntity(fornecedor, new Date(), total);

        produtoComprado.setCompra(compra);

        ps.salvarProduto(produto);
        cs.saveCompra(compra);
        pcs.salvaProdutoComprado(produtoComprado);

        return produtoComprado;
}
return null;
    }

}
