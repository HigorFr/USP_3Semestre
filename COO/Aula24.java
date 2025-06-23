public class Aula24 {
    
    //Continuando coleção


    //SOrtedSet

    //É uma coleção que mantém os elementos ordenados
    //É uma interface que estende a interface Set, ou seja, é uma coleção que não permite elementos duplicados
        //Méotos
        //First()
        //Last()
        // HeadSet(E e) - Retorna uma visão da parte da coleção que contém os elementos menores que o elemento especificado
        // TailSet(E e) - Retorna uma visão da parte da coleção que contém os elementos maiores ou iguais ao elemento especificado


    //Lembre que cada coleção tem suas particularidades e suas necessidades, no caso so SortedSet é meio díficil aplicar pois o Map vai cumprir as funcionalidades dele

    //O map é uma coleção que armazena pares de chave-valor, onde cada chave é única e mapeada para um valor específico
        //Diferente o hash que é mapeado em uma função de hash que dá o índice
    
    //Isso é muito semelahnte à um dicionário, onde você tem uma chave e um valor associado a essa chave

    //Já o tree-map é uma implementação do Map que mantém os elementos ordenados de acordo com a ordem natural das chaves ou de um comparador fornecido
        //Ele é baseado em uma árvore binária de busca, o que permite operações de inserção, remoção e busca eficientes

    //Note que nos MAPS, diferente da coleção em sí, o valor guardado não significa nada para busca ou operçaões, somente o índice
        //Isso permite eu meio que adicionar atributos novos sem de fato ter que mudar a estrutura do objeto, apenas uso valor associado à chave, e meio que adiciono informações por lá.
        //Isso é útil para váriáveis aleatórias

        //Inclusive o próprio objeto pode ser a chave do MAP. Criando uma estrutura de Algo existente -> Informação complentar

        //Map também é íterável, ou seja, você pode usar o for each para iterar sobre os elementos do Map
            //Como ele ítera? Ele basicamente retorna uma Coleção de dados referentas aos índices (Que não repetem) 
}
        //Para pegar so dados de fato é map.get(chave) dentro da iteração


        