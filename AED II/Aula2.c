//Bascaimente metade do semetres vai ser sobre grafos
    //Diferente de AED I, invés de se precupaar sobre alteração de dados na memória, o problema agora é utilizar diferentes abordadens para estruturas maisc complexas


//Teoria dos grafos
    //Origem anterior à computação
    //Vertices e Arestas
    //Ex Conexão em redes sociais

    //Digrafos: Pode haver direção nas arestas, dependendo do problema (Uma rua de mão única por exemplo). Normalmente representado por setas
        //Nesse caso as arestas são pares ordenados, mesmo que o vértice seja consigo mesmo (Auto laço). Representddo por (U,V)
            //Dificilmente o auto-laço é útil na vida real, mas em teorias é usado
    
    //Se não tiver direção é só um par sem ordem.
        //E pela teoria dos grafos, não existe auto-laço sem direção
    
    //Vertices vizinhas ou adjacentes são vértices que se conectam, note que em digrafos isso não necessariamente é simétrico

    //Grau de um vértice é o numero de arestas qe incidem nele. Caso for digrafo é a soma das que saem com as que chegam
        //Se tiver auto laço, automaticamente ele tem no mínimo 2, pois um já sai e um entra.
        //Pode haver grau de entrada e grau de saída para especificar na nomemclatura

    //Um caminho é uma sequencia de vértices, que há uma aresta do primeiro ao último (Se for direcionado, as arestas devem corresponder a direção do caminho)
        //Caminho pode usar auto-laços

    //Ciclo é uma sequencia que permite que você chega no primeiro 
        //Normalmente na representação fica implicto na descrição. Ex Ciclo de V0,V1,V2 já passa a ideia que V0,V1 V1,V2 V2,V0
        //Em digrafos dá para ter direção mútua, uma aresta de ida e uma de volta, isso é um ciclo se existir
    
    //Um grafo é conexo se todas as vertices forem ligadas por uma aresta em um todo
        //Existe o fortemente conexo, que é uma descrição masi especifica para digrafos que possuem caminhos de ida e de volta.
        //Fracamente conexo é se o digrafo, se fosse substituido por um grafo normal, produzisse um grafo conexo
        //Um desconexo pode ser visto como dois grafos diferentes (Mas óbvio que o contexto que vai definir se é ou não)

    //Um clique é bem específico. É um subjunto de vertices que todo mundo está ligado em todo mundo.
        //Todos são de tamanho 2 por padrão.
        //Um pentagono é um ciclo. Se eu desenhar um pentagrama dentro ele vira um clique.
        //Normalmente o contexto se refere ao maior
            //Usado principalmente para análises de agrupamento
            //Quase nunca usado em grafos dirigidos (Não há na teoria dos grafos)
                //Principalmente pois não dá pra saber se precisa de ida e volta ou só ida
    
    //Grafos podem ser ponderados, ou seja, podem ter valores atribuidos às arestas invés de ser apenas uma ligação boleana

    //Grafo transporto é a alteração feita em um grafo digrafo invertendo todas as direções

    //Sub Grafos é um pedaço do grafo, escolhendo vértices e arestas. Ele é Próprio se for diferente do original (Pois um grafo é subgrafo dele mesmo)

    //Coisas externas à teoria dos grafos:

    //Grafo bipartido é aquele que todas a areastas saem de um subconjunto e vão para outro (Nunca as areastas se conectam entre sí)
        //Se eu tiver um grafo com produtos e pessoas descrevendo um ambiente de compra, teremos grafos bipartido (Já que pessoas não compram pessoas e produtos não compram produtos)

    //Multigrafo são mútiplas arestas em uma mesmo par de vértices (Ex analisar simuntaneamente daus redes sociais diferentes)
        //Normalemnte só concanectam as arestas na prática, adicionando ambas as informações e voltando a ser apenas uma aresta

    // Misto é aquela que possui grafos direcionais e não direcionais
        //Dificilmente usada, nem tem representação padrão      


    //Representação em estruturas computacionais:
        //Deve-se mapear vertices e a relações entre eles
        //Ou seja, para cada nó irei guardar seus vizinhos
        //Representado por uma Matriz
            //Cada coluna e linha representarão os grafos. E os valores serão 0 e 1 que representando a existêncai da relação
            //A matriz será simétrica se for um grafo não direcionado
            //Se for ponderado será guardardado o peso das arestas invés de 0 e 1 (0 pode ser válido, então deve-se tomar cuidado). Normalmente se usa uma constante padrão pré estabelecida (Ou usa duas matrizes separadas) para não haver duplos sentidos.
        
        //Pode ser representado por uma arranjo de lista adjacentes
            //São um arranjo de n listas (para cada uma dos vértices) ligados contendo os vertices dos vizinhos (Sem colocar vértices que não são vizinhos)
            //Se for dirigido a lógica é a mesma, mas só não será simétrico
            //Se for ponderado é só guardar o peso na lista

        //Normalmente, a maioria das realações não são tão grandes quanto o máximo possível. Mas da maneira criada da matriz ocupa muito espaço que mutias vezes não precisa pois leva isso em consideração. Então vale a pena usar a lista para economizar memória. Contudo a matriz é mais eficiente em um contexto mais denso invés de espaço. Depende do contexto




