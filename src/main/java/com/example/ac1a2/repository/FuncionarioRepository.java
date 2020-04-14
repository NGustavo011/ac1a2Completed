package com.example.ac1a2.repository;

import com.example.ac1a2.entidade.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

}