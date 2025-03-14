//Aula 3 AED

//Matrizes  de Adjacência
    //A primeira forma mencionada de representazar os grafos dentro da estruura de programação
    
//Isso vai ser parecido com AED I, vamos ver a estrutura e como aplica, mas não só aquels três (Buscar, Incluir, Excluir)

//Inicializar Grafo
//Imprimir Grafo
//Retornar Numero de Arestas/Vertices 
//Remover Adicionar Arestas/Vertices
//Verificar Vizinhos de Vertices e Grau
//Entre outros

//Isso existe para os Direcionados/Não Direcionados e Ponderdaos/Não Ponderadas


//Começando para os não ponderados  
    //É uma matriz com 0,1 onde 1 diz que existe relação
    //Então, como é uma matriz não direcionada, sua diagonal é espelhada
    
#include <stdio.h>
#include <stdlib.h>

#define true 1
#define false 0

typedef int bool;

//Estrutura em sí:
typedef struct
{
    int numVertices;
    int numArestas;
    bool** matriz;
} Grafo;

//Normalmente os grafos sempre tem o numVertices e o numArestas já pela estrutura, pois contar é muito lento, já que a quantidade de arestas é O(n^2) do numero de vértices por exemplo.
    //Uma matriz com 10 elementos pode ter até 100 posições

//Note que a matriz é ponteiro de ponteiro pois ela é uma matirz (Ou seja, um arranjo de arranjos).


//Inicializar
//Não é tão simples


bool inicializaGrafo(Grafo* g, int vertices){ //Note que já é dito a quantidade de vértices
    if(g==NULL || vertices < 1) return false //Impedir erros
    g->numVertices = vertices;
    g->numArestas = 0;
    int x,y;
    g->matriz = (bool**) malloc(sizeof(bool*)*vertices); //Zerando todas as vertices e arestas
    for (x=0; x<vertices; x++){
        g->matriz[x] = (bool*)malloc(sizeof(bool*)*vertices);
        for(y=0; y<vertices;y++){
            g->matriz[x][y] = false;
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
        if(g->matriz[x][y] == false)
            printf("\t    ");
        else printf("\t%5.2f", g->matriz[x][y]);
    }
}






// liberar Grafo, ordem inversa (primeiro dentro dos arranajos e depois o arrranjo em sí)

bool liberar(Grafo* g){
    if (!g) return false;
    int x;
    for(x=0; x<g->numVertices;x++)free(g->matriz[x]);
    free(g->matriz);
    //Mudo para 0 para evitar concorrência ou erros:
    g->numArestas = 0;
    g->numVertices = 0;
    g->matriz = NULL;
    return true;
}

//inserir aresta
//Essa operação é O(1)
bool insereAreasta(Grafo* g, int v1, int v2){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numArestas || v2 >= g->numVertices || v1 == v2) return false;
    //Tudo isso deve acontecer, pois se não, não faz sentido fazer uma adição
        //A ultima condição é porque os grafos não direcionais não tem auto-laço
    
    if(g->matriz[v1][v2] == false){
        g->matriz[v1][v2] = true;
        g->matriz[v2][v1] = true;
        g->numArestas++;

    }
    return true;
    //dependendo do objetivo, pode ser errado retornar TRUE se dois vértices já possuem aresta, mas isso vai depender do contexto
}


bool RemoveAreasta(Grafo* g, int v1, int v2){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numArestas || v2 >= g->numVertices || v1 == v2 || g->matriz[v1][v2] == false) return false;
    //Mesma conferência da inclusão, mas se eles já forem amigos, não dá para excluir e retorna false (Mas isso é escolha de projeto)

    g->matriz[v1][v2] = false;
    g->matriz[v2][v1] = false;
    g->numArestas--;

    return true;
}

