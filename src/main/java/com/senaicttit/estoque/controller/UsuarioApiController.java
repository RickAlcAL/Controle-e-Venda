package com.senaicttit.estoque.controller; // mesmo pacote

import com.senaicttit.estoque.model.Usuario;
import com.senaicttit.estoque.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession; // ou javax.servlet.http.HttpSession
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class UsuarioApiController {

    private final UsuarioRepository repository;

    public UsuarioApiController(UsuarioRepository repository) {
        this.repository = repository;
    }
    //API do usuario para conferir que a autenticação foi feita
    @GetMapping("/api/usuario")
    public ResponseEntity<?> buscarUsuarioLogado(HttpSession session) {
        System.out.println("API | sessão: " + session.getId() + " | usuarioLogado: " + session.getAttribute("usuarioLogado"));
        String username = (String) session.getAttribute("usuarioLogado");

        if (username == null) {
            return ResponseEntity.status(401).body("Não autenticado");
        }

        Usuario u = repository.findByUsername(username).orElse(null);

        if (u == null) {
            return ResponseEntity.status(404).body("Usuário não encontrado");
        }

        Map<String, Object> dados = createDados(u);

        return ResponseEntity.ok(dados);
    }
    //Metodo com nonull para retornar no front-end os valores
    @NonNull
    private static Map<String, Object> createDados(Usuario u) {
        Map<String, Object> dados = new LinkedHashMap<>();
        dados.put("username", u.getUsername());
        dados.put("nome", u.getNome_usuario());
        dados.put("sobrenome", u.getSobrenomeUsuario());
        dados.put("endereco", u.getEnderecoUsuario());
        dados.put("cep", u.getCepUsuario());
        dados.put("estado", u.getEstadoUsuario());
        dados.put("cidade", u.getCidadeUsuario());
        dados.put("numero", u.getNumeroUsuario());
        dados.put("telefone", u.getTelefoneUsuario());
        dados.put("observacao", u.getObservacao_usuario());
        return dados;
    }
}