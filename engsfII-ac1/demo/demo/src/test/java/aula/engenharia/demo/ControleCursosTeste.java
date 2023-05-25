package aula.engenharia.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import aula.engenharia.demo.model.Aluno;
import aula.engenharia.demo.model.Curso;
import aula.engenharia.demo.service.ControleCursos;

public class ControleCursosTeste {
	ControleCursos controle = new ControleCursos();

	@Test
	public void matriculaStatusAtivo() {
		var aluno = new Aluno("Margarida");

		aluno.cursosLiberados(new Curso("Curso Básico I"));
		aluno.cursosLiberados(new Curso("Curso Básico II"));

		assertEquals(2, aluno.getCursosLiberados().size());
	}

	@Test
	public void cursoFinalizadoAcimaMedia() {
		var aluno = new Aluno("Margarida");
		var cursoPrincipal = new Curso("Curso Básico I", 8.7);

		aluno.cursosLiberados(cursoPrincipal);
		controle.verificaCurso(aluno, cursoPrincipal);// Como está acima da média 7, libera mais 3 cursos

		assertEquals(4, aluno.getCursosLiberados().size());
	}

	@Test
	public void cursoFinalizadoAbaixoMedia() {
		var aluno = new Aluno("Margarida");
		var cursoPrincipal = new Curso("Curso Básico I", 5.7);

		aluno.cursosLiberados(cursoPrincipal);
		controle.verificaCurso(aluno, cursoPrincipal);// Como está abaixo da média não libera mais 3 cursos

		assertEquals(1, aluno.getCursosLiberados().size());
	}

}
