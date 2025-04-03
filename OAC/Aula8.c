//Contadores

//Crescente ou decrecrescente
//Notações tipos de sinais de controle para nível
//1 , 0 , subida ou descida

//Flip flop Tipo D lembrando
//Ele inverte o sinal de saída

//Contador é um encadeamento de Flip Flop tipo D, onde o Q' é o Clock do seguinte
//Assim cada clock vai aumentando em binário:
//Vendo de cima pra baixo (Direita para esquerda)
//  1- 000
//  2- 001
//  3- 010
//  4- 011
//etc

//É assíncrno, pois o sinal de clock não é o mesmo para todos os flip flops, e sim o Q' do anterior
//Contador Síncrono é aquele que todos os flipflops recebem o mesmo clock


//Circuito instáavel é algum circuito que troca de valor toda vez que o circuito passa
    //Tipo encaderar 3 NOTS e conectar o fim com final
    //Ele não possui um estado definido


//Circuito SIPO
    //Entrada serial e saída paralela
    //Dá uma sequencia de pulsos, e dependendo do chaveamento vai soltando valores em linhas diferentes
    //Isso trasnforma os 001, em 0 em um fio, 0 em outro e 1 em outro fio


//Assincrono tipo T também
    //Clock de descida
//Todos os assincronos são de 2^n
//Sempre incrementações mútiplos de 2, nunca de 0 a 9 por exemplo
    //Dá pra colocar um clear que aciona quando chega em dado valor

//Várioas tipos de contador assincrono no slide
//Decrescente eu posso pegar simplemnte o inverte ro clock de de descida para subida
    //Tem dois tipos que contam sempre paenas até 2^n-1    
        //Sempre começam no zero para crescente ou terminar no zero

//Tem como alterar de crscente para decrescente
    //Adiciona um XOR do Clock em cada Q do clock anterior
    //Quanto pressinada essa entrada, vai inverter o clock, isso faz a subida virar descida.
    //Na pratica isso inverte quando o clock sobe ou desce, e inverte um contador de crescente para decrescente
    //(Não durante a contagem), é uma decisão de contagem antes


//Resetar o Contador
    //Tenho que ir até o ir até o valor desejado mais 1, pois o reset é quase instantâneo, então ele vai piscar o valor mais 1, invés de piscar o valor desejado
    //Isso é algum milésimo de precisão que perde (Por isso ele não é usado para precisão)
    //Então eu vejo qual é o valor+1 em binário e faço um AND (Com um NOR) com ele que leve até o Reset.
        //(Lembrando que o Reset ativa com 0)
    

    //O reset pode resetar um valor específico, isso faz com que eu possa ter contagens até valores específicos em como limite



//Contador Síncrono
    //Mesmo clock
    //Pelo funcionamento dos binarios, um digito de mairo valor só aparece quando os digitos anteriors forem 1
        //Isso descreve o sincronro, eu posso aplciar um encdeamento de flipflips, onde as saídas vão para um AND
        //Isso vai aumentar gradativavementeo valor, fazendo assim um contador com todo mundo no mesmo clock

        //Em baixo (Pegando pelo Q') você terá drecrescente e em cima (Pegando pelo Q) crescente



//Maquinas de Estado
    //Analisar problema analisando trasição de Flip-Flop
    //Indicar quais condições levam à determinado valor
    //Ex jk
    //Transição. Valor obrigatorio
    //0 pra 0, J é 0
    //0 pra 1, J é 1
    //1 pra 0, K é 1
    //1 pra 1, K é 0

//EP será de contador LOGISIM

//Máquina de transição em escala

    
