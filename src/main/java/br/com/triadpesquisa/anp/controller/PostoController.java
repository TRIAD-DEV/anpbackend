package br.com.triadpesquisa.anp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.triadpesquisa.anp.Bean.PostoBean;
import br.com.triadpesquisa.anp.entity.ResponseResult;
import br.com.triadpesquisa.anp.service.PostoService;

@RestController
@RequestMapping(value="/posto")
public class PostoController {

	@Autowired
	private PostoService _service;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseResult> AdicionarPosto(@RequestBody PostoBean postoBean, HttpServletRequest request) {
		ResponseResult result = new ResponseResult();
		
		try {
			_service.Adicionar(postoBean);
			result.Success("Adicionado com sucesso");
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.Error("Não foi possível inserir o posto.");
			return ResponseEntity.badRequest().body(result);
		}
	}
}
