//Hashing

//Vai ser a aplicação disso na sexta forma
//Pois ele tabém é muito usado em memória primaria, então vamos explorar essas parte para depois aplicar em disco e em banco de dados.


//Primeiro vamos ver como funciona uma tabela de array
//Imagina uma função que recebe um numero e retorona a versão por exetenso do numero (O texto)
    //Isso normalmente seria feito em um arranjo
    //Isso é chamado de endereçamento direto, e é encontrada instantanemante dependendo da chave (Que é um numero).

//Criaremos um Dicionário Dinamico, que é esse cocneito abstratos de colocar, acessar e remover valores através de uma chave
    //Ou seja, em C eu atribuo um "Nome" a uma chave, que no fundo vai ser um numero, mas quando eu quiser acesssar eu consigo só usando o nome, o que é instantâneo

//Isso pe válido quando quando tenho poucas chavas, pois isso vai exigir memória, (Eu vou precisar de um campo para cada chave no fim das contas), já que elas mapearão direto para minha tabela


//Contudo, supondo que eu tenho várias "Colunas", eu tenho que ser capaz de indexizar tudo isso rápido, para acessar o conteúdo independente da coluna, meu objetivo aqui pe evitar busca sequencial
    //Problemas: (Não anotei)


//Teremos uma uma tabela de hash, que terá um tamanho fixo e cada chave vai cair em uma posição específica (Usando módulo por exemplo, ou seja, não é todos valores)
    //Ela vai ser uma estrutura ótima para dicionários, tempo médio é O(1), contudo pode acontecer Teta(N) (Se tudo cair no mesmo índice, o que é praticamente impossível)
    //Será um arranjo de lista ligada, cada chave tera uma lista ligada que irá passar pelos elemntos que cairam nela.
    
//Esse processo de transformar uma chave em um indice é chamado de função Hashing, bem comum ser o módulo.
    //Colisão é quando duas chaves caem no mesmo índice
    //Tem as hashing sem colisão também, para garantir que sempre é O(1), mas isso é bem raro na vida real

//A ideia então é achar algo aleatorio no dado paara atribuir a linha dele, já que padrões iriam acumular em uma mesma linha
//Banco de dados combinam isso com árvore B
    //Ele é excelente para busca pontuais
    //Contudo ele é horrível para Ranges, ai que arvores complementam bem.

