package br.anhembi.mercado.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.mercado.dto.FornecedorDTO;
import br.anhembi.mercado.model.Fornecedor;
import br.anhembi.mercado.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @PostMapping
    public ResponseEntity<Fornecedor> insert(@RequestBody FornecedorDTO dto) {
        Optional<Fornecedor> fornecedorOpt = service.insert(dto);
        if(fornecedorOpt.isPresent()) {
            return ResponseEntity.ok(fornecedorOpt.get());
        }
        return ResponseEntity.badRequest().build();
    }
}
