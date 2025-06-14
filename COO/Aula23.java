//Coleções em Java
//Continuação

//Tabela de espalahamento hash é um tipo de coleção, com várias nunãncias


//Threads é fluxo de processamento, isso é para organizar o código para o processador.
    //Inclusive a maioria dos progrmas com interface são multithread


//For EACH
    //Usado no for, para ir sempre para o for
    //Você pode implementar a classe interface Iterable, que é uma interface que permite que a classe seja iterável
    //E ai você pode usar no for each também

    //Única limitação é que não é possível remover elementos do for each, apenas ler



//o Equals passa por todo um For
    //A coleção não especificar criterios de igualdade, será o tipo do objeto
        //Nem toda igualdade é só usar "=="
    //O equals meios que itera os valores da coleção e compara para falar se é igual ou não


//O equals é fundamental, principalemnte num hash.
    //Imagina que você tem objetos considerados equals, imagine que você aplica um hash e ele retorna valores dierentes
    //Isso pode acontecer pois o hash pode olhar o endereço na memporia, isso é algo que todos os objetos compartilham que sempre será diferente


//Função Hashcode()
    //É uma função que retorna um inteiro, que é o código hash do objeto
    //O hashcode é usado para comparar objetos, e é usado para armazenar objetos em coleções como HashMap e HashSet
    //Se dois objetos são iguais, eles devem ter o mesmo hashcode
    //Se dois objetos não são iguais, eles podem ter o mesmo hashcode, mas isso é raro

    //Ele será passado para função de hash para ai ela calcular o índice. (Óbivo, pois os ranges podem não bater)

    //Então é como se hash sempre recebece um hashcode, 2 etapas.

    //O ponto é: eu tenho qeu fazer o mesmo hashcode se eles caem no equals, para evitar aquele problema.
        //Ou seja, é um contrato, não tem como forçar, mas eu tenho que garantir isso ou os hash de coisas iguais vão ser diferentes

//Toda vez que você redefinir o euqals, você deve redefinir o hashcode também
    //E vice-versa, se você redefinir o hashcode, você deve redefinir o equals também
    //E ai você tem que ser criativo, se vira e acha alguma formula usando algum ID único.
        //Ex, se fosse dados de NUSP, você pode retornar o inteiro dele como hashcode, e isso já garante padronização


//No fim isso será O(1), pois você usa o proprio dado para ir direto onde ele está