package com.mirahalahy.objet;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mirahalahy.monde.Camera;

public class GameObject {
    String image;
    Sprite sprite;
    Texture texture;
    TextureRegion textures;
    Animation<TextureRegion> animation;
    SpriteBatch batch;
    FixtureDef fdef;
    Vector2 vitesse;
    boolean flip = false;
    float stateTime = 0f;
    float width = 0, height = 0;

    // Box2D variables
    Body body;
    World world;

    public GameObject(World world, float width, float height) {
    	this.width= width; this.height = height; 
        this.world = world;
        batch = new SpriteBatch();
        sprite = new Sprite();
        fdef = new FixtureDef();
    }

    public Vector2 getVitesse() {
        return vitesse;
    }

    public void setVitesse(Vector2 vitesse) {
        this.vitesse = vitesse;
        body.setLinearVelocity(0, vitesse.y);
    }

    public Vector2 getPosition() {
        return new Vector2(sprite.getX(), sprite.getY());
    }

    public void setPosition(Vector2 position) {
        this.sprite.setPosition(position.x, position.y);
        if (body != null) {
            body.setTransform(position.x, position.y, body.getAngle());
        }
    }
    
    void resetPositionToBody() {
    	setPosition(body.getPosition());
    }

    public boolean isFlip() {
        return flip;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image, int frameCount) {
        this.image = image;
        this.texture = new Texture(image);

        int frameWidth = texture.getWidth() / frameCount;
        TextureRegion[] animationFrames = new TextureRegion[frameCount];

        for (int i = 0; i < frameCount; i++) {
            animationFrames[i] = new TextureRegion(texture, i * frameWidth, 0, frameWidth, texture.getHeight());
        }

        this.animation = new Animation<>(0.1f, animationFrames);
        this.sprite.setTexture(texture);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public TextureRegion getTextures() {
        return textures;
    }

    public void setTextures(TextureRegion textures) {
        this.textures = textures;
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public void setAnimation(Animation<TextureRegion> animation) {
        this.animation = animation;
    }

    // Method to create Box2D body and fixtures
    public void createBody() {
        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(sprite.getX() + width/2, sprite.getY() + height/2);

        body = world.createBody(bdef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2, height / 2);

        fdef.shape = shape;

        body.createFixture(fdef);
        shape.dispose();
    }
    

    public Body getBody() {
        return body;
    }
    

    public void renderImage() {
        stateTime += Gdx.graphics.getDeltaTime();
        resetPositionToBody();

        TextureRegion currentFrame = this.getAnimation().getKeyFrame(stateTime, true);

        if (flip && !currentFrame.isFlipX()) {
            currentFrame.flip(true, false);
        } else if (!flip && currentFrame.isFlipX()) {
            currentFrame.flip(true, false);
        }

        batch.setProjectionMatrix(Camera.getCombined());
        batch.begin();
        batch.draw(currentFrame, this.getSprite().getX() - width/2, this.getSprite().getY() - height/2);
        batch.end();
    }
}
