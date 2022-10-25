package sadf;

import java.util.Scanner;

public class SaidaEntradaConsole {

	public static void main(String[] args) {
		Scanner escaner = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
		String nome = escaner.nextLine();
		System.out.println("Seu nome é: " + nome.toUpperCase());
		
		System.out.println("Digite um numero: ");
		Integer inteiro = escaner.nextInt();
		System.out.printf("O numero digitado é: %d" , inteiro);	
	}

}
