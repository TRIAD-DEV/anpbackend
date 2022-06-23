package br.com.triadpesquisa.anp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.triadpesquisa.anp.Bean.PostoBean;
import br.com.triadpesquisa.anp.entity.Endereco;
import br.com.triadpesquisa.anp.entity.Estado;
import br.com.triadpesquisa.anp.entity.Posto;
import br.com.triadpesquisa.anp.entity.ResponseResult;
import br.com.triadpesquisa.anp.model.EstadoVo;
import br.com.triadpesquisa.anp.model.PostoVo;
import br.com.triadpesquisa.anp.repository.EnderecoRepository;
import br.com.triadpesquisa.anp.repository.PostoRepository;

@Service
public class PostoService {

	@Autowired
	private PostoRepository _repository;

	@Autowired
	private EnderecoRepository _repositoryEndereco;

	public void Adicionar(PostoBean postoBean) {
		Endereco endereco = new Endereco(postoBean);
		_repositoryEndereco.save(endereco);
		Posto posto = new Posto(postoBean);
		posto.setEndereco(endereco);
		_repository.save(posto);
	}

	// put
	public void Atualizar(PostoBean postoBean) {

		Endereco endereco = new Endereco(postoBean);;
		_repositoryEndereco.save(endereco);
		Posto posto = new Posto(postoBean);
		posto.setEndereco(endereco);
		posto.setId(postoBean.getCodigo());
		_repository.save(posto);
	}

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
