package br.com.triadpesquisa.anp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.triadpesquisa.anp.entity.ResponseResult;
import br.com.triadpesquisa.anp.service.SituacaoService;

@RestController
@RequestMapping(value="/situacao")
public class SituacaoController {
	
	@Autowired
	private SituacaoService _service;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseResult> BuscarSituacoes(HttpServletRequest request) {
		ResponseResult result = new ResponseResult();
		
		try {
			result = _service.Buscar();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.Error("Não foi possível buscar as situações.");
			return ResponseEntity.badRequest().body(result);
		}
	}
}
