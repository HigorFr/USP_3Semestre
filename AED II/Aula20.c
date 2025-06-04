//Árvores B+ e B*, variações da B


//B+
    //Os nós vão armazenar apenas íncides (Ponteio de filho e chave)
    //E as folhas vão armazenar os registros de dados

    //Isso torna a blocagem menor, então cabem mais elementos na memória e aproveito mais (A árvore fica menor)
        //Por isso muitos bancos de dados usam isso


    //Ou seja, os folhas não será o o dado em sí, mas um ponteiro para o dado.
        //Obviamente nessa estrutura sempre vai ter uma folha para cada respectivo dado, ou eu perderia ele.

    //Contudo, nós folhas vão ter uma nó sobrando (Porque eu sempre tenho 4 ponteiros para 3 elemntos por exemplo), esse pontiero vai apontar para o nó folha irmão, o que me permite busca em intervalo (Como em uma lista ligada)

    //Dà para os memos registros serem armazenados em diferntes árvores B+ para cada um dos campos, e assim eu consigo fazer buscas mais rápidas (Por exemplo, se eu quero buscar por nome, eu busco na árvore B+ de nomes, e se eu quero buscar por idade, busco na árvore B+ de idades)
        //Isso é usado em bancos de dados para otimizar buscas

    //Agora folha então pode ter de t-1 a 2t-1, já que você vai ter um pontiero para cada chave (Elemnto) + 1 para ligar no próxima folha irmã

    //Nesse caso o código muda, a folha não vai ser excluida já que manter o pontiro para o registro, nesse caso ela vai ser copiada para o pai

    //Exclusão pode ser feita de dois modos, sendo um deles mais classico,
        //Tudo no slide

    
    //B*
    //Feita por knuth, importante para bancos de dados
    //Otimizar uso da memória, fazer menos divisões de nós lotados.
    //Bloco não cheio não aproveita todo HD, e quando é mandado para RAM, também chega pela metade, o que é ruim para RAM também.

    //O mínimo de preenchimento é 2/3
    //Ele posterga a divisão até que dois irmãos imediatos estejam cheios (DAi divide os 2 nós em 3)

    //Alguns sitemas que gerenciam banco de dados (SGBD) usam um B+ com parametro similiar à esse B* com um fill factor entre 0,5 e 1, as vezes até separa esse fator para nós internos e outro para folhas.