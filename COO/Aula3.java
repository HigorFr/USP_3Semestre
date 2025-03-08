//Instancia é sinonimo de objeto

//Linguagem procedural é aquela oposta às OOs (Por exemplo C)

//Todo código deve estar dentro de uma classe

//tamanho de vetor já está junto dele como atributo. É arg.lenght, isso vale pra qualquer vetor, já que todos eles são objeto, mesmo que não explicitamente.


public class Aula3 {
    public static void main(String[] args) {
        System.out.println("Olá, Mundo!");
    }
}
//A primeira classe declarada é a principal, que compartilha o nome do arquivo sempre. Ela que terá a main


//Explicando aspectos
//Public - Visibilidade da classe/método (atributo??), quando é public o acesso é livre para qualquer outra função/classe, se for private nenhuma pode usar. Existem graus intermediários que permitem apenas grupos específicos utilizarem.
    //Normalmente o método Main (SIM, a main é um método da classe principal) é sempre public já que sempre o objetivo da main é ser executada por um programa externo à ela. Main private não faz sentido. (Nos versões atuais colocar public é opcional, já que é óbvio)
    //Isso é diferente do C em que não podemos limitar acesso.

//Static - É algo que adiciona na declaração. Ele diz que um método pode ser executado sem um objeto declarado ( Usando Classe.Método(), invés de Objeto.Métood() ). Existem casos em que não faz sentido criar objeto então ele é rezóavel. Mas normalmente ele é excessão e não regra.
    //Hello world por exemplo não faz sentido ter um objeto.
    //Static também é o padrão da main e também virou opcional

//Culpa da ma fama de java de "Lingaugem Verbosa" vem disso, muitas dependencias de classes

    //System.Out.Println
        //O Println é claramente um método que vai printar o "Hello World"
        //O System.out (Dá pra escrever Sysout que funciona):
            //System é a classe refrente ao sistema e o out é o objeto que gerencia saída dentro da classe do sitsema

    //É facíl identificar, 
        //classes tem letra maiuscula no inicio. (Também são sempre o que inicia qualquer instrução já que tudo tem que estrar dentro de uma classe)
        //Méotods tem ()
        //Objetos são os que não possuem nenhum

    //Isso de obrigar classes em tudo é o que define o Java, dentro das linguagens mais comuns ele é o mais puro orientado à objetos, diferente do python que meio que mistura e deixa você programar sem orientar nada à objetos.
        //Claro que existem linguagens orientadas à objeto ainda mais rígidas que o java (O java tem o chamado "variáveis primitivas")

//Em nomenclatura, O Public e o Static são os chamados "Modificadores"


//Para compilar, o >javac que é o programa usado em um .Java com o código. Ele vai criar um arquivo .class (Não um executável próprio para o sistema como padrão). Esse .class vai ser executado pelo programa >java
    //Ou seja, o usuário só vai ter o programa que executa (A máquina virtual), e não o compilador
    //As máquinas virtuais possuem uma prorpriedade chamada JIT (Just in Time). Elas vão compilando simunantenamente conforme executam o arquivo
    //

//Um único arquivo pode ter apenas uma classe pública. Ou seja, ele força você a se organizar e se modular de maneira que crie classes privadas para suporte e classes públicas para cumprirem apenas o objetivo do arquivo.

//O java também é modular no nível que não necessariamente utilzia o main. Utilizando o JavaFx é possível colocar uma classe que herda uma iniciação de outra classe. Desse modo nem sempre precisa de uma main Public Static. (Sla, Não entendi direito isso).







