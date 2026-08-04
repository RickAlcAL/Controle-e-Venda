package com.senaicttit.estoque.service;

import com.senaicttit.estoque.model.Fornecedor;
import com.senaicttit.estoque.repository.FornecedorRepository;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Transactional
    public Fornecedor salvandoFornecedor (Fornecedor fornecedor){
        return  fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> buscarTodosFornecedores(){
        return  fornecedorRepository.findAll();
    }


}
