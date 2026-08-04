package com.senaicttit.estoque.service;

import com.senaicttit.estoque.model.Entrada;
import com.senaicttit.estoque.repository.EntradaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Transactional
    public Entrada salvandoEntrada(Entrada entrada){
        return entradaRepository.save(entrada);
    }

    public List<Entrada> buscandoIdProduto () {
        return entradaRepository.findAll();
    }
}
