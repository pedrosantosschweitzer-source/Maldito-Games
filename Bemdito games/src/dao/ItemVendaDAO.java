package dao;

import entidade.ItemVenda;

public interface ItemVendaDAO {
    void salvar(ItemVenda itemVenda);
    ItemVenda buscarPorId(int id);
    void atualizar(ItemVenda itemVenda);
    void deletar(int id);
}