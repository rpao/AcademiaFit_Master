package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.AvaliacaoFisicaDAO;
import br.com.academiafit.entidade.AvaliacaoFisica;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.AvaliacaoFisicaService;
import br.com.academiafit.vo.AvaliacaoFisicaVO;
import br.com.academiafit.vo.converter.ConverterAvaliacaoFisica;

@Service
public class AvaliacaoFisicaServiceImpl implements AvaliacaoFisicaService{
	@Autowired(required=true)
	private AvaliacaoFisicaDAO dao;
	
	@Override
	@Transactional
	public void incluir(AvaliacaoFisicaVO avaliacaoFisicaVO) throws BusinessException {
		boolean status = dao.consultar(avaliacaoFisicaVO.getId());
		if (status){
			throw new BusinessException("ID j� est� sendo usado por outro avaliacaoFisica!");
		}else{
			AvaliacaoFisica avaliacaoFisica = ConverterAvaliacaoFisica.ConverterVoParaAvaliacaoFisica(avaliacaoFisicaVO);
			dao.incluir(avaliacaoFisica);
		}
	}

	@Override
	@Transactional
	public void excluir(AvaliacaoFisicaVO avaliacaoFisicaVO) throws BusinessException{
		boolean status = dao.consultar(avaliacaoFisicaVO.getId());
		System.out.println(avaliacaoFisicaVO.getId() + " - " + status);

		if (status){
			dao.excluir(avaliacaoFisicaVO.getId());

		}else{
			System.out.println("nada!");
			throw new BusinessException("Avalia��o F�sica n�o foi encontrado!");

		}

	}

	@Override
	@Transactional
	public void alterar(AvaliacaoFisicaVO avaliacaoFisicaVO) throws BusinessException{
		boolean status = dao.consultar(avaliacaoFisicaVO.getId());

		if (status){
			AvaliacaoFisica avaliacaoFisica = ConverterAvaliacaoFisica.ConverterVoParaAvaliacaoFisica(avaliacaoFisicaVO);
			dao.alterar(avaliacaoFisica);

		}else{
			throw new BusinessException("Avalia��o F�sica n�o foi encontrado!");

		}
	}

	@Override
	@Transactional
	public AvaliacaoFisicaVO consultar(AvaliacaoFisicaVO avaliacaoFisicaVO) throws BusinessException{
		boolean status = dao.consultar(avaliacaoFisicaVO.getId());

		if (status){
			AvaliacaoFisica avaliacaoFisica = ConverterAvaliacaoFisica.ConverterVoParaAvaliacaoFisica(avaliacaoFisicaVO);
			List<AvaliacaoFisicaVO> lista = ConverterAvaliacaoFisica.ConverterListaAvaliacaoFisicaParaListaVo(dao.consultarTodos());
			for (AvaliacaoFisicaVO avaliacaoFisicaAtual : lista){
				if (avaliacaoFisicaAtual.getId() == avaliacaoFisicaVO.getId()){
					return avaliacaoFisicaVO; 
				}
			}
		}else{
			throw new BusinessException("Avalia��o F�sica n�o foi encontrado!");
		}
		return null;
	}

	@Override
	@Transactional
	public List<AvaliacaoFisicaVO> consultarTodos() {
		List<AvaliacaoFisica> listaAvaliacoes = dao.consultarTodos();
		return ConverterAvaliacaoFisica.ConverterListaAvaliacaoFisicaParaListaVo(listaAvaliacoes);
	}
}