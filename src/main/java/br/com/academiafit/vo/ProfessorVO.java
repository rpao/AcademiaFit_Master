package br.com.academiafit.vo;

import java.util.Date;

public class ProfessorVO {
	
	// atributos de pessoa
	private String cpf;
	private String nome;
	private Date dtnascimento; 
	private String end;
	private String bairro;
	private String cidade;
	private String estado;
	private String fone;
	private char sexo;
	
	// atributos de funcionario
	private Date datacontrato;
	private String escolaridade;
	private UsuarioVO usuario;
	
	// atributos de professor
	private String horario;

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDtnascimento() {
		return dtnascimento;
	}
	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public Date getDatacontrato() {
		return datacontrato;
	}
	public void setDatacontrato(Date datacontrato) {
		this.datacontrato = datacontrato;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public UsuarioVO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioVO usuarioVO) {
		this.usuario = usuarioVO;
	}	
	
}
