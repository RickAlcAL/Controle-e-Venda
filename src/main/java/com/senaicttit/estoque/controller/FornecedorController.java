package com.senaicttit.estoque.controller;

import com.senaicttit.estoque.model.Fornecedor;
import com.senaicttit.estoque.model.Usuario;
import com.senaicttit.estoque.repository.FornecedorRepository;
import com.senaicttit.estoque.service.FornecedorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/fornecedores")
@CrossOrigin(origins = "*") /* Adicionando crossorigin para falar pro fron-end que aqui terá acesso total*/
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;
    @Autowired
    private FornecedorRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    @GetMapping()
    @ResponseBody
    public List<Fornecedor> listarFornecedores() {
        return fornecedorService.buscarTodosFornecedores();
    }

    @PostMapping("/cadastrar-fornecedor")
    public String cadastrar(@RequestParam String nomeFornecedor,
                            @RequestParam String cpf_ou_cnpj,
                            @RequestParam String telefone_fornecedor,
                            @RequestParam String email_fornecedor,
                            @RequestParam String endereco_fornecedor,
                            @RequestParam String senha_fornecedor,
                            HttpServletRequest request) {
        Fornecedor f = repository.findByCpfOucnpjFornecedor(cpf_ou_cnpj).orElse(null);
        HttpSession antiga = request.getSession(false);
        //Verifica se ja possui uma sessão ativa
        if (antiga != null) {
            antiga.invalidate();
        }
        if (f == null){
            Fornecedor forneNew = new Fornecedor();
            forneNew.setNomeFornecedor(nomeFornecedor);
            forneNew.setCpfOucnpjFornecedor(cpf_ou_cnpj);
            forneNew.setTelefoneFornecedor(telefone_fornecedor);
            forneNew.setEmailFornecedor(email_fornecedor);
            forneNew.setEnderecoFornecedor(endereco_fornecedor);
            forneNew.setSenhaHashFornecedor(encoder.encode(senha_fornecedor));
            repository.save(forneNew);
            System.out.println("Enviado");
        }
        HttpSession session = request.getSession(true);

        session.setAttribute("usuarioLogado", nomeFornecedor);
        System.out.println("API | sessão: " + session.getId() + " | usuarioLogado: " + session.getAttribute("usuarioLogado"));
        nomeFornecedor = (String) session.getAttribute("usuarioLogado");

        return "redirect:/select.html"; // Após cadastrar, volta para o login4

    }
}
