/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.projetoIntegrador2.service;

import br.com.senac.projetoIntegrador2.entity.ProdutoVendidoEntity;
import br.com.senac.projetoIntegrador2.repository.ProdutoVendidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author escre
 */
@Service
public class ProdutoVendidoService {

    @Autowired
    ProdutoVendidoRepository pvr;

    public ProdutoVendidoEntity salvarProdutoVendido(ProdutoVendidoEntity pve) {

        return pvr.save(pve);
    }

}
