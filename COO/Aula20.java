public class Aula20 {
    
    //Na implementação do tipo generico, é como se fosse uma camada a mais de parametrização

    public class pilha <T>{ // Código da pilha de exemplo
        private T[] pilha;
        private int topo;
        private int max;

        public pilha(T valor) {
            this.max = max;
            this.pilha = (T[]) new Object[max];
            this.topo = 0;
        }

        public void push(T elemento) {
            if (topo == max - 1) {
                System.out.println("Pilha cheia");
            } else {
                pilha[++topo] = elemento;
            }
        }

        public T pop() {
            if (topo == -1) {
                System.out.println("Pilha vazia");
                return null;
            } else {
                return pilha[topo--];
            }
        }
    };

    //Existem algumas notações, T é normalmente a mais gera, e E é para elemento (Em estrutura de dados), X e Y são outros

    //E o T não muda de tipo em função da execução, se ele é chamado como inteiro, ele vai ser inteiro na chamada toda.
        //Inclusive depois de compilar, o compilador vai gerar um código que vai ser específico para aquele tipo, ou seja, ele não vai ser genérico na execução, ele vai ser específico para aquele tipo.

    //Então T é um tipo genérico, ele é universal, o compilador não sabe o que é, então apenas métodos universais podem ser usados, como o toString, equals, hashCode, etc. 
        //Não tem como criar algo que mudará conforme a escolha

    //Tipo
    T x = new T(); // Isso não é possível, pois o compilador não sabe o que é T, então não tem como criar um objeto desse tipo. Nem criar vetor de objetos tipo T também

    //Também temos métodos genéricos, que são métodos que podem receber qualquer tipo de dado, e o compilador vai garantir que o tipo é o mesmo em todos o escopo
    public <T> void metodoGenerico(T elemento) {
        System.out.println(elemento);
    }

    //USando a classe generica
    pilha<Integer> pilhaInt = new pilha<>(10); //Na segunda, na instância, se for na mesma linha eu posso omitir o elemnto, por isso <> invés de <integer>. Porquê é intuitivo que eu quero a mesma coisa
    //Ou seja, eu já falo que que é uma pilha tipo genérica
    //Mas ai tem uma problema, eu não posso colocar uma INT, pois o T só aceita objetos, e Int é tipo primitvo
        //Para resolver isso eu posso converter a int em Integer, ou seja, eu faço o boxing, que é a conversão de tipos primitivos para tipos objetos
    

    //Contudo, pelo exemplo do professor ainda terá um warnign do java avisando que os typcasts quando tiver usando métodos genéricos, não poderão ser verificados em tempo de execução, pois o compilador não sabe o que é T
        //Normalmente as pessoas colocam para o compilador ignorar esses erros
        @SuppressWarnings("unchecked"); // Ignora os warnings do compilador

        //Arrobas no código são anotações, que são metadados que descrevem o código, e podem ser usadas para gerar documentação, ou para fazer verificações em tempo de execução. Isso sinaliza alguma coisa para o compilador mas não vai mudar nada no código executavel em sí.
            //Tem outros exemplos, tipo quanto vamos fazer uma sobrescrita de um método filho no pai (Que nem aprendendomos nas outras aulas). A IDE normalmente já colca isso. Isso é bom para o compilador saber se de fato aconteceu alguma sobrescrita e se não aconteceu, ele vai dar aviso.
            @override // Sobrescreve o método pai

        //Eu também posso limitar o quão generica é minha classe, ou seja, eu posso dizer que T tem que ser um tipo que estenda uma classe específica, ou implemente uma interface específica. Isso é muito útil para garantir que o tipo é compatível com o que eu quero fazer com ele.
            //Para isso eu uso o operador extends, e coloco a classe ou interface que eu quero que T estenda ou implemente
            public class pilha <T extends Comparable<T>> { // Isso significa que T tem que ser um tipo que estenda a classe Comparable
                //Ou seja, eu só posso usar tipos que implementem a interface Comparable, como Integer, Double, String, etc.
                //Então é limitado, mas ainda é genérico, para evitar inserções não adequadas

                //Isso é meio confuso, mas proxima aula será mais especificado
            }

    //Outra coisa é que ume variável genérica não pode ser chamada em contexto staticos, pois em métoods staticos são universas, e variáveis genéricas não estão definidas ainda (eu acho )
}
