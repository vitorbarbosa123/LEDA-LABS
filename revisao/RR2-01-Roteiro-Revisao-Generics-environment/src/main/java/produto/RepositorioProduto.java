package produto;

public interface RepositorioProduto<T extends Produto> {
    public boolean existe(int code);
    public void inserir(T product);
    public void atualizar(T product);
    public void remover(int code);
    public T procurar(int code);
}
