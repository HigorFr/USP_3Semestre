//Continuação Árvores B
    
//Lembrando 
    //Minimo é para garantir o balancemaneto e Máximo é eficiencia da busca sequencial
    //T-1 elementos é o mínimo, e 2T-1 é o máximo
    //Ordem T é grau minimo (ele por sí só não representa nada, é só uma constante que define os coisas)

    //Vou passando dividindo o que está cheio antes de inserir.
    //Se a folha está cheia divido e promovo à mediana para pai
    //Note que 2T-1 é sempre ímpar, logo há mediana fixa
        //E o nó pai sempre terá espaço, pois se não eu já teria quebrado ele

    
    //E se a raiz estar cheia?
        //Ela vai aumentar de altura, vou dividir ela normal e vou promover a mediana
        //Nesse caso é uma nova raiz, e o nó pai vai ser a mediana
        //Ela é a excessão, ela pode ter menos que o mínimo de elementos, pois é a raiz


//Código inserção
    //recursivo, mas preciso de uma função que engloba ela para tratar o caso da raiz estar cheia 
        //Dai tem que criar um pai vazio e ai sim posso chamar e recursção
    //Se for nó folha, é só inserir organizadamente, então eu abro espaço (Empurrando cada um) e coloco o valor

    //Se eu lotar o nó folha de maneira que o pai fica lotado em seguida, eu não vou voltar.
        //Mas isso pode deixar o pai desorganizado se eu colocar de qualquer jeito.

    //Código no Slide - Bascaimente O(logt(B))
    //Tenho um caso base que é se o nó for folha, e nesse caso eu insiro o valor de maneira ordenada e o caso recursivo, no fim eu vou simplesmente rodar a altura da arvore + o caso base.

//Remoção 
    //Necessita função auxiliar
    //Muito complexo - Vários casos possíveis
    //Fusão de nós se necessário
    //Caso base é se for no folha com quantidade maior que o mínimo (T-1) de elementos, dessa forma só remover e ele fica maior ou igual à T-1

    //Se for nó não folha, se algum deles tiver nó sobrando eu pego um valor deles. O maior a esquerda ou o menor a direita (Depende qual tem item sobrando) e subsitituo o pai por esse valor excluindo o valor que peguei do filho
        //Isso é recursivo até chegar em uma folha (Sempre vai ser uma folha o maior a esquerda ou o menor a direita)

    //No caso que os filhos não tem nada sobrando eu vou ter que fundir os dois filhos (Isso é garantido)
        //Nisso esse filho pode ser jogado para os elemntos que sobraram do pai, e não haverá excesso

    
    //Tem o caso em que eu vou remover um nó com filhos que depois de removido vai ficar com menos que a quantidade minima de elementos (T-1)
        //Nesse caso eu vou ter que fundir com o irmão, e pegar o valor do pai para colocar no meio
        //Resto não peguei legal não

    //Complexidade - No fim, de todas até agora a B é a melhor, em geral tudo exceto busca sequencial (O(b) vai ser log(b)
        //Inclusive é quase a usada na vida real.
        //A usada é a B+ (Também tem B*), que tem algumas modificações


    //Proxima é Hashing que é útil para coisas não ordenadas.
        //Tudo constante usando artifícios específicos.
        //Normalmente banco de dados combinam as duas
        

    

    




    