bool arestaExiste(Grafo* g, int v1, int v2){
    if(!g || v1<0 || v2<0 || v1>=g->numVertices || v2 >= g->numVertices || !g->matriz[v1][v2]) return false; 
    return true;
} //Também tem a questão de tratar erro diferente de falso, mas também fica a critério do objetivo.


//Numero de arestas e de vertices é óbvio, só trazer o atributo

//Mas tem como contar, se preciso
int numeroAresta(Grafo* g){
    if (g==NULL) return -1;
    int x,y, arestas = 0;
    for(x=0;x<g->numVertices;x++)
        for(y=x+1;y<g->numVertices;y++) if(g->matriz[x][y]) arestas++;
        //o y=x+1 é para passar só por metade da matriz, já que ela é simétrica
        //Isso vai ser u ma PA de razão 1, ou seja (N² - N)/2 que é O(N²)
}

//Para o grau do vértice é a mesma coisa, contudo eu não paro e vou somando
bool retonarGrau(Grafo* g, int v){
    int n = 0;
    if(!g || v<0 || v>=g->numVertices) return false;
    for(int x = 0; x<g->numVertices;x++){
        if(g->matriz[v][x]) n++; //Travo a linha e olha um por um
    }
    return n
}

//Função que vê se vertice tem vizinhos é, além das condições básicas, um for para cada uma um dos possíveis vizinhos, e dou break (return) se acho alguém. (Não anotei, igual contar grau quase) 


bool temVizinho(Grafo* g, int v){
    if(!g || v<0 || v>=g->numVertices) return false;
    for(int x = 0; x<g->numVertices;x++){
        if(g->matriz[v][x]) return true; //Travo a linha e olha um por um
    }
    return false;
}


//Agora para gráfos dirigos, ponderados é na prox aula:
    //A matriz não é simética, e pode ter auto-laço
    //Focando só no que mudous

//Inserir/Remover e Retonar grau que mudam principalemnte


bool insereAreasta(Grafo* g, int v1, int v2){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numArestas || v2 >= g->numVertices || 
    //v1 == v2 Isso agora pode
    ) 
    return false;
    
    if(g->matriz[v1][v2] == false){
        g->matriz[v1][v2] = true;
        //g->matriz[v2][v1] = true; Agora isso não é simétrico
        g->numArestas++;

    }
    return true;
 }


bool RemoveAreasta(Grafo* g, int v1, int v2){
    if(!g || v1<0 || v2 < 0|| v1 >= g->numArestas || v2 >= g->numVertices || 
    //v1 == v2 || mesma coisa
    g->matriz[v1][v2] == false) return false;
 
    g->matriz[v1][v2] = false;
    //g->matriz[v2][v1] = false; mesma coisa
    g->numArestas--;

    return true;
}

//Numero de arestas agora percorre tudo
int numeroAresta(Grafo* g){
    if (g==NULL) return -1;
    int x,y, arestas = 0;
    for(x=0;x<g->numVertices;x++)
        for(y=0;y<g->numVertices;y++) if(g->matriz[x][y]) arestas++;
        //o y=x+1 agora não existe
}


//Retornar Grau (Não fiz para a outra pois era óbvio)
//Agora preciso saber quantas arestas chegam nele (Ou seja, usar a coluna)
bool retonarGrau(Grafo* g, int v){
    int n = 0;
    if(!g || v<0 || v>=g->numVertices) return -1;
    for(int x = 0; x<g->numVertices;x++){
        if(g->matriz[v][x]) n++;
        if(g->matriz[x][v]) n++; //Contando quantos chegam
        //Lembrando que auto-laço é dois mesmo, então ele já considera isso
    }
    return n;
}




//prox aula vai ser com grafos ponderados
    //Agora falso não necessariamente é 0, pois é um valor válido
    //Será criado uma constante arbitrária (Que eu tenho certeza que a aplicação não usa) para servir como falso.
        //Não da para tratar como NULL, já que é uma matriz do tipo ponteiro float. Precisaria de outra camada como ponteiro para colocar como NULL e consumiria o dobro de memória.