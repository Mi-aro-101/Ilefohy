package com.mirahalahy.objet.utilite;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mirahalahy.objet.GameObject;
import com.mirahalahy.objet.entite.vivant.Joueur;

public class Projectile extends GameObject{
	float attaque, jumpforce = 120;
	boolean enTir;
	
	
	public Projectile(World world) {
		super(world, 20, 20);
		setImage("images/projectile/projectile.png", 1);
	}
	
	
	public void tir(Joueur player) {
		this.setEnTir(true);
		this.createBody();
		if(!player.isFlip()) {
			this.getBody().setLinearVelocity(new Vector2(jumpforce, jumpforce));
			this.setPosition(new Vector2(player.getPosition().x + getWidth() / 2 + 20, player.getPosition().y + getHeight() / 2 + 20));
		}
		else {
			this.getBody().setLinearVelocity(new Vector2(-jumpforce, jumpforce));
			this.setPosition(new Vector2(player.getPosition().x + getWidth() / 2 - 40, player.getPosition().y + getHeight() / 2 + 20));
		}
	}
	
	public float getAttaque() {
		return attaque;
	}
	public void setAttaque(float attaque) {
		this.attaque = attaque;
	}
	public boolean isEnTir() {
		return enTir;
	}
	public void setEnTir(boolean enTir) {
		this.enTir = enTir;
	}
	
	
}
