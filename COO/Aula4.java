//Revisandao conceitos básicos
    //Cuidado d


//Exemplo
class Pessoa {
    int id;
    String nome;
}



public class Aula4 {
    
    public static void main(string[] args){
        //Pessoa p; isso não declara de fato
        Pessoa p = new Pessoa(); //Isso de fato declara, o new é como se fosse um malloc 
            //Pode haver parametros no pessoa(), pois o objeto também ganha uma função do mesmo nome que se inicializa.
            //Nesse caso não foi declarado um construtor lá na classe pessoa
                //Logo fica uma função vazia (tipo pessoa (){}; )
            //Isso é o contrtutor do objeto, ele nunca retorna nada.


        //Rever isso:
        //Qualquer variável primitiva (Int, public, class) são armazenadas junto com o endereço da varíavel
            //Então um string[] "abc" guarda tanto a stirng e a do endereço que contem "abc"


        System.out.println("Pessoa: id =" + p.id + ",nome" + p.nome); //Isso não imprimir nada, pois não há atributos nesse objeto, então será impresso 0 para ID, pois é uma variável, e "NULL" para a String que é um ponteiro (mas lá no fundo também é zero)

        //Ou seja, o compilador não irá permitir variáveis não inicializadas, mas irá permitir atributos não declarados
            //Note que para acessar os atributos usa-se o ponto.
            //Note também que o + soma as string (concatena elas)

        
        //Dá para colcar atributos usando:
        //p.nome = "Joao";
        //p.id = 1234;
        //Isso não é o certo, pois não está encapsulado da meneira correta. Estou permitando o usuário colocar valores não permitidos. O certo é criar um método que recebe os valores e os inclui dentro da classe os validando.
        //Qualquer boa prática básica fala isso.


        //Também da para colocar os atributos na própria inicialização, colocando o construtor na classe:
        //  Pessoa (int i, String s){
        //    id = i;
        //    nome = s;
        //  }
        //E usar Pessoa p = new Pessoa(1234,"João")


        //Contudo isso também não resolve o código todo, pois estou novamente buscando dados diretamente pela propriedade, o certo seria utilizar um método que me retorna o que eu quero, (Seja todas as informações, só o ID, só o nome etc...)

        //Ex
        // void imprimeInfo(){
        //  System.out.println("Pessoa: id =" + id + ",nome" + nome); 
        //  }

        //E ai eu posso chamar apenas o imprimeInfo
        
        //Note que como esse código vai rodar dentro do objeto, ele sabe que p.nome e p.id já são de p. Então não se coloca p.

        

//Strings
        //Quando java declara uma string, a máquina virtual já guarda os argumentos antes de executar a função
        //E para tudo que é varíavel primordial, ele só copia o valor, contudo para classes como String, ele apenas muda o ponteiro.
        //Então eu não preciso especificar o tamanho da memória que a string irá usar, pois quando ele for alocar a string, ele não estará criando nada, irá apenas apontar para a string já conhecida pela máquina virtual

        //Tem um negócio chamado alocação implítita que eu não entendi


        //Isso será aprofundado no futuro

        //As strings são imutáveis, para "altetar" você precisa criar um novo espaço de memória e alterar o ponteiro

    }

}
