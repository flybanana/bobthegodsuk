package com.missionbit.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.Random;

public class AnimationExercise extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Random randomSource;
//    private Sprite myImage;
    private SpriteBatch myBatch;
//    private Vector2 velocity;
  //  private Flyingdog dog;
    private ArrayList<Flyingdog> creatures = new ArrayList<Flyingdog>();

    @Override
    public void create() {
        randomSource = new Random();

        // Set up camera for 2d view of 800x480 pixels
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // Create a sprite batch for rendering our image
        myBatch = new SpriteBatch();

        //TODO: Load our image
//        myImage = new Sprite(new Texture(Gdx.files.internal("image/ob.png")));
//        myImage.setX(200);
//        myImage.setY(200);
//        // Create a random X and Y velocity
//        velocity = new Vector2(- randomSource.nextFloat() * 300, - randomSource.nextFloat() * 300);
       // dog = new Flyingdog(myBatch);
        for(int i = 0; i < 10; i++){
            Flyingdog f = new Flyingdog(myBatch);
            creatures.add(f);
        }
    }

    @Override
    public void render() {
//        float xPos = myImage.getX() + velocity.x * Gdx.graphics.getDeltaTime();
//        float yPos = myImage.getY() + velocity.y * Gdx.graphics.getDeltaTime();
//
//        myImage.setX(xPos);
//        myImage.setY(yPos);

        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Set up our camera
        camera.update();
        myBatch.setProjectionMatrix(camera.combined);

//        if(myImage.getX() < 0) {
//            myImage.setX(0);
//            velocity.x *= -1;
//        }
//        if(myImage.getY() < 0) {
//            myImage.setY(0);
//            velocity.y *= -1;
//        }
//        if(myImage.getX() + myImage.getWidth() > Gdx.graphics.getWidth() ) {
//            myImage.setX(Gdx.graphics.getWidth()- myImage.getWidth());
//            velocity.x *= -1;
//        }
//        if(myImage.getY() + myImage.getHeight() > Gdx.graphics.getHeight() ) {
//            myImage.setY(Gdx.graphics.getHeight() - myImage.getHeight());
//            velocity.y *= -1;
//        }
            //TODO: Draw our image!
        myBatch.begin();
          // dog.update();
    // myImage.draw(myBatch);
        for(Flyingdog s : creatures) {
            // dog.draw();
          s.update();
          s.draw();

        }
         myBatch.end();


        if(Gdx.input.isTouched()){
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

            camera.unproject(touchPos);
            System.out.println(touchPos.x + " " + touchPos.y);
            for(Flyingdog s : creatures){
             s.handleClick(touchPos);
            }
           // dog.handleClick(touchPos);
//         boolean Image = myImage.getBoundingRectangle().contains(touchPos.x, touchPos.y);
//               System.out.println(Image);
//               if(Image){
//                   myImage.setColor(1, 0, 1, 1);  //Choose any RGB values//
//               }
//              else {
//                   myImage.setColor(1, 1, 0, 1);  //Choose any RGB values//
               }

        }
   // }

    @Override
    public void dispose() {
        myBatch.dispose();
        {
        }
    }
}