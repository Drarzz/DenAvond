package com.robindemoor.denavond;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.robindemoor.denavond.States.GameStateManager;
import com.robindemoor.denavond.States.MenuState;

import java.util.Random;

public class DenAvond extends ApplicationAdapter {


	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	public static final String TITLE = "Den Avond";

	private GameStateManager gsm;

	private SpriteBatch batch;


//	public static int[] skill = new int[9];
//	public int totalSkill = 800;
//	public int i = 0;
//	public int dif = 0;
//
//
//
//	public void skillLoop(){
//		Random rn = new Random();
//		if(totalSkill>0){
//			dif = rn.nextInt(10);
//			skill[i] += dif;
//			totalSkill -= dif;
//
//			if(skill[i]>100){
//				skill[i] -= dif;
//				totalSkill += dif;
//			}
//
//			if(i == 8){
//				i = 0;
//				skillLoop();
//			}
//			else{
//				i++;
//				skillLoop();
//			}
//		}
//
//		else{
//			System.out.println("done with skill assignment");
//
////			for(i=0;i<9;i++){
////				System.out.println(skill[i]);
////			}
//		}
//	}

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));

	}


	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);

	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
