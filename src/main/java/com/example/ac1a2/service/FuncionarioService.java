package com.example.ac1a2.service;

import com.example.ac1a2.repository.FuncionarioRepository;

import java.util.List;

import com.example.ac1a2.entidade.Funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository fp;

    public List<Funcionario> getFuncionario()
    {
        return fp.findAll();
    }

    public void addFuncionario(Funcionario f)
    {        
       fp.save(f);
    }
    
}