package crud;

import dao.PagamentoDAO;
import dao.ReservaDAO;
import model.Pagamento;
import model.Reserva;
import java.util.Scanner;

public class PagamentoCRUD {

    public static void main(String[] args) {
        PagamentoDAO pagamentoDAO = new PagamentoDAO();
        ReservaDAO reservaDAO = new ReservaDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        int posicao = 0;

        do {
            System.out.println("=== CRUD Pagamentos ===");
            System.out.println("1 - Cadastrar Pagamento");
            System.out.println("2 - Consultar Pagamento");
            System.out.println("3 - Atualizar Pagamento");
            System.out.println("4 - Deletar Pagamento");
            System.out.println("5 - Buscar por id");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // CREATE
                    System.out.println("Digite o valor do pagamento: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Digite o tipo de pagamento (Dinheiro/Cartão/Pix): ");
                    String tipoPagamento = scanner.nextLine();

                    System.out.println("Digite o ID da reserva para pagamento: ");
                    int idReserva = scanner.nextInt();
                    scanner.nextLine();

                    Reserva reserva = reservaDAO.readById(idReserva);

                    Pagamento pagamento = new Pagamento(valor, tipoPagamento, idReserva);
                    pagamentoDAO.create(pagamento);

                    System.out.println("\n*** Pagamento efetuado ***\n");
                    break;

                case 2:
                    // READ
                    for (Pagamento p : pagamentoDAO.read()) {
                        System.out.println("Id: " + p.getId() + " valor: " + p.getValor() + " Tipo de Pagamento: " + p.getTipo());
                    }
                    break;
                case 3:
                    // UPDATE
                    System.out.println("Digite o ID do pagamento que deseja atualizar: ");
                    posicao = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o novo valor de pagamento: ");
                    double novoValor = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Digite o novo tipo de pagamento (Dinheiro/Cartão/Pix): ");
                    String novoTipoPagamento = scanner.nextLine();
                    System.out.println("Digite o ID da nova reserva: ");
                    int novoIdReserva = scanner.nextInt();
                    scanner.nextLine();

                    Reserva novaReserva = reservaDAO.readById(novoIdReserva);

                    Pagamento pagamentoAtualizado = new Pagamento(posicao, novoValor, novoTipoPagamento, novoIdReserva);
                    pagamentoDAO.update(pagamentoAtualizado);

                    System.out.println("Pagamento atualizado");
                    break;
                case 4:
                    // DELETE
                    System.out.println("Digite o ID do pagamento que deseja excluir: ");
                    posicao = scanner.nextInt();
                    pagamentoDAO.delete(posicao);
                    System.out.println("\n*** Pagamento Estornado ***\n");
                    break;
                case 5:
                    // BUSCA POR ID
                    System.out.println("Digite o ID do pagamento que deseja buscar: ");
                    posicao = scanner.nextInt();
                    Pagamento pagamentoEncontrado = pagamentoDAO.readById(posicao);

                    System.out.println("Id: " + pagamentoEncontrado.getId() + " Valor: " + pagamentoEncontrado.getValor()
                            + " Tipo de Pagamento: " + pagamentoEncontrado.getTipo());
                    break;
                default:
                    System.out.println(opcao != 0 ? "Opção inválida, digite novamente." : "");
                    break;
            }
        } while (opcao != 0);

        System.out.println("Até mais!");
        scanner.close();
    }
}
