//Correção de Erro

//Perdemo metade da aula para arrumar o pc do professor



//Paridade então é o numero de bits 1 que eu tenho, não o que eles representam

//Decobrir o numero K de bits eu consigo encontrar todas as posições
    //M+K <= 2^K-1
    //Esse é o K que eu quero encontrar (lembra que K é o bit de paridade e ele se inclui no dado)

    //Então se M for 4 por exemplo, k é no minimo 3, já que 4+3 <= 2^3-1, K = 2 daria errado
        //Tem que sempre o menor K possível


        //Para fazer a formula de conferencia eu faço o seguinte passo a passo
        //Pego a posição referente de cada M dado e escrevo como uma soma das posições do P partidades
        //Agora eu tenho que achar a representação de P pelo M

            //Isso exige uma compressão melhor do XOR, sempre que for XOR(A,A) dá zero, isso vale para tudo par
                //Se for impar, dá 1

        //Farei um XOR para todos os M que tem P na representação, de maneira que eles cancelam e sobra apenas um P
        //Desse modo eu tenho o bit de paridade igualado à um XOR

        //Isso tudo só pra deduzir a formula de paridade

    //Tem como interpreta palo bit que cada paridade está cobrindo, exemplo, o P1 cobre o 3, 5 7, que são todos que tem 1 no final (011 101 e 111) por exemplo
        //O p2 (101) por exemplo cobre todos com 1 no meio (011, 111, 101), ou seja, 3 6 e 7
        //E por isso as posições
    
    //Tem como vizualizar 4 pelo diagrama também

    //Se for dois erros muda as coisas
        //Calculo todos os bits de paridade
        //ELe vai trocar algo que estava certo nesse caso e vai trocar
        //Exemplo, em 4 bits de dados, se eu tiver 2 erros, ele vai cometer outro erro e vai ficar 3.
    
    //Para arrumar, ou seja, fazer ele corrigir mais de 1 tenho que fazer o bit de paridade global
    //  É um bit que olha todos os bit de DADOS, (ignora os de paridade) e faz outra paridade deles.
    //Então se for 3, ele fica 1 para termianr a paridade

    //Então se tiver um erro, a paridade global muda e inverte. Mas com dois erros ele continua igual.
        //Então antes de corrigir o bit ele olha a paridade global,se tem um erro e ela não mudou , significa que tem mais de um erro. (Mas isso sem identificar onde).
        //Se tem um erro, e a paridade global mudou, quer dizer que é só um mesmo.

        //Isso pode não funcionar se a quantidade de erros for enorme. (Mas dai é pedir demais).

//EP
    //TXT com vários, converter um arquivo de C para assembly
        //MARS para simulação
        //Quatro funções básicas
        //Literalmente ler caractere
        
        

//Dispositivos de Entrada e Saída
    //Falta isso, e memória externa
    //E processador
    //Interfaces Fìsicas

    //Ou seja, aparelhos que recebem e enviam e salvam dados e enviam para o computador

    //"Subsistema de Entrada e Saída"
    //Tem dispositivos de entrada ou saída, ou as vezes as duas simultaneamente
        //Cada um tem uma velocidade específica


    //Comunicação Serial ou Paralela
        //Serial - Bit a bit
        //Paralela - Vários bits ao mesmo tempo



    
