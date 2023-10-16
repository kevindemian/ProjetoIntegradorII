/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.projetoIntegrador2.service;

import br.com.senac.projetoIntegrador2.entity.ProdutoCompradoEntity;
import br.com.senac.projetoIntegrador2.repository.ProdutoCompradoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author escre
 */

@Service
public class ProdutoCompradoService {
    @Autowired
    ProdutoCompradoRepository pcr;
    
    public List<ProdutoCompradoEntity> geraListaProdutoComprado(){
    
        return pcr.findAll();
    }
    
    public ProdutoCompradoEntity getProdutoCompradoPorId(int id){
    
        return pcr.findById(id).orElse(null);
    }
    
    
    public ProdutoCompradoEntity salvaProdutoComprado(ProdutoCompradoEntity produtoComprado){
    
    
    return pcr.save(produtoComprado);
    }
    
    
   
    
}
