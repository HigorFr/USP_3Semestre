import java.io.IOException;

public class Aula18 {
    //Continuando o tratamento de erros

    //Existe uma stack em chamadas de erros, eu posso carpturar um erro em métodos/classes mais acima, e não só no método que deu erro, para isso eu uso o try catch, onde eu coloco o código que pode dar erro dentro do try e o código que vai tratar o erro dentro do catch.


    //Eu posso ir fazendo diferentes tratamentos conforme o erro sobe a árvore de call, catchs repetidos com cada um fazendo alguma coisa (E ir mandando throws)
        //Talvez isto esteja errado porque eu não estou presntando atenção na aula


    //Isso torna isso mais flexivel, você pode ter vários catchs para várias exceções diferentes, um catch genérico para todos

    //Também o compilador não deixa o catch genérico ficar antes do específico, pois ele não vai compilar, pois o específico já pega o erro e o genérico nunca vai ser chamado. (Exception already catched)

    public static void metodoGenericoInverte() throws IOException {
        try {
            metodoEspecificoInverte();
        } catch (IOException e) {
            System.out.println("Tratamento específico no metodoGenericoInverte: " + e);
        }
    }

    public static void metodoEspecificoInverte() throws IOException {
        try {
            throw new IOException("Erro específico invertido");
        } catch (Exception e) {
            System.out.println("Tratamento genérico no metodoEspecificoInverte: " + e);
            //throw e;  // relança para metodoGenericoInverte tratar especificamente
        }
    }


 public static void main(String[] args) {

        System.out.println("\nTestando: tratamento genérico dentro do método específico");
        try {
            metodoGenericoInverte();  // tratamento genérico dentro do metodoEspecifico
        } catch (IOException e) {
            System.out.println("Exceção capturada no main: " + e);
        }
    }

}