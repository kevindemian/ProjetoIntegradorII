package br.com.senac.projetoIntegrador2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 *
 * @author escre
 */
/**
 * Registra as vendas
 */
@Entity
@Table(name = "venda")
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int codigoDaVenda;
///*
//    *Mapeia a relação entre venda e produto
//    */    
//    @OneToMany(mappedBy="venda", cascade = CascadeType.ALL)
//    List<ProdutoVendidoEntity> produtosVendidos;

    @Column(name="qtd_parcelas")
    private int quantidadeParcelas;

    private Date data_venda;

    
    /**Mapeia a relação entre usuário e produto*/
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private UsuarioEntity usuario;

    private String forma_pagamento;

    private Double total;

    @Column(columnDefinition = "boolean not null default true")
    private boolean ativo = true;

    public VendaEntity() {
    }

    public VendaEntity(int codigoDaVenda, int quantidadeParcelas, Date data_venda, UsuarioEntity usuario, String forma_pagamento, Double total, boolean ativo) {
        this.codigoDaVenda = codigoDaVenda;
        this.quantidadeParcelas = quantidadeParcelas;
        this.data_venda = data_venda;
        this.usuario = usuario;
        this.forma_pagamento = forma_pagamento;
        this.total = total;
        this.ativo = ativo;
    }

    public int getCodigoDaVenda() {
        return codigoDaVenda;
    }

    public void setCodigoDaVenda(int codigoDaVenda) {
        this.codigoDaVenda = codigoDaVenda;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }




}
