
//Outras formas de indexar 


//Lista ligada, dessa forma eu não preciso ficar desfragmentar os blocos
//Eles não são sequenciais, cada bloco indica o próximo
//Lembrnado o bloco tem o endereço e os registros dentro
//Assim que é feito 


//Em uso de espaço a Vantagem é que eu não tenho fragmentação no disco, mas a desvantagem é que ocupa um pouquinho para armazenar o endereço
    //Mas essa desvantagem é ínfima

//Contudo na leitura, isso vai afetar bastante pois para ler todos os registro eu vou precisar de muitos seeks


//Na hora de inserir, eu também posso ter o problema de empurar todo mundo um para frente, mas agora eu posso simplesmente enderçar o bloco que estaria no meio para outro lugar aleatório do disco e conectar o próximo com outro endereço.
//Isso fica O(1) considerando que eu já tenha o endereço do bloco onde quero inserir

//No geral todas as outras operações vão ser O(1) + a Busca, e como a busca é muito lenta, eu preciso achar um jeito de  fazer ela mais rápida, ou essa "Arquitetura" vai ser ínutil


//Busca 
//Muito lenta de maneira crua, então foi feita a FAT 32, uma tabela que fica na memória principal (RAM) que guarda o endereço de cada bloco, de maneira como uma "Lista ligada em um arranjo normal" que vimos em AED I
    //Nela eu vou guardar a ordem dos blocos, então fazer uma busca binária a busca binária fica rápida na RAM, e isso acelara a busca muito

//Problema: Ela sozinha também tem algo muito desvantajoso, na época que foi inventado ela, o disco era muito pequeno, então a tabela ocupava pouco espaço na memória principal
//Atualmente com discos de 1TB, ele quase não consegue sequer endereçar tudo, e ainda oucupa 4GB de RAM





//No brasil, era proibido importar computadores até 1993, então os computadores que chegaram pós isso tinha muito 


//Alocação indexada



//Como criar indices pela ordem física e pela ordem de outros campos
    //


    //Perdi muita coisa aqui no meio da aula



//Indice Secundário
    //Suponde que fisicamente está tudo ordenado por ordem alfabetica e agora quero consultar por ID
    //Nesse caso eu vou ter guaraddo uma tabela ordenada pelo ID contendo o endereço de cada registro
        //Isso permite que eu faça uma busca binária, mais rápida

    //Isso se repete para todos os campos, para cada valor de chave


//Organização Multinivel
    //É como se eu tivesse várias tabelas de range de índices, e um índice secundário que endereça cada uma das tabelas, é o mesmo principio da arvore binárias, ele vai excluindo valores fora do range conforme vou aprofundando os níveis
        //Pode der n numero de níveis, isso vai far loga(r1) onde A é o numero de registro que cabem no bloco e r1 é o número de registros no nível 1
            //Problema, as Âncoras de cada níveis vão ter qeu ser alterados toda vez que eu alterar/remover algum valor
                //Da pra resolver isso, nas proximas aulas veremos



















//IDEIA: Organização que condiz o dado com o endereço para economizar processamento