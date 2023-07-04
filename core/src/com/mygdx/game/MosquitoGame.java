package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

public class MosquitoGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Texture imgBG;
    int[] x = new int[3];
    int[] y = new int[3];
    int[] vx = new int[3];
    int[] vy = new int[3];
    int[] mosquitWH = new int[3];
    int width = 1280, height = 720;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("mosquito.png");
        imgBG = new Texture("bg.jpg");
        for (int i = 0; i < x.length; i++) {
            x[i] = MathUtils.random(0, 500);
            y[i] = MathUtils.random(0, 500);
            vx[i] = MathUtils.random(2, 10);
            vy[i] = MathUtils.random(2, 10);
            mosquitWH[i] = MathUtils.random(100, 200);
        }
    }

    @Override
    public void render() {
        for (int i = 0; i < x.length; i++) {
            x[i] += vx[i];
            y[i] += vy[i];
            if (x[i] > width - mosquitWH[i] || x[i] < 0) vx[i] = -vx[i];
            if (y[i] > height - mosquitWH[i] || y[i] < 0) vy[i] = -vy[i];
        }
        ScreenUtils.clear(0, 1, 0, 1);
        batch.begin();
        batch.draw(imgBG, 0, 0, width, height);
        for (int j = 0; j < x.length; j++) batch.draw(img, x[j], y[j], mosquitWH[j], mosquitWH[j]);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}

class Mosquito {
    int x, y;
    int vx, vy;
    int mosquitWH;
}