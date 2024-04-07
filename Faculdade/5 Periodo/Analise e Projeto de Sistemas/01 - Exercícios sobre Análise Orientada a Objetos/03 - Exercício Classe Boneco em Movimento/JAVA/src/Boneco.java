import java.util.Scanner;

class MoveBoneco{

    final static String BRANCO = "\u001b[107m \u001b[0m";
    final static String PRETO = "\u001b[40m \u001b[0m";
    final static String VERMELHO = "\u001b[101m \u001b[0m";
    final static String RESET = "\u001b[0m";

    final static int map_size = 8;

    public static class Boneco{

        private int ID, posX, posY;
        private String nome;

        public void init(int ID, String nome, int posX, int posY){
            this.ID = ID;
            this.nome = nome;
            this.posX = posX;
            this.posY = posY;
        }
        public int getX(){
            return  this.posX;
        }
        public int getY(){
            return posY;
        }
        public void cima(){
            this.posY = (posY - 1) >= 0 ? (posY - 1) : posY;
        }
        public void baixo(){
            this.posY = (posY + 1) < map_size ? (posY + 1) : posY;
        }
        public void direita(){
            this.posX = (posX + 1) < map_size ? (posX + 1) : posX;
        }
        public void esquerda(){
            this.posX = (posX - 1) >= 0 ? (posX - 1) : posX;
        }


    }
    public static void fazMatrix(String mapa[], Boneco boneco){
        int tez=0;
        for(int l =0; l<map_size;l++){
            for(int c=0; c<map_size;c++){
                mapa[(l * map_size) + c] = (((l * map_size) + c) % 2) == tez?PRETO : BRANCO;
            }
            tez = tez==0?1:0;
        }
        mapa[(boneco.getY() * map_size) + boneco.getX()] = VERMELHO;

    }
    public static void printMatrix(String mapa[]){


        refresh();
        for(int l = 0; l < map_size; l++){
            for(int c = 0; c < map_size; c++){
                System.out.print(mapa[(l * map_size) + c]);
            }
            System.out.print("\n");
        }


    }
    public static void refresh(){

        for (int i = 0; i < 600; i++) System.out.println("\b");
    }
    public static void jogar(String mapa[], Boneco boneco){


        Scanner entrada = new Scanner(System.in);
        String resp;
        boolean tester = true;

        while(tester == true){
            fazMatrix(mapa,boneco);
            printMatrix(mapa);

            System.out.println("Digite para qual lado se mover (cima, baixo, direita, esquerda) ou \'cancel\' para cancelar");
            resp = entrada.nextLine();

            if(resp == "cancel") tester = false;
            switch(resp){
                case "cima":
                    boneco.cima();
                    continue;
                case "baixo":
                    boneco.baixo();
                    continue;
                case "direita":
                    boneco.direita();
                    continue;
                case "esquerda":
                    boneco.esquerda();
                    continue;
                case "cancel":
                    tester = false;
                    continue;
            }
            System.out.println("Nao entendi...");

        }
    }

    public static void main (String[] args) {

        String mapa[]=new String[map_size * map_size];
        Boneco boneco = new Boneco();
        boneco.init(666, "Khushi", 4,6);

        jogar(mapa, boneco);

    }
}
