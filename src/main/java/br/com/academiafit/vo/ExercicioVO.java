package br.com.academiafit.vo;

public class ExercicioVO {
	private long id;
	private String exercicio;
	private String musculo;
	private MaquinarioVO maquinario;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getExercicio() {
		return exercicio;
	}
	public void setExercicio(String exercicio) {
		this.exercicio = exercicio;
	}
	public String getMusculo() {
		return musculo;
	}
	public void setMusculo(String musculo) {
		this.musculo = musculo;
	}
	public MaquinarioVO getMaquinario() {
		return maquinario;
	}
	public void setMaquinario(MaquinarioVO maquinario) {
		this.maquinario = maquinario;
	}
}