package dao;

import entidade.Cliente;
import java.sql.*;

public class ClienteDAOimpl implements ClienteDAO {
    private Connection conn;
    
    public ClienteDAOimpl() {
        this.conn = DBConnection.getInstance().getConnection();
    }
    
    @Override
    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, cpf, telefone, email, endereco) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Cliente salvo: " + cliente.getNome());
        } catch (SQLException e) {
            System.out.println("Erro ao salvar cliente");
            e.printStackTrace();
        }
    }
    
    @Override
    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM clientes WHERE id_cliente = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("endereco")
                );
                rs.close();
                stmt.close();
                return cliente;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente");
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nome=?, cpf=?, telefone=?, email=?, endereco=? WHERE id_cliente=?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());
            stmt.setInt(6, cliente.getIdCliente());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Cliente atualizado: " + cliente.getNome());
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente");
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Cliente deletado - ID: " + id);
        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente");
            e.printStackTrace();
        }
    }
}