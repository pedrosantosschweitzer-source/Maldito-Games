package main;

import dao.DBConnection;
import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;
import entidade.Produto;

public class TesteDAOconexao {
    public static void main(String[] args) {
        
        System.out.println("=== TESTE CONEXÃO ===");
        
        DBConnection db = DBConnection.getInstance();
        
        if (db.getConnection() != null) {
            System.out.println("Conectou ao banco!");
        } else {
            return;
        }
        
        ProdutoDAO dao = new ProdutoDAOImpl();
        
        Produto p = new Produto(0, "Morango", "fruta mó boa", 15.90, 30, "Fruta");
        dao.salvar(p);
        
        Produto encontrado = dao.buscarPorId(1);
        if (encontrado != null) {
            System.out.println("Produto: " + encontrado.getNome() + " - R$" + encontrado.getPreco());
        }
    }
}