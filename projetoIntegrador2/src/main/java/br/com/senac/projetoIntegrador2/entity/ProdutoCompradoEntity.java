/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.projetoIntegrador2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "item_comprado")
public class ProdutoCompradoEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 

    @ManyToOne
    @JoinColumn(name="compra_id")
    private CompraEntity compra;
    
    @ManyToOne
    @JoinColumn(name="produto_id")
    private ProdutoEntity produtoComprado;

    private int quantidade_comprada;

    private double preco;

    @Column(columnDefinition = "boolean default true")
    private boolean ativo;
    
    
    
  //MÉTODOS----------------------------------------------------------------------------------------------------------------------------------------------  

    public ProdutoCompradoEntity() {
    }

    public ProdutoCompradoEntity(CompraEntity compra, ProdutoEntity produtoComprado, int quantidade_comprada, double preco) {
        this.compra = compra;
        this.produtoComprado = produtoComprado;
        this.quantidade_comprada = quantidade_comprada;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompraEntity getCompra() {
        return compra;
    }

    public void setCompra(CompraEntity compra) {
        this.compra = compra;
    }

    public ProdutoEntity getProdutoComprado() {
        return produtoComprado;
    }

    public void setProdutoComprado(ProdutoEntity produtoComprado) {
        this.produtoComprado = produtoComprado;
    }

    public int getQuantidade_comprada() {
        return quantidade_comprada;
    }

    public void setQuantidade_comprada(int quantidade_comprada) {
        this.quantidade_comprada = quantidade_comprada;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    

}
