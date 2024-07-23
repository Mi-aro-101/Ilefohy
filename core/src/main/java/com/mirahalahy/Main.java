package com.mirahalahy;

import com.badlogic.gdx.ApplicationAdapter;
import com.mirahalahy.monde.*;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

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
