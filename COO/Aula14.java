public class Aula14 {
    //Java em sí

    //Retomando, coisas a lembrar
        //Super - Chamar métodos da superclasse
            //Inclusive ao proprio contrutor
        //this - Chamar métodos da propria classe
    
    //Uma classe só tem um Super, nada mais, nada menos
    
    //Classes default que não derivam de nada
        //Clone() - Clona o objeto, mas não é garantido que ele seja igual ao original, só que é um clone
        //equals() - Verifica se o objeto é igual ao outro, mas não compara os atributos, apenas se são o mesmo objeto
        //toString() - Retorna uma string com o nome da classe e o hashcode do objeto, não é garantido que seja igual ao original, só que é um clone
        //Entre outros

        //Ex de clone
        //Produto p1 = new Produto("Produto 1", 10.0, 5);
        //Produto p2 = p1.clone(); // Clona o objeto p1

        //Assim como no toString:
            //Produto p1 = new Produto("Produto 1", 10.0, 5);
            //System.out.println(p1.toString()); // Imprime o nome da classe e o hashcode do objeto p1

        //O toString acontece implicitamente quando você imprime o objeto, então não precisa chamar ele diretamente

        //Mas na hora de imprimir você vai vert o tipo do objeto e o hashcode dele, não os atributos
            //Mas isso é muito útil, pois eu sei que toda classe terá isso
            //Então eu posso sobrescrever o toString para imprimir os atributos que eu quiser, e não só o nome da classe e o hashcode
            //E isso é muito útil para debugar

        //Ex:
            public String toString() {
                return "Produto: " + nome + ", Preço: " + preco + ", Quantidade: " + quantidade;
            }
            //Dentro de produto






        //O Equal um pouco mais importante, também padrão
            //Ele observa se dois objetos são iguais
            //Compara os endereço, se são iguasi é True, e se não, é false
            //Isso é basicamente um == para objetos (Mas cuidado, pois o == nem sempre é compração de objetos)
                //Obs o == em primitivos nunca é endereço
                //Cuidado com "=" que é atribuição (Em C, é possível retornar atribuição, java não deixa)

            //Aqui também podemos sobrescever o método herdado padrão dependendo do que eu quero
                //Normalmente ele é usado para comparar objetos do mesmo tipo
                //Também posos usar para comparar os valores dos atributos, e não o endereço
                
        
        //CLone
            //Ideia de criar uma nova instância de um objeto
            //Diferente dos outros métodos, o clone não é garantido que seja igual ao original
                //Depende dro crítério escolhido 
            //Logo também há maneiras de editar ele para implementações específicas
            
            //Por exemplo, se quero clonar A e ele tem o filho B, o clone de A não vai ter o filho B, só A por padrão
                //E isso pode estar errado, posso querer que o clone de A tenha um clone filho B também
                //Ou posso querer que o clone de A tenha um ponteiro para o mesmo B original
                //Tudo isso depende

            //Normalment o clone tem acesso travado
                //Então tem como substituir o clone geral usando a classe Object
                //Ex
                public Object clone() {
                    return super.clone(); // Chama o método clone da superclasse
                }


                
}
