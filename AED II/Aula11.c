//Busca em largura, dessa vez com um algoritimo que processa pesos

//Diferente das árvores também, ele não tem relação com conectar todos os vértices ou passar curtamente por todos eles
//Soma dos custos


//Arvores de Caminho de Peso Mínimo
    //Nomenclatura (Cuidado com "árvores de Caminhos Mínimos" pois pode confundir com busca em largura)
    //Floyd Warshal - Acha peso minimo entre todos os pares de vértices
        //Sem origem, ele calcula para todos
    //Bellman-Form
        //Apenas uma origem para todos os destinos
    //Dijkstra 
        //Mesmo do anterior

//FLoyd, lógica mais simples
    //Dificilmente usado na pratica (EM um mapa por exemplo issi não é usado)
    //Grafos ponderados, direcionados
    //Arestas podem ter peso negativo, mas não pode haver ciclos negativos (Ou a resposta seria menso infinito)
    //O(V³) Pelo que ele faz, isso é o esperado
        //Pensa-se que seria V^V, mas não
        //Utilizado em programação Dinâmica isso fica melhor
        //Ou seja, utiliza resultados de processos anterior para agilizar novas iterações

    //Duas matrizes, uma que indica o caminho menor entre dois pontos e outro de predecessores e outro normal com as distâncias
        //Nessa que indica o caminho, suponho a linha como origem e coluna (destino) qual aresta irei usar para conectar ambos, ou seja, marco o atalho
        //Por padrão, se já existe a aresta, será o proprio valor dela (Ainda sem substituição de atalhos)

    //Eu faço uma for conferindo todos os pares de caminhos, se a soma de dois caminhos derem menor que uma distância direta eu substituo na matriz de caminho, pois isso é um atalho. Se não eu deixo
        //Se o caminho não existe, eu coloco como infinito (Ou um numero muito grande), então qualquer novo caminho que conecte os dois será o melhor
            //Pode ser que o caminho não exista mesmo, então fica apenas o infinito, e na tabela de caminho fica sempre -1, que já era o esperado
        //Então ele vai peenchendo a matriz e no final todos as somas de menores distâncais estarão nas matrizes de distãncias, onde linha é origem e coluna é destino

    //Transformar isso em caminho de fato em árvore
        //Escolha a origem, seleciona a linha referente na tabela de caminho entre pontos
        //Cada elemento vai ser um vértice, e o peso será o peso da aresta
        //se for um destino especifico é só escolher a colina e ir puxando o que eu preciso (De trás para frente)

        //Os outros que não só desse tipo só retornam uma linha, já que eles especificam qual destino e qual origem (mas são mais rápidos)
            //Mas rodar varias vezes os outros é mais lento que isso (Por isso esse é útil)
        
    //Belman-Ford
        //Pareceido, funciona por relaxamento
        //De uma unica origem para todos os destinos, diferente do anterior
        //O(V*E);EM aplicação real aresta é igual vértices (Uma esquina tem 4 vizinhos, ou seja, 4 ruas novas)
    
        //Aqui o relaxamento é por aresta, perguntando apeanas a ultima aresta comoa talho
            //Então toda vez que chego no final do caminho eu confiro se a diferença entre o proxima e o ultimo é menor, se for, eu substituo

        //Ao final teremos uma linha da Floyd como resultado, montar a árvore é a mesma coisa
        //Parametro Origem, na formula
        //Apenas conexos, disconexos vai ter caminhos infinitos (Pois não haverá caminhos para substituir)
        
        //Mesma limitações da anteriro
            //Detectar ciclos negativos é díficil, mas tem versões que tem.
            //Também tem um agortimo para identificar se é ciclo infinito ou não, pela mesma lógica de achar caminho
                //Adiciona um laço interno, 5 linhas a mais, roda outra iteração, de diminuir novamente, é obviamente ciclo negativo (Pois deveria já ter otimizado no maximo)

                //Códigos no slide
            
        //Complexidade O(V*E) confome mencionado
    
    //Prox a aula é a outra

        
        