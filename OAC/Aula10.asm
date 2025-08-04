#Display de 7 Segmentos
    #Resistor para limitar corrente
    #Capactiro para impedir ruídos

#Existem Led (Diodos) que formam o Display
    #Há diversos tipos de diodos
    #Um led para cada número é impossível, ia gastar muito, ia ter muitos ANDs

#O de sete segmentos tem aepnas sete diodos e funciona para todos os números
    #O Diodo tem um Ànodo (Entrada) e Cátodo (Saída)
        #Anodo é mais fino, cátodo é mais grosso
        #Do lado do ´catodo tme uma planificação
        #POdem ser ligados usando o catodo em comum (Para não fechar corrente com os outros diodos)
            #Isso é, todos os pontos dos cartós estão ligados entre si
            #Preciso passar volts, e aterrar na catódos conectados para só ligar quando eu passar corrente

        #Ou podem ser ligados usando o Anodo em comum (fe)
            #Nesse caso eu preciso atterar o que eu quero acender, e todos vão estar carregados
            #Efetivaemnteo inverso
            #Na pratica isso é mais díficil de fazer, pois o diodo tem um limite fisco que aguenta votlagem
                #Cocas-se um resistor normalmente para calcular a carga
            
        #Atividade BCD para anodo


#Multivibradores
    #Biestável - Se estiver em 0, vai para 1 e vice-versa, amobs estados são estáveis (parados) (Tipo flipflop)
    #Monoestável - Se vai de 0 para 1, fica um tempo e depois volta para 0, temporizadores (Controlável)
    #Astável - Não é estável, ele ocila entre zero em 1 (O Clock sem sí) enquanto ativado(?)


#Astável
    #Criar clock
        #Sincronizar circuito
        #Usar um 555, que é um circuito integrado que gera um clock (ele normalemnte é um temporizador)
            #Ele tem 3 pinos, um para o positivo, um para o negativo e outro para o clock
            #O clock é a frequência de oscilação, ou seja, a velocidade que ele vai ligar e desligar
            #Ele tem uma frequência de 1Hz, ou seja, ele liga e desliga uma vez por segundo
            #A frequência pode ser alterada com resistores e capacitores (R1,R2,C1)
                #Aumentando R1 e R2 diminui a frequência, aumentando C1 aumenta a frequência
                #reugulo eles através da entrada

            #CLock rapidíssimo, para eitar ricso de rúdios
            #Tem restrições de entrada (Ver no slide)
                #3 Entdas para definir a frequêncai (E consequentemente a ocilação)
                    #Capactitancia C, Resitor 1 Ra resitor 2 Rb
            
            #Pinagem específica

            #Não tem muita precisão pois o resistor adequado não existe no mercado (Assim como capactiro)

            #Pino 3 vai ser o sinal de clock 
                #Ele não vai estar perfeito, pois o caapacitor demora para carregar e descarregar (Curva exponencial)
                #A placa também tem transições, logo essa curva terá uma zona cinza de indecição (Não sabe se é 0 ou 1)
                #Então deve resolver essa curva, pois o clock está analogíco demais (Limites do capacitor)

            #Então só deve ser 1, quando deve ser de fato 1, não da zona cinzenta
                #Usar um aparelho que define quando ele considera 1 e quando usar 0, retornando uma onda quadrada
                #Ele não tem zona cienzenta, então é só conectar ele
                #Ele também consegue 
                #Esse problema é de BAIXAS frequências, pois a curva não importa em alta (Desprezível)

            