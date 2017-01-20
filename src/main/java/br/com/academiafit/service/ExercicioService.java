package br.com.academiafit.service;
import java.util.List;

import br.com.academiafit.vo.ExercicioVO;

public interface ExercicioService {	
	
	public void incluir(ExercicioVO exercicio);
	public void excluir(ExercicioVO exercicio);
	public void alterar (ExercicioVO exercicio);
	public List<ExercicioVO> listarTodos();
	
}
