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
        public <T extends Number> void metodoGenerico(Lista<Number> objeto){
            }

        //Por mais que o méotdo aceita o tipo Inteiro ou double, pois ele aceita qualquer coisa que extend Number, a Lista não vai aceitar, pois ela é um parametro.
            //Isso tem que ser limitado pois o parâmetro não pode acabar extendendo o que o método não aceita, e o compilador para garantir isso não deixa. (Não tem como garantir que o tipo mais génerico que estou passando vai sair como tipo mais específico)

            //Ou seja, o méotodo aceita qualquer coisa que extend Number, mas a lista só aceita Number, então não tem como rodar adequadamente como INT

            //Para funcionar eu deveria usar o <T> para manter ele sincronizado com o esperado do méotodo


            //Até aqui é a P1 (Dia 30/5)


//Outro conteúdo aqui pro futuro (E pro EP)
    //Coleções Java

    //Java collections framework

            //Implementa estruturas clássicas de dados
                //Listas
                //Filas
                //Pilha
                //Conjuntos
                //Mapas

            //Para usar é só importar a biblioteca java.util
                //Todas já são as mais eficientes possíveis
                //Dá para trocar estuturas por outras sem grandes mudanças de arquitetura

            //Existe uma classe abstrata chamada Collection, que é a superclasse de todas as coleções
                //Ela tem métodos comuns a todas as coleções, como add, remove, clear, size, etc
                //E ela tem subtipos que são as implementações das estruturas de dados
                    //List: ArrayList, LinkedList, Vector
                    //Set: HashSet, LinkedHashSet, TreeSet
                    //Map: HashMap, LinkedHashMap, TreeMap            

            //Ele meio que define todas as operações elementares, ela é o básico de operações
                //Dentro dela tem ainda a List que é uma interface que extende a Collection com métodos específicos para listas
                //Conforme vai descendo a hierarquia, vou ficnado com operações mais específicas


        }