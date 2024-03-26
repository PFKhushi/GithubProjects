import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LeitorImagem{

    public static void main (String[] args) {
        try {
            ///File imagem = new File("Primeiro Manipulador de Imagem/DATOS/Originais/image.png");
            BufferedImage image = ImageIO.read(new File("../../DATOS/Originais/image.png"));

            // Create a JLabel to hold the image icon
            JLabel imageLabel = new JLabel(new ImageIcon(image));

            // Create a JFrame to display the image
            JFrame frame = new JFrame("Image Display");
            frame.add(imageLabel);
            frame.pack();
            frame.setVisible(true);

        } catch(Exception e){
            e.printStackTrace();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.exit(0);


    }
}
