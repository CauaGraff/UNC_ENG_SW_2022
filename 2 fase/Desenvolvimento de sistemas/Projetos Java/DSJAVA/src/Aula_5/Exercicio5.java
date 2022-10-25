package Aula_5;

import java.util.Scanner;

public class Exercicio5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o nome do produto");
		String nomeProd = scan.nextLine();
		System.out.println("Digite o valor unitario do produto");
		float unit = scan.nextFloat();
		System.out.println("Digite a quantidade vendida");
		float qtd = scan.nextFloat();
		float total = unit*qtd;
		System.out.println("O produto vendido foi "+ nomeProd + " deu um total de R$"+total);
	}

}
