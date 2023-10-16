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
@Table(name = "item_vendido")
public class ProdutoVendidoEntity {

    /*ATRIBUTOS--------------------------------------------------------------------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produtoVendido;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private VendaEntity venda;

    private int quantidade_vendida;

    private double preco;

    @Column(columnDefinition = "boolean not null default true")
    private boolean ativo=true;

    /*MÉTODOS---------------------------------------------------------------------------*/

    public ProdutoVendidoEntity() {
    }

    public ProdutoVendidoEntity(int id, ProdutoEntity produtoVendido, VendaEntity venda, int quantidade_vendida, double preco, boolean ativo) {
        this.id = id;
        this.produtoVendido = produtoVendido;
        this.venda = venda;
        this.quantidade_vendida = quantidade_vendida;
        this.preco = preco;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProdutoEntity getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(ProdutoEntity produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    public VendaEntity getVenda() {
        return venda;
    }

    public void setVenda(VendaEntity venda) {
        this.venda = venda;
    }

    public int getQuantidade_vendida() {
        return quantidade_vendida;
    }

    public void setQuantidade_vendida(int quantidade_vendida) {
        this.quantidade_vendida = quantidade_vendida;
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
