/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.projetoIntegrador2.service;

import br.com.senac.projetoIntegrador2.entity.FornecedorEntity;
import br.com.senac.projetoIntegrador2.repository.FornecedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author escre
 */
@Service
public class FornecedorService {
    
    @Autowired
    FornecedorRepository fr;
    
    
    public List<FornecedorEntity> geraListaFornecedores(){
    
        List<FornecedorEntity> lista = fr.findAll();
    
        return lista;
    }
    
    public FornecedorEntity buscaFornecedorPorId(int id){
        
        return fr.findById(id).orElse(null);
    }
}
