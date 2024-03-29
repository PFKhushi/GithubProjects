import java.util.*;
import java.IO.BufferedWriter;
import java.IO.FileWriter;


class StateGraph {

    public static class Cidade {
        private String nome;
        private int ID;
        Vector<Integer> conexoes; // Recebe os IDs das cidades com as quais tem conexao

        public void setCidade(String nome, int ID){
            this.nome = nome;
            this.ID = ID;
        }
        public void setConexaop(int ID){

            this.conexoes.add(ID);
        }

        public String getNome(){
            return this.nome;
        }
        public int getID(){
            return this.ID;
        }
        public Vector<Integer> getConexoes(){
            return this.conexoes;
        }

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

        File

    }



}
