#Convenções para interperação do binário
    #Exemplo com display numérios
    #Representações no computador também devem seguir uma estrutura

#Representação númerica já é uma representação (Por padrão a hindu-arabica)
#Matemticamenticamente usando a base decimal pela quantidade de dedos

#Cada dígito (Cada 1, cada Fio) é chamado de Bit
    #Em octal precisamos de 3 bits por exemplo para represntar
    #Em hexadecimal é 4 (Usado muito em eletrónica)

#Transformações em Hexa pra binario é a transformação individual
#2F8 é 1011111000 - É 10-1111-1000 (Ou seja, cada um individual)


#Bit mais à esquerda é o mais representativo

#Em notação, colocamos sempre 
    #b no final para falar que é binário
    #0 à esquerda para falar que é ocatal
    #0x no inicio ou h no final para falar que é hexadecimal

#Não é qualquer representação que é boa para fazer cálculos, por isso usamos essas em específicas
    #Tipo somar numero romano, que exige que transformemos em decimal primeiro

#Também note que 1 não significa exatamente 1, ele pode significar 1,10,100 pois é uma representação posicional. (Sinificado muda conforme a posição)
#Ou seja, valor * base^posição

#Lembrando, binário é 1 e 0 pois são as correntes possíveis em um transistor



#Representações em binário
    #2 bits podem representar 4 valores
    #3 bits 8 valores
    #4 bits 16 valores etc...

#Arquitetura dos computadores hoje em dia é 64 Bits, ou seja, a quantiade de memória endereçável é 2^(64)

#Regra prática Decimal para qualquer coisa
    #Direita para esquerda
        #Escolha um numero
        #Divide inteiro o numero e seu cociente pela base repetidamente até o cociente ser 0
        #Volte recolhendo os restos de baixo para cima

#Se não quiser pegar resto, basta dividir por 2, se der 0,5 coloque um e pegue o resto
    #byte = 8 bits


#Para octal, invés de 0,5. Observamos se é 0 (0) , 125(1), 250(2), 375(3), 500(4) etc 


#Conversão direta a->b

#De hexadecimal para binário por exemplo, são bases mútiplas, então 4 bits do binário representam do hexadecimal, assim como de octal para binario dois bits representam.
#E de hexadecimal para octal é dois bits também.
    #Só não pode esquecer de adicionar os 0 à esquerda para compensar
#Assim com uma tabela é só questão de traduzir


#Fracionarios funcionam do mesmo jeito, depois da virgula fica base^-1 e vai diminuindo
    #Ou seja a parte inteira eu só uso aquele esquema de divisão
    #E com a parte decimal eu irei mutiplicando pela base e tirando a parte ineira (Só que agora da Esquerda para direita)


#Operações
    #Definindo regra da soma da maneira certa
    #O limitante da base é retirado sempre que ultrapssado e adicionado à posição seguinte


#Subtração e mutiplicação













