package br.com.triadpesquisa.anp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.triadpesquisa.anp.Bean.PostoBean;
import br.com.triadpesquisa.anp.entity.Bandeira;
import br.com.triadpesquisa.anp.entity.Endereco;
import br.com.triadpesquisa.anp.entity.Estado;
import br.com.triadpesquisa.anp.entity.Posto;
import br.com.triadpesquisa.anp.entity.ResponseResult;
import br.com.triadpesquisa.anp.entity.Situacao;
import br.com.triadpesquisa.anp.model.EstadoVo;
import br.com.triadpesquisa.anp.model.PostoVo;
import br.com.triadpesquisa.anp.repository.BandeiraRepository;
import br.com.triadpesquisa.anp.repository.EnderecoRepository;
import br.com.triadpesquisa.anp.repository.EstadoRepository;
import br.com.triadpesquisa.anp.repository.PostoRepository;
import br.com.triadpesquisa.anp.repository.SituacaoRepository;

@Service
public class PostoService {

	@Autowired
	private PostoRepository _repository;

	@Autowired
	private EnderecoRepository _repositoryEndereco;
	
	@Autowired
	private EstadoRepository _repositoryEstado;
	
	@Autowired
	private BandeiraRepository _repositoryBandeira;
	
	@Autowired
	private SituacaoRepository _repositorySituacao;
	

	
	//Post
	public ResponseResult Adicionar(PostoBean postoBean) {
		
		ResponseResult result = new ResponseResult();
		
		Endereco endereco = new Endereco(postoBean);;
		Posto posto = new Posto(postoBean);
		
		Estado estado = _repositoryEstado.findById(postoBean.getEstadoId()).get();
		endereco.setEstado(estado);
		
		_repositoryEndereco.save(endereco);
		
		Bandeira bandeira = _repositoryBandeira.findById(postoBean.getBandeiraId()).get();
		Situacao situacao = _repositorySituacao.findById(postoBean.getSituacaoId()).get();
		posto.setBandeira(bandeira);
		posto.setSituacao(situacao);
		posto.setEndereco(endereco);
		posto.setId(postoBean.getCodigo());
		
		Posto novoPosto = _repository.saveAndFlush(posto);
		result.Success(novoPosto);
		return result;
		
		
		/* 
		PostoVo postoVo = new PostoVo(posto);
		result.Success(postoVo);
		return result; 
		 */
	}

	// put
	public ResponseResult Atualizar(PostoBean postoBean) {

		ResponseResult result = new ResponseResult();
		
		Endereco endereco = new Endereco(postoBean);;
		Posto posto = new Posto(postoBean);
		
		Estado estado = _repositoryEstado.findById(postoBean.getEstadoId()).get();
		endereco.setEstado(estado);
		
		_repositoryEndereco.save(endereco);
		
		
		posto.setEndereco(endereco);
		posto.setId(postoBean.getCodigo());
		
		Posto novoPosto = _repository.saveAndFlush(posto);
		result.Success(novoPosto);
		return result;
	
		/* PostoVo postoVo = new PostoVo(posto);
		result.Success(postoVo);
		return result; 
		 */
	}
	
	

	//get
	public ResponseResult Buscar() {
		ResponseResult result = new ResponseResult();

		List<Posto> postoEntities = _repository.findAll();
		List<PostoVo> postoVo = postoEntities.stream().map(posto -> new PostoVo(posto)).collect(Collectors.toList());

		result.Success(postoVo);
		return result;
	}

	// get por ID
	public ResponseResult BuscarPorId(@PathVariable Long id) {
		ResponseResult result = new ResponseResult();

		Optional<Posto> posto = _repository.findById(id);

		
		result.Success(posto);
		return result;
	}

	// delete
	public void Deletar(@PathVariable Long id) throws Exception {

		// verficiando se o ID existe
		if (id <= -1) {
			throw new Exception("Codigo do posto invalido");
		}

		_repository.deleteById(id);
	}

}
