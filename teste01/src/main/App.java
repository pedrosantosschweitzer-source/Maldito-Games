package main;

import entidade.Cliente;
import entidade.Funcionario;
import entidade.ItemVenda;
import entidade.Pagamento;
import entidade.Produto;
import entidade.Venda;

public class App {

    public static void main(String[] args) {

        Cliente c1 = new Cliente(1, "João", "12345678900", "11999999999", "joao@email.com", "Rua A");
        Cliente c2 = new Cliente(2, "Maria", "98765432100", "11888888888", "maria@email.com", "Rua B");

        
        System.out.println("Cliente 1:");
        System.out.println("ID: " + c1.getIdCliente());
        System.out.println("Nome: " + c1.getNome());
        System.out.println("CPF: " + c1.getCpf());
        System.out.println("Telefone: " + c1.getTelefone());
        System.out.println("Email: " + c1.getEmail());
        System.out.println("Endereço: " + c1.getEndereco());

        System.out.println();

        System.out.println("Cliente 2:");
        System.out.println("ID: " + c2.getIdCliente());
        System.out.println("Nome: " + c2.getNome());
        System.out.println("CPF: " + c2.getCpf());
        System.out.println("Telefone: " + c2.getTelefone());
        System.out.println("Email: " + c2.getEmail());
        System.out.println("Endereço: " + c2.getEndereco());
        
        System.out.println();
        
        Produto p1 = new Produto(67, "Banana", "esta é uma fruta", 11.90, 8, "Fruta");

        System.out.println("Produto 1:");
        System.out.println("ID: " + p1.getIdProduto());
        System.out.println("Nome: " + p1.getNome());
        System.out.println("Descrição: " + p1.getDescricao());
        System.out.println("Preco: " + p1.getPreco());
        System.out.println("quantidadeEstoque: " + p1.getQuantidadeEstoque());
        System.out.println("categoria: " + p1.getCategoria());
        
        Produto p2 = new Produto(69, "Pera", "esta é uma fruta bonita", 5.08, 1, "Fruta");

        System.out.println("Produto 2:");
        System.out.println("ID: " + p2.getIdProduto());
        System.out.println("Nome: " + p2.getNome());
        System.out.println("Descrição: " + p2.getDescricao());
        System.out.println("Preco: " + p2.getPreco());
        System.out.println("quantidadeEstoque: " + p2.getQuantidadeEstoque());
        System.out.println("categoria: " + p2.getCategoria());
        
        System.out.println();
        
        Venda v1 = new Venda(1, "05/03/2026", 59.90, 2, "Pago");

        System.out.println("Venda:");
        System.out.println("ID: " + v1.getIdVenda());
        System.out.println("Data: " + v1.getData());
        System.out.println("Valor Total: " + v1.getValorTotal());
        System.out.println("ID Cliente: " + v1.getIdCliente());
        System.out.println("Status Pagamento: " + v1.getStatusPagamento());
        
        System.out.println();
        
        ItemVenda item1 = new ItemVenda(1, 1, 3, 2, 23.80);

        System.out.println("Item da Venda:");
        System.out.println("ID Item: " + item1.getIdItemVenda());
        System.out.println("ID Venda: " + item1.getIdVenda());
        System.out.println("ID Produto: " + item1.getIdProduto());
        System.out.println("Quantidade: " + item1.getQuantidade());
        System.out.println("Subtotal: " + item1.getSubtotal());
        
        System.out.println();
        
        Pagamento p11 = new Pagamento(1, 1, "Cartao", 50.00, "05/03/2026");

        System.out.println("Pagamento:");
        System.out.println("ID Pagamento: " + p11.getIdPagamento());
        System.out.println("ID Venda: " + p11.getIdVenda());
        System.out.println("Forma de Pagamento: " + p11.getFormaPagamento());
        System.out.println("Valor Pago: " + p11.getValorPago());
        System.out.println("Data do Pagamento: " + p11.getDataPagamento());
        
        System.out.println();
        
        Funcionario f1 = new Funcionario(1, "Carlos Silva", "Gerente", "carlos", "1234");

        System.out.println("Funcionario:");
        System.out.println("ID Funcionario: " + f1.getIdFuncionario());
        System.out.println("Nome: " + f1.getNome());
        System.out.println("Cargo: " + f1.getCargo());
        System.out.println("Login: " + f1.getLogin());
        System.out.println("Senha: " + f1.getSenha());
    }
}