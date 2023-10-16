/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.projetoIntegrador2.controller;

import br.com.senac.projetoIntegrador2.entity.FornecedorEntity;
import br.com.senac.projetoIntegrador2.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    
    @Autowired 
        FornecedorService fr;
    
    @GetMapping
    public FornecedorEntity getFornecedorPorId(@RequestParam(name="id")int id){
    
    
    
    return fr.buscaFornecedorPorId(id);
    }
    
}
