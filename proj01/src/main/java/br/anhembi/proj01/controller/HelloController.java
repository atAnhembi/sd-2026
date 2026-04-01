package br.anhembi.proj01.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // indica que esta classe será um controller e responderá no "modelo" REST
@RequestMapping("/hello") // mapeamento do recurso que cporresponde a este controller
public class HelloController {

    @GetMapping("/{nome}")
    public ResponseEntity<String> hello(@PathVariable String nome) {
        if(nome.equals("Emerson")) {
            return ResponseEntity.ok("Acesso concedido!");
        } 
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> helloPost() {
        return ResponseEntity.ok("Inserido com sucesso!");
    }

}
