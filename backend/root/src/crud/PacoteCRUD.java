package crud;

import java.util.Scanner;
import dao.PacoteDAO;
import model.Pacote;

public class PacoteCRUD {

    public static void main(String[] args) {
        // Instância DAO 
        PacoteDAO pacoteDAO = new PacoteDAO();

        // Instância Scanner
        Scanner s = new Scanner(System.in);
        int opcao = 0;
        int posicao = 0;
        String destino = "";
        double preco= 0;

        // Menu
        do {
            System.out.println("=== Menu de Pacotes ===");
            System.out.println("1 - Cadastrar Pacote");
            System.out.println("2 - Consultar Pacote");
            System.out.println("3 - Atualizar Pacote");
            System.out.println("4 - Deletar Pacote");
            System.out.println("5 - Buscar por id");
            System.out.println("0 - Sair");
            opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    // Criar pacote
                    System.out.println("Digite o destino: ");
                    destino = s.nextLine();
                    System.out.println("Digite o preço: ");
                    preco = s.nextDouble();
                    s.nextLine();

                    Pacote u1 = new Pacote(destino, preco);
                    pacoteDAO.create(u1);
                    System.out.println("\n*** Cadastrado ***\n");
                    break;
                case 2:
                    // Ler todos os pacotes
                    for (Pacote u : pacoteDAO.read()) {
                        System.out.println(
                            "Id: " + u.getId() + 
                            " Destino: " + u.getDestino() + 
                            " Preco: " + u.getPreco());
                    }
                    break;
                case 3:
                	// Atualizar pacote
                	System.out.println("Digite o id do Pacote: ");
                	posicao = s.nextInt();
                	s.nextLine();
                	System.out.println("Digite o destino do Pacote: ");
                	destino = s.nextLine();
                	System.out.println("Digite o preco do Pacote: ");
                	preco = s.nextDouble();
                	s.nextLine();

                	Pacote u2 = new Pacote(posicao, destino, preco);
                	pacoteDAO.update(u2);
                	System.out.println("Atualizado!" + u2.getDestino());
                	break;
                case 4:
                    // Deletar pacote
                    System.out.println("Digite o id do Pacote: ");
                    posicao = s.nextInt();
                    pacoteDAO.delete(posicao);
                    System.out.println("\n*** Deletado ***\n");
                    break;
                case 5:
                    // Ler pacote por ID
                    System.out.println("Digite o id do Pacote: ");
                    posicao = s.nextInt();
                    Pacote u3 = pacoteDAO.readById(posicao);
                    System.out.println(
                        "Id: " + u3.getId() + 
                        " Destino: " + u3.getDestino() + 
                        " Preco: " + u3.getPreco());
                    break;
                default:
                    System.out.println(opcao != 0 ? "Opção inválida, digite novamente." : "");
                    break;
            }

        } while (opcao != 0);

        System.out.println("Até mais!");
        s.close();
    }

}

