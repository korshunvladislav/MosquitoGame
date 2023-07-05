package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

public class MosquitoGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Texture imgBG;
    Mosquito[] mosquito = new Mosquito[100000];

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("mosquito.png");
        imgBG = new Texture("bg.jpg");
        for (int i = 0; i < mosquito.length; i++) {
            mosquito[i] = new Mosquito();
            mosquito[i].x = MathUtils.random(0f, 500);
            mosquito[i].y = MathUtils.random(0f, 500);
            mosquito[i].vx = MathUtils.random(2f, 10);
            mosquito[i].vy = MathUtils.random(2f, 10);
            mosquito[i].mosquitWH = MathUtils.random(25f , 200);
        }
    }

    @Override
    public void render() {
        for (Mosquito value : mosquito) {
            value.x += value.vx;
            value.y += value.vy;
            if (value.x > 1280 - value.mosquitWH || value.x < 0)
                value.vx = -value.vx;
            if (value.y > 720 - value.mosquitWH || value.y < 0)
                value.vy = -value.vy;
        }
        ScreenUtils.clear(0, 1, 0, 1);
        batch.begin();
        batch.draw(imgBG, 0, 0, 1280, 720);
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