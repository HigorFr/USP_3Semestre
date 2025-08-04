#Memoria cache (ultimo conteudo da p1)

#Memória nunca é totalmente endereçada, ou seja, não é possível acessar todos os endereços de memória
    #Normalmente é tipo, algum dos extrememos, e bem pequeno
    #Outro ponto é que a memória acessada uma vez tem a tendência de ser acessada novamente

#Isso é o principio da localidade
    #Hierarquia de memórias
        
        #TIpos de memórias antigas:
        #SRAM
        #DRAM
        #DISCO MAGNÈTICO

        #Hirariquia:
            #Mais proximas do processador é mais rapida e cara (RAM)
            #Mais longe do processador é mais lenta e barata (HD)

        #Então sempre que o HD busca um dado, eu procuro na cache, se não estiver, sigo para RAM, e repito para o HD
        #CACHE -> PROCESSADO (PALAVRA)
        #RAM -> CACHE (LINHA)
        #HD -> RAM (BLOCO)


        #Conceitos
        #Bloco - 
        #Hit - DAdo acesso está na cache (Nìvel superiror)
        #Miss - Dado não está na cache (Nìvel superior)
        #Hit Ratio - Porcentagem de acertos
        #Miss Ratio - Porcentagem de erros (1-hit ratio) 
        #Hit time - tempo para descobrir se o dado está na cache ou não
        #Miss Penalty - Tempo para buscar o dado na memória principal (RAM)
            #Ou seja, não achei no cache, então vou buscar na RAM
        

        #O cache
            #Ele em sí é qualquer cosia entre RAM e processador
            #Toda vez que o processo chama algo, ele olha o cache, se não achar ele vai para RAM e salva na cache
            #Se a cache estiver cheia ele tem que tirar algo de lá
                #Tem varios algortiimos de substituição
                    #LRU - Least Recently Used
                    #FIFO - First In First Out
                    #Random - Aleatório
                    #LFU - Least Frequently Used
                    #MRU - Most Recently Used
                    #OPT - Optimal (Melhor)

                    #Mais comum é a que eu removo aquela que ainda não registrei na RAM

        #Para economizar memória e saber qual linha da RAM significa minha cache 
            #Eu uso o conceito de mapeamento
                #Direto - Eu pego o endereço e divido pelo tamanho da cache, e o resto é a linha da cache
                    #Ou seja, se em 64 bits eu tenho 4 bits no cache, todos os endereços que der 0, 4, 8, 12, etc vão para a mesma linha (São substituidos se vierem em seguida inclusive)
                    #Mas para eu saber qual linha das linhas (Se é 0,4,8) eu olho a TAG, que é o a outra parte do binário, (A sempre terei 2 bits para o cache, o resto é TAG nesse caso)
                    #Ao final, eu tenho vários endereços para a mesma linha, e a TAG para saber qual deles é, o processador sempre vai olhar se a TAG e a linha batem para ai puxar o conteúdo de fato da cache

                    #Ainda tem o bit de validade, que é Y ou N que me indidica algo se a linha é válida ou não, pois em casos que a memória é dinâmica, ela pode ser inválida (Desatualizada) e eu não posso usar, ou seja, tudo que tem N, o processador vai diretor na RAM
                                #Sempre que a cache é inicializada, tudo fica N por exemplo
        
                                #OBS tudo isso é arquitetura específica, ou seja, cada arquitetura tem uma forma diferente de fazer isso

                    #Ainda tem o deslocmento, que caso o processador não va ler a palavra inteira, ele salava especificamente o que ele vai usar.

                    #Depois que a tabelinha é feita, é muito simples, tem um circuito que confere se é tudo igual usando um AND e uma subtração, se for ele solta um 1 pra Hit. O processador nem terá acesso a essas informações, só vai tentar acessar.

                    #Ainda tem como calcular o tamanho da cache aplicando uma formula
                    #2^n * (Bits de daos + bits de tag - offset - n + bits de validade)
                    
                    #Toda palavra minha (intrução) ocupa 4 bytes, ou seja, 32 bits


                    #Então se eu tenho um cache com 64KB de dados, eu tenho 16k palavras (64KB / 4 bytes)
                    #Isso é 2^14 palavras, ou seja, a minha ta tag vai ser 32-14-2 = 16 bits
                    #Então a tag será 16, o dado mais 32 e o bit validador mais 1, totalizando 49 bits de espaço, isso no total é 98KB de cache no total (Sendo que o dado é só 64KB)

                    #Ou seja, eu tenho aproximadamente 50% a mais de informação só para endereçar, o que quero

            #Então tem um ciclo complexo que daz o cache funcionar se der miss
                #Toda vez que algo sai do PC, ele já vai procurar no cache e ir para proxima palavra (Ou seja PC+4) simuntaneamente (É um ciclo, ele vai aumentando 4 em 4).
                #Então se o cache der miss, eu não posso mais jogar o PC para procurar na memória RAM para procuar (Porque já aumentou 4 nesse clock), eu tenho que tirar 4 para voltar para o endereço original que eu estava

                #OBS: normalmente o cache nas notações é colocado como RAM direto, as vezes fica subentendido que entre a RAM e o processador vai ter um cache acontecendo e não é colocado.

                
                #Então salvo o que peguei da ram no cache e mando o processamento voltar com o dado que achei. (Ou seja, processador fica "parado" até o dado chegar)

                #Também vale ressaltar que no miss eu tenho que esperar o tempo da RAM, e isso é o STALL, (Não tem como como parar de fato o processador, é só um comando para fazer o processador não processar sem alterar nada).

        #Escrever
            #NA ram, arquitura meps, eu manipulo só a ram com LW e SW (Load word e Store word)
            #Na hora de relizar operação de variável tipo (A=A+B), eu perco tempo de clock para ficar atualizando a RAM (Já que o processdor vai atualizar o cache e eu preciso manter tudo atualizado)

            #Então uma das soluções e fazer um buffer de escrita. Tudo que eu quero que escrever eu mando para ele e ele resolve, e o processador pode continuar processando
                #Mas isso não vai ser tão simples, já que o barramento vai ficar ocupado com o buffer, o processador vai só funcionar enquanto tiver cache, depois disso ele vai dar miss, vai querer a RAM e não vai conseguir (Vai ter que esperar o buffer acabar de qualquer jeito)
                
            
            #Mas tem outro método, o write through, que é horrível, eu tento escrever a todo momento na RAM, isso é calculável e dá 2.5 ciclos para escrever do que o 1.2 na média que era o padrão






                