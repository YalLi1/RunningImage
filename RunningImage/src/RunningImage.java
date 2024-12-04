import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RunningImage extends JPanel{
    private Image image;
    private int xPosition = 0; // положение по оси х
    private int yPosition = 0; // положение по оси у
    private final int speed = 5; // скорость перемещения изображения

    //загружаем изображение
    public RunningImage(){
        try{
            image = ImageIO.read(new File("C:\\Users\\New\\Pictures\\1.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // create timer
        Timer timer = new Timer(30, e -> moveImage());
        timer.start();
    }

    private void moveImage(){
        // обновление позиции изображения
        xPosition += speed;
        yPosition += speed;

        if(xPosition> getWidth() || yPosition> getHeight()){
            xPosition = 0;
            yPosition = 0;
        }
       repaint();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Рисуем изображение
        if (image != null) {
            g.drawImage(image, xPosition, yPosition, null);
        }
    }



}
