public class Pilha<T> {

    No primeiro;


    public class No {
        T valor;
        No prox;
        
    }

    public void inserir(T valor){
        No novo = new No();
        novo.valor = valor;
        novo.prox = primeiro;
        primeiro = novo;
    }

    public T pop(){
        No pop = primeiro;
        primeiro = primeiro.prox;
        return pop.valor;

    }


}
