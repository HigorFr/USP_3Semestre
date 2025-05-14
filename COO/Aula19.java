public class Aula19 {
//Prova dia 30/5
    //Terá EP
    //COO no geral
    //Pacotes
    //Execução
    //Basicamente tudo que foi visto

//Tipos genéricos

    //Supomdo uma pilha, cada função de pilha tem um tipo diferente na assinatura, e eu não quero ficar criando várias funções para cada tipo, então eu uso generics, que é uma forma de criar uma função que pode receber qualquer tipo de dado, e o compilador vai garantir que o tipo é o mesmo em todos os lugares onde a função é chamada.
    
    //O compilador vai garantir que o tipo é o mesmo em todos os lugares onde a função é chamada, e se não for, ele vai dar erro de compilação. Isso é muito útil para evitar erros de tipo em tempo de execução, que são mais difíceis de detectar e corrigir.

    //Para isso, eu uso o tipo objeto, que é a superclasse de todos os tipos em Java (Tudo que eu faço vai ser um objeto, exceto os tipos primitivos), e eu posso usar o operador instanceof para verificar se o objeto é de um tipo específico. Isso é muito útil para evitar erros de tipo em tempo de execução, que são mais difíceis de detectar e corrigir.

    //Ainda tem os tipos empacotadores, que são os tipos primitivos em forma de objeto, como Integer, Double, etc. Eles são usados para evitar erros de tipo em tempo de execução, que são mais difíceis de detectar e corrigir. Eles também são usados para evitar erros de tipo em tempo de compilação

        //Isso contudo, dá problemas, pois torna frágil a minha tipagem na hora da execução, pois eu posso ter um objeto que não é do tipo que eu espero, e isso pode causar erros de tipo em tempo de execução. Isso é muito difícil de detectar e corrigir, e pode causar muitos problemas em programas grandes e complexos.

            //Tipo, supondo uma pilha que aceita objetos, isso pode dar errado:
            Integer j = (integer) p.pop();
            int x = j.intValue();


    //Um meio termo apra resolver esse problema seria criar uma classe pilha generica pai, que só recebe objeto, e depois criar classes filhas que extendem essa classe e recebem tipos específicos, como pilha de inteiros, pilha de doubles, etc. E sobrecarregar uma função Push para cada. Isso funcionaria melhor mas tem um problema
        //A classe filha teria que restringir a classe pai, coisa que a filha não pode fazer, então um "PushINT" continuaria teria que ser int no parametro. Logo não esta de fato substituindo o PUSH, está criando uma outra função, com diferentes parametros, o que não é o que queremos
            //Eu vou acabar tendo várias funções com o mesmo nome, mas com parâmetros diferentes que seria o mesmo de não tivesse usado herança.

    //Uma outra maneira melhor seria um pouco mais complexa, eu guardo a pilha mais genérica dentro de uma pilha mais específica. (Ou seja, uma PilhaInt com uma Pilha dentro) 
        //Isso é meio que criar uma casca externa, que vai filtrar, vai gerenciar o que entra e o que sai da para pilha interna
        //Nesse caso não tem como usar errado, pois a saída da pilha externa vai ser sempre igual a ao parametro esperado, não precisarei de typcast e se der algum problema ele irá me avisar (Diferente da objeto, que nesse caso vai pensar que está fazendo tudo certo)


    
    //Melhor que isso é de fato o tipo generico, que é uma forma de criar uma função que pode receber qualquer tipo de dado, e o compilador vai garantir que o tipo é o mesmo em todos os lugares onde a função é chamada.
        //Ou seja eu jogo a minha variável no tipo generico e o compilador vai garantir que o tipo é o mesmo em todos os lugares onde a função dessa chamada até a saída, e se não for, ele vai dar erro de compilação. 

        
        

    //Tem ainda o Boxing e o Unboxing, que é a conversão de tipos primitivos para tipos objetos e vice-versa. (Coisa que antigamente não existia)

    Intger X = 10; //daria erro assim como
    int y = i; //(sendo i uma Integer) também daria erro

    //Eu tinha que fazer na mão Integer X = new Integer(10); ou Integer y = i.intValue(); 
    //Mas agora o compilador já faz isso para mim, ele entende que é óbvia a minha transformação, e faz isso automaticamente.









}
