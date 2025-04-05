
public class Aula11 {

    //Voltando um pouco para interface
    //É um "Contrato" que a classe tem que seguir



//Problema novo
    //Métodos semelhantes em uma mesma classe
    //    //Exemplo: calcular a área de um círculo e de um quadrado

    //Criar métodos diferentes para cada forma? Ou criar um método genérico?~
    //O jeito mais fácil é criar métodos diferentes para cada forma, mas isso não é uma boa prática de programação
    //O jeito mais correto é criar um método genérico, que vai receber o tipo da forma como parâmetro e calcular a área de acordo com o tipo da forma
        //Ou seja, um novo argumento que dirá de qual forma a função funcionará 
        //Esse tipo de argumento é parâmetro (ele define funcionalidade)
            //Isso faz parte do principio SOLID, (Nesse caso é o O, de Open/Closed Principle)
                //Open CLosed (Abertas para extensão e fechadas para modificação)
                //Capaz de adicionar novas funcionalidades sem modificar o código existente
    //Constantes no Java
    //São atributos que não podem ser alterados, estáticos, diferente no C que s    ão pré processados e substituidos


    //Contudo fazer essa parametrização (Através de um IF, ou Switch) fica meio merda
        //Também da pra usar sobrecarga para fazer argumento opcional (Caso o parametro exija, mas fica ruim do mesmo jeito)
        //Sempre que tem uma sequência muito grande de IFs ou Switchs, é um sinal de que o código não está bom
    
    //O jeito mais correto é colocar um objeto interface que irá me trazer todas as informações para a função como único parametro
        //Classe Interface "Critério", que terá ter uma classe para cada parametro (tipo de função)
            //Nesse caso vai ser à formula de area
        //A função não vai saber o que está dentro do critério

    //Modificador implements 
        //A classe que implementa a interface é obrigada a implementar todos os métodos da interface
        //A interface não pode ser instanciada, apenas as classes que implementam a interface podem ser instanciadas
        //A interface pode ter métodos abstratos e métodos concretos (com implementação)
        //A classe que implementa a interface pode ter métodos concretos e métodos abstratos (sem implementação)
        //A classe que implementa a interface pode ter atributos e métodos concretos e abstratos (sem implementação)
        //A classe que implementa a interface pode ter construtores, mas não pode ser instanciada diretamente


}
