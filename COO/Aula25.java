public class Aula25 {
    

    //Continuando aula de mapas (particularmnete essa é a terceira aula e eu ainda não entendi nada)

    //Mapa é mais simples que muitas outras coleções, mas pode ser facilmente substitido
        //Por exemplo, guardar quantidade de letras de uma palavra, poderia ser um Map<Character, Integer> onde a chave é a letra e o valor é a quantidade de vezes que ela aparece na palavra

        //Entrada e saída em java.


        //Principalemnete gerenciando pela entrada STD IO do java.
            //Fluxos de dados em geral, tudo com relação ao arquivo ou à saida do terminal.
            //O proprio printi do System.out.println() é um fluxo de dados, que escreve na saída padrão do sistema, que é o terminal.
            //Vamos estudar a arvore  de classes que definem essas funções padrões do java

        //Read() - Ler dados de um fluxo de entrada
        //Write() - Escrever dados em um fluxo de saída
        //Elas são implementadas por meio de classes que representam os fluxos de dados, como InputStream e OutputStream para fluxos binários, e Reader e Writer para fluxos de caracteres.
            //Elas são classes abstratas, ou seja, regem o compartamento mais básico de entradas e saídas


        //BufferedReader e BufferedWriter é para ler e escrever dados de forma eficiente, usando buffers para melhorar o desempenho
            //Ele acumula uma fila de alterações de arquivos, para jogar tudo de uma vez, que é amis eficiente do que ficar chamando a memória toda hora.

        //Zip é para compactar o numero de bytes que está sendo escrito

        //Note que essa calsses estendem a classe Reader e Writer, que são classes abstratas que definem os métodos básicos para ler e escrever caracteres
            //Contudo elas não especificam de fato, não é uma extensão direta, é como se fosse algum outro tipo de classe completamente, ela acrescenta pouco. As vezes é só para agrega-las em um mesmo lugar.

        //Se eu precisar de várias dessas coisas simultanemanete, tipo algo em buffer e compacto (Buffer e Zip) você vai simplesmente encadear as classes (Como se fosse um composição). Desse modo o buffer receberia algo que já passou le afunção ZIP. É como um decorar (Cascas em torno de um objeto)


        
        





}
