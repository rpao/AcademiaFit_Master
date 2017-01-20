package br.com.academiafit.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.UsuarioDAO;
import br.com.academiafit.entidade.Usuario;
import br.com.academiafit.exception.BusinessException;

@Repository
public class UsuarioDAOImpl extends AbstractDAOImpl implements UsuarioDAO{

	// Salvar: salva o novo usu�rio no banco de dados
	@Override	
	public void incluir(Usuario usuario){
		// incluir o usuario correspondente
		super.getEntityManager().persist(usuario);
	}

	// excluir: exclui um usu�rio do banco
	@Override
	public void excluir(String nickname){
		// exclui o usuario correspondente
		Usuario usuario = super.getEntityManager().find(Usuario.class, nickname);
		super.getEntityManager().remove(usuario);
	}

	// alterarSenha: altera a senha de um determinado usu�rio
	@Override
	public void alterar(Usuario usuario){
		// merge = atualizar
		this.getEntityManager().merge(usuario);
	}

	// busca o usu�rio no banco
	@Override
	public boolean consultar(String nickname){
		// encontra o usuario no banco de dados
		// se o usuario existir, retorna true, se n�o, retorna false.
		return (super.getEntityManager().find(Usuario.class, nickname) != null);

	}

	// listarTodos: obt�m todos os Usuarios a partir do banco
	@Override
	public List<Usuario> consultarTodos(){
		// cria uma query com o select na tabela usuario
		Query query = super.getEntityManager().createQuery("select u from Usuario u");

		// armazena o resultado da busca numa collection de usu�rios
		List<Usuario> listaUsuario = query.getResultList();
		return listaUsuario;
	}
}