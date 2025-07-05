#include <stdio.h>
#include <stdlib.h>

#define MAX_TAM 100 //Para não dar overflow


// Função auxiliar proprio para o quicksort (Indo como referência o material de AED I)
void quicksort(float *v, int ini, int fim) {
    if (ini >= fim) return;

    float pivo = v[fim];
    int i = ini - 1;

    for (int j = ini; j < fim; j++) {
        if (v[j] < pivo) {
            i++;
            float temp = v[i];
            v[i] = v[j];
            v[j] = temp;
        }
    }

    float temp = v[i + 1];
    v[i + 1] = v[fim];
    v[fim] = temp;

    quicksort(v, ini, i);
    quicksort(v, i + 2, fim);
}

// Função de ordenação principal que a main  vai chamar 
void ordena(int tam, int tipo, float *vetor) {
    if (tipo == 0) {
        // Insertion Sort (também como referência o material de AED I)
        for (int i = 1; i < tam; i++) {
            float chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }
    } else quicksort(vetor, 0, tam - 1);
}

//Função em sí
int main() {
    FILE *arquivo = fopen("entrada.txt", "r");
    float numeros[MAX_TAM];
    int qtd = 0;

    while (fscanf(arquivo, "%f", &numeros[qtd]) == 1 && qtd < MAX_TAM) {
        qtd++;
    }

    fclose(arquivo);

    printf("Lidos %d números:\n", qtd);
    for (int i = 0; i < qtd; i++) {
        printf("%.2f\n", numeros[i]);
    }


    int tipo = 1; //Aqui define o tipo, 0 para quick, 1 para o insertion

    ordena(qtd, tipo, numeros);

    printf("\nValores ordenados:\n");
    for (int i = qtd-1; i >= 0; i--) {
        printf("%.2f\n", numeros[i]);
    }

    return 0;
}
