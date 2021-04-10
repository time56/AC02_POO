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
			System.out.print("O saque ser� efetuado na conta de qual cliente? (0 a " + (contas.length - 1) + "): ");
			indiceConta = entrada.nextInt();
			if (indiceConta >= 0 && indiceConta < contas.length) {
				clienteValido = true;
			} else {
				System.out.println("�ndice de cliente inv�lido!");
			}
		}

		System.out.print("Qual o valor do saque? ");
		double saque = entrada.nextDouble();
		contas[indiceConta].sacar(saque);
		System.out.println("Saque finalizado.\n");
	}
	
	// M�todo utilizado para depositar um valor determinado em uma conta selecionada
	public static void interacaoDepositar(ContaBancaria[] contas) {
		boolean clienteValido = false; 
		int indiceConta = -1;
		while (!clienteValido) { // loop at� selecionar um cliente v�lido (dentro do indice de clientes)
			mostrarInfo(contas); // exibe dados das contas e indices dos clientes
			System.out.print("O deposito ser� efetuado na conta de qual cliente? (0 a " + (contas.length - 1) + "): ");
			indiceConta = entrada.nextInt();
			if (indiceConta >= 0 && indiceConta < contas.length) { // Se o �ndice for v�lido
				clienteValido = true; // sai do loop
			} else {
				System.out.println("�ndice de cliente inv�lido!"); // Retorna ao in�cio do loop
			}
		}

		System.out.print("Qual o valor do dep�sito? ");
		double deposito = entrada.nextDouble();
		contas[indiceConta].depositar(deposito); // chama o m�todo da classe conta bancaria
		System.out.println("Dep�sito finalizado.\n");
	}
	
	// Intera��o que permite que a transfer�ncia seja realizada de uma conta para outra
	public static void interacaoTransferir(ContaBancaria[] contas) {
		boolean clienteValido = false; // Verifica se o cliente que ir� transferir � valido
		boolean clienteValido2 = false; // Verifica se o cliente que ir� receber � valido
		int indiceConta = -1;
		int indiceTransferencia = -1;
		while (!clienteValido) { // enquanto o �ndice do primeiro cliente n�o for v�lido n�o segue a a��o
			mostrarInfo(contas);
			System.out.print("A transfer�ncia ser� efetuada por qual cliente? (0 a " + (contas.length - 1) + "): ");
			indiceConta = entrada.nextInt(); // N�mero da conta que ir� transferir o dinheiro
			if (indiceConta >= 0 && indiceConta < contas.length) {
				clienteValido = true;
			} else {
				System.out.println("�ndice de cliente inv�lido!");
			}
		}
		while (!clienteValido2) { // enquanto o �ndice do segundo cliente n�o for v�lido n�o segue a a��o
			mostrarInfo(contas);
			System.out.print("Para qual cliente ser� efetuada a transfer�ncia? (0 a " + (contas.length - 1) + "): ");
			indiceTransferencia = entrada.nextInt(); // �ndice da conta que receber� o dinheiro
			if (indiceTransferencia >= 0 && indiceTransferencia < contas.length) {
				clienteValido2 = true;
			} else {
				System.out.println("�ndice de cliente inv�lido!");
			}
		}

		System.out.print("Qual o valor da transfer�ncia? ");
		double transferencia = entrada.nextDouble(); // Recebe o valor da transfer�ncia
		contas[indiceConta].transferir(transferencia, contas[indiceTransferencia]); // Chama o m�todo da classe conta Bancaria
		System.out.println("Transfer�ncia finalizada.\n");
	}
	
	public static void main(String[] args) {
		ContaBancaria[] contas = new ContaBancaria[5];
		contas[0] = new ContaBancaria("Marcos", 1000.00);
		contas[1] = new ContaBancaria("J�lia", 250.00);
		contas[2] = new ContaBancaria("Jo�o", 2500.00);
		contas[3] = new ContaBancaria("Roberto", 3000.00);
		contas[4] = new ContaBancaria("Jana�na", 4500.00);

		entrada = new Scanner(System.in);
		boolean sair = false;

		while (!sair) {
			System.out.println("Escolha uma opera��o:");
			System.out.println("(1) mostrar informa��es de todas as contas");
			System.out.println("(2) sacar");
			System.out.println("(3) depositar");
			System.out.println("(4) transferir");
			System.out.println("(5) sair");
			System.out.print("Op��o escolhida: ");
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
				System.out.println("Op��o inv�lida!");
			}
			System.out.println();
		}
		System.out.println("Fim do programa!");
	}
}
