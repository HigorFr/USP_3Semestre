//Voltando ao Protected que foi colado dentro da classe produto
//Retomando aquela propriedade invocar versões diferentes de um método com mesmo nome



//Caracteristica do JAVA é que ele não tem o conceito de múltiplas heranças, ou seja, não é possível herdar de mais de uma classe ao mesmo tempo
//Python por exemplo tem herença mútipla, então uma classe pode herdar de várias classes ao mesmo tempo, o que pode gerar problemas de ambiguidade, já que o compilador não sabe qual método chamar
    //Chance de confusão é alta


//Abstract é um modificador de acesso que indica que a classe não pode ser instanciada, ou seja, não pode ser criada um objeto dela diretamente
    //Ela é usada para criar classes que servem como base para outras classes, ou seja, ela é uma classe pai que não pode ser instanciada
    //Isso é útil quando você quer criar uma classe que tem métodos que devem ser implementados pelas classes filhas, mas não quer que a classe pai seja instanciada diretamente
    //Então ela serve como um modelo para as classes filhas, e as classes filhas devem implementar os métodos da classe pai
    //Isso é útil quando você quer criar uma hierarquia de classes, onde cada classe filha tem suas próprias implementações dos métodos da classe pai
    //É como um molde para outras classes


    //Nela, os métodos não tem corpo, ou seja, não tem implementação, apenas a assinatura do método
    //E os atributos podem ser declarados normalmente, mas não podem ser instanciados diretamente;

    
    
    //Final é o ponto final da cadeira de herança
        //OU seja, ela não pode ser herdada, não tem filhas
        //String por exemplo é final, não tem como criar algo dela (Provavelmente porquê ela é muito elemntar, contato proximo do OS e isso pode dar problmema)
    
    
//Interfaces
    //"Ferramenta de meio de comunicação entre partes"

    //Interface de uma classe é o que ela pode fazer, ou seja, os métodos PUBLICOS que ela tem
        //E a implementação é como ela faz isso, ou seja, o corpo dos métodos
    
        //No java é  algo ainda mais específico

        //Interfaces são semelhantes as classes abstratas, mas não podem ter atributos, apenas métodos
        //E todos os métodos são abstratos, ou seja, não tem implementação, apenas a assinatura do método

        //Todos que derivarem dela devem implementar os métodos dela, ou seja, não tem como criar uma classe que herde dela e não implemente os métodos
    
        //Se você tentar declarar 

public class Aula10 {
    
}
