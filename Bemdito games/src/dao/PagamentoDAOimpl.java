package dao;

import entidade.Pagamento;
import java.sql.*;

public class PagamentoDAOimpl implements PagamentoDAO {
    private Connection conn;
    
    public PagamentoDAOimpl() {
        this.conn = DBConnection.getInstance().getConnection();
    }
    
    @Override
    public void salvar(Pagamento pagamento) {
        String sql = "INSERT INTO pagamentos (id_venda, forma_pagamento, valor_pago, data_pagamento) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pagamento.getIdVenda());
            stmt.setString(2, pagamento.getFormaPagamento());
            stmt.setDouble(3, pagamento.getValorPago());
            stmt.setString(4, pagamento.getDataPagamento());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Pagamento salvo: " + pagamento.getIdPagamento());
        } catch (SQLException e) {
            System.out.println("Erro ao salvar pagamento");
            e.printStackTrace();
        }
    }
    
    @Override
    public Pagamento buscarPorId(int id) {
        String sql = "SELECT * FROM pagamentos WHERE id_pagamento = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Pagamento pagamento = new Pagamento(
                    rs.getInt("id_pagamento"),
                    rs.getInt("id_venda"),
                    rs.getString("forma_pagamento"),
                    rs.getDouble("valor_pago"),
                    rs.getString("data_pagamento")
                );
                rs.close();
                stmt.close();
                return pagamento;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar pagamento");
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void atualizar(Pagamento pagamento) {
        String sql = "UPDATE pagamentos SET id_venda=?, forma_pagamento=?, valor_pago=?, data_pagamento=? WHERE id_pagamento=?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pagamento.getIdVenda());
            stmt.setString(2, pagamento.getFormaPagamento());
            stmt.setDouble(3, pagamento.getValorPago());
            stmt.setString(4, pagamento.getDataPagamento());
            stmt.setInt(5, pagamento.getIdPagamento());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Pagamento atualizado: " + pagamento.getIdPagamento());
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pagamento");
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM pagamentos WHERE id_pagamento = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Pagamento deletado - ID: " + id);
        } catch (SQLException e) {
            System.out.println("Erro ao deletar pagamento");
            e.printStackTrace();
        }
    }
}