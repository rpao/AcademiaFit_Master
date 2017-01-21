package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.ClienteDAO;
import br.com.academiafit.entidade.Cliente;
import br.com.academiafit.entidade.Usuario;

@Repository
public class ClienteDAOImpl extends AbstractDAOImpl implements ClienteDAO{

	@Override //diz que em outro lugar existe um padrao que vai ser implementado aqui, que no caso e o clienteDAO.
	public void incluir(Cliente cliente) {
		this.getEntityManager().persist(cliente); //esse e o objeto do hiberneite, que da acesso a usa-lo
	}                       // o persist salva no banco o objeto cliente

	@Override
	public void alterar(Cliente cliente) {
		this.getEntityManager().merge(cliente);
	}                        // merge ele atualiza os dados do cliente quando for alterado. procura pelo id para alterar

	@Override
	public List<Cliente> listarTodos() {
		// query e um comando de acesso ao banco  retornando essa nemsagem em azul abaixo
		Query query = super.getEntityManager().createQuery("select c from Cliente c");
		List<Cliente> listaCliente = query.getResultList(); // a query armazenada  os resultados em na lista cliente com os seus dados.
		
		return listaCliente; // retorna o que foi encontrado
	}

	@Override
	public void excluir(long index) { // procura um cliente pelo id, armazena no "cliente" 
		Cliente cliente = super.getEntityManager().find(Cliente.class,index);
		super.getEntityManager().remove(cliente); // remove cliente que estava armazenado 
	}

	@Override
	public Cliente consultarPorId(long index) { // procura e id e retorna o cliente com o id solicitado
		return this.getEntityManager().find(Cliente.class, index);
	}

}