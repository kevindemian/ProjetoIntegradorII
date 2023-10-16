
package br.com.senac.projetoIntegrador2.service;

import br.com.senac.projetoIntegrador2.entity.ProdutoEntity;
import br.com.senac.projetoIntegrador2.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author escre
 */
@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository pr;

    public ProdutoEntity salvarProduto(ProdutoEntity pe) {

        pr.save(pe);

        return pe;
    }

    public List<ProdutoEntity> listarProdutos() {

        return pr.findAll();
    }

    public ProdutoEntity buscaProdutoPorId(Integer id) {
        
        ProdutoEntity produto = pr.findById(id).orElse(null);

        return produto;
    }

    public void deletaProdutoPorId(Integer id) {

        ProdutoEntity pe = buscaProdutoPorId(id);

        pr.deleteById(pe.getId());
    }

    public List<ProdutoEntity> buscaPorNome(String nome) {
        
      List<ProdutoEntity> lista =  pr.findByNomeContainingOrderByNomeAsc(nome);
  

        return lista ;

    }
}
