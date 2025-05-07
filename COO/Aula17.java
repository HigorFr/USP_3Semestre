public class Aula17 {
    //Continuação tratamento de exceções
    
    //Objetivo no final basciaente é não quebrar o código, manter ele rodando mesmo com situações inesperadas, e separar tratamento de erro do código esperado.
    
    //Retorno não é bom ter uma sobrecarga de função, como por exemplo devolver se deu erro
        //Normamente é só para retornar o valor para função pai
        //Então return -1 em java, é algo mal visto.

        //Try então é bloco onde eu tento executar o código limpo, sem me preucupar com erros
        //Catch é o bloco onde eu trato o erro, ou seja, eu vou executar o código que está dentro dele se der erro no try
        
        //Throw é para lançar uma exeção manualmente que você fez, e ainda você pode configurar o catch para capturar ela (Note que nada abaix do throw vai ser executado, pois ele interrompe o código ali mesmo)

        //Exemplo aqui, ele não vai retornar o X se for fora de 0 a 10:
        public static double ledouble() throws Exception {
            //Preciso do throws Exception, pois eu indico que talvez essa função mande exceção
            
            if(x < 0 || x > 10) throw new Exception("Valor inválido" + x);
            return x;


        //aqui eu trato o do ledouble, se eu não tratar da maneira certa ele não vai compilar (Mesmo se não sequer ele foi chamado)
            catch(Exception e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace(); //Esse método imprime o Callstack onde está o erro, isso facilita muito na hora de identificar o problema

                //Nesse caso "Exception" é um tipo de erro genérito, ou seja, ele ta pegando vários tipos de erros que dá e rodando esse código, contudo tem outros erros mais específicos que podem ser tratados, tipo IOException, etc..
                    //Se a exceção lançada não bater com esse catch ele simplesmente não executa.

                  
                return 0

            }
        }

        //Supondo que eu precise uma exceção específica, onde eu carrego mais informações sobre o problema eu posso criar minhas próprias exceções customizadas

        //Em programas pequenos, o uso de tratamentos de erros muito específicos pode não ser necessário, já que é possível simplesmente reiniciar o programa. 
        //No entanto, em sistemas complexos com callstacks muito profundos, reiniciar o processo inteiro pode ser inviável. 
        //Nesses casos, faz sentido implementar tratamentos de erros mais detalhados e específicos para garantir a continuidade do programa.

        //no final invés de colocar um switch case eu tenho vários catchs, onde cada um trata um erro diferente, e o último é o genérico (catch(Exception e)) que pega todos os erros que não foram tratados antes.

        //Exemplo

        class notaForaDoIntervaloException extends Exception {
            public notaForaDoIntervaloException(double x) {
                super("Nota fora do intervalo: " + x);
            }
        }

        //Mas lembrando que se eu fazer algo especifico eu posos acabar tendo erros não esperados sem tratamento, mas se for muito generico eu posso acabar tratando erros que não eram para serem tradas daquela maneira

        //lembrando que Expepcion é uma classe no fim, mas eu não posos sair dando throw em tudo, normalmente eu extendo uma classe dela para criar meu problema. 
        //Ela não é a classe pai dos problemas. A pai é "thowable", que tem exception e error como filhos. Erros são mais raros, coisas críticas que não há o que fazer (tipo falta de memória, etc..), enquanto as exceções são mais comuns e podem ser tratadas.

            //Exception também é dívida em várias partes, entre elas tem as runtime exceptions, que são erros de execução, ou seja, erros que só aparecem quando o programa está rodando (Exemplo: NullPointerException, ArrayIndexOutOfBoundsException, etc..) e as outras.
                //As runtime são chamadas de unchecked exceptions, ou seja, não precisam ser tratadas, mas é bom tratar elas para evitar problemas futuros.
                //As outras (inclusive os erros eu acho) são chamadas de checked exceptions, ou seja, precisam ser tratadas, caso contrário o código não compila. (Exemplo: IOException, SQLException, etc..)

            //Todas as runtime exceptions são culpas do programador, ou seja, são erros de lógica, enquanto as outras podem ser erros de execução que não são culpa do programador (Exemplo: Arquivo não encontrado, etc..).

            //sempre é uma escolha do programado colocar ou não throws, as vezes não vale a pena


            


}  

