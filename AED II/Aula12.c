//Última aula de caminhos de custo mínimo e último assunto da prova
//Dijkstra

//Principios semelhantes
//Para cada vértice aresta ele confere se existe um atalho (Operação de relaxamento)
//Só que de um ponto de origem aos demais vértices (Inicialmente foi planejado só para 1 destino)

//Complexidade O(E+V * log(v)), menor complexidade conehcida para  problema (menor que os anteriores)
    //Não foi originalmente essa, inicialmente era v²
    //Usa abordagem guolosa e programação dinâmica

//Vai somando o caminho até o vértice atual relação à origem (do parametro) somado até cada um dos vizinhos
    //Todo vizinho começa com infnito, então qualquer primeiro caminho vai ser melhor
    //Se a soma do atual até o vizinho for menor que o que já existe, eu substituo o valor do vizinho
    //Continuo, comparando apenas os vizinho ainda não processados
        //Tem gomo garantir matematicamente que os caminhos processsados já são os menores, por isso o algoritmo é guloso e funcion
    //Esse é o dijkstra padrão



 //Corretude com LOOP INVARIANTE
        //Provando por absurdo o d[u] sempre sera a distancia minima para todo u pertencente a S, tanto antes, durante e depois.
        //Ex no segundo  vértice, ele obrigatoriamente é o menor caminho, pois ou o outro caminho seria menor (Violando a hipotese, pois eu já deveria ter escolhido o menor), ou teria caminho com valores negativos (Que também viola).
            //isso fica generalizado para todos os vértices.



//Adaptou-se alguma estruturas auxiliares para melhorar a complexidade
    //Heap de fibonacci.        
        //Truque no heap de prioridade
        //Quando um filho diminui a prioridade e fica menor que o pai, você invés de trocar o valor, você remove a aresta com o pai e cria dois heaps.
        //A cada divisão de aresta, ele testa se dá para juntar os dois heaps para não ter muitoes heaps
            //Se tiver muitos heaps a operação de remover elemento vai ficando pior, então é um equilibrío
        //Também tem a "complexidade armorizada", que é na média, o tempo de execução é O(1).
            //Não é o pior caso

        //Isso em conjuto faz o código ficar o mais eficiente possível
