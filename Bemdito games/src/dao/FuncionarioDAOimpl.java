package dao;

import entidade.Funcionario;
import java.sql.*;

public class FuncionarioDAOimpl implements FuncionarioDAO {
    private Connection conn;
    
    public FuncionarioDAOimpl() {
        this.conn = DBConnection.getInstance().getConnection();
    }
    
    @Override
    public void salvar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (nome, cargo, login, senha) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getLogin());
            stmt.setString(4, funcionario.getSenha());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Funcionario salvo: " + funcionario.getNome());
        } catch (SQLException e) {
            System.out.println("Erro ao salvar funcionario");
        }
    }
    
    @Override
    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM funcionarios WHERE id_funcionario = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Funcionario funcionario = new Funcionario(
                    rs.getInt("id_funcionario"),
                    rs.getString("nome"),
                    rs.getString("cargo"),
                    rs.getString("login"),
                    rs.getString("senha")
                );
                rs.close();
                stmt.close();
                return funcionario;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionario");
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionarios SET nome=?, cargo=?, login=?, senha=? WHERE id_funcionario=?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getLogin());
            stmt.setString(4, funcionario.getSenha());
            stmt.setInt(5, funcionario.getIdFuncionario());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Funcionario atualizado: " + funcionario.getNome());
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionario");
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM funcionarios WHERE id_funcionario = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Funcionario deletado - ID: " + id);
        } catch (SQLException e) {
            System.out.println("Erro ao deletar funcionario");
            e.printStackTrace();
        }
    }
}