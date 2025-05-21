
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
    //São atributos que não podem ser alterados, estáticos, diferente no C que são pré processados e substituidos


    //Contudo fazer essa parametrização (Através de um IF, ou Switch) fica meio merda
        //Também da pra usar sobrecarga para fazer argumento opcional (Caso o parametro exija, mas fica ruim do mesmo jeito)
        //Sempre que tem uma sequência muito grande de IFs ou Switchs, é um sinal de que o código não está bom
    
    //O jeito mais correto é colocar um objeto interface que irá me trazer todas as informações para a função como único parametro
        //Classe Interface "Critério", que será usada para implementar outras classes para cada parametro
            //Nesse caso vou ter um Class AreaCircuco Implements Criterio, Class AreaQuadrado Implements Criterio etc...
            //Todas elas terão métodos próprios para implementa um resultado proprio (Que nesse cario é um inteiro representando a área)    
        //Esse objeto "critério" da classe critério será o parametro da função, e já retornará o valor da área
        //Isso ajuda a generalizar

    //Modificador "Implements"
        //A classe que implementa a interface é obrigada a implementar todos os métodos da interface
        //Então fica Classe Utilizadora implements Interface
    
    
}
