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
	
	public static void interacaoDepositar(ContaBancaria[] contas) {
		boolean clienteValido = false;
		int indiceConta = -1;
		while (!clienteValido) {
			mostrarInfo(contas);
			System.out.print("O deposito será efetuado na conta de qual cliente? (0 a " + (contas.length - 1) + "): ");
			indiceConta = entrada.nextInt();
			if (indiceConta >= 0 && indiceConta < contas.length) {
				clienteValido = true;
			} else {
				System.out.println("Índice de cliente inválido!");
			}
		}

		System.out.print("Qual o valor do depósito? ");
		double deposito = entrada.nextDouble();
		contas[indiceConta].depositar(deposito);
		System.out.println("Depósito finalizado.\n");
	}
	
	// Interação que permite que a transferência seja realizada de uma conta para outra
	public static void interacaoTransferir(ContaBancaria[] contas) {
		boolean clienteValido = false;
		boolean clienteValido2 = false;
		int indiceConta = -1;
		int indiceTransferencia = -1;
		while (!clienteValido && ! clienteValido2) {
			mostrarInfo(contas);
			System.out.print("A transferência será efetuado na conta de qual cliente? (0 a " + (contas.length - 1) + "): ");
			indiceConta = entrada.nextInt(); // Número da conta que irá transferir o dinheiro
			if (indiceConta >= 0 && indiceConta < contas.length) {
				clienteValido = true;
			} else {
				System.out.println("Índice de cliente inválido!");
			}
			mostrarInfo(contas);
			System.out.print("Para qual cliente será efetuada a transferência? (0 a " + (contas.length - 1) + "): ");
			indiceTransferencia = entrada.nextInt(); // índice da conta que receberá o dinheiro
			if (indiceConta >= 0 && indiceConta < contas.length) {
				clienteValido2 = true;
			} else {
				System.out.println("Índice de cliente inválido!");
			}
		}

		System.out.print("Qual o valor da transferência? ");
		double transferencia = entrada.nextDouble(); // Recebe o valor da transferência
		contas[indiceConta].transferir(transferencia, contas[indiceTransferencia]);
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
