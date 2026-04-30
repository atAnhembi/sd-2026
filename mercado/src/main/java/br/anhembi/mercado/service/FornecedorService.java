package br.anhembi.mercado.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.mercado.dto.FornecedorDTO;
import br.anhembi.mercado.model.Fornecedor;
import br.anhembi.mercado.repository.FornecedorRepo;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepo repo;

    public Optional<Fornecedor> insert(FornecedorDTO dto) {
        Fornecedor fornecedor = dto.toFornecedor();
        
        // É necessário vincular o fornecedor a cada produto manualmente.
        // Como Product é o "lado proprietário", o Hibernate precisa que o campo
        // 'fornecedor' dentro de cada Product esteja preenchido para gerar a FK.
        if (fornecedor.getProducts() != null) {
            fornecedor.getProducts().forEach(p -> p.setFornecedor(fornecedor));
        }

        return Optional.of(repo.save(fornecedor));
    }
}
