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

        File file = new File("../../DATOS/Originais/image.png");
        BufferedImage imagem = null;
        BufferedImage nova_imagem = null;

        try {
            imagem = ImageIO.read(file);

        } catch(IOException e){
            e.printStackTrace(System.out);
        }

        if (imagem != null){
           /// display(imagem);
            pretoEbranco(imagem);
            display(imagem);
        }

    }
    public static void display (BufferedImage imagem) {
        System.out.println("Displaying image");
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        frame.setSize(imagem.getWidth(), imagem.getHeight());
        label.setIcon(new ImageIcon(imagem));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
    public static void pretoEbranco (BufferedImage imagem){

        int p, a, r, g, b, md;

        for(int l = 0; l < imagem.getHeight(); l++){
            for(int c = 0; c < imagem.getWidth(); c++){

                System.out.println(1);
                p = imagem.getRGB(c, l);
                System.out.println(2);
                a = (p>>24)&0xff;
                System.out.println(3);
                r = (p>>16)&0xff;
                System.out.println(4);
                g = (p>>8)&0xff;
                System.out.println(5);
                b = p&0xff;
                System.out.println(6);

                md = (r+g+b)/3;
                System.out.println(7);

                p = (a<<24) | (md<<16) | (md<<8) | md;
                System.out.println(8);

                imagem.setRGB(c, l, p);
                System.out.println("\n\nLinha: " + l + " Coluna: " + c);
                System.out.println("Height " + imagem.getHeight() + " Width " + imagem.getWidth());
            }
        }

        display(imagem);

    }
}
