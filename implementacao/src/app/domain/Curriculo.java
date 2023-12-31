package app.domain;

import java.io.Serial;
import java.util.*;
import java.io.Serializable;

public class Curriculo implements Serializable {

	@Serial
	private static final long serialVersionUID = 7804906008877094589L;

	private UUID id;
	private int ano;
	private int semestre;
	private Curso curso;
	private Aluno aluno;
	private List<Disciplina> disciplinas;

	public Curriculo (int ano, int semestre, Curso curso, Aluno aluno) {
		this.id = UUID.randomUUID();
		setAno(ano);
		setSemestre(semestre);
		setCurso(curso);
		setAluno(aluno);
		this.disciplinas = new ArrayList<Disciplina>();
	}

	public UUID getId() {
		return this.id;
	} 

	public int getAno() {
		return this.ano;
	}

	public int getSemestre() {
		return this.semestre;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public List<Disciplina> getDisciplina() {
		return this.disciplinas;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setSemestre(int semestre) {
		if(semestre < 0 || semestre > 2) {
			System.out.println("Semestre só pode ser 1º ou 2º");
			return;
		}
		this.semestre = semestre;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public boolean adicionarDisciplina(Disciplina d) {
		if(this.disciplinas.contains(d)) {
			System.out.println("Disciplina ja está no curriculo");
			return false;
		}

		return this.disciplinas.add(d);
	}

	public double calcularCargaHoraria() {
		if(this.disciplinas.isEmpty()) return 0.0;

		double cargaHoraria = 0;
		for(Disciplina d : this.disciplinas) {
			cargaHoraria += d.getPreco();
		}
		return cargaHoraria;
	}

	public boolean removerDisciplina(Disciplina d) {
		if(this.disciplinas.isEmpty()) return false;

		return this.disciplinas.remove(d);
	}

	@Override
	public String toString() {
		return "Curriculo{" +
				"id=" + id +
				", ano=" + ano +
				", semestre=" + semestre +
				", curso=" + curso +
				", aluno=" + aluno +
				", disciplina=" + disciplinas +
				'}';
	}
}	
