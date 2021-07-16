package com.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.service.CodigosService;


 

@RestController
public class CodigoController {
	
	@Autowired
	@Qualifier("servicio")
	CodigosService codigosService;
	
	@GetMapping(value = "/codes/{cod}")//Endpoint=http://localhost:8080/codes/55
	public boolean esPrioritario(@PathVariable("cod") String cod) {
		boolean resp = false;
		
		return codigosService.esPrioritario(cod);		 
		
	}
	
	@GetMapping(value = "/ve/{cod}")//Endpoint=http://localhost:8080/ve/DCR-88578-9
	public boolean vErificarDigito(@PathVariable("cod") String cod) {
		boolean resp = false;
		
		return codigosService.vErificar(cod);		 
		
	}
	
	@GetMapping("/ordenar/v2")//Endpoint=http://localhost:8080/ordenar/v2?codigos=DCR-88578-9,MCR-88578-9,BCR-88578-9
	public ArrayList<String> oRdenarLista(@RequestParam ArrayList<String> codigos) {
	    return codigosService.oRdenarLista(codigos);
	}
	
	@GetMapping("/unificar/v2")//Endpoint=http://localhost:8080/unificar/v2?listauno=DCR-88578-9,MCR-88578-9,BCR-88578-9&listados=LCR-88578-9,HCR-88578-9
	public ArrayList<String> uNificarListas(@RequestParam ArrayList<String> listauno, @RequestParam ArrayList<String> listados) {
	    return codigosService.uNificarListas(listauno, listados);
	}
	
	@GetMapping("/interceptar/v2")//Endpoint=http://localhost:8080/interceptar/v2?listauno=DCR-88578-9,MCR-88578-9,BCR-88578-9&listados=LCR-88578-9,HCR-88578-9
	public ArrayList<String> iNterceptar(@RequestParam ArrayList<String> listauno, @RequestParam ArrayList<String> listados) {
	    return codigosService.iNterceptarListas(listauno, listados);
	}

}
