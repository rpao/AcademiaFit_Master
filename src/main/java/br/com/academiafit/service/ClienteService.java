package br.com.academiafit.service;
import java.util.List;

import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.vo.ClienteVO;

public interface ClienteService {
	
	                                         //throws serve para permiter que o sistema nao pare por causa de um erro. BusinessException define a execao.
	public void incluir(ClienteVO clienteVO) throws BusinessException;
	public void excluir(ClienteVO clienteVO) throws BusinessException;
	public void alterar(ClienteVO clienteVO) throws BusinessException;
	public List<ClienteVO> listarTodos();

}
