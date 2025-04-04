//Fila de prioridade mínima
    //Heap Mínimo
    //Cada nó terá valor menor ou igual que seus filhos
        //Faz sentido, pois quero excluiro o de menor de prioridade (Que vai ser a raiz)

//Necessária Redução de prioridade
    //Ser atendido mais rápido

//Inicialização
    //Mesma prioridade é O(n), e respeita a declaração do heap
    //Se for prioridade diferente, monta aleatoriamente
        //Precisa do constrói heap depois

        //Lembrando heap min  (Pode ser recursivo ou iterativo)
            //Aplico recursivamente o arrumar heap em cada nó sem ser folha, ele vai inverter o pai pelo menor filho
            //O(N)
            


//Excluir
    //Trocar o primeiro pelo último e chamar o arrumar heap
    //log(n)

//Incluir
    //Insere na primeira posição livre do arranjo, e precisa de um outro ajuste (Eu ajusto vendo se o pai está certo invés de ver o filho)
    //log(n)

//Dimuir elemento (A prioridade)
    //Parte mais importante da aula
    //Diminuo o valor e chamo o mesmo arrumar do inlcuir (Vou conferindo o pai)

//Retorno da menor prioridade
    //Óbivo, só olhar o primeiro

//Ver se está vazio/qtd
    //Ver o num de elemtos

//Tudo isso vai ser usado agora na aula

//Aula10

//Arvores geradoras de custo mínimo (MST)

    //A soma das areastas tem o menor valor para resolver meu problema
        //"Grafo Gerador" - subgrafo de G que possui todos os vértices de G, (Independete das arestas, só são conexas)
        //"Arvore" - Tipo, nós com um único pai ou sendo raiz. E aciclico
    
    //São para árvores com CUSTOS
        //Não é quantas arestas eu preciso, é a soma do custo que será diminuido
    //Normalmente são conexos, ponderados (o peso) e não direcionados
    //Pode haver várias árvores geradoras de custo mínimo em um único grafo

    //Algotirimo
        //Escolhe um um V aleatorio (V0)
        //Enquanto houver vértices não visitado guardo as todas as arestas que ligam o V a um vértice não visitado em uma fila de prioridade
        //Associo um vértice à essa aresta de entrada para ele, e conforme ele for visitado, vou substitutindo por arestas menores
            //Ao final tenho apenas as arestas que compoem o custo mínimo, e se somar o total de pesos, é o custo mínimo
        //No slide, não anotei o resto

    //prox aula algoritimo de kruskal (Mais fácil no gerla, mas tem um tem uma exceção específica que é mais complexa)
