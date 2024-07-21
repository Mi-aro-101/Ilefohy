package com.mirahalahy.objet.entite.vivant;

import com.badlogic.gdx.physics.box2d.World;
import com.mirahalahy.objet.entite.Individu;
import com.mirahalahy.objet.utilite.Projectile;

public class Joueur extends Individu {

	public Joueur(World world, float width, float height) {
		super(world, width, height);
		// TODO Auto-generated constructor stub
	}

	Projectile[] projectiles;

	public Projectile[] getProjectiles() {
		return projectiles;
	}

	public void setProjectiles(Projectile[] projectiles) {
		this.projectiles = projectiles;
	}
}
