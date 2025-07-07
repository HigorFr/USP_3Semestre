package controle;

public class Evento {
    public long tempo;
    public String tipo;
    public double x, y;
    public String objeto;
    public long vida;

    public Evento(String objeto, String tipo, long vida, long tempo, double x, double y) {
        this.objeto = objeto;
        this.tempo = tempo;
        this.vida = vida;
        this.tipo = tipo;
        this.x = x;
        this.y = y;
    }
}