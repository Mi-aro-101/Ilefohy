package com.mirahalahy.monde;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera {
	static OrthographicCamera camera = new OrthographicCamera();

	public static OrthographicCamera getCamera() {
		return camera;
	}

	public static void setCamera(OrthographicCamera camera) {
		Camera.camera = camera;
	}
	
	public static void update() {
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		camera.update();
	}
}
