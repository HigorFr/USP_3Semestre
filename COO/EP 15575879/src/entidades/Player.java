package entidades;

import gamelib.GameLib;
import powerup.PowerUp;
import projéteis.*;
import controle.Contexto;
import java.awt.Color;

public class Player extends Entidade {


    public long shootcooldown = 100;
    public double radius = 12.0;
    private double explosion_start = 0;
    private double explosion_end = 0;
    private long nextShot;
    private int vidas;
    private boolean invencivel = false;
    private long invencivelFim = 0;

    private Color cor = Color.BLUE;

    public Player(long currentTime) {
        state = ACTIVE;
        cord_x = GameLib.WIDTH / 2;
        cord_y = GameLib.HEIGHT * 0.90;
        velocity_X = 0.25;
        velocity_Y = 0.25;
        this.nextShot = currentTime;
    }

    public double getRadius() {
        return radius;
    }

    public void setShootcooldown(long shootcooldown) {
        this.shootcooldown = shootcooldown;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    private void explodir(long currentTime) {
        state = EXPLODING;
        explosion_start = currentTime;
        explosion_end = currentTime + 2000;
        vidas--;
    }


    public void update(Contexto ctx) {

        long currentTime = ctx.getCurrentTime();
        long delta = ctx.getDelta();

        // Atualiza status de invencibilidade
        if (invencivel && currentTime > invencivelFim) {
            invencivel = false;
        }

        // Colisão com quem mata
        if (state == ACTIVE && !invencivel) {
            for (Entidade e : ctx.getColisores()) {
                double dx = e.getCord_x() - this.cord_x;
                double dy = e.getCord_y() - this.cord_y;
                double dist = Math.sqrt(dx * dx + dy * dy);

                if (dist < (radius + e.getRadius()) * 0.8) {
                    explodir(currentTime);
                    break;
                }
            }
        }

        //Colisão com Powerup
        if (state == ACTIVE) {
            for (PowerUp p : ctx.getPowerUp()) {
                double dx = p.getCord_x() - this.cord_x;
                double dy = p.getCord_y() - this.cord_y;
                double dist = Math.sqrt(dx * dx + dy * dy);

                if (dist < (radius + p.getRadius()) * 0.8) {
                    p.Colidiu();
                    break;
                }
            }
        }

        // Movimento
        if (state == ACTIVE) {
            if (ctx.isUp()) cord_y -= delta * velocity_Y;
            if (ctx.isDown()) cord_y += delta * velocity_Y;
            if (ctx.isLeft()) cord_x -= delta * velocity_X;
            if (ctx.isRight()) cord_x += delta * velocity_X;

            if (cord_x < 0.0) cord_x = 0.0;
            if (cord_x >= ctx.getWIDTH()) cord_x = ctx.getWIDTH() - 10;
            if (cord_y < 25.0) cord_y = 25.0;
            if (cord_y >= ctx.getHEIGHT()) cord_y = ctx.getHEIGHT() - 10;

            // Tiro
            if (ctx.isCtrl() && currentTime > nextShot) {
                Projetil p = new PProjetil();

                p.setCord_x(cord_x);
                p.setCord_y(cord_y - 2 * radius);
                p.setVelocity_X(0.0);
                p.setVelocity_Y(-1.0);
                p.setState(ACTIVE);
                nextShot = currentTime + shootcooldown;

                ctx.addPProjetil(p);

            }
        }

        // Respawn
        if (state == EXPLODING && currentTime > explosion_end) {
            if (vidas > 0) {
                state = ACTIVE;
                invencivel = true;
                invencivelFim = currentTime + 3000; // 3 segundos de invencibilidade
                cord_x = GameLib.WIDTH / 2;
                cord_y = GameLib.HEIGHT * 0.90;
            } else {
                state = INACTIVE; // sem vidas
            }
        }

        // Desenhos
        if (state == EXPLODING) {
            double alpha = (currentTime - explosion_start) / (explosion_end - explosion_start);
            GameLib.drawExplosion(cord_x, cord_y, alpha);
        } else if (state == ACTIVE) {
            if (invencivel && (currentTime / 100) % 2 == 0) {
                setCor(Color.YELLOW); // piscando
            } else {
                setCor(Color.BLUE);
            }
            GameLib.drawPlayer(cord_x, cord_y, radius, cor);
        }

        // Desenhar corações de vida
        for (int i = 0; i < vidas; i++) {
            GameLib.setColor(Color.RED);
            GameLib.drawDiamond(30 + i * 25, 50, 10); // desenha como quadradinhos de coração
        }
    }
}
