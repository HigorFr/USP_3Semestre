#Última aula de circuito sequencial
#EP vai ser em assembly (fazer uma ordenação em um processador)

#Máquina de estado
    #Exige conhecimentos anteriores


#Dois tipos de márquinas

#Estrurua combinacional e sequencial

#Maqúina de Moore
    #Entradas não interferem diretamente na saída
    #Entradas interferem no proximo estado
    #Saída depende do estado



#Máquina de Mealy
    #Igual, mas entradas interferem na saída



#Representação
    
    #Circulo é o estado/saída ou só entrada em máquinas de moore
    #Na seta será entrada ou entrada/saída em máquinas de moore



#Diagrama de estados
    #Exemplo de botão usando circuito pós decodificador
        #Tenho 3 botões, ABC, sendo 01 10 e 11, e minha luz só acende quando eu pressionar todos até C
        #Não posso apertar 2 ao mesmo tempo
    #Tenho que guardar os estdos dos botões, ou seja, quais eu já apertei
        #Isso é feito com as máquinas de estado, toda vez que eu colcoo uma certa entrada, é como se a máquina mudaassse a operação e fosse para um proximas (Cada alteração é um estado, com difernetes entradas e saídas)
    #Se eu apertar C (Quebrar a sequencia) eu tenho que voltar para o estado anterior (mas isso é definido de acordo com o problema)
        #Ou seja, eu tenho estados que dou nome que podem revesar quem está atuando dependnedo das entradas

#Assincrono com moore fica assíncrono, já que a entrada vai saír imediatamente no penultimo estado antes mesmo do atualziar o estado final.

#Retomando flipflops
#Q   J K
#0 0 0 X
#0 1 1 X
#1 0 X 1
#1 1 X 0

#Q   T
#0 0 0
#0 1 1
#1 0 1
#1 1 0

#Q   D
#0 0 1
#0 1 1
#1 0 0
#1 1 1


#Será escolhido o D para fazer a máquina de estado, já que ele é o mais simples

#Normalemnte o nome do estado é dado em binário, 01 10 11 100 etc, o numero de bits é o numero de flipflops que você vai precisar para construir ele
    #Pelos diagramas de transisão você consegue montar a tabela de transição que montara o estado

#Tabela
    #Vou ter para cada máquina uma tabela.
    #Primeira coluna de estado atual, entrada, estado futuro, e saída
    #A tabela já representa meu problema, só preciso de uma mapa de karnot

#Usando o D de exemplo eu só comparao o estado atual com futuro e defino para ver o que saiu
    #O D1 vai ser identico ao meu estado Futuro, eu só preciso fazer mapa de karnot para o as entradas deles usando o estado atual e as entrdas

    #Agora da saída eu só preciso olhar o estado atual e ver se é igual à quando sai (No caso eu quero 11) então é só um E no Q1 Q0 e conectar do D0 ou D1 para formar o estado futuro

    #Lembrnado que no assincrono, a primeira saída que seria no sincrono será agora a segunda, pois no assíncrono a saída atualiza antes do estado futuro.
        #Não haverá diferença entre a variação de estado, as tabelas será as mesmas.
        #Contudo com a saída haverá mudanças, precisaremos usar a entrada pois agora dependerá de ambos.
            #Ensse caso agora terá um novo and que será possível acionar também

