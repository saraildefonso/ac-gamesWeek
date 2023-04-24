package org.academiadecodigo.bootcamp.oportunity;

import org.academiadecodigo.bootcamp.oportunity.FallingObjects.FallingObject;
import org.academiadecodigo.bootcamp.oportunity.FallingObjects.Git;
import org.academiadecodigo.bootcamp.oportunity.FallingObjects.SlackZip;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player;
    private FallingObject git;
    private Text text;
    private  boolean gameOver = false;
    private boolean startGame = false;
    private int counterDeAreia = 0;

    public void init() {
        Background Background = new Background();
        player = new Player(this);
        new Handler(player,this);
        git = new Git(player,this);


        Picture menu = new Picture(10,10,"MenuIniciar.png");
        menu.draw();
        while(!startGame){
            System.out.println("waiting ...");
        }
        menu.delete();



    }
    
    public void start() throws InterruptedException {
        text = new Text(100, 100, player.getScoreInString());
        text.draw();
        text.setColor(Color.WHITE);
        text.grow(30,20);
        
        while(!gameOver){

            git.startFalling();
            git.collisionChecker();
            if (git.collisionChecker()){
                System.out.println("--------------------");
                int p =  (int)(Math.random()*10);
                if (p<5) {
                    System.out.println("git");
                     git =  new Git(player,this);
            
                } else {
                    System.out.println("zip");
                    git= new SlackZip(player,this);
                }
            }
        }
    }

    public Text getText(){
        return text;
    }
    public void setText(Text text){
        this.text=text;
    }
    public void setGameOver(){
        gameOver=true;
    }
    public void setGameStart(boolean start){
        this.startGame=start;
    }


    public int getCounterDeAreia() {
        return counterDeAreia;
    }

    public void setCounterDeAreia(int counterDeAreia) {
        this.counterDeAreia = counterDeAreia;
    }
    public String getGitNaAreiainString() {
        return String.valueOf(counterDeAreia/3);
    }
}

