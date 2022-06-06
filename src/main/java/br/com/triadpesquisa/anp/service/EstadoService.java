package br.com.triadpesquisa.anp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.triadpesquisa.anp.entity.Estado;
import br.com.triadpesquisa.anp.entity.ResponseResult;
import br.com.triadpesquisa.anp.model.EstadoVo;
import br.com.triadpesquisa.anp.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository _repository;
	
	public ResponseResult Buscar() {
		ResponseResult result = new ResponseResult(); 
		
		List<Estado> estadosEntities = _repository.findAll();
		List<EstadoVo> estadosVo = estadosEntities.stream().map(uf -> new EstadoVo(uf)).collect(Collectors.toList());
		
		result.Success(estadosVo);
		return result;
	}

}
