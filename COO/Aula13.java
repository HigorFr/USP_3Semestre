public class aula13
{
    //Retomando delegação
    //Camadas de chamadas que entrarm em objetos dentro da propria calsse
        //Atributos podem estar dentro de objetos dentro da camada
        //Get/Set que chama métodos internos do objeto

        //Como uma cebola de classes, que o centro e o cerne, e cada nova camada adiciona funções/atributos

    //Imagine calsse Carro e classe motor
        //Carro tem o objeto motor, e o motor tem um monte de funções
        //Mas o usuario de carro não quer saber como o motor funciona
        //Mas o carro em sí fará chamadas para o motor para ele funcionar
    
    //Nesse caso a herança não faz o menor sentido, motor não usa metodos de carro nem vice-versa
        //Nem contextualmente, dá para falar que um motor é uma especie de carro ou vice-versa

    //OBS: Polimorfismo não é exclusivo da herança
        //As interfaces também têm o polimorfismo, existe aquele if que confere qual o tipo da função que foi mostrado nas aulas anteriores, e dependendo do tipo realizar uma ação diferente.


    //Código fica mais extenso quando eu uso esse sistema de delegação
        //Diferente da herença, que é mais direta. Isso causa um pouco de estranheza
        //Mas no geral ela substitui a herança, mesmo sendo mais burocratíca, ela consegue se rmais flexivel que a herança e aproveitar mais do polimorfismo. Isso não inutilzia a herença

    
    //Nova limitaçãpo
        //Usando delegação, eu fico limitado a todo "ProdutoContador" ter um "Produto" dentro
        //Tem como flexibilizar isso, para que ele englobe vários objetos
            //Então eu uso a Interface em comum como argumento, isso abre portas para eu colocar todos os "Produtos" ou "ProdutosX", sem sequer saber o tipo tipo deles, apenas que são da classe principal "IProdutos".

        //Então eu posso ter classes que atuam como camadas gênericas, aplicadas quantas vezes quiser em infinitas outras classes diferentes
            //E lembrando posso usar o instance of para distinguir objetos e tratar diferente,( Claro que o objetivo é usar isso Esporadicamente, ou nem faria sentido o polimorfismo)
        
        //Ex
        new Prodx(new prodCont(new Produto()));

        //E uma classe também pode possuir mutiplos objetos e a ordem da camada pode ser qualquer um
            //É como se fosse um leque de opções que você pode ir formando
            //Como se fosse uma "Herenaça Mútipla" (Coisa que o java não suporta)
            


}
