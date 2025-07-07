#Exercício, transformar programa em Assembly


#Principais coisas usadas
#SLTI ver se é menor
#BEQ é para se o valor A igual ao B ele pula para outro lugar
#ADD adiciona
#SLL é para deslocar n para esquerda (ou seja, mutiplicar por 2^n)
#SW é para guaradar palavras com um X() deslocamento (X é sempre constante, não pode ser valor que vem de registrador)
#Load é para quando já se tem o endereço de memória e quero à ler (Nesse caso é o valor, não endereço)


#Na hora de escrever a função, você não tem de antemão o que você irá usar para funcionar, então a pilha que ela vai usar para ganhar variáveis você só monta depois que você já implementou ela inteira

#Mais exemplos em Assembly

#Normalmente os Ts, t0,t1 são usado como argumentso extras, já que por padrão o limite é 4 (de a0 até a3)

#Manipualação de arquivos
#Abrir no modo leitura - Ler - Fechar
#Abrir no modo escrita - Escrever - Fechar
    #Essas operações mudam, pois o SO vai tratar diferente caso outros processos queiram abrir também

#Código 13 em $v0 para abrir o arquivo (Só abrir)
    #no $a0 tem que estar o enderçeo do arquivo
    #no $a1 tem que estar 1 para gravar e 0 para ler  
    #syscall pra chamar o OS

#Depois para continuar eu tenho que fazer outra função
#Descritor é o retorno que vai pra v0, se V0 ficou 0 quer dizer que não abriu
    #Agora eu faço outra função com v0 código 14 (Que é leitura)
    #Aquele descritor que está em V0 tem que ir pra a0 (Eu tinho que copiar ele pra outro lugar)
    #a1 é o local que vou salvar ele pra ler (endereço de memoria do tipo asciiz)
    #a2 é o tamanho que vai ser o arquivo #Não cabe muito, as vezes é melhor ler de 1 em 1 em loop


#Se fosse gravação seria código 15


#Transformar caractere em número é só fazero ascii -48 (Pois os numeros coemçam em 48 na tabela ascci. 0 é 48, 1 é 49, 2 e 50 etc...)

#mtc1  transforma inteiro em float
#cvt.d.w transforma float em double

    #Fazer manualmente é muito mais complexo, tem que andar mutiplicando por 10 o anteiror (10 será uma constatne em algum lugar) até chegar no ponto, quando chegar no ponto você troca a constante por 0.1 e continua mutiplicando
    #Também tem que conferir o que será o /n
