package com.tabela.fipe.service;

import com.tabela.fipe.model.Carro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarroService {
    private List<Carro> carros = new ArrayList<>();
    private Long proximoId = 1L;

    // Lista todos os carros
    public List<Carro> listarCarros() {
        return carros;
    }

    // Busca um carro por ID
    public Carro buscarPorId(Long id) {
        Optional<Carro> carro = carros.stream().filter(c -> c.getId().equals(id)).findFirst();
        return carro.orElse(null);
    }

    // Salva um novo carro
    public Carro salvarCarro(Carro carro) {
        carro.setId(proximoId++);
        carros.add(carro);
        return carro;
    }

    // Atualiza um carro existente
    public boolean atualizarCarro(Long id, Carro carroAtualizado) {
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getId().equals(id)) {
                carroAtualizado.setId(id);
                carros.set(i, carroAtualizado);
                return true;
            }
        }
        return false;
    }

    // Deleta um carro por ID
    public boolean deletarCarro(Long id) {
        return carros.removeIf(c -> c.getId().equals(id));
    }
}