#Caminho de dados do processador


#Tipos de instruções

#Formato R
#32 bits, 6 OP, 5 RS, 5rt, 5 rd, 5 shamt, 8 funct


#rd é destino da operação (O primeiro argumento normalemnte)
#rs e rt é as fontes


#Shamt é para argumentos de deslocamento
#Funct é para definir qual operação (ADD, SUB, ect..) é a função
    #Todas essas de exemplo tem o mesmo OPCode (Agrupamento de várias funções)
    #Essa separação de OP e FUNCT é para facilitar implementação no código

#Tem também as no formato I, com outro OP code
    #Normalmente os load, LW
    #nesse caso é sempre é RS a fonte e RT o destino
    #E os 16 bit que sobram é para constatnes or endereço (que é o outro argumento dos load)



#E tem o tipo branch, com outro OPCode
    #Nesse caso é rt e rs é a comparação, e os outros é de deslocamento na labem (o compilador trnasforma a label e em um numero da linhas)
    #Note que esse deslocamento de 16 bits é pouco, normalmente é somado ao PC para ter um range grande.]
        #Endereço tem que estar em byte e o deslocamento em é  word, então tem que mutiplicar por 4. (Ou dividir não lembro)
        #E também tem que transformar de 16 para 32 bits


#Tem as de desvio incodicional j, jr etc
    #o Op code é só 6, e o resto é pro deslocamento (26 bits)
    #também é pouco, mutiplico por 4 para virar palavra e fica 28
    #depois ainda pego 4 bit mais sinigficativo do pc pra inteirar 32 bits




#Circuito

#Elemento de estado entre lógicas combinatória é sempre necessario
    #Sincronizar circuito, guarda valores, e organiza fluxo de dados.
    #Meio que armazena o resultado



#Elementos 
    #PC proxima instrução
    #ULA, opreção em cima de dois daddos (Tipo soma) (E tem uma entrada pra definir operação)
    #Memeoria - Entra com endereço e dados para gravar

#Banco de registradores, recebe duas entradas sempre (independente se precisa ou não)
    #Também recebe o valor de dado que vai ser escrito e ainda um sinal de permissão (Se ele for zero nunca escreve)
    
#ALU também tem uma saída boeleana para conferir se a conta deu zero
    #oepra só 32 bits também (tem varias coisas que precisa de 32 e ai precisa de conversão)
    #operações
    #AND 0000
    # OR 1
    # 10 ADD
    # 110 SUB
    # 111 set onm less than
    #1100

    #Poderia ter menos bits, mas nesse caso foi adicionado mais para facilitar o circuito interno do ALU
    #NO tipo R, ele é definido pelo function que vai definir a operação
        #Ele só vai ler function sempre no tipo R, e eu preciso de um controlador para saber o que Ler e como


    #controlador ALU
        #Ele vai receber o op code e vai definir a operação do tipo ALU 
        #ou seja, se o OP for 10, que é a do tipo R, ai ele vai ver o function, por exemplo
        #se for um 00 (Load wotd/ store word) ele vai ignorar o campo funct, e vai direto pra soma
        #E assim por diante, tem várias configurações e uma tabela nos slides que mostra como é cada


#Circuito fica ainda mais complexo com isso, tem no slide

#No fim, vai ter um controle geral que vai ler o OP code que vai definir todos os padrões de leitura de todos unidades
    #Ou seja, é como se parte partezinha azul fosse definida por algo e já definida
    #Por enquanto ta dudo seuqencial

#No final cada código de 32 bits vai fazer um grande comando que especifica o caminho


#Na prova eu tenho qeu analisar isso, entrada e saídas de cada etapa e os caminhos percorridos dependendo do código inciial de 32 bits (Que vai especificar tudo)




