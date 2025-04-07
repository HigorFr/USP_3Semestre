//Algoritimo de Krusakl
    //Diferente do algortimo de Prim, ele organiza as arvores de maneira individuais e percorre as arestas de forma ordenada
        //Cada vértice faz parte de uma única árvore
        //A cada iteração, adiciona a aresta de menor peso que não forma um ciclo (Ou seja, mantém a arvore)
            //ELe não necessariamente vai aumentando a mesma
        //Isso vai unindo as árvores, ao final, teremos uma única árvore

    //Ou seja, o principio dele é ordenar a arestas, e ir colocando conferindo se as àrvores já estão conecatadas ou não
    
    //Para Arvores Disjuntas 
        //Gerenciar conjunto de elementos e cada elemento pertence a um único conjunto
        //Principais operações no slide

    //Implementação por padrão é usando florestas
        //Uma para gerenciar conjuntos disjuntos, e outra para a árvore geradora de custo mínimo
    

    //Sempre fundindo as árvores de altura menor nas de valor menor altura
        //Raiz de uma sempre vira filha da raiz da outra (E a aresta repete o peso)

    //Representação
        //Navego de baixo para cima, então cada nó eu só preciso saber quem é meu pai
        //Custo propocional à altura da árvore
            //Dífícil observar, pior caso é juntar árvores do mesmo tamanho, isso é dobrar a quantidade de vértices no mínimo para aumentar h, logo relação de h é O(Log2V), que é O(Log V)
        //Lembrando que uma árvore que é uma "linha reta pra baixo" não existe, na estrutura que ela é contruinda, isso não pode acontecer

        //Endereçamento direto, teremos um arranjo com todos os endereços de todos os vértices
        //Parte mais demorada é organizar as arestas.
            //(ElogE) quando não organizada / O(ElogV) par organizada
        //Ou seja, Kruskal é mais simples na lógica, mas é menos eficiente por precizar de realizar uma ordenação

        //Proxima três aulas é resolver o problema de custo mínimo para mapas
            //Diferente da busca em largura que é numero de arestas, na vida real o peso que importa
            //Para o menor caminho com pesos, precisamos de um algoritimo que leva eles em consideração
            //Floyd Warshall (O "Bubble sort" desses tipos)
        