package com.robindemoor.denavond.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.robindemoor.denavond.DenAvond;
import java.awt.image.BufferedImage;

import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;


/**
 * Created by Shteen on 21/10/2016.
 */

public class MenuState extends State{


    public boolean skillLoopBool = true;

    private Texture background;
    private Texture scene;

    private Texture iconRegie ;
    private Texture iconMuziek;
    private Texture iconKledij;
    private Texture iconTech;
    private Texture iconDans;
    private Texture iconFoto;
    private Texture iconDecor;
    private Texture iconSketch;
    private Texture iconScript;
    private Texture iconGeld;

    private Texture skillBar;
    private Texture skillBarBack;
    private Texture skillBg;

    private Texture buttonUpgrades;
    private Texture buttonResearch;
    private Texture buttonOptions;
    private Texture buttonSponsors;


    public static BufferedImage iconSheet;
    private static final int TILE_SIZE = 32;

    public int skill0 = 0;



    BufferedImage sprite = null ;


    public static int[] skill = new int[11];
    public int totalSkill = 640;
    public int i = 0;
    public int dif = 0;



    public void skillLoop(){

        Random rn = new Random();
        if(totalSkill>0){
            dif = rn.nextInt(10);
            skill[i] += dif;
            totalSkill -= dif;

            if(skill[i]>100){
                skill[i] -= dif;
                totalSkill += dif;
            }

            if(i == 10){
                i = 0;
                skillLoop();
            }
            else{
                i++;
                skillLoop();
            }
        }

        else{

            //System.out.println("done with skill assignment");

			for(i=0;i<11;i++){
				System.out.println(skill[i]);
                skillLoopBool = false;
			}
        }
    }




    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        scene = new Texture("scene.png");
        iconRegie = new Texture("iconRegie.png");
        iconMuziek = new Texture("iconMuziek.png");
        iconKledij = new Texture("iconKledij.png");
        iconTech = new Texture ("iconTech.png");
        iconDans = new Texture ("iconDans.png");
        iconFoto = new Texture ("iconFoto.png");
        iconDecor = new Texture ("iconDecor.png");
        iconSketch = new Texture ("iconSketch.png");
        iconScript = new Texture ("iconScript.png");
        iconGeld = new Texture ("iconGeld.png");
        skillBar = new Texture("skillBar.png");
        skillBarBack = new Texture("skillBarBack.png");
        buttonOptions = new Texture("buttonOptions.png");
        buttonResearch = new Texture("buttonResearch.png");
        buttonUpgrades = new Texture("buttonUpgrades.png");
        buttonSponsors = new Texture("buttonSponsors.png");
        skillBg = new Texture("skillBg.png");
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        if (skillLoopBool == true){
            skillLoop();
        }

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        sb.draw(background,0,0, DenAvond.WIDTH,DenAvond.HEIGHT);
        sb.draw(skillBg,(DenAvond.WIDTH / 10) -20, 2);


        sb.draw(scene, (DenAvond.WIDTH /2) - (scene.getWidth() / 2), DenAvond.HEIGHT /2);
        sb.draw(iconGeld, (DenAvond.WIDTH / 10) -13, (DenAvond.HEIGHT /2  - 50) +10);
        sb.draw(iconRegie, (DenAvond.WIDTH / 10) -13, (DenAvond.HEIGHT /2  - 90) +10);
        sb.draw(iconDans, (DenAvond.WIDTH / 10) -13, (DenAvond.HEIGHT /2  - 130) +10);
        sb.draw(iconDecor, (DenAvond.WIDTH / 10) -13, (DenAvond.HEIGHT /2  - 165) +10);
        sb.draw(iconFoto, (DenAvond.WIDTH / 10) -13, (DenAvond.HEIGHT /2  - 205) +10);
        sb.draw(iconKledij, (DenAvond.WIDTH / 10) -13, (DenAvond.HEIGHT /2  - 245) +10);
        sb.draw(iconMuziek, (DenAvond.WIDTH / 10) -13, (DenAvond.HEIGHT /2  - 280) +10);
        sb.draw(iconTech, (DenAvond.WIDTH / 10) -13, (DenAvond.HEIGHT /2  - 320) +10);
        sb.draw(iconSketch, (DenAvond.WIDTH / 10) -13, (DenAvond.HEIGHT /2  - 360) +10);
        sb.draw(iconScript, (DenAvond.WIDTH / 10) -13, (DenAvond.HEIGHT /2) - 400 +10);


        sb.draw(skillBarBack,(DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 50 + 20));
        sb.draw(skillBarBack,(DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 90 + 20));
        sb.draw(skillBarBack,(DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 130 + 20));
        sb.draw(skillBarBack,(DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 165 + 20));
        sb.draw(skillBarBack,(DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 205 + 20));
        sb.draw(skillBarBack,(DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 245 + 20));
        sb.draw(skillBarBack,(DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 280 + 20));
        sb.draw(skillBarBack,(DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 320 + 20));
        sb.draw(skillBarBack,(DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 360 + 20));
        sb.draw(skillBarBack,(DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 400 + 20));

        sb.draw(skillBar, (DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 50 + 20), (float) skill[1] /100 *60, 10);
        sb.draw(skillBar, (DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 90 + 20), (float) skill[2] /100 *60, 10);
        sb.draw(skillBar, (DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 130 + 20), (float) skill[3] /100 *60, 10);
        sb.draw(skillBar, (DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 165 + 20), (float) skill[4] /100 *60, 10);
        sb.draw(skillBar, (DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 205 + 20), (float) skill[5] /100 *60, 10);
        sb.draw(skillBar, (DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 245 + 20), (float) skill[6] /100 *60, 10);
        sb.draw(skillBar, (DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 280 + 20), (float) skill[7] /100 *60, 10);
        sb.draw(skillBar, (DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 320 + 20), (float) skill[8] /100 *60, 10);
        sb.draw(skillBar, (DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 360 + 20), (float) skill[9] /100 *60, 10);
        sb.draw(skillBar, (DenAvond.WIDTH / 10) + 20, (DenAvond.HEIGHT /2  - 400 + 20), (float) skill[10] /100 *60, 10);

        sb.draw(buttonOptions, (DenAvond. WIDTH) - buttonOptions.getWidth() - 5, buttonOptions.getHeight()-20);
        sb.draw(buttonResearch, (DenAvond. WIDTH) - buttonOptions.getWidth()*2 - 10, buttonOptions.getHeight()-20) ;
        sb.draw(buttonUpgrades,(DenAvond. WIDTH) - buttonOptions.getWidth() - 5, buttonOptions.getHeight()*2-15);
        sb.draw(buttonSponsors,(DenAvond. WIDTH) - buttonOptions.getWidth()*2 - 10, (buttonOptions.getHeight()*2)-15);



        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        scene.dispose();
        iconGeld.dispose();
        iconSketch.dispose();
        iconMuziek.dispose();
        iconRegie.dispose();
        iconDans.dispose();
        iconDecor.dispose();
        iconFoto.dispose();
        iconKledij.dispose();
        iconScript.dispose();
        iconTech.dispose();
        skillBar.dispose();
    }
}
