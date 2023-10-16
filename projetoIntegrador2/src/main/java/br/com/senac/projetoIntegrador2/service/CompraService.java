/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.projetoIntegrador2.service;

import br.com.senac.projetoIntegrador2.entity.CompraEntity;
import br.com.senac.projetoIntegrador2.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author escre
 */
@Service
public class CompraService {
    
    @Autowired
    CompraRepository cr;
    
    
    public CompraEntity saveCompra(CompraEntity compra){
    
        return cr.save(compra);
    }
    
}
