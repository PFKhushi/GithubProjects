import java.util.*;

class TextoSaida{

    final static String PretoBG= "\u001b[40m";
    final static String BrancoBG = "\u001b[107m";
    final static String AzulBG = "\u001b[104m";
    final static String AmareloBG = "\u001b[103m";
    final static String CinzaBG = "\u001b[100m";

    final static String PretoF = "\u001b[30;1m";
    final static String BrancoF = "\u001b[97;1m";
    final static String AzulF = "\u001b[34;1m";
    final static String AmareloF = "\u001b[93;1m";
    final static String CinzaF = "\u001b[90;1m";

    final static String RESET = "\u001b[0m";

    public enum CorF{
        PRETO, BRANCO, AZUL, AMARELO, CINZA;
    }
    public enum CorBG{
        PRETO, BRANCO, AZUL, AMARELO, CINZA;
    }

    public enum Comp{
        LABEL, EDIT, MEMO;
    }


    public static class Texto{

        private String texto;
        private int font_size;
        private CorF cor_f;
        private CorBG cor_bg;
        private Comp componente;

        public void init(String texto, int font_size, CorF cor_f, CorBG cor_bg, Comp componente){
            this.texto = texto;
            this.font_size = font_size;
            this.cor_f =cor_f;
            this.cor_bg = cor_bg;
            this.componente = componente;
        }
        public void setTexto(String texto){
            this.texto = texto;
        }
        public void setFontSize(int size){
            this.font_size = size;
        }
        public void setCorF(CorF cor){
            this.cor_f = cor;
        }
        public void setCorBG(CorBG cor){
            this.cor_bg = cor;
        }
        public void setComp(Comp componente){
            this.componente = componente;
        }
        public String getTexto(){
            return this.texto;
        }
        public int getFontSize(){
            return this.font_size;
        }
        public CorF getFontColor(){
            return this.cor_f;
        }
        public CorBG getBGColor(){
            return this.cor_bg;
        }
        public Comp getComponente(){
            return this.componente;
        }



    }
    public static Texto criaTexto(Texto texto){

        Scanner entrada = new Scanner(System.in);
        CorF cor_f=null;
        CorBG cor_bg=null;
        Comp componente=null;

        System.out.println("Escreva o texto:\n");
        String text = entrada.nextLine();

        System.out.println("Digite o tamanho da fonte:\n");
        int tamanho = entrada.nextInt();

        System.out.println("Digite o número da cor da fonte");

        System.out.println("1 - Preto\n2 - Branco\n3 - Azul\n4 - Amarelo\n5 - Cinza");
        int resp = entrada.nextInt();
        switch (resp){
            case 1:
               cor_f = CorF.PRETO;
               break;
            case 2:
               cor_f = CorF.BRANCO;
               break;
            case 3:
               cor_f = CorF.AZUL;
               break;
            case 4:
               cor_f = CorF.AMARELO;
               break;
            case 5:
               cor_f = CorF.CINZA;
               break;
        }

        System.out.println("Digite a cor do fundo:\n");
        System.out.println("1 - Preto\n2 - Branco\n3 - Azul\n4 - Amarelo\n5 - Cinza");

        resp = entrada.nextInt();

        switch (resp){
            case 1:
               cor_bg = CorBG.PRETO;
               break;
            case 2:
               cor_bg = CorBG.BRANCO;
               break;
            case 3:
               cor_bg = CorBG.AZUL;
               break;
            case 4:
               cor_bg = CorBG.AMARELO;
               break;
            case 5:
               cor_bg = CorBG.CINZA;
               break;
        }
        System.out.println("Qual o tipo de componente:\n\n1 - LABEL\n2 - EDIT\n3 - MEMO\n\n");
        resp = entrada.nextInt();

        switch(resp){
            case 1:
                componente = Comp.LABEL;
                break;
            case 2:
                componente = Comp.EDIT;
                break;
            case 3:
                componente = Comp.MEMO;
                break;

        }


        texto.init(text,tamanho,cor_f,cor_bg,componente);
        return texto;
    }

    public static void printTexto(Texto texto){

        System.out.println("Tamanho Fonte: " + texto.getFontSize());
        System.out.println("Cor Fonte: " + texto.getFontColor());
        System.out.println("Cor Background: " + texto.getBGColor());
        System.out.println("Componente: " + texto.getComponente());

        switch(texto.getFontColor()){
            case PRETO:
                System.out.println(PretoF);
                break;
            case BRANCO:
                System.out.println(BrancoF);
                break;
            case AZUL:
                System.out.println(AzulF);
                break;
            case AMARELO:
                System.out.println(AmareloF);
                break;
            case CINZA:
                System.out.println(CinzaF);
                break;
        }
        switch(texto.getBGColor()){

            case PRETO:
                System.out.println(PretoBG);
                break;
            case BRANCO:
                System.out.println(BrancoBG);
                break;
            case AZUL:
                System.out.println(AzulBG);
                break;
            case AMARELO:
                System.out.println(AmareloBG);
                break;
            case CINZA:
                System.out.println(CinzaBG);
                break;
        }

        System.out.println(texto.getTexto());
        System.out.println(RESET);

    }

    public static void main (String[] args) {

        Texto text = new Texto();
        text = criaTexto(text);

        printTexto(text);

    }
}
