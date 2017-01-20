package br.com.academiafit.dao;

import java.util.List;
import br.com.academiafit.entidade.AvaliacaoFisica;
import br.com.academiafit.exception.BusinessException;

public interface AvaliacaoFisicaDAO {
	// Salvar: salva o novo Avalia��o F�sica no banco de dados
	public void incluir(AvaliacaoFisica avaliacaoFisica);

	// excluir: exclui um Avalia��o F�sica do banco
	public void excluir(long index);

	// alterarSenha: altera a senha de um determinado Avalia��o F�sica
	public void alterar(AvaliacaoFisica avaliacaoFisica);

	// busca o Avalia��o F�sica no banco
	public boolean consultar(long id);

	// listarTodos: obt�m todos os AvaliacaoFisicas a partir do banco
	public List<AvaliacaoFisica> consultarTodos();
}