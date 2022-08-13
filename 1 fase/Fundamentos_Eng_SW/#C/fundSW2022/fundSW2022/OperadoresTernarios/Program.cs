using System;

namespace OperadoresTernarios
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var messagem = "";
            var nota = 8;

            //CONDIÇÃO ? VALOR SE VERDADEIRO : VALOR SE FALSO
             messagem = nota >= 7 ? "Aprovado" : "Reprovado";

            Console.WriteLine(messagem);

        }
    }
}
