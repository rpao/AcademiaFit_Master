package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.MaquinarioDAO;
import br.com.academiafit.dao.impl.AbstractDAOImpl;
import br.com.academiafit.entidade.Maquinario;
import br.com.academiafit.service.MaquinarioService;
import br.com.academiafit.vo.MaquinarioVO;
import br.com.academiafit.vo.converter.ConverterMaquinario;

@Service
public class MaquinarioServiceImpl extends AbstractDAOImpl implements MaquinarioService{
	@Autowired(required=true)
	private MaquinarioDAO dao;
	
	@Override
	@Transactional
	public void incluir(MaquinarioVO maquinario) {
		Maquinario maquina = ConverterMaquinario.ConverterMaquinarioVoParaMaquinario(maquinario);
		dao.incluir (maquina);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Maquin�rio inclu�do com sucesso."));
		
	}

	@Override
	public void excluir(MaquinarioVO maquinario) {
		dao.excluir(maquinario.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Maquin�rio exclu�do com sucesso."));
	}

	@Override
	public void alterar(MaquinarioVO maquinario) {
		Maquinario maquina = ConverterMaquinario.ConverterMaquinarioVoParaMaquinario(maquinario);
		dao.alterar(maquina);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Maquin�rio alterado com sucesso."));
		
	}

	@Override
	public List<MaquinarioVO> listarTodos() {
		return ConverterMaquinario.ConverterMaquinaListaParaListaVO(dao.consultarTodos());
	}
	
	@Override
	public MaquinarioVO consultarMaquinarioPorId(long id) {
		Maquinario maquinario = dao.consultarPorId(id);
		return ConverterMaquinario.ConverterMaquinarioParaMaquinarioVO(maquinario);
	}

}
