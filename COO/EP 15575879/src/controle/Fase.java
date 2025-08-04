package controle;
import entidades.Spawner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Fase {


    private boolean iniciada = false;
    private List<Evento> eventos = new ArrayList<>();
    private int indexEvento = 0;
    private boolean chefeVivo = false;
    private long tempoInicio;
    private boolean finalizada;

    public Fase(String pathFase) {
        carregar(pathFase);
    }

    private void carregar(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] p = linha.trim().split(" ");

                String objeto = p[0];
                String tipo = p[1];

                if(Objects.equals(objeto, "CHEFE")) {
                    long vida = Long.parseLong(p[2]);
                    long tempo = Long.parseLong(p[3]);
                    double x = Double.parseDouble(p[4]);
                    double y = Double.parseDouble(p[5]);
                    eventos.add(new Evento(objeto,tipo, vida,tempo, x, y));

                }

                else{
                    long tempo = Long.parseLong(p[2]);
                    double x = Double.parseDouble(p[3]);
                    double y = Double.parseDouble(p[4]);
                    long vida = 0;
                    eventos.add(new Evento(objeto,tipo, vida,tempo, x, y));
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean isIniciada() {
        return iniciada;
    }

    public void iniciar(long tempoAtual) {
        tempoInicio = tempoAtual;
        indexEvento = 0;
        iniciada = true;
    }

    public void update(Contexto ctx) {
        boolean ant_chefeVivo = chefeVivo;
        chefeVivo = (ctx.getBossativo() != null);

        if(ant_chefeVivo && !chefeVivo) finalizada = true;

        long tempoFase = ctx.getCurrentTime() - tempoInicio;

        while (indexEvento < eventos.size() && eventos.get(indexEvento).tempo <= tempoFase) {
            Evento e = eventos.get(indexEvento);

            Spawner.Spawnar(e.objeto, e.tipo, e.vida, e.x, e.y, ctx);


            indexEvento++;
        }

    }

    public boolean isFinalizada(Contexto ctx) {
        return finalizada; //&&!ctx.getInimigo().stream().anyMatch(i -> i instanceof Chefe && i.getState() == Entidade.ACTIVE);
    }
}
