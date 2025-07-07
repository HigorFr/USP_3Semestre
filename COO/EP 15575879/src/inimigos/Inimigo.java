package inimigos;


import gamelib.GameLib;
import entidades.Entidade;
import controle.Contexto;
import projéteis.*;

public abstract class Inimigo extends Entidade{
	double angle;				// ângulos (indicam direção do movimento)
	double RV;					// velocidades de rotação
	double explosion_start;			// instantes dos inícios das explosões
	double explosion_end;			// instantes dos finais da explosões
	long nextShoot;				// instantes do próximo tiro
	long cooldowndano = 0;




	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public double getRV() {
		return RV;
	}
	public void setRV(double rv) {
		RV = rv;
	}
	public double getExplosion_start() {
		return explosion_start;
	}
	public void setExplosion_start(double explosion_start) {
		this.explosion_start = explosion_start;
	}
	public double getExplosion_end() {
		return explosion_end;
	}
	public void setExplosion_end(double explosion_end) {
		this.explosion_end = explosion_end;
	}
	public long getNextShoot() {
		return nextShoot;
	}
	public void setNextShoot(long nextShoot) {
		this.nextShoot = nextShoot;
	}




	public boolean confereEstado(long tempoAtual) {
		if(state == INACTIVE) return false;
		
		
		
		if(state == EXPLODING){
			if(tempoAtual > explosion_end) {
				state = INACTIVE;
				return false;
			}

			double alpha = (tempoAtual - explosion_start) / (explosion_end - explosion_start);
			GameLib.drawExplosion(cord_x, cord_y, alpha);

		}

		if(state == ACTIVE){

			if(cord_y > GameLib.HEIGHT + 10 || cord_x > GameLib.WIDTH + 10 || cord_x < -10 || cord_y < -10) {
				state = INACTIVE;
				return false;
			}

			return true;
		}


		return false;
	}


    public void explodir(Long currentTime) {				
        state = EXPLODING;
        explosion_start = currentTime;
        explosion_end = currentTime + 500;
    }



	public boolean recebeuBala(Contexto ctx){
		
		for(Projetil p : ctx.getPProjeteis()){

			if(state == ACTIVE && p.getState() == ACTIVE){
			
				double dx = cord_x - p.getCord_x();
				double dy = cord_y - p.getCord_y();
				double dist = Math.sqrt(dx * dx + dy * dy);
				
				if(dist < getRadius()){
					p.setState(INACTIVE);
					return true;
				}

			}			

		}
		return false;
	}




}