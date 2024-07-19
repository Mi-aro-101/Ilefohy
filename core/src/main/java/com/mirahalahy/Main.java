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
	Environment environment;
    @Override
    public void create() {
    	environment = new Environment(0);
    }

    @Override
    public void render() {
    	environment.render();
    }

    @Override
    public void dispose() {

    }
}
