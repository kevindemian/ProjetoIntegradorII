/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.projetoIntegrador2.service;

import br.com.senac.projetoIntegrador2.entity.UsuarioEntity;
import br.com.senac.projetoIntegrador2.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author escre
 */
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository ur;
    
    
    public UsuarioEntity salvarUsuario(UsuarioEntity ue){
    
        ur.save(ue);
        
        return ue;
    }
    
    public List<UsuarioEntity> listarUsuarios(){
    
        return ur.findAll();
    }
    
    public UsuarioEntity buscaUsuarioPorId(Integer id){
    
   return ur.findById(id).orElse(null);
    
    }
    
    public void deletaUsuarioPorId(Integer id){
    
        UsuarioEntity ue = buscaUsuarioPorId(id);
    
    ur.deleteById(ue.getId());
    
    }
    
}
