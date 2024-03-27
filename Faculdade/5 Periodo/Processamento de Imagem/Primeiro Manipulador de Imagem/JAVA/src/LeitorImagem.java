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
            display(imagem);
            binarizacao(imagem);
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


    } public static void pretoEbrancoMedia (BufferedImage imagem){

        int p, a, r, g, b, md;

        for(int l = 0; l < imagem.getHeight(); l++){
            for(int c = 0; c < imagem.getWidth(); c++){

                p = imagem.getRGB(c, l);
                a = (p>>24)&0xff;
                r = (p>>16)&0xff;
                g = (p>>8)&0xff;
                b = p&0xff;
                md = (r+g+b)/3;
                p = (a<<24) | (md<<16) | (md<<8) | md;
                imagem.setRGB(c, l, p);
            }
        }

        display(imagem);

    }

    public static void maisVermelho (BufferedImage imagem){

        int p, a, r, g, b;

        for(int l = 0; l < imagem.getHeight(); l++){
            for(int c = 0; c < imagem.getWidth(); c++){

                p = imagem.getRGB(c, l);
                a = (p>>24)&0xff;
                r = (p>>16)&0xff;
                g = (p>>8)&0xff;
                b = p&0xff;

                r = ((r+60)>255)?(255):(r+60);

                p = (a<<24) | (r<<16) | (g<<8) | b;
                imagem.setRGB(c, l, p);
            }
        }

        display(imagem);

    }public static void maisVerde (BufferedImage imagem){

        int p, a, r, g, b;

        for(int l = 0; l < imagem.getHeight(); l++){
            for(int c = 0; c < imagem.getWidth(); c++){

                p = imagem.getRGB(c, l);
                a = (p>>24)&0xff;
                r = (p>>16)&0xff;
                g = (p>>8)&0xff;
                b = p&0xff;

                g = ((g+60)>255)?(255):(g+60);

                p = (a<<24) | (r<<16) | (g<<8) | b;
                imagem.setRGB(c, l, p);
            }
        }

        display(imagem);

    }public static void maisAzul (BufferedImage imagem){

        int p, a, r, g, b;

        for(int l = 0; l < imagem.getHeight(); l++){
            for(int c = 0; c < imagem.getWidth(); c++){

                p = imagem.getRGB(c, l);
                a = (p>>24)&0xff;
                r = (p>>16)&0xff;
                g = (p>>8)&0xff;
                b = p&0xff;

                b = ((b+60)>255)?(255):(b+60);

                p = (a<<24) | (r<<16) | (g<<8) | b;
                imagem.setRGB(c, l, p);
            }
        }

        display(imagem);

    }public static void negativo (BufferedImage imagem){

        int p, a, r, g, b;

        for(int l = 0; l < imagem.getHeight(); l++){
            for(int c = 0; c < imagem.getWidth(); c++){

                p = imagem.getRGB(c, l);
                a = (p>>24)&0xff;
                r = (p>>16)&0xff;
                g = (p>>8)&0xff;
                b = p&0xff;

                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                p = (a<<24) | (r<<16) | (g<<8) | b;
                imagem.setRGB(c, l, p);
            }
        }

        display(imagem);

   } public static void binarizacao (BufferedImage imagem){

        int p, a, r, g, b, md;

        for(int l = 0; l < imagem.getHeight(); l++){
            for(int c = 0; c < imagem.getWidth(); c++){

                p = imagem.getRGB(c, l);
                a = (p>>24)&0xff;
                r = (p>>16)&0xff;
                g = (p>>8)&0xff;
                b = p&0xff;

                md = (((r+g+b)/3)<120)?0:255;
                p = (a<<24) | (md<<16) | (md<<8) | md;

                imagem.setRGB(c, l, p);
            }
        }

        display(imagem);

    }



}
