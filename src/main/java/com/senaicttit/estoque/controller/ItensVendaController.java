package com.senaicttit.estoque.controller;

import com.senaicttit.estoque.model.ItensVenda;
import com.senaicttit.estoque.service.ItensVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itensVenda")
public class ItensVendaController {
    @Autowired
    private ItensVendaService itensVendaService;

    @GetMapping("/listarItensVendas")
    public List<ItensVenda> pegandoListaItensVenda () {
        return itensVendaService.listarItensVendas();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItensVenda adicionandoVenda (@RequestBody ItensVenda itensVenda) {
        return itensVendaService.salvandoItens(itensVenda);
    }
}
