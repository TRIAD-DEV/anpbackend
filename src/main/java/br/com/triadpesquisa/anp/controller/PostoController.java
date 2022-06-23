package br.com.triadpesquisa.anp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.triadpesquisa.anp.Bean.PostoBean;
import br.com.triadpesquisa.anp.entity.ResponseResult;
import br.com.triadpesquisa.anp.service.PostoService;

@RestController
@RequestMapping(value = "/posto")
public class PostoController {

	@Autowired
	private PostoService _service;

	//Post
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
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

	//Put
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseResult> AtualizarPosto(@RequestBody PostoBean postoBean, HttpServletRequest request) {
		ResponseResult result = new ResponseResult();

		try {
			_service.Atualizar(postoBean);
			result.Success("Atualizado com sucesso");
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.Error("Não foi possível atualizar o posto.");
			return ResponseEntity.badRequest().body(result);
		}
	}

	//Get Normal
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseResult> BuscarPostos(HttpServletRequest request) {
		ResponseResult result = new ResponseResult();

		try {
			result = _service.Buscar();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.Error("Não foi possível buscar os postos.");
			return ResponseEntity.badRequest().body(result);
		}
	}

	//GET por Id
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
	public ResponseEntity<ResponseResult> BuscarPostosPorId(@PathVariable Long id, HttpServletRequest request) {
		ResponseResult result = new ResponseResult();

		try {
			result = _service.BuscarPorId(id);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			result.Error("Não foi possível buscar o posto selecionado.");
			return ResponseEntity.badRequest().body(result);
		}
	}

	//Delete
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
	public ResponseEntity<ResponseResult> DeletarPosto(@PathVariable Long id) {
		ResponseResult result = new ResponseResult();

		try {
			_service.Deletar(id);
			result.Success("Posto deletado com sucesso");
			return ResponseEntity.ok(result);

		} catch (Exception e) {
			result.Error("Não foi possível deletar o posto selecionado.");
			return ResponseEntity.badRequest().body(result);
		}

	}
}
