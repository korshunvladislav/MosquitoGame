package com.mygdx.game;

import static com.mygdx.game.MosquitoGame.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {

	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);

		SCR_WIDTH = 1280;
		SCR_HEIGHT = 720;

		config.setWindowedMode((int) SCR_WIDTH, (int) SCR_HEIGHT);
		config.setTitle("Game");
		new Lwjgl3Application(new MosquitoGame(), config);
	}
}