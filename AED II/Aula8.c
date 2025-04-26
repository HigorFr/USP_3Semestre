//Aula 8

//Outra busca sem ser em profundidade (DFS, Depth First Search) 
//Assunto que será usadao para fazer o EP numero 1


//Busca em largura (BFS, Breadth First Search).

//Busca em largura é uma técnica de busca em grafos que explora todos os vértices de um nível antes de passar para o próximo nível. É útil para encontrar o caminho mais curto em um grafo não ponderado.
//A busca em largura é implementada usando uma fila, onde os vértices são visitados em ordem de descoberta. A fila garante que os vértices sejam processados na ordem em que foram descobertos, permitindo que a busca explore todos os vizinhos de um vértice antes de passar para o próximo nível. Isso é diferente da busca em profundidade, que explora um caminho até o final antes de retroceder.
    //DO ponto de vista algoritimico, a busca é a mesma coisa, estou visitando um vértice de cada vez
    //Contudo ele é mais eficiente na prática

    //A fila será formado pelos vizinhos do nó atual, ou seja, os nós que estão diretamente conectados a ele. A fila é usada para armazenar os nós que ainda precisam ser visitados, garantindo que a busca explore todos os vizinhos antes de passar para o próximo nível.

    //Para um labirinto por exemplo, a busca em largura é útil para encontrar o caminho mais curto entre dois pontos, pois garante que todos os caminhos de um determinado comprimento sejam explorados antes de passar para caminhos mais longos. Isso significa que, quando a busca encontra o destino, ela já terá encontrado o caminho mais curto.

    //Essa busca irá gerar uma árvore de busca também, que irá significar o menor caminho do V0 até qualquer outro desejado. (Pode haver mais de um caminho mais curto, ele falará só um deles).

    //Supondo umna fila já estruturada (E lista de adjacências)
    void buscaEmLargura(Grafo* G, int inicial, bool* visitado){
        if(!g||inicial<0||inicial>=G->numVertices) return;
        int x, atual;
        Fila f; No* no;
        inicializaFila(&f);
        insereFila(&f, inicial); //Coloca o nó inicial na fila
        visitado[inicial] = true; //Marca o nó inicial como visitado
        while(!filaVazia(&f)){ //Enquanto a fila não estiver vazia
            atual = removeFila(&f); //Remove o nó da fila e armazena na variável atual
            printf("%d ", atual); //Imprime o nó atual
            no = G->adjacencias[atual]; //Pega a lista de adjacências do nó atual
            while(no != NULL){ //Enquanto houver nós adjacentes
                no = excluiFila(&f); //Pega o vértice do nó adjacente
                atual = no->valor;
                free(no);
                for(x=0;x<G->numVertices;x++ && g->matrizAdj[atual][x]){ //Para cada nó adjacente
                    if(!visitado[x]){ //Se o nó não foi visitado
                        visitado[x] = true; //Marca como visitado
                        insereFila(&f, x); //Insere na fila
                    }
                }
        }
    } //Acho que isso está errado, foi o copilot que fez

//Complexidade, no extremo, é O(V^2). Mas confirmar isso é complexo.

//EM matriz é diferente:
    void MatrizBuscaemLargura(Grafo* G, int inicial, bool* visitado){
        if(!g||inicial<0||inicial>=G->numVertices) return;
        int x, atual;
        Fila f; No* no;
        inicializaFila(&f);
        insereFila(&f, inicial); //Coloca o nó inicial na fila
     
        visitado[inicial] = true; //Marca o nó inicial como visitado
        while(!filaVazia(&f)){ //Enquanto a fila não estiver vazia
            atual = removeFila(&f); //Remove o nó da fila e armazena na variável atual
            for(x=0;x<G->numVertices;x++){ //Para cada nó adjacente
                if(g->matrizAdj[atual][x] && !visitado[x]){ //Se o nó é adjacente e não foi visitado
                    visitado[x] = true; //Marca como visitado
                    insereFila(&f, x); //Insere na fila
                }
            }
        }
    } //Feito pelo copilot, provavelmente está errado.

//Isso é O(V+E), a equação é complexa também, tem dois Whiles,

//Lemrando que o grafo não necessariamente possui caminhos, então precisaria de uma função pai que chama, para cada vértices ainda não visitado, a função de busca. (Ou fazer um for antes dentro da propria função)


//Aplicação:
    //Caminho mais curto
    //Encontrar componentes conexos
    //Verificar se o grafo é bipartido (ou seja, se pode ser colorido com duas cores de forma que arestas não conectem vértices da mesma cor)
    //Fluxo de redes (algoritmo de Ford-Fulkerson)

//Explorando o caminho mínimo
    //Labirinto
    //Incia função no inicio
    //Retorno tabela que representa uma árvore, como vizualizar em formato de caminho?
        //Para vizualizar em caminho é complexo, está no slide a explicação
        //O(V+E)

    //Isso é refinidado em busca A*, que é heurisitca, ou busca em largura com pesos, que é o Dijkstra.


//Fila de prioridade
//Não é uma Estrutura, é um comportamento (Pilha e Fila são também de certa forma)
//Estrutura de dados que permite acessar o elemento com maior prioridade em O(1) e inserir elementos em O(log n).
//Não é exatamente uma Fila, mas é uma lista ligada onde cada elemnto tem um valor associdado que define a prioridade da exclusão ou inclusão do elemnto
    //Então é como uma fila com ordem.
        //Continuo removendo o primieiro elemnto, mas não insiro ele no último, e sim em uma posição que condiz com o valor interno.
    //Isso será útil na busca em largura com arestas com pesos (Onde a distância menor será prioritária), mas é usado em mais coisas

    //Tem fila de prioridade mínima e máxima, mas a mínima é a mais comum, ou seja, o menor valor é o que tem prioridade.

//Implentação simples, com arranjo ordenado.
    //Arranjo (Com o registro e o campo da prioridaede)
    //tamanho
    //Numelementos
    
    //Ordem fica decrescente, para quando eu excluir o último (Que é o menor, mais prioritário) eu não precisar "Puxar" ninguém para trás
    
    //Incializar é
        //Estrutura Vazia O(1)
        //Inciailização Mesma prioridade O(n)
        //Inicialização Prioridade Difernete O(Nlogn) - Organizar

    //Operações
    //Para remover o prioritario, eu não removo de fato, apeans diminuo a quantidade de elemntos e o algoritimo vai ignorar naturalmente O(1)
    //Exclusão de eleemnto arbritrário, eu apago um e vou puxando os outros para trás, mas isso é O(n)
    //Inserção é O(n) também, preciso colocar no final e deslocar toodo mundo
    //Diminuir prioridade de um elemento é O(n), preciso achar o elemento e depois fazer o --
    //Retordo do elemento de menor prioridade é O(1), só pego o último elemento e retorno ele
    //Verificar se a fila está vazia é O(1), só verifico o tamanho



