package org.academiadecodigo.bootcamp.oportunity.FallingObjects;

import org.academiadecodigo.bootcamp.oportunity.Game;
import org.academiadecodigo.bootcamp.oportunity.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.TimeUnit;

public class SlackZip implements FallingObject {

    private final Picture image;
    private final Game game;
    private final Player player;

    public SlackZip(Player player,Game game) {
        this.game=game;
        image = new Picture((int) (Math.random() * 940), 30, "slackZIP.png");
        image.draw();
        this.player=player;
    }
    public void startFalling() throws InterruptedException {

        TimeUnit.MILLISECONDS.sleep(2);
        image.translate(0, 3);
    }
    public boolean collisionChecker() {

        if (this.getImage().getMaxY() > player.getPlayer().getY()+20 &&
                this.getImage().getMaxX()  > player.getPlayer().getX() &&
                this.getImage().getX()  < player.getPlayer().getMaxX()) {
            player.setScore(0);
            this.image.delete();


            /*game.getText().delete();
            game.setText(new Text(470, 100, "GAME OVER"));
            game.getText().draw();*/
            game.getText().setColor(Color.WHITE);
            game.getText().grow(17,8);
            game.getText().translate(10,10);

            Picture gameOver = new Picture(250,35 , "gameover.png");
            gameOver.draw();



            Text textt =new Text(120,70,"SCORE");
            textt.draw();
            textt.grow(50,20);
            textt.setColor(Color.WHITE);

            Text gitsNaAreia = new Text (470,370,"GIT's perdidos na areia: " + game.getGitNaAreiainString());
            gitsNaAreia.draw();
            gitsNaAreia.grow(300,30);
            gitsNaAreia.setColor(Color.WHITE);

            game.setGameOver();

            return false;

        }
        if (this.getImage().getMaxY() > 790) {
            System.out.println("slackamos");
            this.image.delete();
            return true;
        }
        return false;
    }


    public Picture getImage() {
        return image;
    }
}
