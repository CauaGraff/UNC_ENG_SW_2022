package sadf;

import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		//2. Faça um algoritmo que peça dois números ao usuário e em seguida multiplique-os. 
		
		Scanner escaner = new Scanner(System.in);
		System.out.println("Digite um numero 1: ");
		Integer n1 = escaner.nextInt();
		System.out.println("Digite um numero 2: ");
		Integer n2 = escaner.nextInt();
		Integer mult = n1*n2;
		System.out.printf("A multiplicação foi de : %d" , mult);	
	}
}
