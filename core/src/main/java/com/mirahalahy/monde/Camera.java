package com.mirahalahy.monde;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Camera {
    static OrthographicCamera camera = new OrthographicCamera();
    static Viewport view = new FitViewport(800, 600, camera);


    public static OrthographicCamera getCamera() {
        return camera;
    }

    public static void setCamera(OrthographicCamera camera) {
        Camera.camera = camera;
        camera.zoom = 0.4f;
        view = new FitViewport(800, 600, camera);
        view.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(view.getWorldWidth()/5, view.getWorldHeight()/5, 0);
    }

    public static Viewport getView() {
        return view;
    }

    public static void setView(Viewport view) {
        Camera.view = view;
    }

    public static Matrix4 getCombined() {
        return camera.combined;
    }

    public static void update() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        camera.update();
        view.apply();
    }

    public static void resize(int width, int height) {
        view.update(width, height);
    }
}
