package br.ifpe.jaboatao.ts.servicos;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Usuario;

public class AssertionsTest {

	@Test
	public void teste01() {
		Assertions.assertTrue(true);
		Assertions.assertFalse(false);
	}
	@Test
	public void teste02() {
		//Number
		Assertions.assertEquals(1, 1);
		Assertions.assertNotEquals(1, 2);
		Assertions.assertEquals(1.1, 1.1);
		Assertions.assertEquals(Math.PI, 3.141592, 0.00001);
		
		//String
		Assertions.assertEquals("casa", "casa");
		Assertions.assertTrue("casa".equalsIgnoreCase("Casa"));
		Assertions.assertEquals("casa".toLowerCase(), "Casa".toLowerCase());
		
		//Objetos
		Usuario u1 = new Usuario("Usuario 01");
		Usuario u2 = new Usuario("Usuario 01");
		
		Assertions.assertEquals(u1, u2);
	}
	@Test
	public void test03() {
		//Objetos
		Usuario u1 = new Usuario("Usuario 01");
		Usuario u2 = new Usuario("Usuario 01");
		Usuario u3 = u1;
		
		Assertions.assertSame(u1, u3);
		Assertions.assertNotSame(u1, u2);
	}
	@Test
	public void test04() {
		Usuario u4 = null;
		Usuario u5 = new Usuario("Usuario 01");
		
		
		Assertions.assertTrue(u4 == null);
		Assertions.assertNull(u4);
		Assertions.assertNotNull(u4, "Não deveria ser null");
	}
}
