import java.time.*;
import java.util.*;


public class ContaLuz{



    private static class Fatura{

        private LocalDate dt_leitura;
        private int num_leitura;
        private int KW_gasto;
        private float valor;
        private LocalDate dt_pagamento;
        private float media_gasto;

        public void init(LocalDate dt_leitura, int num_leitura, int KW_gasto, float valor){

            this.dt_leitura = dt_leitura;
            this.num_leitura = num_leitura;
            this.KW_gasto = KW_gasto;
            this.valor = valor;
            setMedia();

        }

        public void setMedia(){
           this.media_gasto = this.valor/this.dt_leitura.lengthOfMonth();
        }

        public LocalDate getDtLeitura(){
            return this.dt_leitura;
        }

        public LocalDate getDtPagamento(){
            return this.dt_pagamento;
        }

        public int getNumLeitura(){
            return this.num_leitura;
        }

        public int getKWGasto(){
            return this.KW_gasto;
        }

        public float getValor(){
            return this.valor;
        }
        public float getMedia(){
            return this.media_gasto;
        }






    }
    private static class Planilha{

        private ArrayList<Fatura> faturas;

        public void addFatura(){

            LocalDate dt_leitura, dt_pagamento;
            int num_leitura, KW_gasto, dia, mes, ano;
            float valor, media_gasto;


            Scanner entrada = new Scanner(System.in);
            Fatura fatura = new Fatura();
            System.out.println("Insira os dados na fatura: ");
            System.out.println("Digite a data da leitura: \nEx: 2024-04-25");



            fatura.init();
        }

        private class MaiorMenor{

            float maior, menor;
            LocalDate dt_maior, dt_menor;

            public void setMaiorMenor(Fatura fatura){
                if(fatura.getValor() > this.maior){


                }
            }

        }
    }



    public static void main (String[] args) {

        LocalDate test = LocalDate.of(2024, 1, 4);
        int test2 = test.lengthOfMonth();
        System.out.println("LOD: " + test2);
        System.out.println("LocalDate: "+test);


    }

}
