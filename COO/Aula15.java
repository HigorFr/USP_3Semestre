public class Aula15 {
    
    //Parte mais prática do java

    //Pacotes

    //Classes e interfaces guaradaos em uma mesma pasta
        //Agrupados por critérios determinados, principalmente semelhança
        //Fonte.java
        //x.java
        //y.java ect
        //Da para ter subpacotes, cada ponto do meu direório é um pacote
        //Ou seja, dá para formar uma árvore, uma cadeia, de pacotes com uma hierarquia

        //Classes do mesmo pacote são "Vizinhas", estão na mesma pasta
            //Se elas não são vizinhas (Pai, filha etc) elas não são visíveis entre si

        //Isso tudo faz parte de uma estrutura hieraquica ainda maior:
            //Funções é a mais baixa
            //Classes é a segunda
            //Arquivos é a terceira (Normalmente isso se confunde pois tem uma classe publica por arquivo)
            //Pacotes(Pastas) é a quarta
            //Biblioteca/Módulos será a quinta (??? não sei o que é isso)
            //Projetos

        //Nada disso tem uma fronteira muito bem definida, mas é uma boa maneira de pensar

        //O que define o nome do pacote é o diretório onde ele está
            //Ex 
            //dir (PAcote da classe principal)
            //dir1.subA (PAcote da subA)
            //dir1.subB (Pacote da subB)

        
            //Isso por mais que pareça redundante, me ajuda a indicar onde começa o arquivo

        //OBS: .Jar é uma estrutura dessa compactada (Praticamente um .zip)


        //Para compilar com os pacotes é só compilar normal o main, diferente do GCC que só passa uma vez e tudo precisa ser especificado
            //Automaticamente o compilador assume que a classe existe em algum arquivo, e procura então no mesmo diretório

        //Nome do pacote com "package nome_do_pacote;"
            

        //Dá para compilar de qualquer caminho
            //seja do módulo filho ou do pai
            //Mais isso pode dar problema, pois se tiver dependicas ente os dois, o compilador não vai saber onde procurar
                //O certo é usar o nome inteiro da classe, com pacote e tudo
                //E estar na raiz do proejto (OU ele não vai achar o arquivo)

        //Também tem o IMPORT, que é para importar pacotes inteiros ou classes específicas
            //Dessa forma eu não preciso usar o nome inteiro, ele já pega o noem da classe          
            //Posso usar * para importar tudo, mas isso não é recomendado
                //Pois pode dar conflito de nomes, e o compilador não vai saber qual usar
                //Então é melhor importar só o que eu preciso, ou o pacote inteiro (Mas isso é raro)
                //E mesmo assim, se tiver conflito, o compilador não vai saber qual usar e vai dar erro

        //Package é para dar o nome do pacote (??? Talvez não, copilot que disse)
    
}
