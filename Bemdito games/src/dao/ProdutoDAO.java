package dao;

import entidade.Produto;

public interface ProdutoDAO {
    void salvar(Produto produto);
    Produto buscarPorId(int id);
    void atualizar(Produto produto);
    void deletar(int id);
}