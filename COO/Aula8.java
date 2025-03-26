   
public class Aula8 {

//Aula8

//Retomando o modificador Static e Não Static
    //Por padrão ele nunca está ativado, ou seja, ele é um caso específico
    //O caso padrão é, cada objeto de determinada classe terá uma cópia dos atributos
        //Ent o cada carro da classe carro terá a própria variável de "marca" por exemplo
        //O mesmo vale para os métodos, eles operam vendo apenas os próprios atributos

    //Só que as vezes é interessante que todos os objetos de uma classe compartilhem um atributo
        //Por exemplo, se eu quiser contar quantos objetos de uma classe foram criados
        //Para isso, eu uso o modificador static
        //Então, se eu fizer um atributo static, todos os objetos da classe vão compartilhar o mesmo atributo
        //O mesmo vale para métodos, se eu fizer um método static, ele vai operar em cima de atributos static

    //Ou seja, é uma informação da classe, uma variável global da calsse, que não está relacionada ao objeto
     
    
    
    
    //Exemplo
    public class Teste {
        int informacao; //Cada objeto tem a propria informação
        static int quantidade_de_objetos;
        //Aqui a quantiade_de_objetos é compartilhada por todos os objetos da classe Teste

        //Para método isso também vale
        static void metod() { System.out.println(quantidade_de_objetos);}
            //Aqui eu não posso acessar informacao, já que ela é um atributo de objeto específico
            //Mas eu posso acessar quantidade_de_objetos, já que ela é um atributo da classe
    }            //Por isso que nesse caso, eu posso chamar a função mesmo sem ter nenhum objeto da classe

    //E claro que todo metodo especifico consegue ver os estáticos e os locais, mas os estáticos não conseguem ver um local específico


    //No exemplo dito, o atributo quantidade_de _objetos deve ser auemntado pelo construtor (Ou se não o usuario seria obrigado por exemplo a fazer Teste.quantidade_de_objetos++)
        //Retomando, o construtor é um método que é chamado quando um objeto é criado, sempre com o nome da classe
    

    
    public static void main(String[] args) {
        Teste.metod(); //Vai printar a quantiade_de_objetos
                        //Observe que nesse caso é class.metodo e não objeto.metodo, o mesmo vale para atributo
                        //O objeto.metodo e atributo também funciona, mas não fica claro, por isso não é usado
    }


    //Existem também blocos estáticos, Static{}, que roda uma vez antes da classe ser carregada, bem raro de usar.
    


    //Em C também tem o modificar Static, mas é totalmente diferente
        //Nesse caso, static é usada para fazer uma varíavel declarada nunca ser resetada, mesmo quando uma funação reinicia. Ou seja, seja é como se sobrevivesse independete de quantas vezes a função é chamada.
        //Também é bem incomum


    //Como mencionado, existem classes já estabelicidas no Java, como o Math
        //Ela tem várias funções matemáticas, como Math.sqrt(), Math.pow(), Math.abs(), Math.random(), Math.max(), Math.min(), Math.round(), Math.floor(), Math.ceil()
        //E na matematica não tem porque ter objetos,tem apenas uma entrada e um retorno, logo ele é somente composta por métoods estáticos por exemplo

    

    //Herança
        //Hierarquia de tipos, classes dentro de classes
        //Herança é uma relação do tipo "é um"
        //Classe "Filha"
        //A classe filha herda todos os atributos e métodos da classe pai 
        //Intuito de reaproveitar coisas já delcaradas, evitar repetição de código
            //Redundância é um mal sinal sempre, aumenta manutenção
        //Dá para adicionar novos atributos e métodos, ou até substituir os métodos da classe pai utilizando o mesmo nome na declaração
        //Ou seja, a classe filha é uma extensão da classe pai
            //Lembrando que a classe pai não consegue acessar os atributos e métodos da classe filha, apenas o inverso, por padrão (mas pode mudar com relçao o modificador de acesso)

        //Também vale ressaltar que assinaturas diferentes são funções diferentes no Java (Mesmo se tiverem nomes iguais), então se o pai tem um m2(arg 1) e a filha tem um m2(arg 1, arg 2), são funções diferentes. Isso faz com que a função filha tenha dois métodos diferentes, um da classe pai e um da classe filha, dependendo da chamada. (Chamamos isso de sobrecarga)
            //Isso pode criar muitos erros, pois você pode pensar que algo está sobreescrevendo algo, mas na verdade está criando uma nova função

    
        //Classes filhas normalmente nunca vão restringir o que a classe pai faz, só expandem, já que pelo entendimento uma classe filha é algo específico da classe pai

        //Dá para também criar um objeto da classe filha, mas restringindo á classe pai, exemplo Pai.objeto = new filha()
        //Isso faz com que os métodos de Y que substituem X sejam chamados, mas os métodos de Y que são novos não sejam chamados
            //Isso acontece pois, na teoria, de fato a variável possui dados do Y, mas o compilador não deixa eu chamar métodos que não existem no X
            //Isso é chamado de polimorfismo, que é a capacidade de um objeto ser tratado como um objeto de uma classe pai, mas ainda assim ser um objeto da classe filha
            //Isso é meio que uma gambiarra, chamamos a função filha que "Subiu" para a classe pai de versão "sobrecarregada", "Shadowing??"

        //Ou seja, o polimorfismo é a capacidade de um objeto ser tratado como um objeto de uma classe pai, mas ainda assim ser um objeto da classe filha


        //Nem sempre vale a pena usar Hereança, alguns pontos a declarar 
            //De fato terá coisa reaproveitada?
            //Se de fato vale a pena craiar uma hierarquia de classes, para usar do polimorfismo
            //E Outros pontos, sempre dá para fugir de herança de algum modo. (inclusive há quem critique muito)
        

}
