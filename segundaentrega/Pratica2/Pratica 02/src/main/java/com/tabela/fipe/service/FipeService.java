package com.tabela.fipe.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;

@Service
public class FipeService {

    private static final String FIPE_API_URL = "https://parallelum.com.br/fipe/api/v1/carros";

    @Autowired
    private RestTemplate restTemplate;

    // Método para buscar marcas de veículos
    public Object getMarcas() {
        String url = FIPE_API_URL + "/marcas";
        return restTemplate.getForObject(url, Object.class);
    }

    // Método para buscar modelos de uma marca específica
    public Object getModelosByMarca(String marcaId) {
        String url = FIPE_API_URL + "/marcas/" + marcaId + "/modelos";
        return restTemplate.getForObject(url, Object.class);
    }

    // Método para buscar anos de um modelo específico
    public Object getAnosByModelo(String marcaId, String modeloId) {
        String url = FIPE_API_URL + "/marcas/" + marcaId + "/modelos/" + modeloId + "/anos";
        return restTemplate.getForObject(url, Object.class);
    }

    // Método para buscar o preço de um modelo e ano específicos
    public Object getPrecoByModeloAno(String marcaId, String modeloId, String anoId) {
        String url = FIPE_API_URL + "/marcas/" + marcaId + "/modelos/" + modeloId + "/anos/" + anoId;
        return restTemplate.getForObject(url, Object.class);
    }
}