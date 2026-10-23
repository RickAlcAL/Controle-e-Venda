package com.senaicttit.estoque.service;

import com.senaicttit.estoque.model.Fornecedor;
import com.senaicttit.estoque.repository.FornecedorRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;


    public List<Fornecedor> buscarTodosFornecedores(){
        return  fornecedorRepository.findAll();
    }
}
