package org.academiadecodigo.bootcamp.oportunity;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private final Picture player;
    private int score;



    public Picture getPlayer() {
        return player;
    }

    public Player (Game game) {
        this.player = new Picture (473, 620, "trigueirinha.png");
        player.draw();
        //new Handler(this,game);
    }


    public void moveRight () {
        if(player.getX()> 900){
            return;
        }else {
            player.translate(30, 0);

        }
    }
    public void moveLeft () {
        if(player.getX()<50){
            return;
        }else{
        player.translate(-30, 0);
        }
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getScoreInString() {
        return String.valueOf(getScore());
    }


}
