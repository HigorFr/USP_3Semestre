import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import controle.Updater;
import gamelib.GameLib;
import powerup.PowerUp;
import controle.Contexto;
import entidades.*;
import inimigos.*;
import projéteis.*;
import controle.ControladorFase;


/***********************************************************************/
/*                                                                     */
/* Para jogar:                                                         */
/*                                                                     */
/*    - cima, baixo, esquerda, direita: movimentação do player.        */
/*    - control: disparo de projéteis.                                 */
/*    - ESC: para sair do jogo.                                        */
/*                                                                     */
/***********************************************************************/

public class Main {




	public static void busyWait(long time){
		
		while(System.currentTimeMillis() < time) Thread.yield();
	}


	/* Método principal */
	
	public static void main(String [] args){

		controle.Contexto ctx = new Contexto("src/config.txt");
		ctx.setJogador(new Player(ctx.getCurrentTime()));

		try (BufferedReader br = new BufferedReader(new FileReader(ctx.getArquivoConfig()))) {
			int vidas = Integer.parseInt(br.readLine());
			ctx.getJogador().setVidas(vidas);
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}


		boolean running = true;

		ControladorFase cf = new ControladorFase(ctx.getArquivoConfig());



		/* iniciado interface gráfica */
		
		GameLib.initGraphics();
		//GameLib.initGraphics_SAFE_MODE();  // chame esta versão do método caso nada seja desenhado na janela do jogo.
		
		/*************************************************************************************************/
		/*                                                                                               */
		/* Main loop do jogo                                                                             */
		/* -----------------                                                                             */
		/*                                                                                               */
		/* O main loop do jogo executa as seguintes operações:                                           */
		/*                                                                                               */
		/* 1) Verifica se há colisões e atualiza estados dos elementos conforme a necessidade.           */
		/*                                                                                               */
		/* 2) Atualiza estados dos elementos baseados no tempo que correu entre a última atualização     */
		/*    e o timestamp atual: posição e orientação, execução de disparos de projéteis, etc.         */
		/*                                                                                               */
		/* 3) Processa entrada do usuário (teclado) e atualiza estados do player conforme a necessidade. */
		/*                                                                                               */
		/* 4) Desenha a cena, a partir dos estados dos elementos.                                        */
		/*                                                                                               */
		/* 5) Espera um período de tempo (de modo que delta seja aproximadamente sempre constante).      */
		/*                                                                                               */
		/*************************************************************************************************/
		
		while(running){
		
			/* Usada para atualizar o estado dos elementos do jogo    */
			/* (player, projéteis e inimigos) "delta" indica quantos  */
			/* ms se passaram desde a última atualização.             */
			
	
			
			/* Já a variável "currentTime" nos dá o timestamp atual.  */

			ctx.setDelta(System.currentTimeMillis() - ctx.getCurrentTime());


			/***************************/
			/* Atualizações de estados */
			/***************************/


			cf.update(ctx);

			ctx.update();

			Updater.update(ctx);

			if(ctx.isEscape()) running = false;

			/* chamada a display() da classe GameLib atualiza o desenho exibido pela interface do jogo. */
			
			GameLib.display();
			
			/* faz uma pausa de modo que cada execução do laço do main loop demore aproximadamente 3 ms. */
			
			busyWait(ctx.getCurrentTime() + 20);





		}
		
		System.exit(0);
	}
}
