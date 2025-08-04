#Lembrando
#Latch com e sem sinal de clock
    #Clock impedir ruído com E
    #Isso é o Flip-Flop RS


#Flip Flip JK
    #Tem um Flip FLop RS dentro.
#As saídas possuem uma conexão AND com as entradas. Depois desse AND que ele vai para o AND do clock RS

#Testando os caminhos
#J K
#0 0 -> Q (mantém o valor anterior)
#0 1 -> 0 Sempre
#1 0 -> 1 Sempre
#1 1 -> Q' (Inverte o valor anterior)

#Ou seja não tem valor inválido nesse caso


#Saida muda entrada, então no caso de eu manter o 1 1 pressionado, a saída vai ficar invertendo

#Notação do CLOCK
#se tiver CK, é clock de nível padrão
#Se tiver a setinha pro lado, é clock de de súbida, se tiver a setinha com um not, é de descida

#Estado proíbido resolvido JK



#Datasheet
    #JK dentro
#Tem um Preset e Clear

#Independente do clock eles funcionam
#Preset deixa no 1 e o clear deixa no 0
#Preset e Clear estão sempre ativos com fonte ligada, com porta lógica NOT. Isso é para evitar rúido, pois ruído é sempre positivo
    #Qunado eu quero ativar de fato eu desativo a fonte




#FLIP FLIP Mestre escravo
#Encademento de dois JK, com a saída (mestre) de um conectado no J e K de outro (Escravo)
#A sacada é que o Clock é por nível, conectado no mestre e com NOR no escravo ao mesmo tempo
#Então o valor do escravo só é alterado quando o clock acaaba, impenddo alteraçãoes
    #A saída do escravo que sai para o resto

#Isso funcionava pois ainda não existia o clock de subida e descida, então o clock era por nível
    #Então atualemte isso não é muito usada


#Flip-Flop D
#É um JK com J invertidos K e ligados, ou seja, ele só tem um valor de entrada, o D
    #O J sempre será o inverso de K pelo NOR
    #Tem um clock pro J e K


#Aplicação
    #Sincroniza circuito usando o clock do FLip-Flop D
    #Processador, ALU


    #Lógicas em algum circuito podem demorar mais que outros em cada saída.
        #Isso pode ser um problema se usar um circuito na sequência, pois as sáidas podem estar errados e já entrarnem erradas para o próximo circuito
        #O clock pelo Flip-Flip ajuda nisso, pois deve aguaradar o clock, e ninguem entra primeiro que outro
    

#Flip-Flop Tipo T
#J e K ligados na mesma entrada T
#Então são sempres iguais, logo 0 0 ele mantém 1 1 ele inverte

#Toda vez que o clock está em 1, ele fica o dobro de tempo ligado, ou seja, ele divide por dois a frequencia do clock
#Isso é útil para dividir frequencias, alterar no meio circuito


#Registrador de Deslocamento
    #Paralelo = Varios Fios, Serial = Ùnico Fio
    #Converte entradas e saídas difentes
    #Entrada paralela ou serial 
    #Saída paralela ou serial
    #Ou seja 4 variações

    #Então enviando a informação 1011 você pode enviar em 1 fio, alterando os volts para 1,0,1,1 com o passar do tempo ou enviar em 4 fios, sendo 1 - ativado, 2 - desativado, 3 e 4 ativados. E enviar tudo ao mesmo tempo

    #OBS: Existe apenas um Ocilador central, os outros clocks são feitos com base nele

    #PP - Paralelo paralelo (Serve apenas para sincronizar circuito)
    #4 FlipFlop tipo D, ou seja, todo mundo tem que aguardar

    #SS - Não vi
    #PS - Não vi

    #SP - Serial paralelo (Serve para converter serial em paralelo)
    #4 FlipFlop tipo D encadeados, quando entra 1, ativa um flip-flop, e quando entra 0 ativa o outro flip-flop, e assim por diante. Ou seja, ele vai guardando a informação em cada flip-flop, e quando chega no último flip-flop ele ativa o clock, e todos os flip-flops vão passar a informação para fora (ou seja, todos vão ativar o clock ao mesmo tempo).
        #Segunda versão, onde o final volta pro inicio
        #Usar para faser contador
    
