#Aqui não é exatamente aula 6 (seria a 7), porquê ele meio que passou duas aulas na aula 5
#Codificadores e decodificadores

#Código
#Qualquer informação ou mensagem com dadas caracteristicas
    #Tradução para outra mensagem
    #BCD 8421, é um chip que transforma de binários para decimal
    #Ou seja, ele pega 4 bits e transforma em decimal

    #Também existe código 7421, que é uma notação, tradução diferente
    #Ou 8421-1 que é a tradução normal, mas com 1 a menos
    #Dependendo do circuito eles são usados para serem mais eficientes
        #Dependendo do circuito não faz seentido usar o 8421 (que é o padrão)

#Código Gray
    #Mede variação de dois estados
    #Motor de passos
    #ele irá copiar o primeiro valor (do algorismo), e para cada um dos seguintes ele irá comparar com o anterior, se tiver alteração ele fica 1, se não fica 0
    #Ex, se ele tradzir 01110, fica 01001
        #Para traduzir de volta, é só copiar o primeiro, se o digito seguinte for 0, vc repete o anterior, se for 1, vc inverte o anterior

#Em sistemas digitais, codificador sempre tem como saida um binário, e os decoficicadores tem sempre a entrada em binário


#Montando o cidificador pro Codificador Gray
    #Entradas e sáidas com N valores, para cada digito
    #Fazer a tabela verdade
    #Fazer mapa de Karnaugh

#S1 fica = A
#S2 fica = A'B + AB' (Isso é um XOR)
#S3 fica = A'B'C + AB'C' + A'BC + AB'C + A'BC' + ABC (Isso é um A XOR B XOR C)
#S4 fica = A'B'C'D + AB'C'D' + A'BC'D + AB'C'D + A'BC'D' + ABC'D + A'BCD + ABCD (Isso é um A XOR B XOR C XOR D)
#Assim por diante


#Circuito Sequencial
#LATCH NOR

#Flip-Flop básico
#terá uma memória do que tinha no passado
#Set e Reset (posso deinir eles com 0, 1) Mas nesse caso se colcoar 1 ele será inválido pois as saídas seráo iguais
    #Set traz um valor esperado
    #O reset inverte o valor esperado

    #Nesse exemplo ele varia, dependendo do transistor que polarizar primeiro

#Instabilidade
    #Ruído faria que isso alterado o valor esperado (pois algo não apertado, um pulso pela rede faria ele acionar)
    #Capacitor que segura esses rúidos

#Latch NAND
    #Funciona normalmente, como NOR (Circuito é o mesmo na prática)
    #Portas invés de NOR ficar NAND
        #A diferença é que você inverte as entradas SET e RESET
        #E a invalidez (Ou seja, se eu colcoar 0,0) dá ambos 1, invés de 0 

#Uma das saídas do flipflip é sempre escolhida para ser barrada, porquê não nos importamos com ela, na teria a saída barrada é sempre o inverso da saída normal

#Diagrama de Tempo
    #Como aqui é sequencial, o valor de saída depende do valor de entrada e do tempo, eles variam
    #Marca todas as transições de entradas/saídas para cada instante
    #Exio 1 é 0 ou 1 (para cada uma das entradas e saídas), e o eixo 2 é o tempo (t)


    #Isso é útil no flip-flop, pois eu dependo da sáida anterior
    #0 - 0 mantém
    #1 - 0 q é 1
    #0 - 1 q é 0
    #1 - 1 é invalido (não pode ser 1,1), mas daria 1 no AND e 0 no OU




#Flip-Flop RS
    #Nova entrada, o E (Sinal de Clock)
    #Ele é um controle de habilitação, ou seja, ele só vai funcionar quando o E for 1
    #Ou seja, ele só deixa alterar quando o E for 1, e quando o E for 0 ele mantém o valor anterior
        #É como se fosse um botão de segurança, dá para sincronizar se precisar, enquanto o E estiver 0, a saída será a mesma

    #Se tem o clock, o capacitor deixar de funcionar, pois não terá como filtrar o ruido vindo do cabo de E (Que estará do lado)
    #Isso acontece pois o tempo do CLOCK ativado é muito grande


    #Então existe uma maneira de arrumar isso será diminuir o tamanho da onda do clock
    #Ou seja, o clock não pode ser muito grande, ele tem que ser apenas um pulso, de subida.
        #Isso é chamdado de tranisção da subida do clock
        #Para fazer o pulso dessa forma criamos um AND de E e E', pois existe um tempo minusculo para o inversos funcionar, isso cria um tempo para o AND passar. 
        #Na prática isso vai isso vai fazer o resto do circuito enxergar apenas um pulso de subida, invés de um sinal grande.

        #Se invés de AND, colocasse NotOU eu conseguiria fazer o mesmo olhando para parte inversa esse périodo, para ser na descida do CLOCK


        #Todo esse "Diminuidor de pulso" é chamado de "Debounce", tem notação propria. (Tudo isso é uma gambiarra)

    #Resumindo, no meu grafico de tempo, só terá alterações quando tiver pulso de subida/descida do clock (mas depende do exercicio)

    #Isso não vai resolver absolutamente o problema, mas a chance de vir ruido enquanto a porta sobe é minusculo, então melhora muito a chance de erros

    #Varios FLipflops guardam informação, e podem ser encadeados (Criando memória)
    #Tudo isso também resume porquê não usamos flip-flop em nível

#Baixar proteus
