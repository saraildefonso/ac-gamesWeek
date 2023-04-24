package org.academiadecodigo.bootcamp.oportunity;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {
    public static final int PADDING = 10;


    public Background () {
        Picture field = new Picture(PADDING, PADDING, "background.jpg");
        field.draw();
    }


}
