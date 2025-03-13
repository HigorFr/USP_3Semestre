//Como visto nos exercicio anterior, nem tudo pode ser representado por binário
    //O 0,1 fica se repetindo depois de determinadido dígito
    //Posso adicionar quantos digitos forem, mas nunca vai chegar em 0,1, só aproxima
    //Isso é um problema pois não há memoria infinita
    //Ou seja, nem numeros muito pequenos nem muito grandes podem ser representados

//Para resolver isso existe outra representação, que é a de ponto flutuante
    //Na matemtica usando notações como 2,3 * 10^31 ou 1,4 * 10^-31
    //Isso é notação cientifica, mas tem esse nome pois a posição da virgula que flutua
    //Isso vira 2,3E31 ou 1,4E-31 por exemplo
    //Cada parte tem um nome:
        //Inteira é a Caractéristica
        //Decimal é a mantissima
        //E a potência é o exepoente (Lembrando que é base 10)

    //Existe o (E0), que é os numeros na representação padrão

//Aplicando para binário:
    //Exemplo: 1,011b * 2^31 ou 1,011b * 2^-31
    //100b fica 1,00b * 2^2
    //101b fica 1,01b * 2^2
    
    //Mesma mecânica, a virgula anda conforme o expoente
    //Em binário é óbvio que a caractérisca é sempre 1b, ou seja, não preciso representa-la

    //O último bit normalmente representa o sinal, 0 para + e 1 para - (Convenção) 
    //Então 8 bits temos:
    // 1 bit para sinal
    // 1 para o sinal do expoente, 
    // 2 paraa para o exepoente 
    // 4 para a mantisssa

    //A mantissa é o detalhe do numero, por isso é 4 para ela
    //A caracteristica, como mencionado, não precisa ser guardada

    //Então 2,25 fica 1,001 * 2^1
    //Isso fica guaradado como 0 0 0 0 1 0 0 1 0
    //Sinal e expoente postiivo, então 0 0
    //Expoente 0 1, que é 1 do 2^1
    // 0 0 1 que é a mantissa
    //Lembrando que a mantissa é esquerda pra direita também

//Em arquitetura 32 bits / 64 bits isso aumenta muito
//Em 64 por exemplo:
//1 pra sinal
//1 pra sinal expoente
//11 pra expoente
//51 de mantissa (Lembrando que ela é o detalhe)

//Em um caso sem mantissa, só teria numeros inteiros potências de 2

//Na representação IEEE, os sinais de expoentes se invertem, 0 pra negativo e 1 pra positivo
    //Isso APENAS para o sinal do EXPOENTE, não para o numero em sí
    

//Motivo (Representação do 0) (Usando 8 bit de exemplo, mas aplica à todos)
    //Na convenção passada 1,0 * 2^0 e 0,0 * 2^0 são identicos (00000000)
    //Isso pode criar diversos problemas, por isso decidiram que 0 deve ser representado por 
    //0,0* 2^-0 para evitar conflito. Isso muda a represntação
        //Dessa forma 1 é 00000000
        //E 0 00010000
        //Isso fica estranho, pois 0 deveria ser 00000000, isso é intuitivo. Por isso a IEE fez essa modificação de inverter o sinal dessa forma pode ser:
        // 1 é 00010000
        //E 0 00000000


//Fazendo contas:
    //Trasnformações, assim como um ser humano somando 6,41 * 10^19 com 2,131 * 10^21 prefere fazer com base iguais, o computador usa o FCU (Sigla pode estar errado) para fazer conta

    //TAbela ASCII também é usada
    //Cada país fez uma notação apra acentos no inicio, depois virou o padrão unicode (UTF)
    //UTF-8, 16 e 32 são os mais comuns
    //Todos eles são compatíveis com a anterior (UTF 8 é compatível com ASCII por exemplo)
    //UTF é 2^(Num do UTF)