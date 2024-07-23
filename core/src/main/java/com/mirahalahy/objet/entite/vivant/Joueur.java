package com.mirahalahy.objet.entite.vivant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mirahalahy.objet.entite.Individu;
import com.mirahalahy.objet.utilite.Projectile;

public class Joueur extends Individu {

	public Joueur(World world) {
		super(world, 28, 28);
        this.setPosition(new Vector2(0, 100));
        this.setImage("images/player/Idle.png", 11);
        this.createBody();
        this.setVitesse(new Vector2(250, -250));
	}

	Projectile[] projectiles;

	public Projectile[] getProjectiles() {
		return projectiles;
	}

	public void setProjectiles(Projectile[] projectiles) {
		this.projectiles = projectiles;
	}

	@Override
	public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
        	droite();
        	setFlip(false);
        	setImage("images/player/Run.png", 12);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
        	gauche();
        	setFlip(true);
        	setImage("images/player/Run.png", 12);
        }
        else {
        	setImage("images/player/Idle.png", 11);
        	stop();
        }
	}
}
