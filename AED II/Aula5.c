//Aula 5
//Listas de Adjacências


//Será alterado listas ligadas e não uma matriz

//Lebrando que podem ser ponderadas ou não, direcionais ou não

//Todas as funções implementadas anteriormente podem ser implementadas com listas ligadas:

//Cada posição de uma lista ligada (Que representa cada vetor) será um vizinho existente
//Ou seja, um arranjo de listas ligadas

//Aqui, a lista ligada será uma lista de adjacências


typedef int bool;
#define true 1
#define false 0


//Estrutura:
typedef struct aux
{
    int vertice;
    struct aux* prox;

} Adjacencia, *Pont;

typedef struct{
    int numVertices;
    int numArestas;
    Pont* lista;

} Grafo;

//Inicialização
    //Aqui, a inicialização é diferente, pois é necessário alocar um vetor de ponteiros
    //E cada posição desse vetor será uma lista ligada

bool inicializaGrafo(Grafo* g, int vertices){
    if(!g || vertices < 1) return false;
    g->numVertices = vertices;
    g->numArestas = 0;
    g->lista = (Pont*) malloc(sizeof(Pont)*vertices);

    for(int i = 0; i<vertices; i++) g->lista[i] = NULL;
    return true;
} //Complexidade O(V)


//Para exibir, existe um conceito que deverá ser analizado pelo programador
    //Não existem arestas para serem imprimidas, então a exibição será diferente
    //Vou imprimir um vértices e seus vizinhos para cada uma das linhas


    void exibirGrafo(Grafo* g){
    if(!g) return;
    printf("Arestas: %i, Vertices %i\n",g->numArestas,g->numVertices);
    Pont atual;
    for(int i = 0; i<g->numVertices; i++){
        printf("%i",i);
        atual = g->lista[i];
        while(atual){
            printf("\t%i",atual->vertice);
            atual = atual->prox;
        }
        printf("\n");
    }
} //Complexidade O(V) + O(E) (Tende a ser O(V^2)), Diferente da matriz que é obrigatoriaemnte (N^2)

//Acho que esqueci uma função

bool liberarGrafo(Grafo* g){
    if(!g) return false;
    Pont atual, prox;
    for(int i = 0; i<g->numVertices; i++){
        atual = g->lista[i];
        while(atual){
            prox = atual->prox;
            free(atual);
            atual = prox;
        }
    }
    free(g->lista);
    g->numArestas = 0;
    g->numVertices = 0;
    g->lista = NULL;
    return true;
} //Aqui eu tenho que percorrer tudo, então eu guardo o proximo, apago o atual, e ando para o proximo
//V(O) + V(E)


//Devo inserir tanto em V1, tanto em V2, terá uma função auxiliar
bool insereAresta(Grafo* g, int v1, int v2){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numVertices || v2 >= g->numVertices) return false;
    if(insereArestaAux(g,v1,v2)){
        insereArestaAux(g,v2,v1);
        g->numArestas++;
    }
    return true;
}

bool insereArestaAux(Grafo* g, int v1, int v2){
    Pont atual = g->lista[v1];
    Pont ant = NULL;
    while(atual && atual->vertice < v2){
        ant = atual;
        atual = atual->prox;
    }
    if(atual && atual->vertice == v2) return false;
    Pont novo = (Pont) malloc(sizeof(Adjacencia));
    novo->vertice = v2;
    novo->prox = atual;
    if(ant) ant->prox = novo;
    else g->lista[v1] = novo;
    return true;
} 


//Remoção será semelhante

bool removeAresta(Grafo* g, int v1, int v2){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numVertices || v2 >= g->numVertices) return false;
    if(removeArestaAux(g,v1,v2)){
        removeArestaAux(g,v2,v1);
        g->numArestas--;
    }
    return true;
}
//Mesmo dilema, se mandar remover aresta que não existe, ele deve retornar true ou falso?
    //Depende

bool removeArestaAux(Grafo* g, int v1, int v2){
    Pont atual = g->lista[v1];
    Pont ant = NULL;
    while(atual && atual->vertice < v2){
        ant = atual;
        atual = atual->prox;
    }
    if(!atual || atual->vertice != v2) return false;
    if(ant) ant->prox = atual->prox;
    else g->lista[v1] = atual->prox;
    free(atual);
    return true;
}


bool arestaExiste(Grafo* g, int v1, int v2){
    if(!g || v1<0 || v2<0 || v1>=g->numVertices || v2 >= g->numVertices) return false;
    Pont atual = g->lista[v1];
    while(atual && atual->vertice < v2) atual = atual->prox;
    if(!atual || atual->vertice != v2) return false; //Falso se cheguei no final ou passei do valor
    return true;
} //Passo por tudo, se encontrar eu retorno


bool numeroVertices(Grafo* g){
    if(!g) return -1;
    return g->numVertices;
} //Mudou nada


//Se eu não tivesse o numero de arestas, eu teria que passar por todos os vértices e contar:
bool numeroArestas(Grafo* g){
    if(!g) return -1;
    int arestas = 0;
    Pont atual;
    for(int i = 0; i<g->numVertices; i++){
        atual = g->lista[i];
        while(atual){
            arestas++;
            atual = atual->prox;
        }
    }
    return arestas/2;
} //Mudou nada

 
//Caso o contario só printar o valor guardado como nas ulas anteriores


