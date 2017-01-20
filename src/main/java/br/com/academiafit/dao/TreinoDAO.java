package br.com.academiafit.dao;

import java.util.List;
import br.com.academiafit.entidade.Treino;
import br.com.academiafit.exception.BusinessException;

public interface TreinoDAO {		
	// Salvar: salva o novo usu�rio no banco de dados
	public void incluir(Treino treino);

	// excluir: exclui um usu�rio do banco
	public void excluir(long index);

	// alterarSenha: altera a senha de um determinado usu�rio
	public void alterar(Treino treino);

	// busca o usu�rio no banco
	public boolean consultar(int id);

	// listarTodos: obt�m todos os Treinos a partir do banco
	public List<Treino> consultarTodos();
}