package br.com.senac.projetoIntegrador2.controller;

import br.com.senac.projetoIntegrador2.entity.FornecedorEntity;
import br.com.senac.projetoIntegrador2.entity.ProdutoEntity;
import br.com.senac.projetoIntegrador2.service.FornecedorService;
import br.com.senac.projetoIntegrador2.service.ProdutoService;
import br.com.senac.projetoIntegrador2.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SiteController {

    @Autowired
    UsuarioService us;
    @Autowired
    ProdutoService ps;
    @Autowired
    FornecedorService fs;
  

    public List<ProdutoEntity> geraListaProdutosEstoque() {

        List<ProdutoEntity> listaProdutos = ps.listarProdutos();
        
        List<ProdutoEntity> produtosEmEstoque = new ArrayList<>();

        for (ProdutoEntity produto : listaProdutos) {
            if (produto.getQuantidade() > 0) {
               
                produtosEmEstoque.add(produto);
            }

        }

        return produtosEmEstoque;
    }

    @GetMapping()
    public String getHome() {

        return "login";
    }

    @GetMapping("/main")
    public ModelAndView acessaMain(HttpServletRequest request) {

        HttpSession sessao = request.getSession();
        if (sessao != null && sessao.getAttribute("usuario") != null && sessao.getAttribute("autorizado").equals(true)) {

            ModelAndView mv = new ModelAndView("main");

            List<ProdutoEntity> estoque = geraListaProdutosEstoque();
            mv.addObject("estoque", estoque);
            
            List<FornecedorEntity> fornecedores = fs.geraListaFornecedores();
            mv.addObject("fornecedores", fornecedores);

            return mv;
        }

        return new ModelAndView("redirect:/");
    }
    
    
    

}
