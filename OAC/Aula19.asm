#Aula 20 é Assembly, para o EP, não terá função recursiva


#Aula de hoje é Interface, continuação da aula anterior
    #Etre o usuário e o computador

#Módulo de entrada e saída (Controlador)
    #Ele recebe os dados para jogar no barramento, e gerencia o formato e o tempo de cada dado
    #Desse modo não é tudo qeu vai direto para o processador
    #Cada dispostiivo tem o proprio controlador, todos eles conectam no geral e só então vão para o processador

#Contudo o controlador cental pode não exisitr mas é bem incomum alguém escolher isso na arquiterura
    #Ou seja, o contrlador recebe o barramento de expanção, e envia para os baramentos de controle, data e endereço (Barramento de sistema)
    #Obs: tudo conectado a ele também é chamado de periférico


#Dentro do controlador central:
    #Buffer, que recebe os dados e só então envia para o sistema
    #Unidade de controle, que gerencia o fluxo.

        #Sinais de controle
        #INPUT, READ, OUTPUT E WRITE

        #Sinais de estado
        #READ ou NOT-READ (Para ver o dispositivo está pronto ou não para enviar dados)

        #Lógica de controle
        #DAi é poprio do dispositivo, recebe comando dependnedo do módulo

        #Transdutor é para transferir, "traduzir" os sinais elétricos e transferir para dados

#Serial é mais rápido que paralelo, posi sincronizar a chegada é mais rápida
    #Atualmente, quase tudo é serial



#Ou seje, no geral esse módulo E/S:
    #Temporiza
    #Guarda Dados (antes de enviar para memória)
    #Comunicação com o proessador
    #Arruma erros


#Cada uma dessas função está especificado no slide
    #Cada dispositivo tem um endereço, pois as mesmas funções podem ser usadas pelo dispositivo
    

#Antes de enviar um dado ele confere se o dado não está corrompido
    #lê o dado, e confere os bits de paridade, e se tiver erro ele corrige.
    #Se não conseguiu ler, ele avisa o processador


#Gerenciamento de dispositivo
    
    #Supondo que o processador quer ler dado do HD
            #Sem controlador central, o processador acessa diretamente o controlador do HD, e ele vai aguardar o dado
            #Logo, o processador vai ficar o ocioso, até o dado do HD estiver pronto
                #Isso é muito ineficiente, vai dar muito STALL
            #Dai começa a transmissão, o processador recebe e joga na memória (RAM) (Tanto leitura, tanto escrita)
            

    #Tem outra forma, usando o méotod de interrupção (Análogo Await de uma linguagem)
        #Um dispositivo pode avisar o processador que ele está pronto, e então o processador decide quando ler
        #Então, não é o processador que fica perguntadno, quando o controlador de interrupção avisa o processador vai lá pega tudo do buffer dela
            #No final de cada clock (Ou algum outro tempo determinado) o processador verifica se tem interrupção


    #O a unica coisa que falta e fazer com o que os dados não tenham que passar pelo processador:
    #Tem outro método que faz isso, que é o DMA (Direct Memory Access)
        #O controlador de E/S pode acessar diretamente a memória, sem passar pelo processador, 
        #Ou seja, o controlador de E/S vai lá e lê os dados direto da memória, e depois avisa o processador que terminou
        #Isso é muito mais rápido, pois não precisa esperar o processador ler
        #O processador só vai ler quando o controlador de E/S avisar que terminou
        #Isso é usado em HDs, placas de vídeo, etc.

        #DMA meio que imita esse trabalho do processador.

        #Desvatagem é que ele vai consumir o barramento, e enquanto ele estiver usando, o CPU não usa.

    #Existe DMA já integrado no IO (Dai ele só ussa barramento pra escrever) e modelos que é um DMA tratando todos e usando barramento (Usa barramento para ler e escrever)

    #Tem ainda uma maneira que usa um barramento próprio para leito, e o barramento de sistema para a memória


#Um pouco da aula de assembly  
    #Considerando processador MIPS, arquiterua (RISC ou RISK, sei la)

#Ex
add a,b,c

# A é destino, b e c são fontess

#Para somar A+B+C tem que fazer uma decomposição de várias coisas simples:
add a,b,c
add a,a,d
add a,a,e

#Isso pelo principio de regularidade, o processador vai sempre prefirir algo mais simples para evitar que o processador trabalhe mais

#$ra guarda endeço a árvore Pai da callstack, em função recursiva eu preciso de $fp e $sempre

#Tabela depois explicando todas as funções
    #Tem uma classificação pra cada comando
    #O que é imediato??
