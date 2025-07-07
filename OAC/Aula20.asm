#Assembly:




#Duas sessões
    #.Texto é código
    #.Data é definições, declarações


#Label é o nome da linha, sempre seguido de main:
    #SO sempre recebe 2 valores, sendo o primeiro o número da operação, e o segundo é o argumento dela.

#LI A,B - Load imediato, carrega o valor B descrito para o registrador A na hora
#LA A,B - 

#Main é fechado pelo syscall para chamar o sistema operecional para realizar o que tem que ser feito.
#Código 10 finaliza o programa, (Seguido do syscall);


#As variaveis mantém, o syscall não muda elas.
#é como se ele copiasse e jogasse pro OS a função toda vez que você escreve 'syscall'



#Imprimir inteiros é código 1 no $v0
#LW A,B - Carrega o valor do inteiro B no registrado A

#Tem o WORD também (Inteiro)

#$a0 é sempre o que será impresso (É pdrão)
    #Caractere e string eu sempre paço endereço para ser trabalho e nunca valor (LI)
    #Caractere é Byte, então declaração é palavra: byte 'm'
    #float é myfloar1: .float 0.43

#Em pontos flutuantes, a unidade aritimética é diferente de inteiros normal, é o co-processador que realiza impresso

#lwc A , B - Load B para um registrador (Float) A (é LWC pois é "Ler palavra pelo coprocessador")
#add.s A,B,C (Diferente do add normal, pois exige precisão simples) Soma B e C e coloca em A
    #$f12 agora é o conteúdo da impressão (Sempre convenções que definem isso)

    #Nesse caso o $v0 é 2

#Dá para guardar coisas no .data também, usando o STORE, dessa forma eu altero o que está em memória

#O double o código dele é 3 para impressão, e ele sempre olha o 12 também

#Comentários são com #


#Para salvar variaveis também eu posso usar o ADD e somar zero (Que é $zero)
#Subtração é sempre SUB A,B,C -> sempre B - C guardado em A

#Multiplicação é MUL
    #Cuidado para não extrapolar na mutiplicação
    #Se A passar de 32 bits eu uso MFLO B (Menos significativos) e MFHI C (mais significativos) e coloco os valores na variável A e B para tratar separadamente. (tem que ser em seguida da mutiplicação)

    #Eles também severm para a divsão: MFLO é o quociente, MFHI é o resto

#Invés de ler arquivos no EP, é mais fácil fazer uma matriz no .data para facilitar

#Também cuidado com /n, que não são automáticos

#Mutiplicações são custosas, se for mutiplos de 2 é melhor fazer deslocamentos usando deslocamentos 
    #SLL A,B,K -> deslocar K para esquerda (2^K) o valor B e colocar em A
    #Isso é útil para se localizar em palavras (Já que elas tem tamnho de bytes definidos)

#Quando eu chamo uma função é usando o JAL e o nome da função (Jump and Link)
    #Link é para arrumar o PC, ou seja, ela vai pegar PC e gravar no $RA, vai mandar ele pra onde está a função e depois que ela terminar você recupera o PC salvo para voltar
    #Essa função tem que está depois do main:, ex printmsg:

    #Para voltar é JR $RA (Jump to Registrador $RA, que é onde eu salvei onde eu estava)
        #$RA precisa ser empilhado em funções nested





#Argumentos de função devem estar em a1 a2 sempre, que a função pode acessar
#Retornos é sempre $V0 (Por isso que usamos na main)



#Pilha

#Pilha é invertida
#Tem uma área de pilha que fica no topo, e a pilha deve crescer de cima para baixo para evitar invadir áreas mais importantes
    #Desse modo se ela estourar ela vai matar seu código, não nada mais importantes
    #Todas variáveis são globais em uma função (Com excessão eu acho);

    #Então a menira de resovler isso é guarda a variável na pilha, usar, e depois colocar novamente o que extrapolar


#SP é o tamanho atual da pilha, inciando no 0 obviamente;
#Primeiro eu abro espaço e dou: addi $sp, $sp, -4 (Lembrando que é negativo para abrir)
#SW A K($sp) - é para colocar A na posição 0 da minha pilha (Empilhar) (K é o quanto eu ando)

#faço o que preciso e zero a pilha
#addi $sp, $sp, 4 (Ou seja, para diminuir o tamanho dela eu somo)

    #É uma constante impilhação e desempilhação


#Se eu tiver uma função chamando outra
    #Cada função pode ter a propria pilha, e o $FP salva a pilha da main
    #$RA dependendo pode ser empilhado para organizar o callstack
    
    #Toda vez que eu vou chaamr uma função eu marco onde termina a pilha da main e onde começa a da função



#Solicitar entrada de dados
    #Uso o $V0 recebe 5 para aceitar valores e dou syscall
    #Esse valor vai para o $v0 e fica guardado lá
    #Se for colocado em ponto flutuante ele guarda $f0 invés de $v0
    #Lembrando que $V0 é uma variável importante pro syscall, então normalmente se copia o valor para outro lugar


    #Float exige 6 na entrada e double é 7
    #Entrada de texto é 8, e tem que especificar tamanho


        #Na data também tem o tipo space, que é só pra reservar valor para coisas que você for usar
        

#BNE A B C é para entrar numa branch se A e B forem diferentes. Ele vai para o endereço C (No caso C é uma função)
    #Se forem iguais ele só segue

#B é só se for para entrar em branch independete de nenhuma análise
    #No fim, é como se não tivesse "funções", tem labels, e elas operam como uma função
    #Assim que elas são na prática



#STL A,B,C Confere se B<C, se sim ela seta A para 1





