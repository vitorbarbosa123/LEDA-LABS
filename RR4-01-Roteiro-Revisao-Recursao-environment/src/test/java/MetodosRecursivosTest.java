
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import recursao.MetodosRecursivos;
public class MetodosRecursivosTest {

	private MetodosRecursivos metodos;
		
	@Before
	public void setUp() {
		this.metodos = new MetodosRecursivos();
	}
		
	@Test
	public void testCalcularSomaArrayPositives() {
		int[] arr = new int[]{1,2,3,4,5};
		int result = metodos.calcularSomaArray(arr);
		assertEquals(15, result);
	}
		
	@Test
	public void testCalcularSomaArrayNegatives() {
		int[] arr = new int[]{-1,-2,-3,-4,-5};
		int result = metodos.calcularSomaArray(arr);
		assertEquals(-15, result);
	}

	@Test
	public void testCalcularSomaArrayNull() {
		int[] arr = new int[]{0,0,0,0,0};
		int result = metodos.calcularSomaArray(arr);
		assertEquals(0, result);
	}
	
	@Test
	public void testCalcularFatorial() {
		int factorial = 5;
		long result = metodos.calcularFatorial(factorial);
		assertEquals(120, result);
	}

	@Test
	public void testCalcularFatorialNull() {
		int factorial = 0;
		long result = metodos.calcularFatorial(factorial);
		assertEquals(1, result);
	}

	@Test
	public void testCalcularFibonacci() {
		int fibo = 20;
		long result = metodos.calcularFibonacci(fibo);
		assertEquals(6765, result);
	}

	@Test
	public void testCountNotNullNotNull() {
		Object[] notNull = new Object[]{1,1,1,1};
		long result = metodos.countNotNull(notNull);
		assertEquals(4, result);
	}

	@Test
	public void testCountNotNullOneNull() {
		Object[] notNull = new Object[]{1,null,null,null};
		long result = metodos.countNotNull(notNull);
		assertEquals(1, result);
	}

	@Test
	public void testCountNotNullAllNull() {
		Object[] notNull = new Object[]{null,null,null,null};
		long result = metodos.countNotNull(notNull);
		assertEquals(0, result);
	}

	@Test
	public void testPotenciaDe2Zero() {
		int potencia = 0;
		long result = metodos.potenciaDe2(potencia);
		assertEquals(1, result);
	}

	@Test
	public void testPotenciaDe2() {
		int potencia = 10;
		long result = metodos.potenciaDe2(potencia);
		assertEquals(1024, result);
	}


	@Test
	public void testProgressaoAritmetica() {
		double termoInicial = 4;
		double razao = 3;
		int n = 16;
		long result = (long) metodos.progressaoAritmetica(termoInicial,razao,n );
		assertEquals(49, result);
	}

	@Test
	public void testProgressaoGeometrica() {
		double termoInicial = 3;
		double razao = 4;
		int n = 5;
		long result = (long) metodos.progressaoGeometrica(termoInicial,razao,n );
		assertEquals(768, result);
	}
	
}
