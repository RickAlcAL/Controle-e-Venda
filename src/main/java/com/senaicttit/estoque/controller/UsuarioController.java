package com.senaicttit.estoque.controller;

import com.senaicttit.estoque.model.Usuario;
import com.senaicttit.estoque.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder encoder;

    // Garante expressamente que quem acede a raiz "/" vai para a tela de login (login.html)
    @GetMapping("/")
    public String paginaInicial() {
        return "redirect:/login.html";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@RequestParam String nomeUsuario,
                            @RequestParam String senha_hash) {
        Usuario u = new Usuario();
        u.setNome_usuario(nomeUsuario);
        u.setSenhaHash(encoder.encode(senha_hash));
        repository.save(u);
        return "redirect:/login.html"; // Após cadastrar, volta para o login
    }

    @PostMapping("/login")
    public String login(@RequestParam String nomeUsuario, @RequestParam String senha_hash) {
        Usuario u = repository.findByNomeUsuario(nomeUsuario).orElse(null);

        if (u != null && encoder.matches(senha_hash, u.getSenhaHash())) {
            // Se acertar o login, vai para a tela de seleção/abas
            return "redirect:/select.html";
        }

        // Se errar, volta para a tela de login
        return "redirect:/login.html?error=true";
    }
}