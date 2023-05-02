package produto;

/**
 * Classe que representa um repositório de produtos usando arrays como estrutura
 * sobrejacente. Alguns métodos (atualizar, remover e procurar) ou executam com
 * sucesso ou retornam um erro. Para o caso desde exercício, o erro será
 * representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 * 
 * Obs: Note que você deve utilizar a estrutura de dados array e não
 * implementações de array prontas da API Collections de Java (como ArrayList,
 * por exemplo).
 * 
 * @author Adalberto
 *
 */
public class RepositorioProdutoPerecivelArray extends RepositorioProdutoArray<ProdutoPerecivel>{

	/**
	 * A estrutura (array) onde os produtos sao mantidos.
	 */
	private ProdutoPerecivel[] produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;

	public RepositorioProdutoPerecivelArray(int size) {
		super(size);
		this.produtos = new ProdutoPerecivel[size];
	}

	@Override
	public void inserir(ProdutoPerecivel produto) {
		if (produto instanceof ProdutoPerecivel) {
			super.inserir(produto);
		}
	}

	@Override
	public void atualizar(ProdutoPerecivel produto) {
		if (produto instanceof ProdutoPerecivel) {
			super.atualizar(produto);
		}
	}
}
