//Já teve introduão dos arquivos, descrever cada um depos

//Códigos
//Básicos


//OBS maioria das funções vem da bilblioteca STDIO
//Gravação e leitura em arquivos de texto
//Ex
#include <stdio.h>
#include <stdlib.h>
void salvarTexto(char *nomeArquivo, char *texto) {
    FILE *arquivo = fopen(nomeArquivo, "w"); // Abre o arquivo para escrita (Ou seobrescreve), Se eu abrir no modo A, eu posso abrir no modo de incremento e apenas aficionar o texto no final do arquivo
    if (arquivo == NULL)  {
        printf("Erro ao abrir o arquivo para escrita.\n");
        return;
    }
    fprintf(arquivo, "%s", texto); // Escreve o texto no arquivo (FIlE Printf)
    fclose(arquivo); // Fecha o arquivo
}

//Agora ler arquivos

void lerArquivo(char *nomeArquivo) {
    FILE *arquivo = fopen(nomeArquivo, "r"); // Abre o arquivo para leitura ()
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo para leitura.\n");
        return;
    }
    //Aqui está sendo feito como char, mas poderia ser feito com string
    char linha[256]; // Buffer para armazenar cada linha lida
    while (fgets(linha, sizeof(linha), arquivo) != NULL) { // Lê cada linha do arquivo (Poderia ser EOF invés de NULL)
        printf("%s", linha); // Imprime a linha lida
    }
    fclose(arquivo); // Fecha o arquivo 
}

//Salvando com Fwrite (texto, tamanho informção, quantas informções, aruivo)
    //Lembrnado que é sempre endereço do texto caso for estrutura
    //Nele invés de fazer um laço usanodo o fprintf, eu especifico um bloco inteiro que será salvo no arquivo (Ele calcula a quantidade de bits usando o N e o tamanho do tipo de dado)


//Printando pelo fgetc, eu consigo ler caractere por caractere, e o EOF é o final do arquivo (Ele não é um caractere, é uma constante que indica o fim do arquivo).
    //ELe usa uma infomação dentro da estrutura FILE, que pegar sempre o próximo caractere até o -1 (EOF).






//Gravação e leitura em arquivos binários com estruturas complexas (Grafos por exemplo)
    //Matriz de adjacência
void salvagrafo(char *nomeArquivo, Grafo *grafo) {
    FILE *arquivo = fopen(nomeArquivo, "wb"); // Abre o arquivo para escrita em binário
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo para escrita.\n");
        return;
    }
    int i, j;
    fprintf(arquivo, "%d %d\n", grafo->numVertices, grafo->numArestas); // Grava o número de vértices e arestas, pode ser só vértice na verdade que é o mais importante (que nem o prof fez)
    for (i = 0; i < grafo->numVertices; i++) {
        for (j = 0; j < grafo->numVertices; j++) {
            fprintf(arquivo, "%d ", grafo->matrizAdj[i][j]); // Grava a matriz de adjacência
        }
        fprintf(arquivo, "\n"); // Nova linha para cada vértice
    }
    fclose(arquivo); // Fecha o arquivo
}



//Leitura de grafo
void leGrafo(char *nomeArquivo, Grafo *grafo) {
    FILE *arquivo = fopen(nomeArquivo, "rb"); // Abre o arquivo para leitura em binário
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo para leitura.\n");
        return;
    }
    int i, j;
    fscanf(arquivo, "%d %d\n", &grafo->numVertices, &grafo->numArestas); // Lê o número de vértices e arestas
    for (i = 0; i < grafo->numVertices; i++) {
        for (j = 0; j < grafo->numVertices; j++) {
            fscanf(arquivo, "%d ", &grafo->matrizAdj[i][j]); // Lê a matriz de adjacência
        }
        fscanf(arquivo, "\n"); // Nova linha para cada vértice
    }
    fclose(arquivo); // Fecha o arquivo
}

//Na implementação do prof ela cria a matriz já na função com tudo zero, e só sobrescreve quando  = 1 
//ai ele tem que contar as arestas uma por uma já que não tem o número de arestas no arquivo dele


//Tem como compressar esse arquivo, afinal são bytes
    //Eu junto os bytes (8 bites) e coloco em um inteiro 
    //Sempre quando compresso eu tenho ganhos e perdas, nesse caso eu vou economizar memória secundaria mas vou perder entendimento do arquivo como pessoa(O que nem sempre é um problema)

    //Descompactar é também uma perca de processamento por exemplo

    //Compactações são muito complexas, exigem calculos matemáticos que pessaos tiveram que pensar muito nisso. Basicmaente é dimuir redundância.



//Gravação e leitura em arquivos binários
//Funções sofisticadas, na lousa

//Registros
//Começando com tamanho fixo
//Exemplo professor nos slides


//No geral eu não preciso salvar individualmente salvar cada atributo ou registro, eu posso salvar como um bloco de memória e depois na hora de ler eu dou um type cast (ou seja, eu transformo o bloco de memória no tipo que eu desejava).
//Então eles salvam os bites que compunha o registro/esteutura, mas continua sendo a mesma coisa "fisicamente", então o typecast só muda a maneira como interpreto os dados



//Obs diferente do fprint, o fwrite ele funciona muito bem para coisas binárias ele quando salva uma estrutura, ele olha o tamanho do tipo de cada atributo dela e salva o número de bytes correspondente, então não precisa fazer laço para salvar cada atributo.
    //Independente se o valor é 1, ou 2, ele vai salvr 64 bits (em uma arquitetura de 64 bits por exemplo) 
    //AVISO, se a estrutura tiver um ponteiro, ele não vai salvar o que está no ponteiro, ele vai salvar o endereço do ponteiro (que é o que ele tem acesso), então não é uma boa prática usar ponteiros em estruturas que serão salvas em arquivos binários. 
    //Não faz sentido salvar o endereço de um ponteiro, já que o endereço pode mudar de execução para execução, então não faz sentido salvar o endereço de um ponteiro em um arquivo binário.
