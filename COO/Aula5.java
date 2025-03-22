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




public class Aula5 {}
