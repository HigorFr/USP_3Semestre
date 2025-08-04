#Voltando ao problema de limitar a contagem~
    #Acumula erro, pois se quero contar até 5, tenho que contar até o 6 e restar
    #Isso dá imprecisção

#Contador assincrono não conta de 4 até 10 por exemplo, para isso preciso de contadores síncronos


#Contador não sequencial
    #Ex
    #0 0 0
    #0 1 1
    #0 0 1
    #1 0 0 
    #1 1 1
    #Agora eu preciso da tabeal de transição para obeservar

    #3 Bits, é 3 flipflops

    #Para cada bit eu olho a variação e registro elea
    #Entçao 0 pra 0, eu anoto 0X
    #Cada flipflop será referente à um bit, esquerda pra direita, q2,q1,q0

        #Circuito entre os flipflops será com base na tabela
        
        #Monto mapa de karnoth
            #Para cada J e K, ou seja 2* o numero de bit
            #No mapa de karnkoh tera´X e valores vazios (Tipo o 4, em 1,2,5)
                #Os vazios tem que ser considerados, então eu crio a tabela deles também e vou preenchendo
                #Na teroai poderia ser X, apenas se sempre iniciasse no 0 (O que na vida real não ocorre)
                    #Inclusive tomar cuidado com simuladores
            #Depois de construir, assumo sempre que X será 1 caso ele possa formar um grupo maior, caso contrario considero 0
            #Ao final pegue o resultado do valor J/k referente
                #Lemenrando sempre que devemo somar os grupos
                #Ex J2 = Q1' AND Q0
                #Sempre que o mapa der tudo 1, assumo J/K = 1. Ou seja, é uma alimentação (1 Constante)
                    #Se for tudo 0, ai é o inverso, assumo J/K=0. Ou seja é um Terra
        
        #Ao final você vai ter todos os J/K e suas dependencias em Q
            #Isso dita o que deve chegar de circuito no J/K referente, então é só montar o circuito

        #Lembrando que tudo isso é sincrono (Asincrono é mais simples, depende da situação)

    #EP
            #Sincrono  
            #61 e volta pra zero
            #CBURCH simulador gratuito
            #Encapsular circuito
            #4 Alunos
            #Flipflip, porta and or xor, e chip 555 (Gera o clock)
            #Documentação, Mapa de karnot e simplificação
            #Dia 11


            #Tabela 0 - 