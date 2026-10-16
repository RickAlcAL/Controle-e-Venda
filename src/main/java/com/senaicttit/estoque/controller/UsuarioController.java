package com.senaicttit.estoque.controller;

import com.senaicttit.estoque.model.Usuario;
import com.senaicttit.estoque.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    /* Método que recebe a senha e o nome do usuario para login.
    *     Com isto passa por um processo de INSERT onde set o nome do usuario e a senha
    * passando por um encoder que criptografa a senha do usuario*/
    @PostMapping("/cadastro")
    public String cadastrar(@RequestParam String nomeUsuario,
                            @RequestParam String senha_hash) {
        Usuario u = new Usuario();
        u.setNome_usuario(nomeUsuario);
        u.setSenhaHash(encoder.encode(senha_hash)); // aqui acontece a criptografia
        repository.save(u);
        return "redirect:/select.html";
    }
    // Método de login
    @PostMapping("/login")
    public String login(@RequestParam String nomeUsuario, @RequestParam String senha_hash) {
        Usuario u = repository.findByNomeUsuario(nomeUsuario).orElse(null);

        if (u != null && encoder.matches(senha_hash, u.getSenhaHash())) {
            return "redirect:/select.html";
            //Caso seja encontrado o usuário ele entra normalmente
        }
        //Caso contraio ele retorna a tela inicial
        return "redirect:/login.html";
    }
}
