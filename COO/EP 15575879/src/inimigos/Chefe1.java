package inimigos;

import gamelib.GameLib;
import controle.Contexto;

import java.awt.*;

public class Chefe1 extends Chefe {


    private long proximoRadial = 0;
    private long tempoUltimoDano = 0;

    public Chefe1(long vida, double x, double y) {
        radius = 200;
        this.vida = vida;
        vidaMaxima = vida;
        cord_x = x;
        cord_y = y;
        velocity_X = 0.25;
        velocity_Y = 0.0;
        angle = (3 * Math.PI) / 2;
        state = ACTIVE;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    public void update(Contexto ctx) {
        long tempoAtual = ctx.getCurrentTime();
        long delta = ctx.getDelta();

        //Eu coloquei a opção de frame entre dano, mas desisti, então deixei isso caso eu queria ativar
        if (tempoAtual - tempoUltimoDano > cooldowndano && recebeuBala(ctx)) {
            vida--;
            tempoUltimoDano = tempoAtual;
            if (vida <= 0) {
                explodir(tempoAtual);
                return;
            }
        }

        if(confereEstadoBoss(tempoAtual, vida)) {
            // Movimentação: vai e volta horizontalmente
            // Atualizar movimentação (vai e volta horizontalmente com oscilação vertical)
            if (cord_x < 50 || cord_x > GameLib.WIDTH - 50) {
                velocity_X *= -1;
            }

            cord_x += velocity_X * delta;

            // Movimento senoidal no eixo Y (oscila para cima e para baixo)
            cord_y = 100 + 30 * Math.sin(ctx.getCurrentTime() * 0.002); // 100 é a "altura base"

            // Ataques (rajada a cada 700ms, radial a cada 3s)
            if (tempoAtual > proximoTiro) {
                dispararRajada(ctx);
                proximoTiro = tempoAtual + 700;
            }

            if (tempoAtual > proximoRadial) {
                dispararRadial(ctx);
                proximoRadial = tempoAtual + 3000;
            }

            // Desenho do chefe
            if (state == ACTIVE) {
                for (int i = 0; i < 20; i++) {
                    double angulo = i * Math.PI / 10 + ctx.getCurrentTime() * 0.002; // rotação com o tempo
                    double raio = 45; // espiral crescente
                    double x = cord_x + Math.cos(angulo) * raio;
                    double y = cord_y + Math.sin(angulo) * raio;

                    GameLib.setColor(Color.magenta);
                    GameLib.drawCircle(x, y, radius * 0.5); // círculos menores em espiral
                }
                // Desenhar barra de vida
                GameLib.setColor(Color.red);
                GameLib.drawCircle(cord_x, cord_y, radius * 0.1);
                desenharBarraDeVida();
            }
        }

        if (state == EXPLODING) {
            double alpha = (tempoAtual - explosion_start) / (explosion_end - explosion_start);
            GameLib.drawExplosion(cord_x, cord_y, alpha);
        }
    }
}
