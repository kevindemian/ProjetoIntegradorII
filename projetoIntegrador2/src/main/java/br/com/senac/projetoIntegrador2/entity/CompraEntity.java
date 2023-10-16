package br.com.senac.projetoIntegrador2.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

/**Classe responsável por registrar as inforamções de compra de produtos*/
@Entity
@Table(name = "compra")
public class CompraEntity {

    //ATRIBUTOS
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_compra;
    
    @OneToMany(mappedBy="compra")
    List<ProdutoCompradoEntity> produtosComprados; 

    @ManyToOne
    @JoinColumn(name="id_fornecedor")
    private FornecedorEntity fornecedor;

    @Column(name="data_compra")
    private Date data;

    private double total;

    @Column(columnDefinition = "boolean not null default true")
    private boolean ativo = true;

    /*------------------------------------------------------------------------------------------------------*/
    //MÉTODOS ESPECIAIS
    public CompraEntity() {
    }

    public CompraEntity(FornecedorEntity fornecedor, Date data, double total) {
        this.fornecedor = fornecedor;
        this.data = data;
        this.total = total;
    }
    
    

    public FornecedorEntity getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorEntity fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<ProdutoCompradoEntity> getProdutosComprados() {
        return produtosComprados;
    }

    public void setProdutosComprados(List<ProdutoCompradoEntity> produtosComprados) {
        this.produtosComprados = produtosComprados;
    }

    

}
