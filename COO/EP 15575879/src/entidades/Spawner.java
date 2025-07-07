package entidades;

import inimigos.*;
import powerup.PowerUp;
import powerup.PowerUp1;
import powerup.PowerUp2;
import controle.Contexto;

public class Spawner{
    public static void Spawnar(String objeto, String tipo, long vida, double x, double y, Contexto ctx) {

        switch (objeto){
            case "INIMIGO":
                switch (tipo) {
                    case "1":

                        Inimigo i = new Inimigo1(ctx.getCurrentTime(), x, y);
                        ctx.addInimigoTipo1(i);
                        break;


                    case "2":
                        Inimigo j = new Inimigo2(x, y);
                        ctx.addInimigoTipo2(j);
                        break;
                }
                break;

            case "CHEFE":

                switch (tipo){
                    case "1":

                        Inimigo i = new Chefe1(vida,x, y);
                        ctx.setBossativo(i);
                        break;


                    case "2":
                        Inimigo a = new Chefe2(vida,x, y);
                        ctx.setBossativo(a);
                        break;

                }
                break;

            case "POWERUP":

                switch (tipo){
                    case "1":
                        PowerUp g = new PowerUp1(x,y);
                        ctx.addPowerUp(g);
                        break;

                    case "2":
                        PowerUp l = new PowerUp2(x,y);
                        ctx.addPowerUp(l);
                        break;
                }

        }
    }
}