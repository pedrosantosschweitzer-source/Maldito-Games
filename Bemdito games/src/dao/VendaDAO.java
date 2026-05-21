package dao;

import entidade.Venda;

public interface VendaDAO {
    void salvar(Venda venda);
    Venda buscarPorId(int id);
    void atualizar(Venda venda);
    void deletar(int id);
}
