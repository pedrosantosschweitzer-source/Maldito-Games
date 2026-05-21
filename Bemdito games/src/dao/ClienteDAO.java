package dao;

import entidade.Cliente;

public interface ClienteDAO {
    void salvar(Cliente cliente);
    Cliente buscarPorId(int id);
    void atualizar(Cliente cliente);
    void deletar(int id);
}
