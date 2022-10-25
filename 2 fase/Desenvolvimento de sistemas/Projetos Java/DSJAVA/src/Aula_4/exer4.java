package Aula_4;

import java.util.Scanner;

public class exer4 {

	public static void main(String[] args) {
		
		Scanner escaner = new Scanner(System.in);
		System.out.println("digite o total de KM");
		Float km = escaner.nextFloat();
		System.out.println("Digite quantidade de litros gastos");
		Float litros = escaner.nextFloat();
		float media = km/litros;
		System.out.println("A média de Km por Litro foi de "+ media);
		
	}

}
