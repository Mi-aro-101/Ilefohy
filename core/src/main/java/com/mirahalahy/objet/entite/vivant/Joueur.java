package com.mirahalahy.objet.entite.vivant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.mirahalahy.objet.entite.Individu;
import com.mirahalahy.objet.utilite.Projectile;

public class Joueur extends Individu {
	Projectile[] projectiles;
	
	float jumpforce = 200;

	public Joueur(World world) {
		super(world, 28, 28);
        this.setPosition(new Vector2(0, 100));
        this.setImage("images/player/Idle.png", 11);
        this.createBody();
        this.setVitesse(new Vector2(250, 0));
        initProjectiles();
	}


	public void initProjectiles() {
        projectiles = new Projectile[10];
        for (int i = 0; i < projectiles.length; i++) {
        	projectiles[i] = new Projectile(getWorld());
		}
	}
	
	public Projectile[] getProjectiles() {
		return projectiles;
	}

	public void setProjectiles(Projectile[] projectiles) {
		this.projectiles = projectiles;
	}

	@Override
	public void handleInput() {
		handleAnimation();
		handleTir();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
        	droite();
        	setFlip(false);
        }
        
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
        	gauche();
        	setFlip(true);
        }
        
        else {
        	stop();
        }
        
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && isOnGround()) {
        	saute();
        }
	}
	
	boolean isOnGround() {
		int velocityGrounded = (int) getBody().getLinearVelocity().y;
		if(velocityGrounded == 0)
			return true;
		else
			return false;
	}
	
	public void saute() {
        getBody().setLinearVelocity(0, jumpforce);
	}
	
	
	void handleAnimation() {
		int velocityGroundedy = (int) getBody().getLinearVelocity().y;
		int velocityGroundedx = (int) getBody().getLinearVelocity().x;
		if(velocityGroundedy == 0) {
			setImage("images/player/Idle.png", 11);
		}
		else if(velocityGroundedy < 0) {
			setImage("images/player/Fall.png", 1);
		}
		else if(velocityGroundedy > 0){
			setImage("images/player/Jump.png", 1);
		}
		
		

        if ((velocityGroundedx > 0 || velocityGroundedx < 0) && velocityGroundedy == 0) {
        	setImage("images/player/Run.png", 12);
        }
	}
	

	
	public void handleTir() {
		if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
			attaque();
		}
		handleProjectiles();
	}

	@Override
	public void meurt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attaque() {
		for(Projectile projectile : projectiles) {
			if(!projectile.isEnTir()) {
				projectile.tir(this);
				break;
			}
		}
	}
	
	public void handleProjectiles() {
		for(Projectile projectile : projectiles) {
			if(projectile.isEnTir()) {
				projectile.renderImage();
			}
			else if(!projectile.isEnTir() && projectile.getBody() != null){
				projectile.getBody().setUserData("projectile");
			}
		}
	}
}
