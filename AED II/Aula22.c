//Aual 22

//Hashing, endereçamento aberto

//Última forma de alocação de bloco de HD
    //Ainda terá outros conteúdos fora esse

//Mapeamemto é quando eu sou indexado para um bloco, mas não necessariamente caio nele.
    


//E se conseguimos saber o numero de rebgistros N previamente?
    //Diferento do que a gente fez com a lista ligada na aula anterior
    //Isso evita lista ligadas para colisões, economizando memória por elemento, que pode ser usado para aumentar ainda mais a quantidade de elemntos
    //Métodos que usam espaço vazio para fazer esse tratamento de colisão são chamados de endereçamento aberto


//Quando colidir nós calculamos uma localização alternativa
    //Se o calculo não for possível a tabela está cheia


    //Mas a inserção fica Teta(M), sendo M o tamanho da tabela

//Slides com, código de exemplo


//Problema da remoção
    //Supomndo uma função que é (k+i) % 10 sendo i a tentativa e k o valor colocado
    //Se tem 31, 42, eles vão para o índice 1 e 2, mas se eu colocar 11, ele vai dar erro no i = 0, e no i= 1, no final ele vai colocar no índice 3.
    //Mas caso eu removo o 42, isso vai dar problema, pois vai ser impossível achar o 11 depois.
    //Então ele só fala "Desconsidera", mas não apaga de fato (Assim como num HD por exemplo)


    //É possível haver um crazamento, ou seja, eu ter uma colisão com um elemnto que nem era para estar lá.
    //Isso juta muita gente e prejudica o funcionamento do código.

//Então o idel é fazer algum outro tipo de moviemnto não tão linear, tipo algum que vai do 1, 5, 8 etc... que impede esses bloco de "Encavalar" um após o outro
    //Ou seja, não é só distribuir de forma uniforme os valores, mas também os valores vazios, espalhar de maneiras diferente cada sondagem de cada tentativa
    //Bem difícil implenmtar, eu teria que ter várias funções que ainda juntas fossem uniformes, o que é bem difícil de fazer, ao mesmo tempo que o hash não pode ser tão complicado para não atrasar o tempo de todas operações

//Uma estratégia é não fazer funções lineares para evitar "Fusões de colisções"
    //A quadrática é diferente, pois ela não vai seguir um padrão prevísivel e sequencial. Ela deixa sempre cada tentativa mais distante da anterior, deixando espaço para colocar coisas mapeadas em um mesmo lugar.
        //Isso é mais eficiente, pois evita colisões.


    //Dá para melhorar ainda mais, fazendo um hashing duplo, ou seja, uma função de hashing dentro da outra que as tornem diferentes, pos mais que inicialmente cairiam no mesmo lugar

//No slide tem um exemplo de função de hash boa, ela tem que ter várias caracteristica, tipo distribuição uniforme e grandes pulos entre elemtos.
    //Mesmo assim ainda pode acontecer os agrupandos secundários (O que tinha sido dito acima é agrupamento primário), que é melhor que os primarios por padrão, contudo pode prejudicar.
        //Isso é quando 2 elemtnos terão a mesma sequencia de colisão caso a posição inicial seja a mesma.

//A quadrática também tem um problema pois o segundo elemento sempre irá bater, já que 1^2 é 1 também, então ele não faz diferença até a segunda tentativa

    //Hashing duplo é aplicar diferente funções encadeadas, que é o hashing duplo, onde a gente usa uma função hash diferente para cada tentativa. Ex; Em colisões pares usamos o último digito do CPF, e em segunda colisão usamos o primeiro digito do CPF. Isso já o tornaria muito mais eficiente.

    







