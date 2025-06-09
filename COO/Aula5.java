//This é o "SELF" do python, se refere à alterar ao objeto em sí
    //Continuando exemplo pessoa, isso seria this.nome ou this.id
    //Como visto, eu não preciso especificar isso na varíavel, já que é subentendido, mas deixa mais explicito pelo menos 


//Voltando ao tópico de encapsulamento, o id e o nome continuam sendo possíveis de serem alterados através de pessoa.id ou pessoa.nome

//Para evitar isso, podemos usar o private, que faz com que só a própria classe possa acessar esses atributos e deixar apenas métodos públicos para acessar esses atributos

//O default (Não colocar nada) é outro nível de segurança, que faz com que apenas classes do mesmo pacote possam acessar o atributo (Isso vai ser dito depois)

//O protected é um nível de segurança que permite que classes filhas possam acessar o atributo, mas não outras classes

//Isso é parte essencial da orientação a objetos

//Por isso existem os metodos get e set, que são métodos públicos que permitem acessar e alterar atributos privados, separados por letra maiúscula
//Exemplo: getNome e setNome, getID e setID



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

}

//Ideia de "O que" e "Como", o usuário não precisa saber como o método funciona, apenas o que ele faz
    //Isso ajuda a manter o código mais organizado e fácil de entender, além de dividir o trabalho de maneira mais eficiente






public class Aula5 {

    public static class Filagenerica<T>{

        private int max;
        private T[] array;
        private int qtd = 0;

        private Filagenerica(int max){
            this.max = max;
            this.array = (T[]) new Object[max];
        }


        public void adicionar(T Elemento){
            if(qtd == max){
                System.out.println("lista cheia");
                return;
            }
            this.array[qtd] = Elemento;
            this.qtd++;
        }
    


        public T remover(){
            if(qtd == 0){
                System.out.println("lista vazia");
                return null;
            }
            
            T temp = array[0];
            int x;
            for(x=1;x<qtd;x++){
                array[x-1] = array[x];
            }
            qtd--;
            return temp;
        }

        public int getTamanho(){
            return this.qtd;

            
        }


    }

    public static class Teste{

        public static <T> Filagenerica<T> criaFila(T[] lista){
            Filagenerica<T> fila = new Filagenerica<>(lista.length);
            for(T elemento : lista){
                fila.adicionar(elemento);
            }
            return fila;
        }


        public static <T> void processafila(Filagenerica<T> fila){
            int x;
            int q = fila.getTamanho();
            for(x=0;x<q;x++){
                System.out.println(fila.remover());
            }
        }

    }


    public static void  main(String[] args){
        String[] lista1 = {"Teste1", "Teste2", "Teste3" };
        Integer[] lista2 = {1,2,3,4,5,6,7,8};
        Double[] lista3 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.9};
        Object[] lista4 = {"a","b","c","d"};

        Teste.processafila(Teste.criaFila(lista1));
        Teste.processafila(Teste.criaFila(lista2));
        Teste.processafila(Teste.criaFila(lista3));
        Teste.processafila(Teste.criaFila(lista4));

    }



}
