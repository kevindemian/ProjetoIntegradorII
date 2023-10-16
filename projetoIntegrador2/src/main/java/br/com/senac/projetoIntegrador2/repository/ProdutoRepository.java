/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.projetoIntegrador2.repository;

import br.com.senac.projetoIntegrador2.entity.ProdutoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author escre
 */
@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {
    
    
List<ProdutoEntity> findByNomeContainingOrderByNomeAsc(String nome);

    
}
