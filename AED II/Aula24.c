//Isso tudo não vai cari na P2 eu acho, só na SUB

//Ordenação externa
//O que é processamento cossequencial
    //Exemplo com ordenação específica

    //Algorítimos que juntam, ou tatram mútiplos conjuntos de maneira que os organiza simultaneamente
    // Exemplo de processamento concorrencial
    //Isso é aplicado princiálemente quando eles não cabem na memória principal (Usaremos no HD)


//Várias etapas, análogo ao merge sort
    //Inicializar
    //Sinconizar
    //Confição de terminar
    //Reconhecer Erros (Nem sempre precisa dependnedo da construção do algoritmo)

//Vamos usar essa organiação como exemplo para estudar isso (Inclusiva é a principal aplicação)
    //Problema, não tem como aplicar algorítimos de ordenação interna pois não cabe
    //Separaremos em pedaçoes e vamos intercalar a ordenação
    //Haverá acesso ao disco, então a complexidade vai ser com base nele (Inclusive é lento)
    //Tem diversos algorítimos para isso, dá para fazer com fitas (Que o braço não se move), com discord paralaleos (Que 1 Byte é divido em 1bit por disco por exemplo), sequencial etc...



//3 Tipos de abpordagens
    //Balanceada
    //Seleção e Substituição
    //Outra que não peguei


//Balanceada - SLide explica melhor, mas passa uma vez já organizando e colocando em disco de entrada, depois passa uma segunda para colocar no disco de saída, usando índice por linha na primeira (entrada) de pois por coluna na segunda (saída)
    //Eu revezo entrada e saída entre os discos, (Então depois de fazer a primeira saída, vou ter blocos organizados, e depois eu preciso usar o disco até agora de entrada como de saída, e ajustar os valores novaemente até virar a resposta)

//COmplexidade será Logf (n/m) sendo tudo isso arrendodado para cima
    //Não só isso, mas N/M (Numero de registros / Tamano da memória) também arredondado pra cima
    //e o f é o número de fita/discos paralelos possíveis.

    //ex com n =22 m = 3 f =3 log3 (22/3) = 2 (Consideradndo os arredondadmentos pra cima)

    //Se não tiver apralelismo as coisas ficam mais complicados, porque eu tenho que ficar redistribuindo pedaços e considerando fitas que sobraram como saídas

    //Se não for apralelo, o número de seeks é quadrádico (Logo Totalmente infeficiente)
        //Tem uma tabeça no slide mostrando a comparação, mas precisa ter bastante HD paralelo para fazer sentido
        //Terá métodos melhores, é isso


