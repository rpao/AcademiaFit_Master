package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.academiafit.dao.ClienteDAO;
import br.com.academiafit.service.ClienteService;
import br.com.academiafit.vo.ClienteVO;
import br.com.academiafit.vo.converter.ConverterCliente;

@Service
public class ClienteServiceImpl implements ClienteService{
	// autowired pede permissao para acessar a camada dao para "descer"
	@Autowired(required = true)
	private ClienteDAO dao;
	
	@Override
	@Transactional // transactional permitir acesso ao banco
	public void incluir(ClienteVO cliente) { // o dao em azul, pede para incluir no banco. 
		dao.incluir(ConverterCliente.ConverterClienteVoParaCliente(cliente));//converte da cliente vo para entidade porq so a entidade tem acesso ao dao
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente cadastrado com sucesso."));	
	}				// getcurrentinstance serve para pega o que esta acontecendo agora  e depois imprime a mensagem
	
	@Override
	@Transactional
	public void excluir(ClienteVO cliente) { 
		dao.excluir(cliente.getId()); // o dao pede para excluir do banco. pesquisa o id do cliente e exclui aquele que foi solicitado
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente excluido com sucesso"));
	}				// getcurrentinstance serve para pega o que esta acontecendo agora  e depois imprime a mensagem

	@Override
	@Transactional
	public void alterar(ClienteVO cliente) { // o dao em azul, pede para alterar no banco
		dao.alterar(ConverterCliente.ConverterClienteVoParaCliente(cliente));//converte da cliente vo para entidade porq so a entidade tem acesso ao dao
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alteração salva com sucesso"));
	}				// getcurrentinstance serve para pega o que esta acontecendo agora  e depois imprime a mensagem
	
	@Override
	@Transactional
	public List<ClienteVO> listarTodos() {//
		return ConverterCliente.ConverterClienteParaListaVo(dao.listarTodos());//converte da cliente para cliente vo e tem o acesso aos dados para listar
	}																		 
}