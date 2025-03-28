package com.tabela.fipe.controller;


import com.tabela.fipe.service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fipe")
public class FipeController {

    @Autowired
    private FipeService fipeService;

    // Endpoint para listar todas as marcas
    @GetMapping("/marcas")
    public Object getMarcas() {
        return fipeService.getMarcas();
    }

    // Endpoint para listar modelos de uma marca
    @GetMapping("/marcas/{marcaId}/modelos")
    public Object getModelos(@PathVariable String marcaId) {
        return fipeService.getModelosByMarca(marcaId);
    }

    // Endpoint para listar anos de um modelo
    @GetMapping("/marcas/{marcaId}/modelos/{modeloId}/anos")
    public Object getAnos(@PathVariable String marcaId, @PathVariable String modeloId) {
        return fipeService.getAnosByModelo(marcaId, modeloId);
    }

    // Endpoint para consultar o preço de um modelo e ano
    @GetMapping("/marcas/{marcaId}/modelos/{modeloId}/anos/{anoId}")
    public Object getPreco(@PathVariable String marcaId, @PathVariable String modeloId, @PathVariable String anoId) {
        return fipeService.getPrecoByModeloAno(marcaId, modeloId, anoId);
    }
}