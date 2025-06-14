//Barramento e cache
//Depois Exercicios citados


//Bararmento é um canal entre componentes
    //Caminho entre dados
    //Estrutura e Hierarquia

    //Dados - Caminho para mandar dados (Bidirecional)
    //Endereço - Localização do dado (Direção única)
    //Controle - Outros (Biderecional)

    //Dois Registradores de Exemplo
        //MDR - Registrador de dados da memoria
        //MAR - Registrador de endereço da memoria
    
    //Hierarquia - Barramento é um canal entre componentes
        //Diferentes para cada componente
        //Tem internos (Dentro do dispositivo, tipo do HD), chamado de locais
        //Tem os do externo (Entre dispositivos, tipo do HD para a RAM), chamado de globais

        //Ex barramento de extensão (Conecta PCI)
    
    //Mas alguns barramentos funcionam em clocks diferentes, então precisa de pontes (bridges) para conectar os barramentos
        //Essas pontes são chamadas de bridges, e elas convertem os sinais de um barramento para outro
        //Exemplo: PCI para PCI express, ou PCI express para PCI express 2.0
        //Ou seja, a bridge é um conversor entre barramentos


//Memória Virtual
    //Antigamente, alguns programas necessitavam de muita memória, e não tinha como denreçar tudo na RAM
    //As vezes a memoria (RAM) ficava fragmentada, e não valia a pena desfragmentar (Nesse caso é "Compactar") para achar mais espaço.
        //Como isso era muito lento foi inventado a divisão em páginas, e os programas não precisavas ser contínuos na memória, era só falar onde começa e onde termina em uma "Tabela de páginas" separada
        //As páginas eram pequenas, pois todos os programas ia ganhar ao menos uma. 
        //FAT 32

        //Mas o problema é que pelas páginas serem pequenas, a tabela ficava na RAM permanentemente e ocupavam muito espaço para serem endereçados, e tinha que ter uma tradução

        //FOra que se ela não tivesse mapeada na página, ela jogava no disco, e guardava um bit para falar onde está

    
    //Processador tinha uma TLB que guardava algumas que estou usando atualmente

    //Isso muda o funcionamento da busca de memoria

    //1- Processador olha se na TLB já tem a página do endereço que eu quero
    //2- Se não tem o endereço da TLB, olha a Virtual memory para ver qual página está na memoria RAM.
    //3- Traduzio na RAM? Então eu olho a cache para ver se já lá o que eu quero. 
    //4- Se não está na memoria RAM, ta em disco.

    //TLB fica no processador, Cache fica entre o processador e a memoria ram (separada) e a Virtual memoery é a tabela na memória RAM

    //A TLB sempre fica sincronizada com a Virtual Memory, é como se fosse um pedaço dela já guardada no processador para acelerar

    //3 Tipos de miss então
    //Miss de não achar na cache
    //Miss de não achar na TLB
    //Miss de VIrtual memory (Ela está em Disco)

    //Algumas combinações são impossíveis


//Mapeamento direto
    //Não precisa calcular o índice (hardware barato)
    //Procura simples
    //Não precisa calcular quem substitui

    //Mas pode acabar aproveitando mal o espaço


