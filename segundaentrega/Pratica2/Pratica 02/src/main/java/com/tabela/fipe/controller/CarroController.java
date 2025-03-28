package com.tabela.fipe.controller;

import com.tabela.fipe.model.Carro;
import com.tabela.fipe.service.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {
    private final CarroService carroService;

    public CarroController() {
        this.carroService = new CarroService();
    }

    @GetMapping
    public List<Carro> listarCarros() {
        return carroService.listarCarros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id) {
        Carro carro = carroService.buscarPorId(id);
        return carro != null ? ResponseEntity.ok(carro) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Carro> salvarCarro(@RequestBody Carro carro) {
        Carro novoCarro = carroService.salvarCarro(carro);
        return ResponseEntity.ok(novoCarro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCarro(@PathVariable Long id, @RequestBody Carro carro) {
        boolean atualizado = carroService.atualizarCarro(id, carro);
        return atualizado ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id) {
        boolean deletado = carroService.deletarCarro(id);
        return deletado ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
