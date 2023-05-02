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
public class RepositorioProdutoNaoPerecivelArray {
	/**
	 * A estrutura (array) onde os produtos sao mantidos.
	 */
	private ProdutoNaoPerecivel[] produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;

	public RepositorioProdutoNaoPerecivelArray(int size) {
		super();
		this.produtos = new ProdutoNaoPerecivel[size];
	}

	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return
	 */
	private int procurarIndice(int codigo) {
		int result = -1;

		if(this.produtos[0] == null) {
			return result;
		} else {
			for(int i = 0; i <= this.produtos.length; i++) {
				if(this.produtos[i].getCodigo() == codigo) {
					return result = i;
				}
			}
		}
		return result;
	}

	/**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean existe(int codigo) {
		return procurarIndice(codigo) != -1;
	}

	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	public void inserir(ProdutoNaoPerecivel produto) {
		if(this.produtos[0] == null) {
			this.produtos[0] = produto;
		} else {
			for(int i = 0; i <= this.produtos.length; i++) {
				if(this.produtos[i] == null) {
					this.produtos[i] = produto;
				}
			}
		}

	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
	public void atualizar(ProdutoNaoPerecivel produto) {
		if(!existe(produto.getCodigo())) {
			throw new Error("Produto inexistente");
		}

		int i = 0;
		while( i <= this.produtos.length) {
			if(this.produtos[i].getCodigo() == produto.getCodigo()) {
				this.produtos[i] = produto;
				break;
			}
		}
	}

	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {
		if(!existe(codigo)) {
			throw new Error("Produto inexistente");
		}

		int i = 0;
		while(i <= this.produtos.length) {

			if(this.produtos[i].getCodigo() == codigo) {
				this.produtos[i] = null;
				break;
			}

			for(int j = i; j <= this.produtos.length; j++) {
				this.produtos[i] = this.produtos[i+1];
			}

		}
	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public ProdutoNaoPerecivel procurar(int codigo) {
		ProdutoNaoPerecivel produto = null;

		int index = procurarIndice(codigo);

		if(index != -1) {
			produto = this.produtos[index];
		}
		return produto;
	}

	public static void main(String args[]) {
		RepositorioProdutoNaoPerecivelArray repo = new RepositorioProdutoNaoPerecivelArray(10);
		ProdutoNaoPerecivel produto = new ProdutoNaoPerecivel(123,"Feijao",10.0,"Feijão carioca", null);
		repo.inserir(produto);
		System.out.println("antes " + repo.produtos[0]);
		repo.remover(123);
		System.out.println("depois " + repo.produtos[0]);

	}
}
