//Dicas da prova
//Ver o que foi feito pelos slides, também usar o livro
//Livro do Stalin Teórico


//Agora naquele sistema eu irei adicionar um novos elemtos

//O cache miss não recebe só valores do PC (Process? Counter), que são dados de instrução apenas, mas também da ULA (Unidade lógica aritimetica) que são loads

//Então o cache miss não é só para instruções, mas também para dados

//Vemos na última aula que Write-throu é horrível, pois toda vez que eu escrevo algo, eu tenho que escrever na cache e na RAM, o que é muito lento

//Que tem também o write-buffer que é meio ruim pois ele ocupa barramento, e o processaodor fica só com o cache

//O write-back é mais interessante, pois eu só escrevo na cache, e quando a cache estiver cheia, eu     escrevo na RAM, ou seja, eu não preciso escrever toda hora, ele registra qunado a linha foi modificada


//Localidade Espacial
    //Nem sempre é palavras que eu movo, dá pra mover várias palavras de uma vez para tentar economizar tempo
    //Isso é chamado de, Bloco pode ser de vários tamanhos (cada um contendo várias palvras)
    //Mas isso também não pode se tão grande pois ai o barramento vai ficar congestionado
    //Então existe um valor ótimo para o tamanho do bloco, que é 4 palavras (16 bytes) normalmente

    //Então o cache não é mais só uma coluna de dado para cada tag, mas sim 4, e agora tenho um novo bit de cache para indicar qual palavra eu quero por um Multiplexador (MUX)
    //Normalmente um cache tem 64 blocos, que é o valor ótimo


    //Normalmente quando eu vou buscar na DRAM a primeira palvra é alto até ela achar o bloco, (Isso é a latência), e uma banda larga boa (barramento?) aceleram o processo (Evita miss penality) 

    //3 Tipos de organização de cache
        //A- Primeiro meus blocos são lidos um por em um em uma única memória, isso é ruim, pois em um bloco de 4 palavras eu vou demorar 60 clocks (Considerando 15 clocks por leitura) isso é 0.25 bytes transferidos por clock, que e ruim

        //B- Agora a banda larga é maior, eu consigo ler 2 palavras por clock ou seja eu consigo melhorar o ciclo. E agora o cache também consegue ler 2 palavras por clock usando o mutiplexidaor, isso quase dobra a velocidade comparando com o A

        //C- Agora invés de aumentar a banda larca eu divido a memória em 4 partes por exemplo, de modo que cada memória guarda informações complementares (A 1 guarad 37, a 2 guarad 38, etc.. ) isso facilita pois eu sempre vou ler 4 palvras por clock obrigatoriamente, e meu gargalo será somente o barramento.

        //Dá para melhorar ainda mais, com
            //Aumentar o cache, eu divido em várias caches, l1,l2 (até l3)
        

        //Calculos no slides


        //Separar sobreposição de cache em vários caches
            //Ou seja, toda vez ele vai pesquisar em 2 por exemplo, ele vai poder ter até duas colisões, isso sacrifica um pouco do processamento mas permite 
            //Inclusive posso fazer toda linha ser associativa, ou seja, o endereço vai ser o proprio valor e terei que passar por todas para desocbrir


            //Páginas é de memoria virtual, é bloco de memória guardado no HD
                //Outro cache, para saber se o que eu quero vai estar na memoria ou no HD, (para eu não ter que aguardar a RAM me responder)

            