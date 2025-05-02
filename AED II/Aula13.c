//Primeira aula que falto do digi
    //Bascimente foi introdução aos arquivos:








    
//Exemplo do Professor



#include <stdio.h>
#include <stdlib.h>    

#define T_nome 30
#define T_nusp 10
#define T_ano 4
#define T_email 25

typedef struct{
  char nusp[T_nusp];
  char nome[T_nome];
  char anoDeIngresso[T_ano];
  char email[T_email];
} PROF;

PROF novoProfessor(char* nusp, char* nome, char* ano, char* email){
  PROF novo;
  int x = 0;
  while (nome[x]){
    novo.nome[x] = nome[x];
    x++;
  }
  for (;x<T_nome;x++) novo.nome[x] = ' ';
 
  x = 0;
  while (ano[x]){
    novo.anoDeIngresso[x] = ano[x];
    x++;
  }
  for (;x<T_ano;x++) novo.anoDeIngresso[x] = ' ';

  x = 0;
  while (nusp[x]){
    novo.nusp[x] = nusp[x];
    x++;
  }
  for (;x<T_nusp;x++) novo.nusp[x] = ' ';
 
  x = 0;
  while (email[x]){
    novo.email[x] = email[x];
    x++;
  }
  for (;x<T_email;x++) novo.email[x] = ' ';
  return novo;
}

void imprimirProfessor(PROF* prof){
  int x;
  for (x=0;x<T_nusp;x++) printf("%c",prof->nusp[x]);
  printf(" ");
  for (x=0;x<T_nome;x++) printf("%c",prof->nome[x]);
  printf(" ");
  for (x=0;x<T_ano;x++) printf("%c",prof->anoDeIngresso[x]);
  printf(" ");
  for (x=0;x<T_email;x++) printf("%c",prof->email[x]);
  printf("\n");
}

void salvarEmArquivo(char* nomeDoArquivo, PROF* prof){  
  FILE *arq;
  if (!(arq = fopen(nomeDoArquivo, "w"))){
    printf("Nao foi possivel abrir o arquivo de saida: '%s'\n", nomeDoArquivo);
    exit(1);
  }
  fwrite(prof, sizeof(PROF), 1, arq);
  fwrite("\n", 1, 1, arq);
  fclose(arq);  
}  

void adicionarEmArquivo(char* nomeDoArquivo, PROF* prof){  
  FILE *arq;
  if (!(arq = fopen(nomeDoArquivo, "a"))){
    printf("Nao foi possivel abrir o arquivo de saida: '%s'\n", nomeDoArquivo);
    exit(1);
  }
  fwrite(prof, sizeof(PROF), 1, arq);
  fwrite("\n", 1, 1, arq);
  fclose(arq);  
}  


void lerArquivo(char* nomeDoArquivo){
  FILE *arq;  
  char c;
  if (!(arq = fopen(nomeDoArquivo, "r"))){
    printf("Nao foi possivel abrir o arquivo de entrada: '%s'\n", nomeDoArquivo);
    exit(1);
  }   
  printf("\nExibindo conteudo do arquivo: '%s'\n", nomeDoArquivo);
  char* buffer = (char*)malloc(sizeof(PROF)+1);
  while (!feof(arq)){
    if (fgets(buffer, sizeof(PROF)+1, arq)){
      imprimirProfessor((PROF*)buffer);
      fgetc(arq);
    }
  }   
  fclose(arq);  
}

int main(){
  PROF digi = novoProfessor(" 3140792", "Luciano Antonio Digiampietri", "2008", "digiampietri@usp.br");
  imprimirProfessor(&digi);
  salvarEmArquivo("TamanhoFixo.txt", &digi);
  lerArquivo("TamanhoFixo.txt");
  printf("\nCriando novos professores.\n");
  PROF norton = novoProfessor("12345678", "Norton Trevisan Roman", "2010", "norton@usp.br");
  imprimirProfessor(&norton);
  adicionarEmArquivo("TamanhoFixo.txt", &norton);
  PROF daniel = novoProfessor(" 7654321", "Daniel de Angelis Cordeiro", "2015", "daniel.cordeiro@usp.br");
  imprimirProfessor(&daniel);
  adicionarEmArquivo("TamanhoFixo.txt", &daniel);
  lerArquivo("TamanhoFixo.txt");
  return 0;
}

