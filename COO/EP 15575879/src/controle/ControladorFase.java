package controle;

import gamelib.GameLib;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorFase {
    private List<Fase> fases = new ArrayList<>();
    private int faseAtual = 0;
    private boolean emTransicao = false;
    private long inicioCooldown = 0;
    private final long DURACAO_COOLDOWN = 3000;
    private boolean finalizado = false;

    public ControladorFase(String configPath) {
        try (BufferedReader br = new BufferedReader(new FileReader(configPath))) {
            br.readLine(); //Pra pular a linha da vida

            int numFases = Integer.parseInt(br.readLine());

            for (int i = 0; i < numFases; i++) {
                String nomeArquivo = br.readLine();
                fases.add(new Fase(nomeArquivo));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void iniciarFaseAtual(long tempoAtual) {
        fases.get(faseAtual).iniciar(tempoAtual);
    }

    public void update(Contexto ctx) {
        GameLib.setColor(Color.WHITE);
        GameLib.drawText("Fase: " + (faseAtual + 1), GameLib.WIDTH - 80, 60);



        if (emTransicao) {

            GameLib.drawText("FASE " + (faseAtual + 1), GameLib.WIDTH / 2 - 30, GameLib.HEIGHT / 2);

            if (ctx.getCurrentTime() - inicioCooldown >= DURACAO_COOLDOWN) {
                emTransicao = false;
                if (faseAtual < fases.size()) {
                    fases.get(faseAtual).iniciar(ctx.getCurrentTime());
                }
            }
            return;
        }


        if (faseAtual >= fases.size() && !finalizado) return;

        Fase fase = fases.get(faseAtual);

        if (!fase.isIniciada() && !finalizado) iniciarFaseAtual(ctx.getCurrentTime());

        fase.update(ctx);

        if (fase.isFinalizada(ctx)) {
            faseAtual++;
            if (faseAtual < fases.size()) {
                // Iniciar cooldown antes da próxima fase
                emTransicao = true;
                inicioCooldown = ctx.getCurrentTime();
            } else {
                faseAtual--;
                GameLib.drawText("VOCÊ VENCEU", GameLib.WIDTH / 2 - 30, GameLib.HEIGHT / 2);
                GameLib.drawText("APERTE ESC PARA SAIR", GameLib.WIDTH / 2 - 60, GameLib.HEIGHT / 2 + 20);
            }
        }
    }

}
