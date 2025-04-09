public class Aula12 {
    
    //Composição
    //Resolve problemas semelhante a da Herança
    //Normalmente combinada com interface

    //Continuando aquele problma, eu poderia ter um critério do tipo "Conferir se é par" que pega da interface critério
    //Se eu fosse criar a classe "Impares", invés de fazer outra extensão do critério, eu poderia simplesmente herdar uma calsse da par, chamar a "Verifica" da Super, e inverter a resposta

    //Mas ainda tem uma maneira de deixar isso mais estruturado
        //Eu poderia criar já objeto dos impares no Par (Ou vice-versa)
        //Então para generalizar ainda mais eu posso criar um método que nega qualquer resposta, tendo como paramento um critério (Ou sejam, método de "critério" que recebe "critério")
            //Isso que irá fazer eu não precisar de herença, eu posso só encadear os métodos

        //Logo eu posso fazer combinações dessas classes para impedir redundância
            //Ex: Eu posso as classes "Menor ou Igual" e "Igual à"  
            //Não faz sentido eu criar uma classe para "Maior que" e "Diferente de", pois elas seriam a mesma coisa, uma Inversão da classe da pai.
            //Ex VeficiarNumeros(Not(Menor_ou_igual_a(K))){
            //  Função aki
            //}
            //Mesma coisa seria para um AND, para um OU etc...

        //Lembrnado que continua tendo alguams limitações, por exemplo, não tem SUPER.SUPER, ou seja, não consigo chamar métodos do AVO (Pois isso permitiria herança mútiplas, e o Java não tem)
            //Um "Entre" por exemplo exigiria o Maior e menor que simuntaneamente


        //A herença no caso do produto valeu a pena pois de fato eu usei a implementação herdada, e também pois havia uma clara hierarquia entre as classes. É nesses casos que devo usar herança
            //Contudo também era bem plausível criar a classe Produtocontador como uma classe que engloba o Produto.
                //As unicas modificações seriam adicionar o objeto Produto dentro dele, e redirecionar (Nome certo é Delegar) dos getters do ProdutoContador para os getters do Produto (que seria um objeto interno)
                    //Ou seja, os getters dele são só um intermediador
                //Mas nesse caso não haveria polimorfismo, e teria outras desvantagens de orginização
}




