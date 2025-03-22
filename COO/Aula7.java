//Tipo primitivos
    //int, double, float, char, boolean
    //int é um tipo primitivo, ou seja, não é uma classe, então não tem métodos
//Muitos semelhantes aos da linguagem C

//String por exemplo, é uma classe, então tem métodos:
    //length() -> Retorna o tamanho da string
    //toUpperCase() -> Retorna a string em maiúsculo 

//Conferir se strings são iguais é conferir se o ponteiro é o mesmo, já que a stirng é imutável
//Para comparar strings, usar equals() ou equalsIgnoreCase()


//Vetores
    //int[] A = new int[10]; -> Cria um vetor de 10 posições
    //vetor[0] = 1; -> Atribui 1 à primeira posição
    //vetor.length -> Retorna o tamanho do vetor

//Ou seja, em memória, o "A" é um ponteiro para o primeiro elemento, e os elementos são alocados em sequência

// int[] a; -> Declaração
// a = new int[10]; -> Alocação
// int[] a = new int[10]; -> Declaração e alocação
//int a = {1,2,3,4,5}; -> Declaração e inicialização

//Pessoas falam que java não é totalmente orientado a objetos, já que tem tipos primitivos, mas isso é uma característica da linguagem
    //Foi feito dessa forma para ser mais eficiente, já que tipos primitivos são mais rápidos que objetos
    //Por isso, a linguagem tem "autoboxing", que converte tipos primitivos em objetos e vice-versa
    

//isso faz diferneça principalmente em funções, já que os argumentos oriundos de primitivos são cópias, enquanto os oriundos de objetos são referências
    //Ou seja, se eu passar um vetor para uma função, eu estou passando um ponteiro, então qualquer alteração feita na função vai ser refletida fora dela
    //Já se eu passar um int, eu estou passando uma cópia, então qualquer alteração feita na função não vai ser refletida fora dela

//Dá para forçar isso usando o método .clone() em objetos, que cria uma cópia do objeto


//Instanciação
    //É o nome de todo processo explicado anteriormente, ou seja, criar um objeto a partir de uma classe
    //Pessoa p = new Pessoa(1, "João"); -> Cria um objeto p da classe Pessoa, com id 1 e nome João


//Retomando modificadores de acesso (Public,Private, Default e Protected) como já explicado, mas agora nos slides
    //Public -> Qualquer classe pode acessar
    //Private -> Apenas a própria classe pode acessar (As filhas não podem acessar)
    //Default -> Apenas classes do mesmo pacote podem acessar (Mesmo .java) (Classes filhas não necessariamente estão no mesmo pacote)
    //Protected -> Apenas classes filhas podem acessar (Mesmo pacote ou sendo filhas)

    
public class Aula7 {   
}
