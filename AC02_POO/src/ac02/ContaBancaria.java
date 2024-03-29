/* Integrantes do Grupo
 * Felipe Victor Matias - RA 1903306
 * Lucas Figueiredo Ventura - RA 1701918
 * Matheus Faria Duarte - RA 1903707
 * Raquel Meire Paternazi de Souza - RA 1903269
 * Vinicius Holanda Lima - RA 1903017
 * */

package ac02;
import java.util.Random;

public class ContaBancaria {
	private static int ultimoNumeroConta = 1000; // �ltimo n�mero de conta utilizado

	private String correntista;
	private int numeroConta; // n�mero da conta
	private double saldo, cpmf; // saldo da conta e cpmf
	private String senha; // Uma string com a senha de cada cliente

	public ContaBancaria(String correntista, double saldo) {
		ultimoNumeroConta++;
		this.numeroConta = ultimoNumeroConta;
		this.saldo = saldo;
		this.senha = criarSenha(); // Chama m�todo que cria senha aleat�ria
		this.correntista = correntista;
		this.cpmf = 0; // Inicia em 0 e � incrementada a cada saque realizado
	}
	
	// M�todo usado para gerar senha aleat�ria
	private String criarSenha() {
	   String s = ""; // 
	   Random gerador = new Random(); // Gerador aleat�rio
			   
		for (int i = 0; i < 6; i++) { // Gera seis n�meros de 0 a 9 e concatena na string
	            s += String.valueOf(gerador.nextInt(10));
	        }
		return s;	// Devolve senha criada aleat�ria com 6 d�gitos de 0 a 9.
	}
	
	public String getSenha() {
		return this.senha; // Para que o cliente possa ter acesso a senha
	}
	
	public double getcpmf() {
		return this.cpmf; // Para que o cliente possa ter acesso ao cpmf acumulado
	}

	public void depositar(double valor) {
		this.saldo = this.saldo + valor;
	}

	public void sacar(double valor) {
		double cpmfDesconto = valor * 0.0025; // Cria uma vari�vel com o valor a ser descontado
		this.saldo = this.saldo - valor - cpmfDesconto; // Desconta valor do cpmf + saque
		this.cpmf += cpmfDesconto;  // Acumula o valor do cpmf
	}
	
	public double getSaldo() {
		return this.saldo;
	}

	public int getNumeroConta() {
		return this.numeroConta;
	}
	
	// Remove valor do saldo da conta do solicitando e adiciona valor ao saldo da conta destino
	public void transferir(double valor, ContaBancaria contaDestino) {
		this.saldo = this.saldo - valor;
		contaDestino.saldo += valor;
	}
	
	public String toString() {
		return "Conta de " + this.correntista + " - Saldo de R$ " + this.saldo;
	}
}