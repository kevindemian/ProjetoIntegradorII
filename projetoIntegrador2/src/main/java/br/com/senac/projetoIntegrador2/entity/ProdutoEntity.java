package br.com.senac.projetoIntegrador2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;



/**Class responsável por criar os objetos Produto*/
@Component
@Entity
@Table(name="produto")
public class ProdutoEntity {

    //ATRIBUTOS
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    /**Mapeamento da relação entre Compra e Produto*/
    @JsonIgnore
    @OneToMany(mappedBy="produtoComprado", cascade = CascadeType.ALL)
    List<ProdutoCompradoEntity> produtoComprado;
    
    /**Mapeamento da relação entre Venda e Produto*/
    @JsonIgnore
    @OneToMany(mappedBy="produtoVendido", cascade = CascadeType.ALL)
    List<ProdutoVendidoEntity> produtoVendido;
    
    private String nome;
    
    private String marca;
    
    private String tipo;
    
    private String fabricante;
    
    private double desconto;
    
    private double precoVenda;
    
    @Column(columnDefinition = "INT UNSIGNED NOT NULL DEFAULT 0")
    private int quantidade;
    
    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    private boolean ativo;

    /*----------------------------------------------------------------------------------------------------------*/
    //MÉTODOS ESPECIAIS
    public ProdutoEntity() {

    }

    public ProdutoEntity(int id, String nome, String fabricante, String tipo, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
    }
    
    

    public ProdutoEntity(String nome, String marca, String tipo, String fabricante) {
        this.nome = nome;
        this.marca = marca;
        this.tipo = tipo;
        this.fabricante = fabricante;
    }

   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public List<ProdutoCompradoEntity> getProdutoComprado() {
        return produtoComprado;
    }

    public void setProdutoComprado(List<ProdutoCompradoEntity> produtoComprado) {
        this.produtoComprado = produtoComprado;
    }

    public List<ProdutoVendidoEntity> getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(List<ProdutoVendidoEntity> produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.marca);
        hash = 29 * hash + Objects.hashCode(this.tipo);
        hash = 29 * hash + Objects.hashCode(this.fabricante);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProdutoEntity other = (ProdutoEntity) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.fabricante, other.fabricante);
    }

    @Override
    public String toString() {
        return "ProdutoEntity{" + "id=" + id + ", produtoComprado=" + produtoComprado + ", produtoVendido=" + produtoVendido + ", nome=" + nome + ", marca=" + marca + ", tipo=" + tipo + ", fabricante=" + fabricante + ", desconto=" + desconto + ", precoVenda=" + precoVenda + ", quantidade=" + quantidade + ", ativo=" + ativo + '}';
    }

}
