package br.edu.caua.projetotransportadora.trasportadora.entidades;

import java.util.Scanner;

public class Index {

	public static void main(String[] args) {
			System.out.println("***** MENU PRINCIPAL *******");
			Scanner scan = new Scanner(System.in);
			System.out.println("1 Cadastros");
			System.out.println("2 Relatorios");
			System.out.println("3 Ajuda");
			System.out.println("0 Sair");
			System.out.print("Digite a operaçao desejada: ");
			int op = scan.nextInt();
	 
 
			if (op == 1) {
				menuCadastro();
			} else if (op == 2) {
				
			}
			scan.close();
		}
		
		
	


		public static void menuCadastro() {
			Scanner scan = new Scanner(System.in);
			System.out.println("***** MENU CADASTRO *******");
			System.out.println("1 Ordem De Serviço");
			System.out.println("2 Motorista");
			System.out.println("3 Veiculo");
			System.out.println("4 Reboque");
			System.out.println("5 Multa");
			System.out.println("6 Parceiro");
			System.out.println("7 Abastecidas");
			System.out.println("8 Manutenção");
			System.out.println("6 Contas");
			System.out.println("0 Voltar");
			System.out.println("Digite a operaçao desejada: ");
			int op = scan.nextInt();

			if (op == 1) {
//				irCadastroFuncionar();
				 
			} else if (op == 0) {
				main(null);
			}
			
			scan.close();
		}

	}


