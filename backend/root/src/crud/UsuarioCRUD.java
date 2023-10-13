package crud;

import java.util.Scanner;
import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioCRUD {

    public static void main(String[] args) {
        // Instância DAO 
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Instância Scanner
        Scanner s = new Scanner(System.in);
        int opcao = 0;
        int posicao = 0;
        String nome = "";
        String email = "";
        String telefone = "";
        String senha = "";

        // Menu
        do {
            System.out.println("=== Menu de Usuarios ===");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Consultar Usuario");
            System.out.println("3 - Atualizar Usuario");
            System.out.println("4 - Deletar Usuario");
            System.out.println("5 - Buscar por id");
            System.out.println("0 - Sair");
            opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    // Criar usuário
                    System.out.println("Digite seu Nome: ");
                    nome = s.nextLine();
                    System.out.println("Digite seu Email: ");
                    email = s.nextLine();
                    System.out.println("Digite seu Telefone: ");
                    telefone = s.nextLine();
                    System.out.println("Digite sua senha: ");
                    senha = s.nextLine();

                    Usuario u1 = new Usuario(nome, email, telefone, senha);
                    usuarioDAO.create(u1);
                    System.out.println("\n*** Cadastrado ***\n");
                    break;
                case 2:
                    // Ler todos os usuários
                    for (Usuario u : usuarioDAO.read()) {
                        System.out.println(
                            "Id: " + u.getId() + 
                            " Nome: " + u.getNome() + 
                            " Email: " + u.getEmail() + 
                            " Telefone: " + u.getTelefone() + 
                            " Senha: " + u.getSenha());
                    }
                    break;
                case 3:
                	// Atualizar usuário
                	System.out.println("Digite o id do Usuario: ");
                	posicao = s.nextInt();
                	s.nextLine();
                	System.out.println("Digite o nome do Usuario: ");
                	nome = s.nextLine();
                	System.out.println("Digite o email do Usuario: ");
                	email = s.nextLine();
                	System.out.println("Digite o telefone do Usuario: ");
                	telefone = s.nextLine();
                	System.out.println("Digite a senha do Usuario: ");
                	senha = s.nextLine();

                	Usuario u2 = new Usuario(posicao, nome, email, telefone, senha);
                	usuarioDAO.update(u2);
                	System.out.println("Atualizado!" + u2.getNome());
                	break;
                case 4:
                    // Deletar usuário
                    System.out.println("Digite o id do Usuario: ");
                    posicao = s.nextInt();
                    usuarioDAO.delete(posicao);
                    System.out.println("\n*** Deletado ***\n");
                    break;
                case 5:
                    // Ler usuário por ID
                    System.out.println("Digite o id do Usuario: ");
                    posicao = s.nextInt();
                    Usuario u3 = usuarioDAO.readById(posicao);
                    System.out.println(
                        "Id: " + u3.getId() + 
                        " Nome: " + u3.getNome() + 
                        " Email: " + u3.getEmail() + 
                        " Telefone: " + u3.getTelefone() + 
                        " Senha: " + u3.getSenha());
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
