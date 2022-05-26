package br.com.triadpesquisa.anp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.triadpesquisa.anp.entity.ResponseResult;
import br.com.triadpesquisa.anp.entity.Situacao;
import br.com.triadpesquisa.anp.model.SituacaoVo;
import br.com.triadpesquisa.anp.repository.SituacaoRepository;

@Service
public class SituacaoService {

	@Autowired
	private SituacaoRepository _repository;
	
	public ResponseResult Buscar() {
		ResponseResult result = new ResponseResult(); 
		
		List<Situacao> situacoesEntities = _repository.findAll();
		List<SituacaoVo> situacoesVo = situacoesEntities.stream().map(situacao -> new SituacaoVo(situacao)).toList();
		
		result.Success(situacoesVo);
		return result;
	}

}
