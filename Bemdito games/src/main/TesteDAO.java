package main;

import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;
import entidade.Produto;

public class TesteDAO {
    public static void main(String[] args) {

        ProdutoDAO dao = new ProdutoDAOImpl();

        System.out.println("TESTE CRUD\n");

        System.out.println("--- CREATE ---");
        dao.salvar(new Produto(0, "Banana", "Fruta", 5.90, 50, "Fruta"));
        dao.salvar(new Produto(0, "Maçã", "Fruta", 8.50, 30, "Fruta"));
        dao.salvar(new Produto(0, "Pera", "Fruta", 7.90, 25, "Fruta"));

        System.out.println("\n--- READ ---");
        Produto p = dao.buscarPorId(1);
        System.out.println("Produto ID 2: " + p.getNome() + " - R$" + p.getPreco());

        System.out.println("\n--- UPDATE ---");
        p.setPreco(10.90);
        dao.atualizar(p);
        System.out.println("Novo preço: R$" + p.getPreco());

        System.out.println("\n--- DELETE ---");
        dao.deletar(3);
    }
}