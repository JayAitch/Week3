package com.jharrison.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends ApplicationAdapter {
	private static final Color BACKGROUND_COLOUR = new Color(0f,0f,0f,1.0f);
	private static final  float WORLD_TO_SCREEN = 1.0f/100.0f;
	private  static final float SCENE_WIDTH = 12.0f;
	private  static  final  float SCENE_HEIGHT = 7.00f;

	private OrthographicCamera camera;
	private Viewport viewport;
	private SpriteBatch batch;
	private TextureAtlas atlas;
	private TextureRegion astronautRegion, saturnRegion;

	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		viewport = new FitViewport(SCENE_WIDTH,SCENE_HEIGHT,camera);
		atlas = new TextureAtlas(Gdx.files.internal("outer_space_assets.atlas"));
		astronautRegion = atlas.findRegion("astronaut");
		saturnRegion = atlas.findRegion("saturn");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		float width = saturnRegion.getRegionWidth();
		float height = saturnRegion.getRegionHeight();
		float originX = width * 0.5f;
		float originY = height * 0.5f;

		batch.draw(saturnRegion,
				- originX + 0.1f, -originY + 0.1f,
				originX, originY,
				width, height,
				WORLD_TO_SCREEN, WORLD_TO_SCREEN *2,
				0.0f);
		batch.draw(astronautRegion,
				- originX + 0.1f, -originY + 0.1f,
				originX, originY,
				width, height,
				WORLD_TO_SCREEN, WORLD_TO_SCREEN *2,
				0.0f);

		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
