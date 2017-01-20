package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.ExercicioDAO;
import br.com.academiafit.dao.impl.AbstractDAOImpl;
import br.com.academiafit.service.ExercicioService;
import br.com.academiafit.vo.ExercicioVO;
import br.com.academiafit.vo.converter.ConverterExercicio;

@Service
public class ExercicioServiceImpl extends AbstractDAOImpl implements ExercicioService{
	@Autowired(required=true)
	private ExercicioDAO dao;

	@Override
	@Transactional
	public void incluir(ExercicioVO exercicio) {
		dao.incluir(ConverterExercicio.ConverterExercicioVoParaExercicio(exercicio));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exercício Inserido com Sucesso!"));
	}

	@Override
	@Transactional
	public void excluir(ExercicioVO exercicio) {
		dao.excluir(exercicio.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exclusão executada com sucesso."));
	}

	@Override
	@Transactional
	public void alterar(ExercicioVO exercicio) {
		dao.alterar(ConverterExercicio.ConverterExercicioVoParaExercicio(exercicio));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alteração salva com sucesso."));

	}

	@Override
	public List<ExercicioVO> listarTodos() {
		return ConverterExercicio.ConverterExercicioListaParaListaVO(dao.consultarTodos());
	}	
	
}
