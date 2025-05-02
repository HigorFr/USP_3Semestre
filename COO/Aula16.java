public class Aula16 {

    //Finalizando pacotes
    //Resumindo aula anterior

    //Todas as classses no mesmo pacote ficam visíveis entre si sem precisar de importação
    //Clsses padrões (Object, String, Tipos Primitivos, etc) são sempre visíveis
    //Classes de pacotes em pastas diferentes precisam de importação

    //O caractere asterisco (*) é um caractere curinga que significa "tudo" na importação
    //Pasta1.Pasta2.*; Importa tudo da Pasta2 que está dentro da Pasta1

    //Nunca rodar fora da pasta main, pois isso impede o compilador de resolver os caminhos (Nomes de pacotes)

    //Classpath é o caminho onde o compilador vai procurar os pacotes (Ele é uma variável do ambiente/compilador)
    //Posso usar o classpath como argumento também na hora de chamar o compilador (Por padrão ele usa o caminho do CMD)

    //Sempre tenho que definir o nome do pacote no começo do arquivo então ex
    //Caminho/meupacotes/principal.java não vai funcionar, pois o compilador não vai saber qual pacote
        //O certo seria Caminho/ meupacotes.principal.java, dese modo ele vai saber o pacote que el epertece

    //A estrutura varia pode ser .:../ que significa ./ ou ../ simultaneamente
        //Isso permite ele contrar mutiplas raizes de pacotes
        //Útil para integrar projetos diefenretes separados

    


    //Relembrando visibilidade
        //Publica, TODOS vêem, mesmo fora do pacote (Só precisa de importação e funciona
        //Pirvada, nenhum arquivo vê, nem mesmo do mesmo pacote (Só funciona dentro do arquivo e da mesma classe)
        //Default, só vê quem está no mesmo pacote (Só funciona dentro da mesma pasta)
        //Protected é os mesmos pacotes e as subclasses (Ou seja, da mesma prata e subclasses)  
            //Subclasses são classes que herdam de outra classe, ou seja, são filhas dela

        
    //Exceções
    //Tratamento d eerro de maneira mais elegante
    //Sinalização de algo atípico (Não necessariamente erro)
    //Erro é algo feito errado, culpa do programador, grave
    //Exceção é algo que não deveria ter acontecido, mas aconteceu (Não necessariamente culpa do programador), literalmente algo que fugiu a regra.
        //Exemplo: Alguém apagou arquivo durante execução do programa

    //Exemplo classico é usando ifs e printar para o usuario os erros
        //Isso não é recomendado, pois não e elegante e não é claro

    //Bloco de Try e Catch
        //Try é o bloco que tenta executar o código, e se der erro, ele vai para o catch
        //Catch é o bloco que trata o erro, ou seja, ele vai executar o código que está dentro dele se der erro no try
        //finally é o bloco que sempre executa, independente de ter dado erro ou não (Ele é opcional)
        //O finally é mais usado para fechar arquivos ou conexões, pois ele sempre vai executar, mesmo que tenha dado erro no try

        //O catch pode ter um ou mais parâmetros, e o primeiro parâmetro é o tipo de exceção que ele vai tratar
            //Ele também pode revertar coisas feitas no try, não só apara enviar mensagens de erro

        //Posso também devolver acontecimentos da execução (Que normalemnte é só return) pelo new Exception("mensagem com erro")
            //Isso é mais usado para erros que não são fatais, ou seja, o programa pode continuar executando mesmo com o erro


        //O Catch(Exception e) é o que vai tratar, o "e" em sí é  o erro que chegou nele, como o parametro de uma função que será usada dentro do bloco do catch. (Ou seja ele pega o objeto "e" de exceção que veio do try)

        //Também tem o throw, que é usado para lançar exceções manualmente (Ou seja, eu mesmo que estou lançando o erro)
            //Ele literalmente lança o objeto na metade do código, interrompendo todo a continuação
            //Isso é be

    


            
}
