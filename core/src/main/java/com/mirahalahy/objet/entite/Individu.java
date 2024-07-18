package com.mirahalahy.objet.entite;

import com.mirahalahy.objet.GameObject;

public class Individu extends GameObject{
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
}
