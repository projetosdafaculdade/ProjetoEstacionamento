package estacionamento.interfaces;

import java.util.List;

public interface DaoI<T> {

    /**
     * Criador de DAO
     *
     * @return
     */
    public List<T> Listar();

    public int cadastrar(T obj);

    public boolean alterar(T obj);

    public boolean deletar(int id);

    public T lerPorId(int termo);

    public List<T> pesquisar(String termo);
}
