import java.util.*;

class ComandaEletronica{


    public static class Comanda{

        private int ID;
        private int ID_cliente;
        private int ID_atendente;
        private int num_mesa;
        private ArrayList<Consumo> consumo;

        public void init(int ID, int ID_cliente, int ID_atendente, int num_mesa, ArrayList<Consumo> consumo){
            this.ID = ID;
            this.ID_cliente = ID_cliente;
            this.ID_atendente = ID_atendente;
            this.num_mesa = num_mesa;
            this.consumo = consumo;
        }

        public

    }
    public static class Atendente{
        private int ID;
        private String nome;
        private float salario;
        private float atendimentos;

        public void init(int ID, String nome, float salario){
            this.ID = ID;
            this.nome = nome;
            this.salario = salario;
            this.atendimentos = 0.0f;

        }



    }
    public class Produto{

        private int ID;
        private String nome;
        private float valor;

        public void init(int ID, String nome, float valor){
            this.ID = ID;
            this.nome = nome;
            this.valor = valor;
        }
        public void changeNome(String novo_nome){
            this.nome = novo_nome;
        }
        public void changeValor(float novo_valor){
            this.valor = novo_valor;
        }
        public int getID(){
            return this.ID;
        }
        public String getNome(){
            return this.nome;
        }
        public float getValor(){
            return this.valor;
        }

    }
    public class Consumo{

        private Produto produto;
        private int quantidade;

        public void init(Produto produto, int quantidade){
            this.produto = produto;
            this.quantidade = quantidade;
        }

    }


    public static void main (String[] args) {

    }
}
