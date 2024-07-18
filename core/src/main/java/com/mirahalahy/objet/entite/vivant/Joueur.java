package com.mirahalahy.objet.entite.vivant;

import com.mirahalahy.objet.entite.Individu;
import com.mirahalahy.objet.utilite.Projectile;

public class Joueur extends Individu {
	Projectile[] projectiles;

	public Projectile[] getProjectiles() {
		return projectiles;
	}

	public void setProjectiles(Projectile[] projectiles) {
		this.projectiles = projectiles;
	}
}
