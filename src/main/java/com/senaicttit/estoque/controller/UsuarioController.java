package com.senaicttit.estoque.controller;

import com.senaicttit.estoque.model.Fornecedor;
import com.senaicttit.estoque.model.Usuario;
import com.senaicttit.estoque.repository.FornecedorRepository;
import com.senaicttit.estoque.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    @Autowired
    private FornecedorRepository fornecedorRepository;
    // Garante expressamente que quem acede a raiz "/" vai para a tela de login (login.html)
    @GetMapping("/")
    public String paginaInicial() {
        return "redirect:/index.html";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@RequestParam String nomeUsuario,
                            @RequestParam String username,
                            @RequestParam String sobrenomeUsuario,
                            @RequestParam String senha_hash,
                            @RequestParam String enderecoUsuario,
                            @RequestParam String numeroCepUsuario,
                            @RequestParam String estadoUsuario,
                            @RequestParam String cidadeUsuario,
                            @RequestParam String numeroEnderecoUsuario,
                            @RequestParam String numeroTelefoneUsuario,
                            @RequestParam(required = false) String observacaoUsuario,
                            HttpServletRequest request) {
        Usuario us = repository.findByUsername(username).orElse(null);
        HttpSession antiga = request.getSession(false);
        if (antiga != null) {
            antiga.invalidate();
        }
        //Inserindo usuario
        Usuario u = new Usuario();
        u.setNome_usuario(nomeUsuario);
        u.setEnderecoUsuario(enderecoUsuario);
        u.setCepUsuario(numeroCepUsuario);
        u.setEstadoUsuario(estadoUsuario);
        u.setCidadeUsuario(cidadeUsuario);
        u.setNumeroUsuario(numeroEnderecoUsuario);
        u.setTelefoneUsuario(numeroTelefoneUsuario);
        u.setObservacao_usuario(observacaoUsuario);
        u.setUsername(username);
        u.setSobrenomeUsuario(sobrenomeUsuario);
        u.setSenhaHash(encoder.encode(senha_hash));
        repository.save(u);
        //Validando a sessão para retorno dos dados no perfil
        HttpSession session = request.getSession(true);
        session.setAttribute("usuarioLogado", username);
        System.out.println("API | sessão: " + session.getId() + " | usuarioLogado: " + session.getAttribute("usuarioLogado"));
        username = (String) session.getAttribute("usuarioLogado");
        return "redirect:/select.html"; // Após cadastrar, volta para o login
    }

    @PostMapping("/login")
    public String login(@RequestParam String identificador,
                        @RequestParam String senha_hash,
                        HttpServletRequest request) {
        //Verifica se a sessão está conectada
        HttpSession antiga = request.getSession(false);
        if (antiga != null) {
            antiga.invalidate();
        }
        //Verifica se o que o usuario digitou é um email ou um username
        if (identificador.contains("@")) {
            Fornecedor f = fornecedorRepository.findByEmailFornecedor(identificador).orElse(null);
            if (f != null && encoder.matches(senha_hash, f.getSenhaHashFornecedor())) {
                request.getSession(true).setAttribute("fornecedorLogado", f.getCpfOucnpjFornecedor());

                System.out.println("Passou e mandou o request");
                return "redirect:/select.html?login=ok";
            }
        } else {
            //Caso contrario não tiver '@' ele verifica como username e confere no banco de dados
            Usuario u = repository.findByUsername(identificador).orElse(null);
            if (u != null && encoder.matches(senha_hash, u.getSenhaHash())) {
                request.getSession(true).setAttribute("usuarioLogado", identificador);
                System.out.println("Passou e mandou o request");
                return "redirect:/select.html?login=ok";
            }
        }

        return "redirect:/login.html?error=true";
    }

    //Get para mostrar o perfil pois possui 2 perfil diferente com isso pegando o atribudo de cada para mostrar deacordo com o que deseja
    @GetMapping("/perfil")
    public String perfil(HttpSession session) {
        //Se o login foi efetuado como fornecedor, irá mostrar o html exaato do fornecedor
        if (session.getAttribute("fornecedorLogado") != null) {
            return "redirect:/perfil-fornecedor.html";
        }
        //Se o login foi feito como usuario irá mostrar o do usuario
        if (session.getAttribute("usuarioLogado") != null) {
            return "redirect:/perfil.html";
        }
        return "redirect:/login.html";
    }
}