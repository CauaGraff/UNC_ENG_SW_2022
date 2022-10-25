package sadf;

import java.util.Scanner;

public class Exercico3 {

	public static void main(String[] args) {
		 /*3. Faça um algoritmo que lê os valores de 3 números e posteriormente os imprima na tela.*/
		
		Scanner escaner = new Scanner(System.in);
		System.out.println("Digite um numero 1: ");
		Integer n1 = escaner.nextInt();
		System.out.println("Digite um numero 2: ");
		Integer n2 = escaner.nextInt();
		System.out.println("Digite um numero 3: ");
		Integer n3 = escaner.nextInt();
		System.out.println("Os três numeros digitados foram: "+ n1 +","+n2+","+n3);	

	}

}
