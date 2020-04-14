package com.example.ac1a2.controller;

import com.example.ac1a2.entidade.Funcionario;
import com.example.ac1a2.service.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioService fs;

    @GetMapping("/funcionarios")
    public ModelAndView getFuncionarioMV()
    {
        ModelAndView mv = new ModelAndView("FuncionarioView");
        mv.addObject("funcionarios", fs.getFuncionario());
        return mv;
    }

    @PostMapping("/salvar")
    public String saveFuncionarioMV(@ModelAttribute Funcionario funcionario, RedirectAttributes attributes)
    {
        if(validar(funcionario))
            fs.addFuncionario(funcionario);
        else
            attributes.addFlashAttribute("msg", "CPF já existente ou algum campo nulo");
        return "redirect:/funcionarios";
    }

    public boolean validar(Funcionario f)
    {
        for (Funcionario auxF: fs.getFuncionario()) {
            if(f.getCPF().equals(auxF.getCPF()))
                return false;
        }
        if(f.getCPF().equals("") || f.getNome().equals("") || f.getEndereco().equals("") || f.getCargo().equals(""))
            return false;
        return true;  
    }
}