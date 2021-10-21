package com.mygdx.game.MenuScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private static final float SPEAD = 2f;

    SpriteBatch batch;
    Texture img;
    Texture seaBackGroundTexture;

    private Vector2 touch;
    private Vector2 v;
    private Vector2 vTo;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        seaBackGroundTexture= new Texture("sea.jpg");

        touch = new Vector2();
        vTo = new Vector2();
        touch.setLength(1.4f);
        v = new Vector2(-1,1);
    }

    @Override
    public void render (float delta) {
        super.render(delta);

        batch.begin();
        batch.draw(seaBackGroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(img, vTo.x,vTo.y);
        batch.end();

        toFollow();
    }

    @Override
    public void dispose () {
        super.dispose();
        batch.dispose();
        seaBackGroundTexture.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("ddddddddddddd " + screenX + "  " +  screenY);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(touch.cpy().sub(vTo)).setLength(SPEAD);
        return super.touchDown(screenX, screenY, pointer, button);
    }

    public void toFollow(){
        if (vTo.dst(touch) <= v.len()){
            vTo.set(touch);
        }else{
            vTo.add(v);
        }
    }


}
