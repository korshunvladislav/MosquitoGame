package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

public class MosquitoGame extends ApplicationAdapter {
    public static final int SCR_WIDTH = 1280, SCR_HEIGHT = 720;
    SpriteBatch batch;
    Texture img;
    Texture imgBG;
    Mosquito[] mosquito = new Mosquito[100];

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("mosquito.png");
        imgBG = new Texture("bg.jpg");
        for (int i = 0; i < mosquito.length; i++) {
            mosquito[i] = new Mosquito();
            mosquito[i].mosquitWH = MathUtils.random(25f, 200);
            mosquito[i].x = MathUtils.random(0f, SCR_WIDTH - mosquito[i].mosquitWH);
            mosquito[i].y = MathUtils.random(0f, SCR_HEIGHT - mosquito[i].mosquitWH);
            mosquito[i].vx = MathUtils.random(-10f, 10);
            mosquito[i].vy = MathUtils.random(-10f, 10);
        }
    }

    @Override
    public void render() {
        for (Mosquito value : mosquito) {
            value.x += value.vx;
            value.y += value.vy;
            if (value.x >= SCR_WIDTH - value.mosquitWH || value.x <= 0)
                value.vx = -value.vx;
            if (value.y >= SCR_HEIGHT - value.mosquitWH || value.y <= 0)
                value.vy = -value.vy;
        }
        ScreenUtils.clear(0, 1, 0, 1);
        batch.begin();
        batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        for (Mosquito value : mosquito) {
            batch.draw(img, value.x, value.y, value.mosquitWH, value.mosquitWH);
        }
        batch.end();
        System.out.println(Gdx.graphics.getFramesPerSecond());
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}

class Mosquito {
    float x, y;
    float vx, vy;
    float mosquitWH;
}