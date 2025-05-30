//AED II


//Outra forma de organizar arquivos:

//B*
//Ainda não há todas operações rápidas com as esturutra que vimos, árvores B vai resolver isso


//Aula passado vimos os índices multinível, e podemos tratar elas como se fosse árvores
    //Ou seja é uma árvore com vários elementos, que fará separação por registros
    //Uma árvore que não será binária, será um Range, e os valores irão de A até B, de B até C, etc...
        //E os filhos delas terão valores entre A e B, e assim por diante, especificando cada vez mais

    
//Inclusive o valor pode ser um "Maior que" ou "Menor que", ou seja, o valor não precisa ser exato dentro do range
    //Ou seja, cada valor da arvore pai sempre vai ter um esuqrda e uma direita

//Várias propriedades no SLIDE

//Todas as folhas estaram no mesmo nível da árvore (Logo, estará garantido que ela está quiblibrada)
    //Isso vai exigir uma regra complexa, pois na hora de inserir pode ficar cheio, e não tem uma "Rotação" fácil de fazer, pois ficar muito caro em disco

//*Não tem motivo para árvore se chamar B



//Nó vai ser de fato um arranajo, e o tamanho máximo vai ser constante.
    //Também vai ter tamanho mínimo, que se aplicará a todos exceto a raiz




//Assintoticamente não é difernete de uma busca binária (Que é log2), contudo aqui é (Logt) que coloca uma constante que diminui muito o temp de processamento

//A quantidade de elemtos filho máxima será sempre o valor mínimo*2 -1
    //E o valor minimo sou eu que defino
    //Quantidade de BLOCOS filho de um bloco vai ser sempre numero de valores preenchidos + 1
    //Cada nó precisa ter T-1 registros no mínimo


//OBS* nos slides as funções salvar disco, ler disco etc.. (Que fizemos em aula) tão modificadas para funcionar em ambientes sem discos. (Tipo internet)
    //Se for usar eu preciso impementar elas, pois só há marcação
    
//Lógica inserção
    //Sempre nas folhas
    //O que ocorre se elas não tiverem espaço?
        //Sempre que eu chegar em um bloco cheio na recursão, eu vou dividir o nó, inepdente se é o que estou buscando ou não ou se vou usar ele
        //A mediana eu promovo para pai (Ele vai ficar exatamente no meio, onde estava o ponteiro, depois preciso ajustar ele)
        //É impossível o nó pai não ter espaço pois se não eu já teria quebrado ele
        //Se for na raiz, isso pode aumentar a altura
        
        //O valor dessa forma sempre terá espaço para ser inserido.
        //E o fato de eu sempre já dividir quem está cheio, garante que eu não vou ter que voltar subindo e divindo (Isso economiza os Seeks do Disco)






