Algoritmo "semnome"
// Disciplina: [Linguagem e L?gica de programa?ao] 
// Professor: Antonio Carlos Nicolodi
// Autor : Cl?udio
// Data : 21/06/2015
// Se??o de Declara??es 
var
   i : inteiro
   x : real
   matriz : vetor[1..10] de real
inicio
// Se??o de Comandos 
i := 1
repita
     x := randi(100)
     matriz[i] := x
     i := i + 1
ate i = 10
fimalgoritmo
