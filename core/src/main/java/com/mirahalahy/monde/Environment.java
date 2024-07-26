package com.mirahalahy.monde;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mirahalahy.listener.ProjectileContact;
import com.mirahalahy.objet.entite.vivant.Joueur;

public class Environment {
    int id;
    TiledMap map;
    OrthogonalTiledMapRenderer tmr;
    World world;
    Box2DDebugRenderer rendererBox2d;
    Joueur player;

    public Environment(int id) {
        map = new TmxMapLoader().load("maps/level1.tmx");
        initWorld();
        createWorld();
        player = new Joueur(world);
        world.setContactListener(new ProjectileContact(world));
    }

    public void handleInput() {
    	player.handleInput();
    }

    public void initWorld() {
        tmr = new OrthogonalTiledMapRenderer(map);
        Camera.setCamera(new OrthographicCamera());
        world = new World(new Vector2(0, -250), true);
        rendererBox2d = new Box2DDebugRenderer();
    }

    public void createWorld() {
        createRectangleBodies(2, 6);
    }

    public void createRectangleBodies(int beginIndex, int endIndex) {
        BodyDef bdf = new BodyDef();
        PolygonShape pShape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for (int i = beginIndex; i < endIndex; i++) {
            for (MapObject object : map.getLayers().get(i).getObjects().getByType(RectangleMapObject.class)) {
                Rectangle rect = ((RectangleMapObject) object).getRectangle();

                bdf.type = BodyDef.BodyType.StaticBody; // Set the body type
                body = world.createBody(bdf); // Create the body in the world
                body.setTransform(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2, 0);

                pShape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
                fdef.shape = pShape; // Assign the shape to the fixture definition
                body.createFixture(fdef);
            }
        }
    }

    public void render() {
        Camera.getCamera().position.set(player.getPosition().x, player.getPosition().y, 0);
        Camera.update();
        tmr.setView(Camera.getCamera());
        tmr.render();
        rendererBox2d.render(world, Camera.getCombined());
        ProjectileContact.handleDestroyBody(world);
        handleInput();
        world.step(1/60f, 6, 2);
        player.renderImage();
    }
}
