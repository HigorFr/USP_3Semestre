#Portas Lógicas
    #Transistores são usados para criar portas lógicas
    #Exemplos no slisdes
        #AND - Série (Parece uma D)
        #OR - Paralalelo (D curvado)
        #NOT - Inversor (Adiciona uma bolinha)
        #XOR - Or Exclusivo (Se forem iguais é 0), (D curvado com traço)
        #NAND - Inverso do AND (Não pode ser ambos 1)

#Tabela verdade
    #Anota em tabela todas a possibilidades entre variáveis (A,B,C) e tem saída
    #Exemplo AND
        #A  B Out
        # 0 0 0
        # 0 1 0
        # 1 0 0
        # 1 1 1
    #O com Not, é só inverter a saída

    #"Ou" é +
    #"E" é *
    # Traço em cima é Not

#Precedência
    #Assim como na matematica é feito em ordem, por isso é importante
    
    #()
    #Not
    #And
    #Xor

#Conversão em circuito

#Terema de Morgam é algumas simplificaiçãoes
    #A' + B' = (A*B)'
    #A' * B' = (A+B)'
    #A + B = (A'*B')'
    #A * B = (A'+B')'

#Circuito combinacional (Foco da aula)
    #Problemas será dados e precisamos resolver
    #Circuitos não possuem memorias, são apenas combinações de portas lógicas
        #Ou seja, mesma entrada é a mesma saída
    #Proxima aula teremos memória

    #Para projetar circuito exige 3 formas
    #1 - Tabela verdade
    #2 - Expressão booleana
    #3 - Diagrama de Karnaugh

    #A simplioficação exige que circuitos estejam na forma que possam ser simplificados
    #Ou seja, não pode ser simplificado um circuito que não está na forma de simplificação
    #Exe ABC + A'BC' pode ser simplificado, pois está na forma de simplificação
    #Exe ABC + (ABC)' não pode ser simplificado, pois não está na forma de simplificação


    #Mintermo e Maxtermos
        #Mintermo é uma expressão que é verdadeira para uma única combinação de variáveis
            #Em "soma de produtos" é tabela verdade que cada linha é 1
        #Maxtermo é uma expressão que é falsa para uma única combinação de variáveis  
            #Em "produto de somas" é tabela verdade que cada linha é 0
    

    #(Compensa pra quando tem muito 0)
    #Em soma dos protuso, ou seja, eu tenho a tabela verade e vou usar a soma d eprodutos
    #Marco todos que são 1 e faço uma expressão para cada em produto (Considerando que tudo é 1)
    #Então a linha 1 0 0 1 (quem tem saída 1), fica A * B' * C' * D por exemplo
    #Depois eu somo todos esssas expressões que criei e tento simplificar. isso será o resutlado da expressão
    #Ou seja, tem como transformar circuito em expressão, vice e versa, expressão em tabela, etc... todas as transformações
        #Simplificar porta logíca aumenta a eficiência, menos operações. Então é bom prestar atenção nisso
    

    #(Compensa pra quando tem muito 1)
    #Em Produtos das somas
    #Marco todos os 0 e faço uma expressão para cada em soma (Cnsiderando que tudo é 0)
    #Depois eu faço o produto dessas expressões que criei e tento simplificar. isso será o resutlado da expressão

    #Lógica inversa
    #Da para simplesmente inverter tudo isso, colocando a barra.
    #Então mesmo que tiver muito 1, eu posso aplicar a barra no resultado, aplicar a  a soma dos produdos e aplicar a barra  novamente na resposta
    #O mesmo vale pra produto das somas


    #Problema disso é que tem muito algebrismo na simplificação
    #Por isso existe o diagrama de Karnaugh, que já traz a expressão simplificada
    #OBS: Acima de 5,6 variáveis ele não compensa, fica muito complexo

    #Explicação
        #Tenho a tabela verdae
        #Crio 2 grupos contendo as variáveis, cada grupo tem quantidade igual ou igual-+1, e não pode ser vazio
        #Crio uma coluna e uma linhas para cada grupo com os possíveis valores
        #E dentro de cada célula coloco o resultado referente
        #Isso é o diagrama de Karnaugh
    
        #Quando escreve a coluna ou  a linha, apenas uma variável muda, então não se pode 01 e 10, pois mudou o primeiro e o segundo algarismo
        #Então tem que ser 00 01 11 10 por exeplo e não 00 01 10 11
    
    #Depois na tabela analizamos tudo que tem 1 e criamos grupos
        
        #Regras:
        #Para analizar a variação, precisamos obrigatoriamente de grupos tamanho 2^n (Caso o contrário não temos como encontrar a variação)
        #Ele também é dobrável, ou seja, o extremo esquerdo é vizinho do extremo direito, assim como cima e baixo
        #Os conjuntos também devem ser quadrados, e todos os 1s devem pertencer a um conjunto
        #Cada 1 também podem pertencer a mais de um conjunto
        #Os grupos devem ser os maiores possíveis

        #Depois de demarcar os grupos, eu crio uma expressão para cada um analisando a variação
            #Observo a variação e da coluna/linha referente (Conforme o tamanho do grupo)


        #Exemplo máquina nas lousas, um diagrama para cada.
        #Software Proteus de cricuito

        #Prox aula será cricuito sequencial (flipflop etc)