package com.robindemoor.denavond.States;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Shteen on 21/10/2016.
 */

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop();
    }

    public void set(State state){
        states.pop();
        states.push(state);
    }


    public void update(float db){
        states.peek().update(db);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }

}
