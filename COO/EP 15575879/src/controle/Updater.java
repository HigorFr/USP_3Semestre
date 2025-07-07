package controle;

import entidades.Movel;
import inimigos.Inimigo;
import powerup.PowerUp;
import projéteis.Projetil;

public class Updater {

    public static void update(Contexto ctx){

        ctx.getJogador().update(ctx);

        //Poderes
        for(PowerUp i : ctx.getPowerUp()){
            i.update(ctx);
        }


        //Inimigos
        for(Inimigo i : ctx.getInimigo1()){
            i.update(ctx);
        }

        for(Inimigo i : ctx.getInimigo2()){
            i.update(ctx);
        }


        /* projeteis (inimigo) */
        for(Projetil p : ctx.getEProjeteis()){
            p.update(ctx);
        }

        /* projeteis (player) */
        for(Projetil p : ctx.getPProjeteis()){
            p.update(ctx);
        }


        /* Fundo */
        for(Movel e : ctx.getEstrelas()){
            e.update(ctx);
        }

        //BOSS
        if(ctx.getBossativo() != null) {
            ctx.getBossativo().update(ctx);
        }


    }

}
