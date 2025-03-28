//Ordenação Tológica
    //Ou seja, criar uma ordem de vertices, onde as arestas são as dependecias
    //Dá para enxergar isso na grade horaria da faculdade, onde as arestas são as dependecias, e os vertices as matérias

    //Características
    //Direcionado, pois não pode haver interdependcia
    //Tem que ser aciclico, pois se houver um ciclo, não tem como definir a ordem (DAGs)

    //Todo DAG, possui uma ordenação topológica, ela sempre existe


    //Existem diferentes formas de realizar uma ordenação
        //Dá para ver os com grau de entrada igual a zero e remover cada um deles, repetindo o processo até não sobrar nada
            //Isso seria N², pois é trabalhasoso conferir os graus de entrada e depois ainda recorrer o programa
        //Dá paara aplicar propriedades de busca em profundidade nisso
            //Crio uma lista, do final para o começo, utilizando as cores: os primeiros a ficarem pretos eu jogo para o final da lista, desse modo eu posso começar de qualquer vértice
            //E a ordem de saída será a ordem topológica
                //Isso é O(V+E), ou seja, linear, e é o mais utilizado na prática
                //Ele não usa tudo que a busca em profundidade tem, tipo nó anterior, tempo descoberta ect...
                //Ele só usa a cor e o tempo de término, e a lista de saída (Com a ordem dos pretos)
                //Como é inserido conforme é terminado, a ordem de saída já é a mesma da ordenação topológica  
            
        //Se eu cirar uma lista, e marcar setas de dependencai, todas vão da esquerda para direita
        //Se tiver aresta de retorno, ou seja, tem ciclo, o código não encontraria uma ordem adequada


//Econtrar componentes conexos em grafos não direcionados
    //contagem de quantos subgrafos existem, ou seja, componentes
        //Ser apenas componente é ser qualquer partice do grafo, ou seja, não é maximal
        //Ser conexo é existir um caminho entre todos os vértices, ou seja, não é desconexo
        
        //Ser componente conexo é ser subgrafo maximal
        //Maximal é signinifica que não é subgrafo de outro grafo, ou seja, ele é o todo daquela parte
            
        //sldies??? não entendi direto

        //Para grafos fortemente conexos, em direcionados
            //Caminho de ida e volta entre todos os vértices    
            //O fracmente conexo é que todos tem algum tipo de ligação
            //Tanto na vida real, tanto para um computador, é difícil afirmar se ele é fortemente conexo ou não
                //Isso é o problema mais díficil de resolver do semestre
                //Terá que comçar por um vértice especóifico invpes de ser aleatório
        

//Grafo transposto
    //Ou seja, o grafo transposto é o grafo original, mas com as arestas invertidas
    //Componentes fortemesnte conexos continuam os mesmos no transposto


//Voltando à encontrar fortemente conexos em grafos direcionados
    //Slide, muito complexo
    //Tempo de término, faz busca de profundidade, utiliza os vértices pretos para ordenar (OU seja, a lista daqueles que já processados)
        //Essa ordem em sí, é ruim, mas se eu transpor o grafo, e aplicar a busca novamente, ele será a fonte dos outros vértices
            //Ao final cada árvore de busca obitida no transposto de G, será uma componente fortemente conexa
            



            
            
        

