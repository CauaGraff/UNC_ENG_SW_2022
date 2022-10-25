package Aula_1;
class Matematica {
   int multiplica(int a, int b){
            return a*b;
   }

   public static void main(String a[]){
        Matematica mat = new Matematica();
        System.out.println("resultado de 4*4: "+ mat.multiplica(4,4) );
   }
}