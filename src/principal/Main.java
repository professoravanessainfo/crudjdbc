package principal;

import java.util.Scanner;

import controllers.PessoaController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PessoaController pessoaController = new PessoaController();

		System.out.println("(1) - CADASTRAR PESSOA");
		System.out.println("(2) - ATUALIZAR PESSOA");
		System.out.println("(3) - EXCLUIR PESSOA");
		System.out.println("(4) - CONSULTAR PESSOA");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe a opção desejada: ");
		Integer opcao = Integer.parseInt(scanner.nextLine());

		switch (opcao) {
		case 1:
			pessoaController.cadastrarPessoa();
			break;
		case 2:
			pessoaController.atualizarPessoa();
			break;
		case 3:
			pessoaController.excluirPessoa();
			break;
		case 4:
			pessoaController.consultarPessoas();
			break;
		default:
			System.out.println("Opção Inválida!");
			break;
		}

		scanner.close();

	}

}
