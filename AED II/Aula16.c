//Aula 16

//Continuação arquivos

//Alocações em Disco


//Sequencial (Blocos um do lado do outro, contínuos fisicamente)
    //Ordenado e não ordenado
    //Análise de SEEKS para o disco assintoticamente
    
    //Beneficio
        //Leitura rápida
        //Acesso aleatório útil em determinadas buscas (Tipo busca binaria em um arquivo ordenado)
        //Expansão complicada, eu precsio de um epaço continuo para salvar tudo (Mesmo se o disco tiver espaço, pode não caber pois não é tudo junto), ou seja, ele fica com espaços fragmentados
            //Desgrafmentar é o que resolve isso, mas é muito lento, e ninguam hoje em dia faz mais isso

    //Organização dos registros
        //Desordendos - Heap
        //Ordenados - 
        

//Primeira alocação - Não ordenado

//Inserção
    //Olha se tem espaço no final do arquivo e coloca se tiver O(1)
        //Caso não tenha, ele vai vendo os blocos um por 1, até achar, ai é O(b) (B é blocos)

//Busca
    //Lembrando que consdiera que cada bloco só carrega um registro, mas normalmente é mais
        //É O(b) para achar o bloco, quando achar ele apaga

//Remoção
    //Precisa de uma busca, e ainda por cima precisaria puxar tudo na frente dele para trás para ocupar o espaço
        //Isso seria extremamente caro, então o que é feito normalmente é marcar o bloco como vazio, e quando for inserir ele vai ser considerado espaço vazio, e então é substituido
    //Se tiver espaço vazio 

//Leitura
    //Ordenar em disco é carissimo, normalmente tem coisas melhores a se fazer que veremos depois, quando cabe na memória é sempre melhor, que ai é O(B) (O melhor)
    //O pior caso nem será calculador aqui

//Minimo e Máximo
    //Dá para guardar no cabeçalho (O(1))
    //É possível que a maior chave e menor chave não estejam ,ai é O(b)

//Modificar
    //Se ele já está em memoria é simples (O(1))
    //O(b)


//Arquivo ordenado
    //Arquivo é ordenado por Chave, um valor do arquivo que é ordenável
    //OU seja, com um unico seek eu consigo achar tudo que eu quero no bloc O(1)
    //Minimo e máximo também é O(1) no cabeçalho, se não tiver é só olhar o inicio e o fim
    //Busca
        //Dentro do bloco eu consigo fazer uma busca binaria, e o tempo de busca é O(log b)

    //??
    //Inserção
        //Busca binaria agora para acahr onde eu preciso inserir, mas eu tenhl que inseriro ordenado.
            //Isso significa que eu tenho que mover os registros para frente para abrir espaço, e isso é  O(b) (Muito lento), principal gargalo dessa abordagem é esse
            

    //Inserção
        //Muito caro, O(b)

    //Exclusão
        //Demorava pra achar, mas agora isso está mais rápido
        //Lembrando que eu não apago, eu só marco como vazio
        //Busca binaria  O(log b) - vire e mexe tem que organizar o disco para não ficar com muito buraco

    
    //Modificação
        //Modificar um campo é de boa, só acahr O(log b), contudo se mudar o tamanho do registro, pode ser que eu tenha que mover tudo para frente assim como na inserção, e ai fica lento.

    //Tabela comparativa Ordenado x Desordenado no Slide:
    //Desordenado ---- Ordenado
        //Inserção - O(1)* - O(b)
        //Busca - O(b) - O(log b)
        //Remoção - O(b) - O(log b)
        //Leitura - (função de ordenação w(b)) - O(1)*
        //Minimo e Máximo - O(1)* - O(1)
        //Modificação - O(b)* - O(log b)*

        //Pode estar errado, copilot que fez
