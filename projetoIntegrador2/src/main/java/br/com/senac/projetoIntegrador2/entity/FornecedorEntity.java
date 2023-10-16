package br.com.senac.projetoIntegrador2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



/**Classe responsável por gerenciar o cadastro de fornecedores*/
@Entity
@Table(name="fornecedor")
public class FornecedorEntity {
//ATRIBUTOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String razaoSocial;
    private String nomeFantasia;
    private String endereco;
    private String telefone;
    private String email;
    private String site;
    private String nomeVendedor;
    private String cnpj;
    private String tipoProduto;
    
    @Column(columnDefinition = "boolean default true")
    private boolean ativo;


    /*-------------------------------------------------------------------------------------------------------------------------*/
//MÉTODOS ESPECIAIS  
    public FornecedorEntity() {
    }

    public FornecedorEntity(String razaoSocial, String nomeFantasia, String endereco, String telefone,
            String email, String site, String nomeVendedor, String cnpj, String tipoProduto) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
        this.nomeVendedor = nomeVendedor;
        this.cnpj = cnpj;
        this.tipoProduto = tipoProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    

}
