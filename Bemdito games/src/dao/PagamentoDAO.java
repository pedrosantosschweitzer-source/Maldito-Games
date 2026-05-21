package dao;

import entidade.Pagamento;

public interface PagamentoDAO {
    void salvar(Pagamento pagamento);
    Pagamento buscarPorId(int id);
    void atualizar(Pagamento pagamento);
    void deletar(int id);
}