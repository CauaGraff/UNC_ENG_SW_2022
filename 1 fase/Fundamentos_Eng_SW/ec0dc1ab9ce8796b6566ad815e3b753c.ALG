Algoritmo "Bascara"
// Disciplina   : [Introdu??o ao desenvolvimento de software]
// Professor   : Moacir Kichel
// Descri??o   : Fun??o para calcular a Bhascara
// Autor(a)    : Bruno Bevilaqua
// Data atual  : 26/03/2021
Var
// Se??o de Declara??es das vari?veis 
a, b, c, delta, deltaraiz, resultado_p, resultado_n: real

Inicio
// Se??o de Comandos, procedimento, fun??es, operadores, etc... 
escreval("Digite a:")
leia(a)
escreval("Digite b:")
leia(b)
escreval("Digite c:")
leia(c)


delta <- (b*b)-(4*a*c)


se delta>0 entao

   deltaraiz <- raizq(delta)
   resultado_p <- (-(b) + deltaraiz) / (2*a)
   resultado_n <- (-(b) - deltaraiz) / (2*a)

   escreval("x': ", resultado_p)
   escreval("x'': ", resultado_n)

senao

escreval("delta ? menor que zero", delta)

fimse

Fimalgoritmo