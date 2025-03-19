//Continuação:

import java.util.Scanner;

class Pessoa {
    int id;
    String nome;
    
    //Esse é o construtor, ele é chamado toda vez que um objeto é criado    
    Pessoa (int i, String s){
        id = i;
        nome = s;
    }

    //Método (centraliza tudo envolvendo a clssse dentro dela mesma)
    void imprimeInfo(){
        System.out.println("Pessoa: id =" + id + ",nome" + nome); 
    }


    //Setters
    void setNome(String s){
        nome = s;
    }

    void setID(int i){
        id = i;
    }

    //Getters
    public String getNome(){
        return nome;
    }

    public int getID(){
        return id;
    }



}






public class Aula6 {

    public static void main(String[] args) {
        //Isso já é grande parte do encapsulamento, que é uma parte essencial da orientação a objetos

        //Scanner é uma classse que permite a entrada de dados pelo teclado
        Scanner scanner = new Scanner(System.in); //System.in é a entrada padrão, ou seja, o teclado


        //Lembrando que no java, os nomes das funções podem ser iguais, desde que a assinatura seja diferente (Ou seja, a quantidade de argumento). Isso cria variações diferentes para cada função (Algumas podem ter tipos genéricos, retornando coisas diferentes dpeendnedo da versão).


        //Também no java, eu posso declarar uma variável e ao mesmo tempo validar uma confição ex:
        int value;

        while (value = scanner.nextInt() != 0){
            System.out.println("Value is not 0");
        }
        //Inclusive da para aumentar um valor, ou seja, value += a dentro do proprio while, isso é muito útil para loops


        //Dentro da estrutura, também posso colcoar o private e o public diretaemnte nos métodos e atributos, não só na classe.

        //Na maioria das vezes os atributos são privados e os métodos são públicos, para que o usuário não possa alterar diretamente os atributos, mas sim através de métodos

        //Exemplo com classe de stacks nos slides (Divisão de trabalho, um utiliza e o outro desenvolve)
            //Denominação explicita de encapsulamento nos slides
            //O que é encapsulamento: É a ideia de que o usuário não precisa saber como o método funciona, apenas o que ele faz, mesmo sendo um "Bônus" para o usuário saber como funciona a classe, isso não significo que ele deve ter acesso à ela.
        


    }
}
