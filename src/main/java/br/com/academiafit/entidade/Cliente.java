package br.com.academiafit.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CLIENTE")// nome da tabela do banco
public class Cliente extends Pessoa{
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATACADASTRO")
	private Date datacadastro;
	
	@OneToMany // mapeia um para todo( um cliente tem varias av.) cria no banco cliente_av
	private List<AvaliacaoFisica> listaAvaliacaoFisica;
	
	@OneToMany // mapeia um para todos ( um cliente tem varias listas de treino)
	private List<Treino> listaTreino;

	
	//get e set
	public Date getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public List<AvaliacaoFisica> getListaAvaliacaoFisica() {
		return listaAvaliacaoFisica;
	}

	public void setListaAvaliacaoFisica(List<AvaliacaoFisica> listaAvaliacaoFisica) {
		this.listaAvaliacaoFisica = listaAvaliacaoFisica;
	}

	public List<Treino> getListaTreino() {
		return listaTreino;
	}

	public void setListaTreino(List<Treino> listaTreino) {
		this.listaTreino = listaTreino;
	}
	
}