bool possuiVisinho(Grafo* g, int v){
    if(!g || v<0 || v>=g->numVertices) return false;
    return g->lista[v] != NULL;
} //passo e vejo se existe um valor na lista ligada, se tiver 1 significa que já tem um vizinho

int retornaGraudoVertice(Grafo* g, int v){
    if(!g || v<0 || v>=g->numVertices) return -1;
    int grau = 0;
    Pont atual = g->lista[v];
    while(atual){
        grau++;
        atual = atual->prox;
    }
    return grau;
} //Passo por todos os vizinhos e conto somando




//Agora Digrados, principalemnteo o que mundamos

//Insere aresta agora não precisa de auxiliar para facilitar, não há repetições


bool insereArestaDigrafo(Grafo* g, int v1, int v2){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numVertices || v2 >= g->numVertices) return false;
    if(insereArestaAux(g,v1,v2)){
        g->numArestas++;
    }
    return true;
} //Não precisa de auxiliar, era só copiar as linhas de código

bool removeAresta(Grafo* g, int v1, int v2){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numVertices || v2 >= g->numVertices) return false;
    if(removeArestaAux(g,v1,v2)){
        g->numArestas--;
    }
    return true;
} //Não precisa de auxilia também.

bool numeroAresta2(Grafo* g){
    if (g==NULL) return -1;
    int x, arestas = 0;
    Pont atual;
    for(x=0;x<g->numVertices;x++){
        atual = g->lista[x];
        while(atual){
            arestas++;
            atual = atual->prox;
        }
    }
    return arestas;
} //Não posso dividir por 2 no final, pois é direcional

//O grau do vertice eu preciso CORRER EM TODAS as listas ligadas, pois eu preciso saber quais chegam nela também
bool retornaGradoVertice(Grafo* g, int v){
    if(!g || v<0 || v>=g->numVertices) return -1;
    int grau = 0;
    Pont atual;
    for(int x = 0; x<g->numVertices;x++){
        atual = g->lista[x];
        while(atual){
            if(atual->vertice == v) grau++;
            atual = atual->prox;
        }
    }
    return grau;
} //Ta errado essa função, copilot que fez, falta somar o grau de saida



//-----Grafos ponderados (Direcionais e não direcionais)

//Estrutura:
typedef struct aux2
{
    int vertice;
    struct aux2* prox;
    int peso;

} Adjacencia, *Pont2;

typedef struct{
    int numVertices;
    int numArestas;
    Pont2* lista;

} GrafoP;


//Exibir Grafo e iniciliazar é a mesma coisa, invés de retornar um boleano, retorna o peso


bool insereArestaPonderada(GrafoP* g, int v1, int v2, int peso){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numVertices || v2 >= g->numVertices) return -1;
    if(insereArestaAuxPonderada(g,v1,v2,peso)){
        insereArestaAuxPonderada(g,v2,v1,peso);
        g->numArestas++;
        return peso;
    }
    return -1;
}
//Diferente da matriz, aqui eu não tenho problema de excluir usando a inserção (Usando o valor -1 por exemplo), pois em lista ligadas, não tem como excluir um nó.


bool insereArestaAuxPonderada(GrafoP* g, int v1, int v2, int peso){
    Pont2 atual = g->lista[v1];
    Pont2 ant = NULL;
    while(atual && atual->vertice < v2){
        ant = atual;
        atual = atual->prox;
    }
    if(atual && atual->vertice == v2) return false;
    Pont2 novo = (Pont2) malloc(sizeof(Adjacencia));
    novo->vertice = v2;
    novo->peso = peso;
    novo->prox = atual;
    if(ant) ant->prox = novo;
    else g->lista[v1] = novo;
    return true;
} //Aqui tem um problema que não posso somar duas vezes (Tem que editar, está errado)



bool removeArestaPonderada(GrafoP* g, int v1, int v2){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numVertices || v2 >= g->numVertices) return -1;
    if(removeArestaAuxPonderada(g,v1,v2)){
        removeArestaAuxPonderada(g,v2,v1);
        g->numArestas--;
        return 1;
    }
    return -1;
}

//Resto é a mesma coisa basicamente




//--Grafos Dirigidos


//Grau inserir e remover que mudam


bool insereArestaDigrafoPonderada(GrafoP* g, int v1, int v2, int peso){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numVertices || v2 >= g->numVertices) return -1;
    if(insereArestaAuxPonderada(g,v1,v2,peso)){
        g->numArestas++;
        return true;
    }
    return false;
} //Não precisa de auxiliar, era só copiar as linhas de código novamente

bool removeArestaDigrafoPonderada(GrafoP* g, int v1, int v2){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numVertices || v2 >= g->numVertices) return -1;
    if(removeArestaAuxPonderada(g,v1,v2)){
        g->numArestas--;
        return true;
    }
    return false;
} //Não precisa de auxilia também.



bool contarGraudoVertice(GrafoP* g, int v){
    if(!g || v<0 || v>=g->numVertices) return -1;
    int grau = 0;
    Pont2 atual;
    for(int x = 0; x<g->numVertices;x++){
        atual = g->lista[x];
        while(atual){
            if(atual->vertice == v) grau++;
            atual = atual->prox;
        }
    }
    return grau;
} //Ta errado essa função, copilot que fez, falta somar o grau de saida TAMBÉM



//Tabela de complexidade nos slides, variação é bem interessante
//Prox aula são funções mais compelxas