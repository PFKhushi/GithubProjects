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

        imagem = fazImagem(file);

        while(imagem != null){

            display(imagem, "Original");
            RGB2YIQnback(file);

            pretoEbrancoMedia(imagem);
            imagem = fazImagem(file);

            maisVermelho(imagem);
            imagem = fazImagem(file);

            maisVerde(imagem);
            imagem = fazImagem(file);

            maisAzul(imagem);
            imagem = fazImagem(file);

            binarizacao(imagem);
            imagem = fazImagem(file);

            negativo(imagem);

            imagem = null;

        }

    }

    public static BufferedImage fazImagem(File file){

        BufferedImage imagem = null;

        try {
            imagem = ImageIO.read(file);

        } catch(IOException e){
            e.printStackTrace(System.out);
        }

        return imagem;
    }

    public static void display (BufferedImage imagem, String nome) {
        System.out.println("Displaying image");
        JFrame frame = new JFrame(nome);
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

        display(imagem, "Preto e Branco Média");

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

        display(imagem, "Mais Vermelho");

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

        display(imagem, "Mais Verde");

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

        display(imagem, "Mais Azul");

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

        display(imagem, "Negativo RGB");

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

        display(imagem, "Binarização");

    }

    public static void RGB2YIQnback(File file){

        BufferedImage brilho_immagine, negativo_immagine, magenta_immagine, ciano_immagine, pb_immagine;

        int p, a, r, g, b, md;
        float y, i, q;

        brilho_immagine = fazImagem(file);
        negativo_immagine = fazImagem(file);
        magenta_immagine = fazImagem(file);
        ciano_immagine = fazImagem(file);
        pb_immagine = fazImagem(file);

        for(int l = 0; l < brilho_immagine.getHeight(); l++){
            for(int c = 0; c < brilho_immagine.getWidth(); c++){


                //////////////////////////////////////////////
                p = brilho_immagine.getRGB(c, l);
                a = (p>>24)&0xff;
                r = (p>>16)&0xff;
                g = (p>>8)&0xff;
                b = p&0xff;

                y = (0.299f*r)+(0.587f*g)+(0.114f*b);
                i = (0.596f*r)-(0.274f*g)-(0.322f*b);
                q = (0.211f*r)-(0.523f*g)+(0.312f*b);

                y*=1.40f;

                r = (int)(y+(0.956f*i)+(0.621f*q));
                g = (int)(y-(0.272f*i)-(0.647f*q));
                b = (int)(y-(1.106f*i)+(1.703f*q));

                r = (r >= 0 && r <= 200)? r : ((r < 0) ? 0 : 200);
                g = (g >= 0 && g <= 200)? g : ((g < 0) ? 0 : 200);
                b = (b >= 0 && b <= 200)? b : ((b < 0) ? 0 : 200);

                p = (a<<24) | (r<<16) | (g<<8) | b;
                brilho_immagine.setRGB(c, l, p);
                //////////////////////////////////////////////

                p = negativo_immagine.getRGB(c, l);
                a = (p>>24)&0xff;
                r = (p>>16)&0xff;
                g = (p>>8)&0xff;
                b = p&0xff;

                y = (0.299f*r)+(0.587f*g)+(0.114f*b);
                i = (0.596f*r)-(0.274f*g)-(0.322f*b);
                q = (0.211f*r)-(0.523f*g)+(0.312f*b);

                y = 255 - y;

                r = (int)(y+(0.956f*i)+(0.621f*q));
                g = (int)(y-(0.272f*i)-(0.647f*q));
                b = (int)(y-(1.106f*i)+(1.703f*q));

                r = (r >= 0 && r <= 200)? r : ((r < 0) ? 0 : 200);
                g = (g >= 0 && g <= 200)? g : ((g < 0) ? 0 : 200);
                b = (b >= 0 && b <= 200)? b : ((b < 0) ? 0 : 200);
                p = (a<<24) | (r<<16) | (g<<8) | b;

                negativo_immagine.setRGB(c, l, p);
                ///////////////////////////////////////////////


                p = magenta_immagine.getRGB(c, l);
                a = (p>>24)&0xff;
                r = (p>>16)&0xff;
                g = (p>>8)&0xff;
                b = p&0xff;

                y = (0.299f*r)+(0.587f*g)+(0.114f*b);
                i = 0;
                q = (0.211f*r)-(0.523f*g)+(0.312f*b);

                r = (int)(y+(0.956f*i)+(0.621f*q));
                g = (int)(y-(0.272f*i)-(0.647f*q));
                b = (int)(y-(1.106f*i)+(1.703f*q));

                r = (r >= 0 && r <= 200)? r : ((r < 0) ? 0 : 200);
                g = (g >= 0 && g <= 200)? g : ((g < 0) ? 0 : 200);
                b = (b >= 0 && b <= 200)? b : ((b < 0) ? 0 : 200);
                p = (a<<24) | (r<<16) | (g<<8) | b;

                magenta_immagine.setRGB(c, l, p);
                /////////////////////////////////////////////////



                p = ciano_immagine.getRGB(c, l);
                a = (p>>24)&0xff;
                r = (p>>16)&0xff;
                g = (p>>8)&0xff;
                b = p&0xff;

                y = (0.299f*r)+(0.587f*g)+(0.114f*b);
                i = (0.596f*r)-(0.274f*g)-(0.322f*b);
                q = 0;


                r = (int)(y+(0.956f*i)+(0.621f*q));
                g = (int)(y-(0.272f*i)-(0.647f*q));
                b = (int)(y-(1.106f*i)+(1.703f*q));

                r = (r >= 0 && r <= 200)? r : ((r < 0) ? 0 : 200);
                g = (g >= 0 && g <= 200)? g : ((g < 0) ? 0 : 200);
                b = (b >= 0 && b <= 200)? b : ((b < 0) ? 0 : 200);

                p = (a<<24) | (r<<16) | (g<<8) | b;


                ciano_immagine.setRGB(c, l, p);
                ////////////////////////////////////////////////



                p = pb_immagine.getRGB(c, l);
                a = (p>>24)&0xff;
                r = (p>>16)&0xff;
                g = (p>>8)&0xff;
                b = p&0xff;

                y = (0.299f*r)+(0.587f*g)+(0.114f*b);
                i = 0;
                q = 0;


                r = (int)(y+(0.956f*i)+(0.621f*q));
                g = (int)(y-(0.272f*i)-(0.647f*q));
                b = (int)(y-(1.106f*i)+(1.703f*q));

                r = (r >= 0 && r <= 200)? r : ((r < 0) ? 0 : 200);
                g = (g >= 0 && g <= 200)? g : ((g < 0) ? 0 : 200);
                b = (b >= 0 && b <= 200)? b : ((b < 0) ? 0 : 200);

                p = (a<<24) | (r<<16) | (g<<8) | b;


                pb_immagine.setRGB(c, l, p);


            }

        }
        display(brilho_immagine, "Brilho");
        display(negativo_immagine, "Negativo");
        display(magenta_immagine, "Zero o I");
        display(ciano_immagine, "Zera o Q");
        display(pb_immagine, "Preto e Branco");




    }

    /*
    public static BufferedImage copyImage(BufferedImage source){

        BufferedImage copia = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics conteudo = new Ge


    }
*/


}
