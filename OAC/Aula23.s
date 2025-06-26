#Processo de Pipepline

#Paralelismo entre processo, dá para fazer mútiplas coisas ao mesmo tempo
    #Certas estururas do código ficam inativas enquanto está tudo acontecendo no diagrama, então o foco é fazer com que elas sejam aproveitadas

#Ele não ajuda na latência em sí de nada, ele só melhora o "throughput", a vazão
    #Ou seja, se eu analisar um aepnas processo isolado é o mesmo tempo do que seria
    #aceleração máxima é o numero de estágios, além disso não vai fazer mais sentido

#O potencial máximo só vai se mostrar de fato quando o pipeline estiver cheio


#Branches executados vão fazer o que já foi executado num "pre-fire" ser jogado no lixo
    #Isso perde desempenho

#outra coisa que pode acontecer que veremos no futuro (OAC II) é dependencia, as vezes um comando depende do outro e preciso ficar loopando para esperar ela terminar



#Calculo sempre utilizando o pipeline cheio:
    #   Tempo do monocilo / Numero de estágios

#MIPS para pipeline (ele é feito para isso)
    #32Bits para facilitar busca e ajuda o pipeline

#estágios
    #Busca BI
    #Leitura, Decodificação ID
    #Execução, usa a ULA EX
    #Acesso na memŕoia, lê ou escreve M (Ou DM)
    #Escreve de volta WB (ou ER)


#só se sabe se é branch ou jump na execução (terceiro ciclo)


#alguma coisas que assumimos que vamos refutar em OAC II
    #todo calculo é o mesmo ciclo (Na verdade mutiplicação demora mais, divisão também)
    #Ignora dependencia de instruição
    #Entre outras


#No diagrama, há de mencionar que entre cada estágio tem buffers, que são flipflops que carregam valores para o proximo estágio de maenira sincronizada com o clock


#Certas informações, como controle são carregadas por esse buffers durante a execuação
    #Tipo saber ond eescrever de volta no write back (O que está lá ja salvo estaria errado, pois ta tudo acotnencendo ao mesmo tempo)
    #No final o doagrama fica diferente então, os sinais de controle vão sendo empurrados com o clock


#Proejto ULA
    #00 Força soma, 01 Foçar subtração, 10 Olha function



#MEMORIA SECUNDARIA CAI NA prova
    #O QUE CAI:
    #Como funciona prato do disco, gravação usando polaridade e geração elétrica

    #Trilhas, setores
    #Tem blocos, em gap que informam toddas as informações sobre localização pro disco, (ele fala setor, bloco etc...)
    #Todo setor tem um campo para esses dados

    #TEM O RAID 
        #Tem varios discos para gravar os dados
        #Níveis, tudo distribuido para os dicso de Agrupamento
        #Dados distribuidos ao longo do disco para ter redundancia

        #Nivel 0 - Só separou os dados em vários discos
        #Nivel 1 - Duplicou, redudancia completa
        #Nivel 2 - Bits de paridade ficam em outros discos (Mesma quantidade de disco duplicada), dai não dá problema no mesmo lugar
        #Nivel 3 - Coloca apenas um disco de redundância invés de um pra cada
        #Nivel 4 - Vários discos dispersos + um disco apenas no mesmo andar para paridade 
        #Nivel 5 - Cada disco tem parte da paridade de todos do mesmo andar, fica distribuido (Ou seja, não tem disco especifico para paridades)
        #Nivel 6 - Dois calculos de paridade todos espalahdos já nos distos de dados (que nem no 5)

