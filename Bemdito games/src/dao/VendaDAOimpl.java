package dao;

import entidade.Venda;
import java.sql.*;

public class VendaDAOimpl implements VendaDAO {
    private Connection conn;
    
    public VendaDAOimpl() {
        this.conn = DBConnection.getInstance().getConnection();
    }
    
    @Override
    public void salvar(Venda venda) {
        String sql = "INSERT INTO vendas (data, valor_total, id_cliente, status_pagamento) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, venda.getData());
            stmt.setDouble(2, venda.getValorTotal());
            stmt.setInt(3, venda.getIdCliente());
            stmt.setString(4, venda.getStatusPagamento());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Venda salva: " + venda.getIdVenda());
        } catch (SQLException e) {
            System.out.println("Erro ao salvar venda");
            e.printStackTrace();
        }
    }
    
    @Override
    public Venda buscarPorId(int id) {
        String sql = "SELECT * FROM vendas WHERE id_venda = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Venda venda = new Venda(
                    rs.getInt("id_venda"),
                    rs.getString("data"),
                    rs.getDouble("valor_total"),
                    rs.getInt("id_cliente"),
                    rs.getString("status_pagamento")
                );
                rs.close();
                stmt.close();
                return venda;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar venda");
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void atualizar(Venda venda) {
        String sql = "UPDATE vendas SET data=?, valor_total=?, id_cliente=?, status_pagamento=? WHERE id_venda=?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, venda.getData());
            stmt.setDouble(2, venda.getValorTotal());
            stmt.setInt(3, venda.getIdCliente());
            stmt.setString(4, venda.getStatusPagamento());
            stmt.setInt(5, venda.getIdVenda());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Venda atualizada: " + venda.getIdVenda());
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar venda");
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM vendas WHERE id_venda = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Venda deletada - ID: " + id);
        } catch (SQLException e) {
            System.out.println("Erro ao deletar venda");
            e.printStackTrace();
        }
    }
}