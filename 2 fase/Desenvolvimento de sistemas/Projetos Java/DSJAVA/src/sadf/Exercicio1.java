package sadf;

import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		// 1. Faça um algoritmo que peça o nome do usuário e em seguida mostre o mesmo na tela.

		Scanner escaner = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
		String nome = escaner.nextLine();
		System.out.println("Seu nome é: " + nome);
	}

}
