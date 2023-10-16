
package br.com.senac.projetoIntegrador2.repository;

import br.com.senac.projetoIntegrador2.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    
}
