package com.mirahalahy.objet.entite;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mirahalahy.objet.GameObject;

public abstract class Individu extends GameObject{

	public Individu(World world, float width, float height) {
		super(world, width, height);
		setEstVivant(false);
	}
	
	int id;
	String nom;
	String description;
	float vie;
	boolean estVivant;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getVie() {
		return vie;
	}
	public void setVie(float vie) {
		this.vie = vie;
	}
	public boolean isEstVivant() {
		return estVivant;
	}
	public void setEstVivant(boolean estVivant) {
		this.estVivant = estVivant;
	}
	
	public abstract void handleInput();
	public abstract void meurt();
	public abstract void attaque();
	
	public void droite() {
		getBody().applyForceToCenter(new Vector2(getVitesse().x, 0), true);
	}
	
	public void gauche() {
		getBody().applyForceToCenter(new Vector2(-getVitesse().x, 0), true);
	}
	
	public void stop() {
        getBody().setLinearVelocity(0, getBody().getLinearVelocity().y);
    }
}
