package aula.engenharia.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CursosApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test 
	public void matriculaStatusAtivo(){
						
	var curso1 = new Curso("Curso Básico I");
	var curso2 = new Curso("Curso Básico II");
	var aluno = new Aluno("Margarida");
	verificaStatusAluno(aluno, curso1, curso2);
	
	assertEquals(2, aluno.getCursosLiberados().size());
	}

	@Test 
	public void cursoFinalizadoAcimaMedia(){
						
	var curso1 = new Curso("Curso Básico I");
	var aluno = new Aluno("Margarida");
	aluno.cursosLiberados.add(curso1);
	aluno.cursoFinalizado(curso1,8.7);//Como está acima da média 7, libera mais 3 cursos
	
	assertEquals(aluno.getCursosLiberados().size(), 4, 0.0001);
	} 

	@Test 
	public void cursoFinalizadoAbaixoMedia(){
						
		var curso1 = new Curso("Curso Básico I");
		var aluno = new Aluno("Margarida");
		aluno.cursosLiberados.add(curso1);
		aluno.cursoFinalizado(curso1,5.7);//Como está abaixo da média não libera mais 3 cursos
		
		assertEquals(aluno.getCursosLiberados().size(), 1, 0.0001);
	}

}
