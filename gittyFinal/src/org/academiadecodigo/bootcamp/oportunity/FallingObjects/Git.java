package org.academiadecodigo.bootcamp.oportunity.FallingObjects;

import org.academiadecodigo.bootcamp.oportunity.Game;
import org.academiadecodigo.bootcamp.oportunity.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.TimeUnit;

public class Git implements FallingObject{
    private final Picture image;
    private final Game game;
    private final Player player;





    public Git(Player player,Game game) {
        this.game=game;
        image = new Picture((int) (Math.random() * 940), 30, "git.png");
        image.draw();
        this.player=player;




    }
    public void startFalling() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(3);
        image.translate(0, 3);
    }
    public boolean collisionChecker() {

        if (this.getImage().getMaxY() > player.getPlayer().getY()+20 &&   //IF the player Catches
                this.image.getMaxX()  > player.getPlayer().getX() &&
                this.image.getX()  < player.getPlayer().getMaxX()) {
            System.out.println("ai que bati GIT!");
            this.image.delete();
            player.setScore(player.getScore()+5);
            System.out.println(player.getScore());

            game.getText().delete();
            game.setText(new Text(100, 100, player.getScoreInString()));
            game.getText().draw();
            game.getText().setColor(Color.WHITE);
            game.getText().grow(30,20);

            return true;
        }
        else if (this.getImage().getMaxY() > 790) {  //if it falls on the ground

            if(player.getScore()>2){
            player.setScore(player.getScore()-2);
            System.out.println(player.getScore());}

            this.image.load("git-na-areia.png");
            System.out.println("gitygity");
            game.setCounterDeAreia(game.getCounterDeAreia()+1);
            System.out.println(game.getCounterDeAreia());

            if (game.getCounterDeAreia()>50){
                this.image.load("castelo.png");
                //game.setCounterDeAreia(0);
            }


            game.getText().delete();
            game.setText(new Text(100, 100, player.getScoreInString()));
            game.getText().draw();
            game.getText().setColor(Color.WHITE);
            game.getText().grow(30,20);

            return true;
        }
        return false;
    }


    public Picture getImage() {
        return image;
    }
}
