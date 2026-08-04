package com.senaicttit.estoque.controller;

import com.senaicttit.estoque.model.Venda;
import com.senaicttit.estoque.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")

public class VendaController {

    @Autowired
    private VendaService vendaService;


    @GetMapping("/listarVendas")
    public List<Venda> listandoVendas () {
        return vendaService.buscandoVendas();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Venda salvandoVenda (@RequestBody Venda venda) {
        return vendaService.salvandoVenda(venda);
    }
}
