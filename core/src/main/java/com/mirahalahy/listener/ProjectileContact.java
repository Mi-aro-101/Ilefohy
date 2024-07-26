package com.mirahalahy.listener;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mirahalahy.objet.utilite.Projectile;

public class ProjectileContact implements ContactListener {
	
	World world;
	
	
	
    public ProjectileContact(World world) {
		super();
		this.world = world;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	@Override
    public void beginContact(Contact contact) {
    	handleProjectileContact(contact);
    }

    @Override
    public void endContact(Contact contact) {
        // Called when two fixtures no longer touch
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        // Called before the collision is resolved
    }

    @Override
    public void postSolve(Contact contact, com.badlogic.gdx.physics.box2d.ContactImpulse impulse) {
        // Called after the collision is resolved
    }
    
    
    
    
    public void handleProjectileContact(Contact contact) {
        if (contact.getFixtureA().getBody().getUserData() instanceof Projectile) {
            Projectile ProjectileA = (Projectile) contact.getFixtureA().getBody().getUserData();
            ProjectileA.onColision(contact.getFixtureB());
            ProjectileA.setEnTir(false);
        }
        
        if (contact.getFixtureB().getBody().getUserData() instanceof Projectile) {
            Projectile ProjectileB = (Projectile) contact.getFixtureB().getBody().getUserData();
            ProjectileB.onColision(contact.getFixtureA());
            ProjectileB.setEnTir(false);
        }
    }
    
    
    public static void handleDestroyBody(World world) {
    	Array<Body> bodies = new Array<Body>();
    	world.getBodies(bodies);
    	for (Body body : bodies) {
			if(body.getUserData() instanceof String || body == null) {
				world.destroyBody(body);
			}
		}
    }
}
