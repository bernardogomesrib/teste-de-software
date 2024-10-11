package br.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Usuario;

public class AssertionsTest {
    @Test
    public void teste02(){
        Assertions.assertTrue(true);
        Assertions.assertFalse(false);
        Assertions.assertEquals(1, 1);
        
    }
    @Test
    public void teste03(){
        //numeros
        Assertions.assertEquals(Math.PI, 3.14, 0.01);
        Assertions.assertEquals(1,1);
        Assertions.assertEquals(1.1, 1.1);
        //strings
        Assertions.assertEquals("bola", "bola");
        Assertions.assertNotEquals("bola", "casa");
        //objetos
        Object obj1 = new Object();
        Object obj2 = obj1;
        Object obj3 = new Object();
        Assertions.assertSame(obj1, obj2);
        Assertions.assertNotSame(obj1, obj3);
        Assertions.assertEquals(obj2, obj1);
        Usuario usuario1 = new Usuario("Usuario 01");
        Usuario usuario2 = new Usuario("Usuario 01");
        Assertions.assertEquals(usuario1, usuario2);
        Usuario usuario4 = null;
        Assertions.assertNull(usuario4);
    }
}
