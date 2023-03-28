package produto;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestRepositorioProdutos {
	
	private RepositorioProdutoPerecivelArray repositorio;
	
	@Before
	public void setUp() {
		this.repositorio = new RepositorioProdutoPerecivelArray(10);
	}
	
	@Test
	public void testExiste() {
		assertFalse(repositorio.existe(5));
	}

	@Test
	public void testInserir() {
		repositorio.inserir(new ProdutoPerecivel(5,"Feijao",10.0,"Feijão carioca", null));
		assertTrue(repositorio.existe(5));
	}

	@Test
	public void testAtualizar() {
		repositorio.inserir(new ProdutoPerecivel(5,"Feijao",10.0,"Feijão carioca", null));
		repositorio.atualizar(new ProdutoPerecivel(5,"Feijao",10.0,"Feijão macassar", null));
		assertEquals("Feijão macassar",repositorio.procurar(5).getDescricao());
	}

	@Test
	public void testRemover() {
		repositorio.inserir(new ProdutoPerecivel(5,"Feijao",10.0,"Feijão carioca", null));
		repositorio.remover(5);
		assertFalse(repositorio.existe(5));
	}

	@Test
	public void testProcurar() {
		assertNull(repositorio.procurar(5));
		repositorio.inserir(new ProdutoPerecivel(5,"Feijao",10.0,"Feijão carioca", null));
		assertNotNull(repositorio.procurar(5));		
	}

}
