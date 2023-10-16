/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.projetoIntegrador2.service;

import br.com.senac.projetoIntegrador2.entity.VendaEntity;
import br.com.senac.projetoIntegrador2.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author escre
 */
@Service
public class VendaService {
    @Autowired
    VendaRepository vr;
    
    public VendaEntity salvaVenda(VendaEntity venda){
    
   return vr.save(venda);
    
    }
    
}
