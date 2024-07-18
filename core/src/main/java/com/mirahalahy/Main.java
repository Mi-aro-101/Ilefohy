package com.mirahalahy;

import com.badlogic.gdx.ApplicationAdapter;
import com.mirahalahy.monde.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

	TiledMap tileMap;
	OrthogonalTiledMapRenderer tmr;
    @Override
    public void create() {
    	tileMap = new TmxMapLoader().load("maps/level1.tmx");
    	tmr = new OrthogonalTiledMapRenderer(tileMap);
    	Camera.getCamera().setToOrtho(false, 1200, 1200);
    }

    @Override
    public void render() {
    	Camera.update();
    	tmr.setView(Camera.getCamera());
    	tmr.render();
    }

    @Override
    public void dispose() {

    }
}
