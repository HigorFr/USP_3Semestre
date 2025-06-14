//Multivibradores

    //Vários Circuitos
    //Como gerar um sinal de clock

    //Voltando ao básico
        //Funcionamento capacitor C
            //Quando carrega para a carga, e ele fica com diferença igual ao V da fonte
        //Quando ele para de receber sinal ele descarrega em um resistor R
            //Carrega em velocidade logaritima e descarrega em velocidade exponencial 
            //Problma, a onda para ser um clock deveria ser um quadrado

        //Multivibradóres resovem isso


//Bíestáveis
    //Ele tem dois estados, 0 e 1, e ele fica parado em um deles
        //Ele só muda de estado quando recebe um sinal de clock (Um pulso)
        //Ele tem dois pinos de saída, um para cada estado (Q e Q')
            //Quando Q está em 1, Q' está em 0 e vice-versa
        //Ele tem um pino de reset, que força ele a voltar para o estado inicial (0 ou 1)
        //Ele tem um pino de set, que força ele a ir para o estado 1 (Q = 1 e Q' = 0)
        //Ele tem um pino de clock, que é o sinal que faz ele mudar de estado
        //EX Flip-Flop

//Monoestável
    //Ele tem um estado estável (0 ou 1) e um estado temporário (0 ou 1)
        //Quando ele recebe um sinal de clock, ele muda para o estado temporário e depois volta para o estado estável
        //Ele tem um pino de saída, que é o estado temporário (Q)
        //Ele tem um pino de reset, que força ele a voltar para o estado inicial (0 ou 1)
        //Ele tem um pino de set, que força ele a ir para o estado 1 (Q = 1 e Q' = 0)
        //Ele tem um pino de clock, que é o sinal que faz ele mudar de estado
        //Ele é ajustando de acordo com as constantes R e C
        //EX Temporizador
        //No proecessador tem para fazer a pseudo paralelismo (Ele reveza vários programas muito rapidamente no processamento)

//Astável
    //Ele não tem estado estável, ele fica mudando de estado (0 e 1) o tempo todo
        //Ele tem um pino de saída, que é o estado atual (Q)
        //Ele tem um pino de reset, que força ele a voltar para o estado inicial (0 ou 1)
        //Ele tem um pino de set, que força ele a ir para o estado 1 (Q = 1 e Q' = 0)
        //Ele tem um pino de clock, que é o sinal que faz ele mudar de estado
        //Ele é ajustando de acordo com as constantes R e C também
        //EX Oscilador


//Estruturas
    //1 -Carossel de dois capactires opostos carregando e descarregando usando tranistores
    //2- Inversores com papacitor no meio
        //Resitor adicional para impedir fusível de dar problema
        //Controle de resistor usando diodos, assim defino o tamanho da decida e subida separadamente
    //3- Oscilador com disparador (Trigger)
        //Rapidamente vai de 0 para 1
        //Tensão cai com tudo, sem a suaviade do capacitor
        //Depois de subir, ele precisa descer mais que o que precisou para subir para descer
            //Isso cria a região cinza que dá a notação dele
    //4- 4093
        //Trigger invertido usando capacitor
        //Controla frequência pela tensão (Por conta do capacitor)

    //5- Oscilador de cristal
        //Cristal de Quartzo, produz onda quadrada quando recebe energia
        //Frequencia dele depende do corte, que nunca será certinho
        //Por isso oscila imprecisamente então são usados dois capacitores para fazer um ajuste fino
    
    //6- O 555
        //Configurável como gerador de clock ou temporizador (Monoestável/Astável)
        //Configuração dois resitores fica astável (gera clock)
        //Sistema usando os Ts
            //Chuto capacitor C comercial e acho valor de F
        //Desenho específico mostra onde fica cada entrada
        //Não é exatamente porquê os calculos dos resistores/capactores não são exatos (não tem no mercado)
        //Problema da área cinza de voltagem, precisa de um trigger na saída para resolver

        //Serve para monoestável também, muda configuração
            //Mesmo jeito, usando resistor e capacitor
            //Pode ser redisparável ou não, ou seja, aceitar pulsos durante a saída ou não
        
        //Exercício
            //Configurar máquina, tempo de trabalho e tempo de parada
            //Pode ser resolvido com flip-flop jk (maquina de estado) ou os multivibradores
            //Primeiro separar o tempo
            //Escolher pulso (sempre tem)
            //Diagrama de tempo
            //Monta saída
            //Conecta
            //Fazer com flipflop (Gerar T2,T3,T3)
            
            
