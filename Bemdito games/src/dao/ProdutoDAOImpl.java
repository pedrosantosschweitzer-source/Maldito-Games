package dao;

import entidade.Produto;
import java.sql.*;

public class ProdutoDAOImpl implements ProdutoDAO {
    private Connection conn;
    
    public ProdutoDAOImpl() {
        this.conn = DBConnection.getInstance().getConnection();
    }
    
    @Override
    public void salvar(Produto produto) {
        String sql = "INSERT INTO produtos (nome, descricao, preco, quantidade_estoque, categoria) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidadeEstoque());
            stmt.setString(5, produto.getCategoria());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Produto salvo: " + produto.getNome());
        } catch (SQLException e) {
            System.out.println("Erro ao salvar produto");
            e.printStackTrace();
        }
    }
    
    @Override
    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM produtos WHERE id_produto = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Produto produto = new Produto(
                    rs.getInt("id_produto"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade_estoque"),
                    rs.getString("categoria")
                );
                rs.close();
                stmt.close();
                return produto;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto");
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void atualizar(Produto produto) {
        String sql = "UPDATE produtos SET nome=?, descricao=?, preco=?, quantidade_estoque=?, categoria=? WHERE id_produto=?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidadeEstoque());
            stmt.setString(5, produto.getCategoria());
            stmt.setInt(6, produto.getIdProduto());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Produto atualizado: " + produto.getNome());
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto");
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM produtos WHERE id_produto = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Produto deletado - ID: " + id);
        } catch (SQLException e) {
            System.out.println("Erro ao deletar produto");
            e.printStackTrace();
        }
    }
}