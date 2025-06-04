//Correção de erros


    //Voltando um pouco na memória

//Palvras (Quantos bits ele vai elr do endereço)

    //ALetória é sempre mais rápida que a direto


//Slides especificando cada um dos atributos da memória


//Desempenho
    //Memdido pelo tempo de clico (Clock), transferencia e acesso

//Tipos de memória
    //Ram
    //ROM
    //PROM
    //EPROM
    //EEPROM
    //Flash (mesma tecnologia do SSD)
    //Discos (Diferentes tipos)
    //Fita magnética

//Cada célula de memória recebe um sinal, um controle, e dependendo deles existe uma entrada ou saída.
    //Organização é em ARRAY (Matriz)


//Memória funcionamento
    //Memória é organizada recbeendo valores de linha e colunas, então uma matriz 2048 recebe 11 bits
    //Note que eu esperava 22 bits, já que é colunas e linhas, mas invés disso eu tenho um controle que me diz se é linhas ou coluna
        //Em um ciclo eu habilito e linha e em outro a coluna, para manter eles ativos eu uso um temporizador

    //Tudo funciona usando um temporizaodor, pois demora para colocar linha e coluna, então o acesso demora

    //isso reduz meus pinos pela metade (Só os de dados) no total, esse é o obijetivo do controle
        //Ou seja, se eu adicionar um pino isso vai quadruplicar o tamanho da RAM (Aumenta um bit de coluna e um de linha)

    //Vários pinos com significado distintos
        //22 no total (no total)

    //A DROM é diferente, normalemnte usada para coisas específicas, então economizar pinos não é tão importante
        //Ela é usada para armazenar o firmware e certas configurações


//Contudo a memória não é só isso, ela tem vários modúlos e cada módulo e uma matriz
    //Para acelerar o processamento eu sempre guardo tudo junto, só que partes diferentes, ou seja
    //Se eu tenho uma palavra de 8 bits, eu guardo 1 bit em cada módulo na mesma posição, mas partes difenretes. Na hora de ler eu formo tudo novamente, isso torna tudo mais rápido.


//Isso também depende da organização da memória, pode ser em grupos para aumentar ainda mais
    //É como se eu tivesse uma matriz de módulos
    //O final vai ser o total de grupos * módulo por grupos * o quanto cada módulo guarda
    //Exemplo no slide de 1 MB 8*4*512*512


//Correção de erros que acontecem
    //Hardware - Físico, caiu pó por exemplo, quando isso acontece pode travar em 0 ou 1, ou ficar oscilando. Grave
    //Software - Erro leve, particula ou radiação ou problema na fonte.

    //Como corrigir:
    //Quando salvo algo eu salvo também o mesmo dado tendo passado por uma função que retorna K-Bits.
    //Na hora que eu leio, eu comparo o dado lido com os K-Bits, se tiver erro ele vai corrigir com base na função.
        //K-bit tem que conseguir endereçar qualquer bit de M+K, então a memória total aumenta


    //Primeira maneira (Função de paridade)
    //Paridade 1 - soma igual a número par
    //Paridade 9 - soma igual a numero ímpar
        //Ele salva o bit de paridade a cada x bits, se for par ele salva 1, se for impar ele salva 0
        //Nesse caso, se um bit foi corrompido ele vai saber que o bit está errado na hora de conferir, mas não vai saber qual é o bit errado
        //Se tiver de tiver dois erros, eles se cancelam também e não avisa, logo é só possível identificar um numero impar de erros
    
    //Outra estratégia é a de Hamming
        //Ele usa mais bits de paridade, e cada bit de paridade é responsável por um conjunto de bits
        //Ele vai salvar os bits de paridade em posições que são potências de 2, e cada bit de paridade vai ser responsável por um conjunto de bits (Copilot que escreveu isso, não eu)
        //Mais complexo, exemplo no slide
        //Logo eu consigo achar o erro, pois está na intersecção dos bits de paridade que estão errados
        
        //Para corrigir erros únicos, eu preciso de log dos bits atuais, então 64 bits precisa d eapenas 7 bits de paridade
        //Na maneira de hamming para analisar precisa de um pouco mais, mas também segue um log.

        //OBS* No hamming ele etmabém vai ter um bit extra de paridade além dos K-bit para ver o total.
    

//Kabit fica sempre em uma potencia de 2 nas posições de 2, e os bits de dados ficam nas outras posições
    //Exemplo: 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096
    //Para saber onde colocar dados, foi proposta a formula:
    //C1 = D1 xor D2 xor D4 xor D5 xor D7
    //C2 = Slide.

    //Ele avisa qual é usando esse método, você diferencia usando a distância de hamming, que é a difenreça da bit de hamming e o dado lido (Cosniderando só os bits de paridade C)
        //Se um bit de paridade estiver corrompido ele também avisa, pois o bit de validade faz parte dele

    //Formula do tamanho total 2^k -1 >= M + K (Pois ele vai guardar a paridade também)

