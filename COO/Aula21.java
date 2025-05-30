public class Aula21 {
    
    //Prova dia 30/5 - Vai até tipos genéricos (De meotod e variavel etc...)

    //Méotods Genéricos

        //Lembrnado que não tem como instanciar calsses genéricos
            //Porque isso acontece? 
            //Quando ele gerar o arquivo byteclss ele vai ignorar o tipo genérico meio que estou fazendo. Um "substituir (como um ctrl f mesmo)" em tudo, isso permite compatibilidade e garante o funcionamento.
        //Por isso que instanciar não é possível, pois o tipo genérico de fato sequer existe na prática, só temporiamente
            //Ele é como se salvesse quais tipo chamam ele e criasse uma função para cada

        //Méotodo genérico
            //Funciona muito semlhante com a classe genérica
                //Ideia é a mesma, escopo restrito ao método, e eu posso faze risso em qualuqer classe, mesmo sem ser genérica
                //Posso usar objeto como parametro, mas daria o mesmo problema da classe, onde o typecasting não poderá ser conferido
                    //Ex, eu uso um objeto para fingir ser genérico, consequentemente retornando um objeto.
                    //Para jogar isso em uma variavel, eu preciso fazer um typecasting, e isso não é garantido que vai funcionar, e o compilador também não vai saber (ELe vai ver um objeto virando qualquer coisa, e isso vai estar certo independente do que for)
                        
                //Então o jeito mais fácil é usar o tipo genérico mesmo
                    //Desse jeito ele já substitui o tipo genérico por um tipo específico na compilação, então não tem como ter erro. ( O <T> é como se fosse um avatar, que vai ser substituído por um tipo específico na hora da compilação)

                public class meotodgenerico{
                    public <T> metodoGenerico(T objeto){
                        return objeto;
                    
                }

                //Dessa forma posso chamar normal
                String s = metodoGenerico("Teste");
                Integer i = metodoGenerico(10);
                //E o compilador vai saber qual tipo é, e se não fizer sentido vai dar erro:
                String s = metodoGenerico(10); //Erro, não pode converter de int para String

                //Se misturar tipos ele também da erro nos parametros:

                public class aleatorio{
                    public <T> aleatorizador(T objeto1, T objeto2){
                        return Math.random() < 0.5 ? objeto1 : objeto2;
                    }
                }

                string s = aleatorizador("Teste", 10); //Erro, não pode converter de int para String
                //Inclusive vai ser um erro bem estranho, pois o compilador vai pensar que é um tipo, e já vai receber outro
  
                //Posso tentar forçar para ele já entender como versão string
                String s = aletorio.<string>aleatorizador("Teste", 10); //Mas vai dar erro, pois se é declarado para tratar strings, ele só pode receber strings
                
                //Também posso explorar tipos em comum para inferir o resultado certo
                Number n = aleatorizador(10.2, 10); //Ele vai entender que o resultado é um número, e não um inteiro ou um double
                    //Contudo isso pode dar erro, talvez eu queira que isso não seja aceito então posso explroar propriedades específicas no méotdo genérico para filtrar isso:
                      public class aleatorio{
                    public <T extends Comparable<T>> aleatorizador(T objeto1, T objeto2){
                        return Math.random() < 0.5 ? objeto1 : objeto2;
                    }
                }

                //Ou seja, é um T que extende o Comparable dele mesmo, ou seja, obrigatoriamente tem que ser um tipo que seja comparável consigo mesmo, coisa que não vai acontecer entre int e float como ali, e nesse caso vai passar a dar erro  
                   // Se eu tirar o <T> do Comparable<T>, vai ficar só Comparable como exigência, então ele vai exigir apenas que ele seja comparável com algo (Ou seja, que implementou comparable alguma vez). Desse modo ele voltaria a funcionar
}