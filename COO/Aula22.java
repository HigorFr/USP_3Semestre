public class Aula22 {
    
    //Finalmente finalzando o assunto de generics
    //<?> é uma notação de função wildcard, ou seja, é um tipo que não importa qual é, mas ele vai ser um tipo específico
    //Ou seja, é um tipo que não importa qual é, mas ele vai ser um tipo específico

    //A diferença do <T> para o <?> é que o <?> não tem como eu fazer um typecasting, ou seja, não tem como eu transformar ele em outro tipo


    //Funções genericas vão sempre tentar rodar a versõa mais específica da função
    //Ou seja, entre Integer e Number, ele vai rodar a versão de Integer caso eu coloque um número inteiro por exemplo
    //Isso considerando que existe méotdos identicos que recebe um Number e outro que recebe um Integer



    //Exceção, qunado eu defino tipo específico do parametro, vai funcionar diferente como a generalização do méotodo:
        //No méotodo:
        public <T extendes Number> void metodoGenerico(Lista<Number> objeto){
            }

        //Por mais que o méotdo aceita o tipo Inteiro ou double, pois ele aceita qualquer coisa que extend Number, a Lista não vai aceitar, pois ela é um parametro.
            //Isso tem que ser limitado pois o parâmetro não pode acabar extendendo o que o método não aceita, e o compilador para garantir isso não deixa. (Não tem como garantir que o tipo mais génerico que estou passando vai sair como tipo mais específico)

            //Ou seja, o méotodo aceita qualquer coisa que extend Number, mas a lista só aceita Number, então não tem como rodar adequadamente como INT

            //Para funcionar eu deveria usar o <T> para manter ele sincronizado com o esperado do méotodo


            

}
