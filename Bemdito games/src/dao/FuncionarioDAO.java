package dao;

import entidade.Funcionario;

public interface FuncionarioDAO {
    void salvar(Funcionario funcionario);
    Funcionario buscarPorId(int id);
    void atualizar(Funcionario funcionario);
    void deletar(int id);
}