package controllers;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import entities.Pessoa;
import repositories.PessoaRepository;

public class PessoaController {

	public void cadastrarPessoa() {

		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("\nCADASTRO DE PESSOA\n");

			Pessoa pessoa = new Pessoa();
			pessoa.setId(UUID.randomUUID());

			System.out.print("Informe o nome da pessoa: ");
			pessoa.setNome(scanner.nextLine());
			System.out.print("Informe o cpf da pessoa: ");
			pessoa.setCpf(scanner.nextLine());
			System.out.print("Informe o telefone da pessoa: ");
			pessoa.setTelefone(scanner.nextLine());

			PessoaRepository pessoaRepository = new PessoaRepository();
			pessoaRepository.inserir(pessoa);

			System.out.println("Pessoa Cadastrada com sucesso! ");

		} catch (Exception e) {
			System.out.println("\nFalha ao cadastrar pessoa! ");
			System.out.println(e.getMessage());
		}

		scanner.close();
	}

	public void atualizarPessoa() {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("\n ATUALIZAÇÃO DE PESSOA ");
			System.out.print("Entre com o ID da pessoa ");
			// convertendo de string para UUID
			UUID id = UUID.fromString(scanner.nextLine());

			// consultando pessoa no bd através de id
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.obterPorId(id);

			// derificando se pessoa foi encontrado
			if (pessoa != null) {
				
				System.out.print("Informe o nome da pessoa: ");
				pessoa.setNome(scanner.nextLine());
				System.out.print("Informe o cpf da pessoa: ");
				pessoa.setCpf(scanner.nextLine());
				System.out.print("Informe o telefone da pessoa: ");
				pessoa.setTelefone(scanner.nextLine());
				
				pessoaRepository.editar(pessoa);
				System.out.println("\n Pessoa atualizada com sucesso! ");
				
			} else {
				System.out.println("\n Pessoa não encontrada! ");
			}
		} catch (Exception e) {
			System.out.println("\nFalha ao atualizar pessoa! ");
			System.out.println(e.getMessage());
		}
		
		scanner.close();
	}
	
	public void excluirPessoa() {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("\n EXCLUSÃO DE PESSOA ");
			System.out.print("Entre com o ID da pessoa ");
			// convertendo de string para UUID
			UUID id = UUID.fromString(scanner.nextLine());

			// consultando pessoa no bd através de id
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.obterPorId(id);

			// derificando se pessoa foi encontrado
			if (pessoa != null) {
				
							
				pessoaRepository.excluir(pessoa);
				System.out.println("\n Pessoa excluída com sucesso! ");
				
			} else {
				System.out.println("\n Pessoa não excluída! ");
			}
		} catch (Exception e) {
			System.out.println("\nFalha ao excluir pessoa! ");
			System.out.println(e.getMessage());
		}
		
		scanner.close();
	}
	
	public void consultarPessoas() {
		try {
			System.out.println("\nCONSULTA DE PESSOAS ");
			PessoaRepository pessoaRepository = new PessoaRepository();
			List<Pessoa> lista = pessoaRepository.obterTodos();
			
			//percorrendo todos as pessoas da lista
			for(Pessoa pessoa: lista) {
				System.out.println("\n ID.....................:" + pessoa.getId());
				System.out.println("\n NOME...................:" + pessoa.getNome());
				System.out.println("\n CPF....................:" + pessoa.getCpf());
				System.out.println("\n TELEFONE...............:" + pessoa.getTelefone());
				System.out.println("\n ---------------");
			}
				
		}
		catch(Exception e) {
			System.out.println("\nFalha ao consultar pessoas! ");
			System.out.println(e.getMessage());
		}
	}
}
