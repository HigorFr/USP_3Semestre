//Continuando matrizes de adjacência
//Agora com Ponderados

//Lembrando que tanto para matrizes de ajacência, tanto para listas, existem 4 possíveis variações
//Ponderadas ou não, e Direcionados ou não

//Maioria das coisas são parecidas
//Será basciamente a aula passada com algumas diferenças reforçadas, contudo a informação guardada será um número

//Lembrando que existe o problema de definir o que é o "Não existe", pois o 0 pode ser válido
// -1 foi a constante escolhida aqui
int varinvalida = -1;

//Agora finalizei todas as funções (Preciso colocar no Aula3 depois) 

//Inicializar Grafo
//Imprimir Grafo
//Retornar Numero de Arestas/Vertices 
//Remover Adicionar Arestas/Vertices
//Verificar Vizinhos de Vertices e Grau
//Entre outros
    

//Observação, o malloc e o free são da mesma biblioteca, então sempre que você dá um malloc, é registrado quanto pesa aquele dado, para quando você dar free ele saber

#include <stdio.h>
#include <stdlib.h>

#define true 1
#define false 0

typedef int bool;
typedef float Peso; //agora é float/double


//Estrutura em sí:

typedef struct
{
    int numVertices;
    int numArestas;
    Peso** matriz;
} Grafo;

bool inicializaGrafo(Grafo* g, int vertices){ //Note que já é dito a quantidade de vértices
    if(g==NULL || vertices < 1) return false 
    g->numVertices = vertices;
    g->numArestas = 0;
    int x,y;
    g->matriz = (Peso**) malloc(sizeof(Peso*)*vertices); 
    for (x=0; x<vertices; x++){
        g->matriz[x] = (Peso*)malloc(sizeof(Peso*)*vertices);
        for(y=0; y<vertices;y++){
            g->matriz[x][y] = varinvalida;
        }    
    }
}

//Exibir
void exibirGrafo(Grafo *g){
    if (!g) return;
    int x,y;
    print("Arestas: %i, Vertices %i",g->numArestas,g->numVertices);
    for (x=0; x<g->numVertices; x++) print(" %i",x);
    print("\n");
    for (x=0; x<g->numVertices; x++) { 
        print("%i",x);
        for(x=0; x<g->numVertices; x++) print("\t%5i %i",g->matriz[x]);
        if(g->matriz[x][y] == varinvalida)
            printf("\t    ");
        else printf("\t%5.2f", g->matriz[x][y]);
    }

}



bool liberar(Grafo* g){
    if (!g) return false;
    int x;
    for(x=0; x<g->numVertices;x++)free(g->matriz[x]);
    free(g->matriz);
    g->numArestas = 0;
    g->numVertices = 0;
    g->matriz = NULL;
    return true;
}

//Aqui muda
bool insereAreasta(Grafo* g, int v1, int v2, Peso peso){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numArestas || v2 >= g->numVertices || v1 == v2) return false;
    
    if(g->matriz[v1][v2] == varinvalida){
        //Outro IF, para encapsular uma exclusão que dá para fazer pela insereAresta
        if(peso != varinvalida){
            g->matriz[v1][v2] = peso;
            g->matriz[v2][v1] = peso;
            g->numArestas++;
        }

    }
    else{
        //Sobreposição de valor por outro
        g->matriz[v1][v2] = peso;
        g->matriz[v2][v1] = peso;
        if (peso == varinvalida) g->numArestas--; //caso ele queira excluir pela função inclusão

    }


    return true;
}


bool RemoveAreasta(Grafo* g, int v1, int v2){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numArestas || v2 >= g->numVertices || v1 == v2 || g->matriz[v1][v2] == varinvalida) return false;
    //Nesse caso se não existe, ele não faz nada, mas isso varia
    g->matriz[v1][v2] = varinvalida;
    g->matriz[v2][v1] = varinvalida;
    g->numArestas--;

    return true;
}

bool arestaExiste(Grafo* g, int v1, int v2){
    if(!g || v1<0 || v2<0 || v1>=g->numVertices || v2 >= g->numVertices || g->matriz[v1][v2] == varinvalida) return false; 
    return true;
} 


//Caso eu não guardasse
int numeroAresta(Grafo* g){
    if (g==NULL) return -1;
    int x,y, arestas = 0;
    for(x=0;x<g->numVertices;x++)
        for(y=x+1;y<g->numVertices;y++) if(g->matriz[x][y] != varinvalida) arestas++;
    return arestas;
}

int retonarGrau(Grafo* g, int v){
    int n = 0;
    if(!g || v<0 || v>=g->numVertices) return false;
    for(int x = 0; x<g->numVertices;x++){
        if(g->matriz[v][x] != varinvalida) n++; 
    }
    return n;
}

bool temVizinho(Grafo* g, int v){
    if(!g || v<0 || v>=g->numVertices) return false;
    for(int x = 0; x<g->numVertices;x++){
        if(g->matriz[v][x] != varinvalida) return true;
    }
    return false;
}



//------------------------
//Para Direcionais
//Quase nada muda


bool insereAreasta(Grafo* g, int v1, int v2, Peso peso){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numArestas || v2 >= g->numVertices) return false;
    
    if(g->matriz[v1][v2] == varinvalida){
        //Outro IF, para encapsular uma exclusão que dá para fazer pela insereAresta
        if(peso != varinvalida){
            g->matriz[v1][v2] = peso;
            g->numArestas++;
        }

    }
    else{
        //Sobreposição de valor por outro

        if (peso == varinvalida) g->numArestas--; //caso ele queira excluir pela função inclusão

    }


    return true;
}


bool RemoveAreasta(Grafo* g, int v1, int v2){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numArestas || v2 >= g->numVertices || g->matriz[v1][v2] == varinvalida) return false;
    g->matriz[v1][v2] = varinvalida;
    g->numArestas--;
    return true;
}


int numeroAresta(Grafo* g){
    if (g==NULL) return -1;
    int x,y, arestas = 0;
    for(x=0;x<g->numVertices;x++)
        for(y=0;y<g->numVertices;y++) if(g->matriz[x][y] != varinvalida) arestas++;
    return arestas;
}


int retonarGrau(Grafo* g, int v){
    int n = 0;
    if(!g || v<0 || v>=g->numVertices) return false;
    for(int x = 0; x<g->numVertices;x++){
        if(g->matriz[v][x] != varinvalida) n++; 
        if(g->matriz[x][v] != varinvalida) n++;
    }
    return n;
}


