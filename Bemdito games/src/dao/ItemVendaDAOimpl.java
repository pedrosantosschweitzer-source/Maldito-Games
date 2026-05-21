package dao;

import entidade.ItemVenda;
import java.sql.*;

public class ItemVendaDAOimpl implements ItemVendaDAO {
    private Connection conn;
    
    public ItemVendaDAOimpl() {
        this.conn = DBConnection.getInstance().getConnection();
    }
    
    @Override
    public void salvar(ItemVenda itemVenda) {
        String sql = "INSERT INTO itens_venda (id_venda, id_produto, quantidade, subtotal) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, itemVenda.getIdVenda());
            stmt.setInt(2, itemVenda.getIdProduto());
            stmt.setInt(3, itemVenda.getQuantidade());
            stmt.setDouble(4, itemVenda.getSubtotal());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("ItemVenda salvo: " + itemVenda.getIdItemVenda());
        } catch (SQLException e) {
            System.out.println("Erro ao salvar itemVenda");
            e.printStackTrace();
        }
    }
    
    @Override
    public ItemVenda buscarPorId(int id) {
        String sql = "SELECT * FROM itens_venda WHERE id_item_venda = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                ItemVenda itemVenda = new ItemVenda(
                    rs.getInt("id_item_venda"),
                    rs.getInt("id_venda"),
                    rs.getInt("id_produto"),
                    rs.getInt("quantidade"),
                    rs.getDouble("subtotal")
                );
                rs.close();
                stmt.close();
                return itemVenda;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar itemVenda");
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void atualizar(ItemVenda itemVenda) {
        String sql = "UPDATE itens_venda SET id_venda=?, id_produto=?, quantidade=?, subtotal=? WHERE id_item_venda=?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, itemVenda.getIdVenda());
            stmt.setInt(2, itemVenda.getIdProduto());
            stmt.setInt(3, itemVenda.getQuantidade());
            stmt.setDouble(4, itemVenda.getSubtotal());
            stmt.setInt(5, itemVenda.getIdItemVenda());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("ItemVenda atualizado: " + itemVenda.getIdItemVenda());
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar itemVenda");
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM itens_venda WHERE id_item_venda = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("ItemVenda deletado - ID: " + id);
        } catch (SQLException e) {
            System.out.println("Erro ao deletar itemVenda");
            e.printStackTrace();
        }
    }
}