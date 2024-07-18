package com.mirahalahy.objet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
	Texture image;
	Animation<TextureRegion> animation;
	Vector2 vitesse;
	Vector2 position;
	boolean flip;
	
	public GameObject() {
		// TODO Auto-generated constructor stub
	}

	public Texture getImage() {
		return image;
	}

	public void setImage(Texture image) {
		this.image = image;
	}

	public Animation<TextureRegion> getAnimation() {
		return animation;
	}

	public void setAnimation(Animation<TextureRegion> animation) {
		this.animation = animation;
	}

	public Vector2 getVitesse() {
		return vitesse;
	}

	public void setVitesse(Vector2 vitesse) {
		this.vitesse = vitesse;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public boolean isFlip() {
		return flip;
	}

	public void setFlip(boolean flip) {
		this.flip = flip;
	}
	
	
}
