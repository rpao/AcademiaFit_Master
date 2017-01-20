package br.com.academiafit.service;

import java.util.List;

import br.com.academiafit.entidade.Usuario;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.vo.UsuarioVO;


public interface UsuarioService {
	// Salvar: salva o novo usu�rio no banco de dados
	public void incluir(UsuarioVO usuarioVO) throws BusinessException;

	// excluir: exclui um usu�rio do banco
	public void excluir(UsuarioVO usuarioVO) throws BusinessException;

	// alterarSenha: altera a senha de um determinado usu�rio
	public void alterar(UsuarioVO usuarioVO) throws BusinessException;

	// busca o usu�rio no banco
	public UsuarioVO consultar(UsuarioVO usuarioVO) throws BusinessException;

	// listarTodos: obt�m todos os Usuarios a partir do banco
	public List<UsuarioVO> consultarTodos();
}
