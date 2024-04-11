import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;


class StateGraph {

    public static class Cidade {
        private String nome;
        private int ID;
        ArrayList<Cidade> conexoes; // Recebe os IDs das cidades com as quais tem conexao

        public void setCidade(String nome, int ID){
            this.nome = nome;
            this.ID = ID;
            this.conexoes = new ArrayList<Cidade>();
        }
        public void setConexao(Cidade cidade){
            this.conexoes.add(cidade);
        }
        public String getNome(){
            return this.nome;
        }
        public int getID(){
            return this.ID;
        }
        public ArrayList<Cidade> getConexoes(){
            return this.conexoes;
        }

    }
    public static class Estradas{

    }

//////////////////////////////////////////////////////

    public static void main (String[] args) {

        Vector<Integer> matrix = new Vector<>(); // É um vetor 2D que segue a formula [coluna * num_elementos + linha]
        ArrayList<Cidade> cidades = new ArrayList<>();
        cidades.add(criaCidade(cidades.size()));

        Cidade cidade = new Cidade();
        cidade = cidades.get(0);
        System.out.println("Nome: " + cidade.getNome() + "ID: " + cidade.getID());

        String test = cidade.toString();
        System.out.println("Test muito doido \n" + test);
        escreverArquivo();



    }
//////////////////////////////////////////////////////

    public static Cidade criaCidade(int num_cidades){


        Cidade cidade = new Cidade();
        Scanner entrada = new Scanner(System.in);
        String nome;
        System.out.println("Qual o nome da cidade que vc deseja adicionar?");
        nome = entrada.nextLine();
        cidade.setCidade(nome, num_cidades);
        entrada.close();

        return cidade;


    }
    public static void escreverArquivo(){


        try {
            File nova_file = new File("../Mapa/test.txt");
            if(nova_file.createNewFile()){
                System.out.println("O arquivo foi criado: "+nova_file.getName());

            }else{
                System.out.println("Aiquivo ja exuiste");
            }
        } catch(IOException e){
            System.out.println("Não foi possivel criar o arquivo!");
            e.printStackTrace();
        }

    }



}
