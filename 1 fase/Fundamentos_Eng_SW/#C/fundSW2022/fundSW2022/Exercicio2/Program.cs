using System;

namespace Exercicio2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int maior = 0;

            Console.WriteLine("---------- SISTEMA PARA VEREFICAR O MENOR NUMERO DIGITADO (DIGITE NUMEROS DIFERENTES)----------");
            for (int i = 1; i <= 10; i++)
            {
                Console.WriteLine("Digite um numero");
                var numero = Console.ReadLine();
                Console.WriteLine(numero);

                if(maior<numero)
                {
                    
                }

            }
        }
    }
}
