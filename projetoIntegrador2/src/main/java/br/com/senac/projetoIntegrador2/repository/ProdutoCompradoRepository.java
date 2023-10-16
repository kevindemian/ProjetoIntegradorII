/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.senac.projetoIntegrador2.repository;

import br.com.senac.projetoIntegrador2.entity.ProdutoCompradoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author escre
 */
@Repository
public interface ProdutoCompradoRepository extends JpaRepository<ProdutoCompradoEntity, Integer>{
    
}
