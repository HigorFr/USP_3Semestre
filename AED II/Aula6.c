//Aula 6

//Aplicações de Grafos, Navegação para resolver determinados problemas
//Busca de profundidade, recrusão vai andando para cada vizinho até ter passado por todos
    //Nem todo grafo está conecntado (Grafo Não Conexo), então diferentemente de uma árvore, é necessario ao final conferir remanacecentes para refazer a recursão neles
    //Isso terá muita importância com Árvores de Profundidade

typedef int bool;
#define 1 true;
#define 0 false;

//Precisa de um memo para saber quais grafos eu já visitei

bool busca(Grafo * g, int atual, bool * visitado, int anterior){
    visitado[atual] = true;
    int x;
    for(x=0;x<g->numvertices;x++)
        if(g->matriz[atual][x] && !visitado[x]) //Em ponderados vai ser != Aresta_invalida obviamente
            busca(g,x,visitado,atual);
}
//Complexidade não é trivial, é necessário analisar o código em sí
//Nesse caso é (v-1)*T(v-1), o parametro é v-1 pois em cada caso eu confiro um grafo
    //Cada vez o numero de vizinhos vai diminuindo também, divimuindo o mutiplicador do T()
    //Isso vira O(V²)

//Em grafos não conexos (Ou não direcionados, não lembro) também é O(V²) já que a proporia recursividade irá compensar o for conferência no final
    //Ou seja, se tiver dois sub-grafos, obivamente a complexidade de cada um será menor indiviualmente, e a complexidade continua na mesma proporção




//Em lista de adjacência
//Tanto faz se é ponderado ou não (Areas não existir = Sem aresta)


bool visitaemprofundidade(Grafo * g, int atual, bool * visitado, int anterior){
    visitado[atual] = true;
    ElemLista* end = g->A[atual];
    while(end){
        if(!visitado[end->vertice]) //Em ponderados vai ser != Aresta_invalida obviamente
        visitaemprofundidade(g,end->vertice,visitado,atual);
    end = end->prox;
    }
}

//Também tem uma complexidade difícil de calcular, O(V+E)
//Na vida real, em aplicações de fato, a areasta é proporcional ao numero de vértices, ficando O(V) apenas




//Pra que a busca em rofundidade é usada (IMplementações
    //Identificar componentes em um grafo (Componentes)
    //Encontrar componetes fortemente conectados
    //Vereficiclar ciclicidade (Se é aciclico)
    //Ordenação tológica
    //Sair de labirinto
        //Muito mais

    //Exemplo labirinto
        //Cor de cada vértice
        //tDescoberta, tempo para descobrir
        //tTermino, 
        //Anterior
        //Tempo geral

    //Quatro Tipos de arestas
        //Aresta de árvore - Usada para acessar vértices pela primeira vez
        //Aresta de Retorno - Conectam um v2, à um antecessor v1 (já buscado) em uma árvore binária
        //Aretas de Avanço - Não são da árvore de busca em profundidade, mas conectam um v1 à um sucessor na árvore
        //Arestas de Cruzamento, vetores simuntênos, não são sucessores nem antecessores

        //Isso pode ser literalmente plotado como uma árvore, onde cada componente é uma arvore separada (Contudo só as arestas de avanço serão visíveis)
        //Nome do conjunto de árvores é "Floresta" muito criativo

//DFS é a sigla pra busca

//Labirinto 
    //Direcionados ou não
    //Cada casa (Posição do labirinto) é um vértice
    //Busca será no inicio, (dessa forma é possível passar por tudo)
    //Resposta será um caminho (Lista ligada)
    //Tivemos isso em IAA, fazendo backtracking (Jeito ruim), busca de profundidade é melhor, e o melhor de todos é a busca em largura
    

//Conferir ciclos
    //Se tiver uma ou mais aresta de retorno ele tem ciclicos
    //Ou seja, eu preciso identificar se ela é aresta de retorno
        //Ele precisa ter um vizinho cinza (Não ter terminado de processar)
    //Pra que isso serve? Sâo DAGs, e tem algoritimos que só funcionam em grafos acíclico
    //Em grafos não direcionados, o teste é diferente, eu preciso saber se estou usando a mesma aresta de ida
        //Então de v2 eu tenho que voltar para v1 de outra forma
