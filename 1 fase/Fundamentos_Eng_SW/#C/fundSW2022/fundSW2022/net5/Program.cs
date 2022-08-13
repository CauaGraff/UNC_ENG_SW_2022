using System;

namespace net5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string codigo = "";

            int[] digitos = new int[11];

            
            int s1=0;

            int s2 = 0;


            Console.WriteLine("-------------Vereficar Codigo de Barras!-------------");

            Console.WriteLine("Digite o Codigo de Barras sem pontos ou traços:");

            codigo = Console.ReadLine();

            for (int x = 0; x <= 10; x++)
            { 
                digitos[x] = int.Parse(codigo.Substring(x, 1));
                Console.WriteLine("Digito do CPF: {0} e valor {1}", x,digitos[x]);
            }
            Console.WriteLine("-----------------------------------------------------");

            for (int y = 0; y <= 10; y=y+2)
            {
                s1 = s1 + digitos[y];
                Console.WriteLine("valor digito {0} é {1}", y, digitos[y]);
            }
            int total = s1 * 3;

            Console.WriteLine("{0}*3={1}",s1, total);

            Console.WriteLine("-----------------------------------------------------");

            for (int z = 1; z <= 10; z = z + 2)
            {
                s2 = s2 + digitos[z];
                Console.WriteLine("valor digito {0} é {1}", z, digitos[z]);
            }

            int somaTotal = total + s2;

            Console.WriteLine("{0}+{1}={2}", s1,total,somaTotal);

            Console.WriteLine("-----------------------------------------------------");

            
            if (somaTotal % 10 == 0)
            {
               int multiplo = somaTotal/10;
                Console.WriteLine("{0}", multiplo);


            } else {
            
                int multiplo = ((somaTotal - (somaTotal % 10)) + 10)/10;
                Console.WriteLine("{0}", multiplo);
            }






        }







    }
}
