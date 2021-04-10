/* Integrantes do Grupo
 * Felipe Victor Matias - RA 1903306
 * Lucas Figueiredo Ventura - RA 1701918
 * Matheus Faria Duarte - RA 1903707
 * Raquel Meire Paternazi de Souza - RA 1903269
 * Vinicius Holanda Lima - RA 1903017
 * */

package ac02;

import java.util.Scanner;

public class Banco {

	public static Scanner entrada;

	public static void mostrarInfo(ContaBancaria[] contas) {
		System.out.println("\nContas de todos os clientes:");
		for (int i = 0; i < contas.length; i++) {
			System.out.println("[" + i + "]" + contas[i].toString());
		}
		System.out.println("");
	}

	public static void interacaoSacar(ContaBancaria[] contas) {
		boolean clienteValido = false;
		int indiceConta = -1;
		while (!clienteValido) {
			mostrarInfo(contas);
			System.out.print("O saque será efetuado na conta de qual cliente? (0 a " + (contas.length - 1) + "): ");
			indiceConta = entrada.nextInt();
			if (indiceConta >= 0 && indiceConta < contas.length) {
				clienteValido = true;
			} else {
				System.out.println("Índice de cliente inválido!");
			}
		}

		System.out.print("Qual o valor do saque? ");
		double saque = entrada.nextDouble();
		contas[indiceConta].sacar(saque);
		System.out.println("Saque finalizado.\n");
	}
	
	// Método utilizado para depositar um valor determinado em uma conta selecionada
	public static void interacaoDepositar(ContaBancaria[] contas) {
		boolean clienteValido = false; 
		int indiceConta = -1;
		while (!clienteValido) { // loop até selecionar um cliente válido (dentro do indice de clientes)
			mostrarInfo(contas); // exibe dados das contas e indices dos clientes
			System.out.print("O deposito será efetuado na conta de qual cliente? (0 a " + (contas.length - 1) + "): ");
			indiceConta = entrada.nextInt();
			if (indiceConta >= 0 && indiceConta < contas.length) { // Se o índice for válido
				clienteValido = true; // sai do loop
			} else {
				System.out.println("Índice de cliente inválido!"); // Retorna ao início do loop
			}
		}

		System.out.print("Qual o valor do depósito? ");
		double deposito = entrada.nextDouble();
		contas[indiceConta].depositar(deposito); // chama o método da classe conta bancaria
		System.out.println("Depósito finalizado.\n");
	}
	
	// Interação que permite que a transferência seja realizada de uma conta para outra
	public static void interacaoTransferir(ContaBancaria[] contas) {
		boolean clienteValido = false; // Verifica se o cliente que irá transferir é valido
		boolean clienteValido2 = false; // Verifica se o cliente que irá receber é valido
		int indiceConta = -1;
		int indiceTransferencia = -1;
		while (!clienteValido) { // enquanto o índice do primeiro cliente não for válido não segue a ação
			mostrarInfo(contas);
			System.out.print("A transferência será efetuada por qual cliente? (0 a " + (contas.length - 1) + "): ");
			indiceConta = entrada.nextInt(); // Número da conta que irá transferir o dinheiro
			if (indiceConta >= 0 && indiceConta < contas.length) {
				clienteValido = true;
			} else {
				System.out.println("Índice de cliente inválido!");
			}
		}
		while (!clienteValido2) { // enquanto o índice do segundo cliente não for válido não segue a ação
			mostrarInfo(contas);
			System.out.print("Para qual cliente será efetuada a transferência? (0 a " + (contas.length - 1) + "): ");
			indiceTransferencia = entrada.nextInt(); // índice da conta que receberá o dinheiro
			if (indiceTransferencia >= 0 && indiceTransferencia < contas.length) {
				clienteValido2 = true;
			} else {
				System.out.println("Índice de cliente inválido!");
			}
		}

		System.out.print("Qual o valor da transferência? ");
		double transferencia = entrada.nextDouble(); // Recebe o valor da transferência
		contas[indiceConta].transferir(transferencia, contas[indiceTransferencia]); // Chama o método da classe conta Bancaria
		System.out.println("Transferência finalizada.\n");
	}
	
	public static void main(String[] args) {
		ContaBancaria[] contas = new ContaBancaria[5];
		contas[0] = new ContaBancaria("Marcos", 1000.00);
		contas[1] = new ContaBancaria("Júlia", 250.00);
		contas[2] = new ContaBancaria("João", 2500.00);
		contas[3] = new ContaBancaria("Roberto", 3000.00);
		contas[4] = new ContaBancaria("Janaína", 4500.00);

		entrada = new Scanner(System.in);
		boolean sair = false;

		while (!sair) {
			System.out.println("Escolha uma operação:");
			System.out.println("(1) mostrar informações de todas as contas");
			System.out.println("(2) sacar");
			System.out.println("(3) depositar");
			System.out.println("(4) transferir");
			System.out.println("(5) sair");
			System.out.print("Opção escolhida: ");
			int escolha = entrada.nextInt();
			System.out.println();

			switch (escolha) {
			case 1:
				mostrarInfo(contas);
				break;
			case 2:
				interacaoSacar(contas);
				break;
			case 3:
				interacaoDepositar(contas);
				break;
			case 4:
				interacaoTransferir(contas);
				break;
			case 5:
				sair = true;
				break;
			default:
				System.out.println("Opção inválida!");
			}
			System.out.println();
		}
		System.out.println("Fim do programa!");
	}
}
