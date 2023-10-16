/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.projetoIntegrador2.controller;

import br.com.senac.projetoIntegrador2.entity.UsuarioEntity;
import br.com.senac.projetoIntegrador2.service.UsuarioService;
import br.com.senac.projetoIntegrador2.uteis.Criptografia;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutenticacaoController {

    @Autowired
    UsuarioService us;



    @PostMapping("/autentica")
    public String autentica(HttpServletRequest request, UsuarioEntity user) {

        HttpSession sessao = request.getSession();

        List<UsuarioEntity> listaUsuarios = us.listarUsuarios();
        user.setSenha(Criptografia.getMD5(user.getSenha()));

        for (UsuarioEntity usuario : listaUsuarios) {

            if (usuario.equals(user)) {

                sessao.setAttribute("usuario", usuario.getNome());
                sessao.setAttribute("nivel", usuario.getNivelDeAcesso());
                sessao.setAttribute("id", usuario.getId());
                sessao.setAttribute("autorizado", true);

                return "redirect:/main";
            }

        }
        return "login";
    }



    
       @GetMapping("/logout")
    public String excluiSessao(HttpServletRequest request) {
        HttpSession sessao = request.getSession();
        if (sessao != null) {
            sessao.invalidate();
        }
        return ("redirect:/");
    }

}
