//Conforme mencionado, acumulação de papeís em uma unica função/arquivo é desorganizado e é um problema.
    //Implmentar uma pilha em C por exxemplo, em um unico arquivo a pilha sera estruturada e implementada, e isso viola um dos principios de organização de programação (Single Responsability)

    //Isso ajuda a centralizar o código, e reaproveitar o que já existe. Perceba como o objetivo é criar uma separação nítida entre o que é a Pilha e o que é a Main, tornando tudo mais flexível.

    //Mesmo reduzindo o máximo possível a responsabilidade da main, inclusive separando arquivos, algumas varíaveis continuarão tendo que ser decladrada para estruturas não diretamente relacionadas com a main. Em c Isso é o máximo.

    //Um dos problemas claros é que as funções da pliha por exemplo, não estão intrisincamentes ligadas às sua estrutura.
    //Outro problema é a falta de encapsulação, nada me impede de acessar informações internas da pilha e apagar tudo, mesmo sendo uma estrutura sem relação com a main. 


    //Em Java, orientado a objetos, podemos criar um vínculo entre funções e estruturas, os chamados métodos. Em C não tem nada que faça essa ligação, as funções da pilha ficariam misturadas com funções não relacionadas.
        //Ou seja chamamos uma função atráves de uma estrutura, uma struct que comportaria funções. O chamado classe.
    //Também é possível criar regras que impedem o acesso direto à estrutura, e protege possíveis erros. Sendo alterações feitas apenas via funções definidas na classe.
        //As variaveis a qual eu atribuo uma classe, (que pode ser observado como um molde/struct) são chamada de objetos
        //Informações sobre ele, variáveis, são os atributos (dados)
        //Operações são os métoods

        //Sintaxe é (Classe).(Metodo/Atributo)  (por padrão é dificil ter que acessar atributo diretamente pois a boa prática é ter uma função propria para fazer alterações)




public class Aula2 {

    //Exemplo classe em pseudo código (Por convenção atributo primeiro e depois métodos)
    private class Carro {
        int gasolina;

        void andar(int km){
            Carro.gasolina -= 1;
        }
    }


}
//Em C, variáveis funcionam como Stack S; e Stack *S = malooc(-) são coisas diferentes, já que um reotrna um ponteiro e outro o bjeto em sí.
//Em Java só existe Stack S; que já significa Stack *S = malooc(-);, ou seja, em java toda delcaração já cria um espaço para dados futuros, já sendo um ponteiro;




