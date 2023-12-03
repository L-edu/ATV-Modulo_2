package crud;

import java.util.Scanner;
import dao.PacoteDAO;
import dao.ReservaDAO;
import dao.UsuarioDAO;
import model.Pacote;
import model.Reserva;
import model.Usuario;

public class ReservaCRUD {

	public static void main(String[] args) {
		ReservaDAO reservaDAO = new ReservaDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PacoteDAO pacoteDAO = new PacoteDAO();

		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		do {
			System.out.println("=== CRUD Reservas ===");
			System.out.println("1 - Cadastrar Reserva");
			System.out.println("2 - Consultar Reserva");
			System.out.println("3 - Atualizar Reserva");
			System.out.println("4 - Deletar Reserva");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite a data de ida (no formato dd/MM/yyyy): ");
				String dataIda = scanner.nextLine();
				System.out.println("Digite a data de volta (no formato dd/MM/yyyy): ");
				String dataVolta = scanner.nextLine();
				System.out.println("Digite a quantidade de passageiros: ");
				int quantidadePassageiros = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o status da reserva: ");
				String statusReserva = scanner.nextLine();
				System.out.println("Digite o ID do Usuário: ");
				int idUsuario = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o ID do Pacote: ");
				int idPacote = scanner.nextInt();
				scanner.nextLine();

				Usuario usuario = usuarioDAO.readById(idUsuario);
				Pacote pacote = pacoteDAO.readById(idPacote);

				Reserva reserva = new Reserva(dataIda, dataVolta, quantidadePassageiros, statusReserva, usuario,
						pacote);
				reservaDAO.create(reserva);

				System.out.println("\n*** Reserva Cadastrada ***\n");
				break;
			case 2:
				// READ
				for (Reserva r : reservaDAO.read()) {
					System.out.println("Id: " + r.getId() + " Ida: " + r.getData_inicio() + " Volta: " + r.getData_fim()
							+ " Quantidade: " + r.getQtd_pessoas() + " Status: " + r.getStatus_reserva());
				}
				break;
			case 3:
				// UPDATE
				System.out.println("Digite o ID da reserva que deseja atualizar: ");
				posicao = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite a nova data de ida (no formato dd/MM/yyyy): ");
				String novaDataIda = scanner.nextLine();
				System.out.println("Digite a nova data de volta (no formato dd/MM/yyyy): ");
				String novaDataVolta = scanner.nextLine();
				System.out.println("Digite a nova quantidade de passageiros: ");
				int novaQuantidadePassageiros = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o novo status da reserva: ");
				String novoStatusReserva = scanner.nextLine();
				System.out.println("Digite o ID do novo usuário: ");
				int novoIdUsuario = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o ID do novo pacote: ");
				int novoIdPacote = scanner.nextInt();
				scanner.nextLine();

				Usuario novoUsuario = usuarioDAO.readById(novoIdUsuario);
				Pacote novoPacote = pacoteDAO.readById(novoIdPacote);

				Reserva reservaAtualizada = new Reserva(posicao, novaDataIda, novaDataVolta, novaQuantidadePassageiros,
						novoStatusReserva, novoUsuario, novoPacote);
				reservaDAO.update(reservaAtualizada);

				System.out.println("Reserva atualizada");
				break;
			case 4:
				// DELETE
				System.out.println("Digite o ID da reserva que deseja excluir: ");
				posicao = scanner.nextInt();
				reservaDAO.delete(posicao);
				System.out.println("\n*** Reserva Excluída ***\n");
				break;
			case 5:
				// BUSCA POR ID
				System.out.println("Digite o ID da reserva que deseja buscar: ");
				posicao = scanner.nextInt();
				Reserva reservaEncontrada = reservaDAO.readById(posicao);

				System.out.println("Id: " + reservaEncontrada.getId() + " Ida: " + reservaEncontrada.getData_inicio()
						+ " Volta: " + reservaEncontrada.getData_fim() + " Quantidade: "
						+ reservaEncontrada.getQtd_pessoas() + " Status: " + reservaEncontrada.getStatus_reserva());
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
