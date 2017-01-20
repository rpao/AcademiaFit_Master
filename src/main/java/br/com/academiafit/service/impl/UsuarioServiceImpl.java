package br.com.academiafit.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.UsuarioDAO;
import br.com.academiafit.entidade.Usuario;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.UsuarioService;
import br.com.academiafit.vo.UsuarioVO;
import br.com.academiafit.vo.converter.ConverterUsuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired(required=true)
	private UsuarioDAO dao;
	
	@Override
	@Transactional
	public void incluir(UsuarioVO usuarioVO) throws BusinessException {
		boolean status = dao.consultar(usuarioVO.getNickname());
		if (status){
			throw new BusinessException("Nickname j� est� sendo usado por outro usu�rio!");
		}else{
			Usuario usuario = ConverterUsuario.ConverterVoParaUsuario(usuarioVO);
			dao.incluir(usuario);
		}
	}
	
	@Override
	@Transactional
	public void excluir(UsuarioVO usuarioVO) throws BusinessException{		
		boolean status = dao.consultar(usuarioVO.getNickname());
		if (status){
			Usuario usuario = ConverterUsuario.ConverterVoParaUsuario(usuarioVO);
			dao.excluir(usuario.getNickname());

		}else{
			throw new BusinessException("Usu�rio n�o foi encontrado!");
		}

	}
	
	@Override
	@Transactional
	public void alterar(UsuarioVO usuarioVO) throws BusinessException{
		boolean status = dao.consultar(usuarioVO.getNickname());
		if (status){
			Usuario usuario = ConverterUsuario.ConverterVoParaUsuario(usuarioVO);
			dao.alterar(usuario);
		}else{
			throw new BusinessException("Usu�rio incorreto!");
		}
	}
	
	@Override
	@Transactional
	public UsuarioVO consultar(UsuarioVO usuarioVO) throws BusinessException{
		boolean status = dao.consultar(usuarioVO.getNickname());

		if (status){
			Usuario usuario = ConverterUsuario.ConverterVoParaUsuario(usuarioVO);
			List<UsuarioVO> lista = ConverterUsuario.ConverterListaUsuarioParaListaVo(dao.consultarTodos());
			for (UsuarioVO usuarioAtual : lista){
				if (usuarioAtual.getNickname().equals(usuarioVO.getNickname())){
					return usuarioVO; 
				}
			}
		}else{
			throw new BusinessException("Usu�rio n�o foi encontrado!");
		}
		return null;
	}
	
	@Override
	@Transactional
	public List<UsuarioVO> consultarTodos() {
		List<Usuario> listaUsuario = dao.consultarTodos();
		return ConverterUsuario.ConverterListaUsuarioParaListaVo(listaUsuario);
	}
}