package controle;

import java.awt.*;

import background.EstrelaFrente;
import background.EstrelaTras;
import gamelib.GameLib;
import powerup.PowerUp;
import projéteis.*;
import entidades.*;
import inimigos.*;
import java.util.ArrayList;
import java.util.List;


public class Contexto {
    public long delta;
    public long currentTime;
    String arquivoConfig;
    public Player jogador;
    public int maxEstrelas = 50;

    public List<Entidade> colisores = new ArrayList<>();
    public List<Projetil> Eprojeteis = new ArrayList<>();
    public List<Projetil> Pprojeteis = new ArrayList<>();
    public List<Inimigo> inimigos = new ArrayList<>();
    public List<Inimigo> inimigo1 = new ArrayList<>();
    public List<Inimigo> inimigo2 = new ArrayList<>();
    public List<Movel> estrelas = new ArrayList<>();
    public List<PowerUp> powerusps = new ArrayList<>();


    public Inimigo bossativo;

    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean escape;
    public boolean ctrl;



    public long WIDTH = GameLib.WIDTH;
    public long HEIGHT = GameLib.HEIGHT;

    public int getMaxEstrelas() {
        return maxEstrelas;
    }

    public void setBossativo(Inimigo bossativo) {
        this.bossativo = bossativo;
    }


    public Inimigo getBossativo() {
        return bossativo;
    }


    public String getArquivoConfig() {
        return arquivoConfig;
    }


    public void addEProjetil(Projetil p) {
        Eprojeteis.add(p);
        colisores.add(p);
    }

    public void addPProjetil(Projetil p) {
        Pprojeteis.add(p);
    }

    public void addInimigoTipo1(Inimigo i) {
        inimigo1.add(i);
        inimigos.add(i);
        colisores.add(i);// opcional: mantém também na lista geral
    }

    public void addInimigoTipo2(Inimigo i) {
        inimigo2.add(i);
        inimigos.add(i);
        colisores.add(i);   // opcional
    }

    public void addPowerUp(PowerUp i) {
        powerusps.add(i);
    }






    public Contexto(String configPath){

        currentTime = System.currentTimeMillis();

        arquivoConfig = configPath;

        for (int i = 0; i < getMaxEstrelas(); i++) {
            Movel novo = (Movel) new EstrelaFrente();
            estrelas.add(novo);
        }

        for (int i = 0; i < getMaxEstrelas(); i++) {
            Movel novo = (Movel) new EstrelaTras();
            estrelas.add(novo);

        }

    }





    public <T extends Entidade> void clear(List<T> lista) {
        lista.removeIf(e -> e.getState() == Entidade.INACTIVE);
    }

    public void clearBoss() {
        if (this.bossativo != null && this.bossativo.getState() == 0) {
            this.bossativo = null;
        }
    }

    public void clearAllInactive(){
        clear(colisores);
        clear(Eprojeteis);
        clear(Pprojeteis);
        clear(inimigos);
        clear(inimigo1);
        clear(inimigo2);
        clear(powerusps);
        clearBoss();
    }


    public long getWIDTH() {
        return WIDTH;
    }

    public long getHEIGHT() {
        return HEIGHT;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isEscape() {return escape;}

    public boolean isCtrl() {return ctrl;}

    public long getDelta() {
        return delta;
    }

    public void setDelta(long delta) {
        this.delta = delta;
    }
    public long getCurrentTime() {
        return currentTime;
    }

    public List<Movel> getEstrelas() {return estrelas;}

    public void setJogador(Player jogador) {
        this.jogador = jogador;
    }

    public List<Projetil> getEProjeteis() {
        return Eprojeteis;
    }

    public List<Projetil> getPProjeteis() {
        return Pprojeteis;
    }

    public List<PowerUp> getPowerUp() {
        return powerusps;
    }

    public List<Entidade> getColisores() {return colisores;}

    public List<Inimigo> getInimigo() {return inimigos;} //

    public List<Inimigo> getInimigo1() {
        return inimigo1;
    } //

    public List<Inimigo> getInimigo2() {
        return inimigo2;
    } //

    public Player getJogador() {
        return jogador;
    }


    public void update() {
        currentTime = System.currentTimeMillis();


        if (GameLib.iskeyPressed(GameLib.KEY_UP)) {
            up = true;
        } else {
            up = false;
        }

        if (GameLib.iskeyPressed(GameLib.KEY_DOWN)) {
            down = true;
        } else {
            down = false;
        }

        if (GameLib.iskeyPressed(GameLib.KEY_LEFT)) {
            left = true;
        } else {
            left = false;
        }

        if (GameLib.iskeyPressed(GameLib.KEY_RIGHT)) {
            right = true;
        } else {
            right = false;
        }

        if (GameLib.iskeyPressed(GameLib.KEY_CONTROL)) {
            ctrl = true;
        } else {
            ctrl = false;
        }

        if (GameLib.iskeyPressed(GameLib.KEY_ESCAPE)) {
            escape = true;
        } else {
            escape = false;
        }

        //Apagar powerups quando morre
        if(jogador.getState() == Entidade.EXPLODING){
            for(PowerUp p : powerusps){
                if(p.isAplicado()) p.remover(jogador);
            }
        }

        if(jogador.getState() == Entidade.INACTIVE){
            GameLib.setColor(Color.WHITE);
            GameLib.drawText("GAME OVER",(GameLib.WIDTH/2.0)-52,GameLib.HEIGHT/2.0);
        }

        clearAllInactive();
    }
}
