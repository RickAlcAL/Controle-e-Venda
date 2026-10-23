package com.senaicttit.estoque.controller;

import com.senaicttit.estoque.model.Fornecedor;
import com.senaicttit.estoque.repository.FornecedorRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class FornecedorApiController {

    private final FornecedorRepository repository;

    public FornecedorApiController(FornecedorRepository repository) {
        this.repository = repository;
    }

    //API do fornecedor onde após o login é efetuado a verificação de request
    @GetMapping("/api/fornecedor")
    public ResponseEntity<?> buscarFornecedorLogado(HttpSession session) {
        String cpfOuCnpj = (String) session.getAttribute("fornecedorLogado");
        System.out.println("API FORNECEDOR | sessão: " + session.getId() + " | fornecedorLogado: " + session.getAttribute("fornecedorLogado"));
        if (cpfOuCnpj == null) {
            return ResponseEntity.status(401).body("Não autenticado");
        }

        Fornecedor f = repository.findByCpfOucnpjFornecedor(cpfOuCnpj).orElse(null);

        if (f == null) {
            return ResponseEntity.status(404).body("Fornecedor não encontrado");
        }

        return ResponseEntity.ok(createDados(f));
    }
    //Método com Nonnull onde os itens não poderam ficar sem valor
    @NonNull
    private static Map<String, Object> createDados(Fornecedor f) {
        Map<String, Object> dados = new LinkedHashMap<>();
        dados.put("nome", f.getNomeFornecedor());
        dados.put("cpfOuCnpj", f.getCpfOucnpjFornecedor());
        dados.put("telefone", f.getTelefoneFornecedor());
        dados.put("email", f.getEmailFornecedor());
        dados.put("endereco", f.getEnderecoFornecedor());
        return dados;
    }
}