//Acesso à memoria secundaria

//continuando com arquivos
    //Aula anteriro foi mais pratica para estabelecer uma relação entre o C e a criação/leitura/escrita de arquivos
    //Essa aula é mais teorica, para mostrar a filosofia da esturua por arquivos


//Poruqe se preocupar com alocação de arquivos na meória secundária
    //Tudo que vimos fomos em meória principal nas aulas anteriores de AED, principalemnte em AED I, e de fato, se cabe na memoria principal a memória já vai ficar bem gerenciada com aqueles algortimos

    //Em grafos vimos estruturas que demonstram relação entre dados, e esse são mais sofisticados mas não se limitam apenas a isso. Mas na vida real não cabe tudo na memória principal, e por isso temos que usar a memória secundária, inclusive quando você desliga o computador, tudo que está na memória principal é perdido, e o que está na memória secundária não.

    //A informação báscca na RAM é de fato o Byte, e no disco é um Bloco, que é uma estrturua muito maior, e exatamente por essa diferente existem algortimos especificos para memória secundária, eu não posso simpelsmente aplicar os mesmos algortimos que eu apliquei na memória principal

    //Tipo de discos
        //HD (Diferente do Disco Flexivel)
        //CD-ROM
        //SSD
        //DVD
        //Pendrive etc...
        //Fitamagnética (A mais barata de tudo de byte por real), ela é lenta mas vale a pena para backup
    
    //RAM - Volátil (Apaga se acabar a energia)
    //HD - Não volátil (Não apaga se acabar a energia)


    //Ordem das memória é
        //Registrador (Unidade básica do PC)
        //Cache (Memória cache)
        //RAM (Memória principal)
        //HD (Memória secundária) (Muito mais lento relativamente com as outras, 1 milhão de vezes mais)

        //Esturura disco rígido
            //Ler e salva em baixo e em cima, cada um uma extensão do braço
            //Vários ptraos com discos magnéticos, e cada prato tem várias trilhas, e cada trilha tem vários setores, e cada setor tem vários bytes
            //Unidade básica de HD é setor (Não tem como eu falar quero tal byte, eu tenho que falar quero tal setor), ele sempre te dá um setor inteiro
            
            //Olhando um prato
            //Circunferencia de um prato é a trilha
            //Setor circular é chamado de "Setor Geometrico"
            //"Setor de trilha" é uma parte da tilha
            //Setor é o pedaço do setor da tilha

            //Lemrbando que a densidade de dados varia já que a borda do disco vai ter mais espaço do que o centro, então a densidade de dados é diferente, e por isso o HD não tem que fazer um ajuste de velocidade para ler distancia diferentes.

            //HD também é acesso aleatório (assim como a RAM), ele não tem acesso sequencial, que é MUITO LENTO, que seria passar byte por byte, assim como fita cassete.
            
            //Arquivos
                //Eles podem estar em uma mesma trilha, analogo à um aray, onde em sequência eu tenho os bytes, ou em setores diferentes, que é o que acontece na vida real, onde os arquivos estão espalhados pelo disco rígido, e não em sequencia.
                //Estar em trilha separada também pode ser útil

            //A avliação de um disco é feito usando um seek, meio que a "complexidade assintotica" dele, ai as análises irão independer da tecnologia usada

            //Mesmo que um programa peça um setor que esteja na mesma trilha, ele não vai considerar isso, vai sempre considerar o prior caso onde o braço tenha que andar novamente para cada seek (Pois tem muita coisa rodando e ele pode mudar)

            //A unidade básica de leitura para os programas é o setor lógico, que é um conjunto de setores (Normalmente 4 setores), normalmente o sistema operacional que define o minimo na prática.

            //O Sistema operacional também se responsabiliza em orgnaizar os arquivos espalhados pelas trilhas e colcoar na memória organizadamente
                //Inclusive os programas tem a ilusão que eles podem salvar em qualquer lugar do dicso, mas o OS também define isso. Os programas não sabem se o que eels tão pedindo estão na RAM ou no HD

            //Grande partes das minhas formas de armazenamento tem versões analogas em disco, Sequencial não ordenado, sequencial ordenado, lsitas ligadas etc..
                //Contudo vai ter outras adicionais como hashing, arvores B e indexado

                //Analisar complexidade assintorica também




            //??? talvez muita coisa nesse arquivo esteja errada, não peguei tudo

            //EP 2, com grafos também continuando o primeiro
                //Também pensando em redes sociais, mais agora com foco em centralidade
                //Entrega até 22/06


