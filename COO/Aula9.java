//Herança
    //for no JAVA suporta a igual a do C, aquela for(inicialização; condição; atualização)
    //Contudo tem uma versão melhor que é o for(inicialização; vetor) sendo na inicialização delcarada uma váriável do  mesmo tipo do vetor, chamado de for each
        //Ele sempre vai do menor para o maior

    //Exemplo prático usando Produtos em uma loja
    
    //Modificador Extends
        //Ele é usado para criar uma nova classe que herda os atributos e métodos de uma classe existente
        //Isso evita redundância, repetição de código, facilita manutenção
        //A classe que herda é chamada de subclasse ou classe filha
        
    //Observação, lembrando que sempre deve-se tomar cuidado em fazer uma sobrecarga invés de sobrescrição 

    //No java, não tem um modificador de acesso que permita apenas as classes derivadas, o protected é o mais perto disso

    //This é referente a classe local
    //Super é referente a classe pai
        //Então Super() é o construtor da classe pai, chamada por padrão na calsse filha, caso ela não tenha (Ou não seja na primeira linha)
        //Isso dá muito problema, pois ele chama o Super() sem argumentos, então é sempre importante especificar ela


    //Ordem de inicialização dos construtores (E de todo contexo no geral) começa sempre pela classe pai
        //Isso é lógico, já que a classe filha pode depender da classe pai, mas nunca o contrário


    //Typecasting funciona como uma cópia, que alteara a maneira como o objeto será tratato (Ou qualquer varíavel)
    //Então eu posso ter a classe Produto, e ProdutoEspecifico filha da classe produto, então eu posso pegar o ProdutoEspecifico P, e criar Produto Novo = (Produto) P
        //Isso eu faço uma nova variável do tipo Produto, contendo os valores da varíavel P, e será tratado como uma.
            //Com isso o compilador permite que eu faça operações de Produto, mas não de ProdutoEspecifico, já que o compilador não sabe se é um ou outro, então eu posso ficar alterando o comportamento de um mesmo objeto
        //Se for o caso contrario (De produto para produto especifico) pode acontecer problemas, se tiver coisas que existem apenas no ProdutoEspecifico, ao transformar em Produto, ele perderá caractarística.
            //Exemplo, se eu chamar um Metodo de ProdutoEspecifico nesse caso, o programa vai quebrar
            //No java, caso for necessário fazer conversões incerteas, existe uma função chamada instanceof, que verifica se o objeto é do tipo desejado, e isso pode ser colocado em um if, para evitar problemas
                //InstanceOF não olha a maneira que ele foi declarado, mas como está de fato salvo na memória
public class Aula9 {
    
}
