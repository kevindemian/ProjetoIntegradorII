/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.projetoIntegrador2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author escre
 */
@Controller
@RequestMapping("/sessoes")
public class SessaoController {

    @GetMapping("/grava")
    public String gravaSessao(HttpServletRequest request, Model model, String nome) {
        HttpSession sessao = request.getSession();
        if (sessao != null) {
            sessao.setAttribute("nome-usuario", nome);
            model.addAttribute("mensagem", "Gravando Sessao[nome]");
        } else {
            model.addAttribute("mensagem", "Sessão nula");
        }
        return "sessao";
    }

    @GetMapping("/le")
    public String leSessao(HttpServletRequest request, Model model) {
        
        HttpSession sessao = request.getSession();
        String nome = "";
        
        if (sessao != null && sessao.getAttribute("nome-usuario") != null) {
            
            nome = (String) sessao.getAttribute("nome-usuario");
        }
        model.addAttribute("mensagem", "Sessao['nome'] = " + nome);
        return "sessao";
    }

    @GetMapping("/exclui")
    public String excluiSessao(HttpServletRequest request) {
        HttpSession sessao = request.getSession();
        if (sessao != null) {
            sessao.removeAttribute("usuario");
        }
        return "Excluído";
    }
}
