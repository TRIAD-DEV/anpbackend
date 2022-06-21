package br.com.triadpesquisa.anp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.triadpesquisa.anp.Bean.PostoBean;
import br.com.triadpesquisa.anp.entity.Endereco;
import br.com.triadpesquisa.anp.entity.Estado;
import br.com.triadpesquisa.anp.entity.Posto;
import br.com.triadpesquisa.anp.entity.ResponseResult;
import br.com.triadpesquisa.anp.model.EstadoVo;
import br.com.triadpesquisa.anp.model.PostoVo;
import br.com.triadpesquisa.anp.repository.EstadoRepository;
import br.com.triadpesquisa.anp.repository.PostoRepository;
import ch.qos.logback.core.joran.spi.NoAutoStart;

@Service
public class PostoService {

	@Autowired
	private PostoRepository _repository;
	
	public void Adicionar(PostoBean postoBean) {
		Endereco endereco = new Endereco(postoBean);
		Posto posto = new Posto(postoBean);
		posto.setEndereco(endereco);
		
		_repository.save(posto);
	}
	
	public ResponseResult Buscar() {
			ResponseResult result = new ResponseResult(); 
			
			List<Posto> postoEntities = _repository.findAll();
			List<PostoVo> postoVo = postoEntities.stream().map(posto -> new PostoVo(posto)).collect(Collectors.toList());
			
			result.Success(postoVo);
			return result;
		}
	
	
	//deletar
	
	//atualizar
		
}
