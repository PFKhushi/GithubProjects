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

        public void init(LocalDate dt_leitura, LocalDate dt_pagamento, int num_leitura, int KW_gasto, float valor){

            this.dt_leitura = dt_leitura;
            this.dt_pagamento = dt_pagamento;
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
        private float maior, menor;
        private LocalDate dt_maior, dt_menor;

        public ArrayList<Fatura> getLista(){
            return this.faturas;
        }
        public float getMenor(){
            return this.menor;
        }
        public float getMaior(){
            return this.maior;
        }
        public LocalDate getDtMaior(){
            return this.dt_maior;
        }
        public LocalDate getDtMenor(){
            return this.dt_menor;
        }

        public void init(){
            ArrayList<Fatura> faturas = new ArrayList<>();
            this.faturas = faturas;
            this.maior = 0f;
            this.menor = 9999999f;
        }

        public void addFatura(){
            Fatura fatura = new Fatura();
            fatura = criaFatura();
            if(fatura==null) return;
            this.faturas.add(fatura);
            checkMaiorMenor(fatura);

        }

        private Fatura criaFatura(){

            LocalDate dt_leitura, dt_pagamento;
            int num_leitura, KW_gasto;
            float valor;
            String resp;
            Boolean feito = false;

            dt_leitura = dt_pagamento = null;
            num_leitura = KW_gasto = -1;
            valor = -1;

            Scanner entrada = new Scanner(System.in);
            Fatura fatura = new Fatura();
            System.out.println("Insira os dados na fatura: ");

            while(!feito){
                System.out.println("Digite a data da leitura: \nEx: 2024-04-25\n ou \'cancel\' para cancelar ");
                resp = entrada.nextLine();
                if(resp == "cancel") return null;
                try{
                    dt_leitura = LocalDate.parse(resp);
                    feito = true;
                }catch(Exception e){
                    System.out.println("Data errada..");
                }
            }
            feito = false;
            while(!feito){

                System.out.println("Digite a data do pagamento: \nEx: 2024-04-25\n ou \'cancel\' para cancelar ");
                resp = entrada.nextLine();
                if(resp == "cancel") return null;
                try{
                    dt_pagamento = LocalDate.parse(resp);
                    feito = true;
                }catch(Exception e){
                    System.out.println("Data errada..");
                }

            }
            feito=false;
            while(!feito){
                System.out.println("Digite o número de leitura: \nou digite \'cancel\' para cancelar");
                resp = entrada.nextLine();
                if(resp == "cancel")return null;
                try{
                    num_leitura = Integer.parseInt(resp);
                    feito = true;
                }catch(Exception e){
                    System.out.println("Número inválido");
                }

            }
            feito=false;
            while(!feito){
                System.out.println("Digite o número de KW gasto: \nou digite \'cancel\' para cancelar");
                resp = entrada.nextLine();
                if(resp == "cancel")return null;
                try{
                    KW_gasto = Integer.parseInt(resp);
                    feito=true;
                }catch(Exception e){
                    System.out.println("Número inválido");
                }
            }
            feito = false;
            while(!feito){
                System.out.println("Digite o valor pago:\nou digite \'cancel\' para cancelar");
                resp = entrada.nextLine();
                if(resp=="cancel")return null;
                try{
                    valor = Float.parseFloat(resp);
                    feito = true;
                }catch(Exception e){
                    System.out.println("Número inválido");
                }
            }

            fatura.init(dt_leitura, dt_pagamento, num_leitura, KW_gasto, valor);

            return fatura;
        }
        public void checkMaiorMenor(Fatura fatura){

            if(this.menor>fatura.valor){
                this.menor = fatura.valor;
                this.dt_menor = fatura.dt_leitura;
            }
            if(this.maior<fatura.valor){
                this.maior = fatura.valor;
                this.dt_maior = fatura.dt_pagamento;
            }

        }

    }



    public static void main (String[] args) {

        Planilha planilha = new Planilha();
        Fatura fatura = new Fatura();
        planilha.init();
        planilha.addFatura();
        fatura = planilha.getLista().get(0);
        System.out.println("Planilha:\n\nData Leitura: " + fatura.getDtLeitura() + "\nData Pagamento: " + fatura.getDtPagamento() + "\nNúmero Leitura: " + fatura.getNumLeitura() + "\nKW Gasto: " + fatura.getKWGasto() + "\nValor Pago: " + fatura.getValor() + "\nMédia Gasta: " + fatura.getMedia());
        /*
        LocalDate test = LocalDate.parse("2024-04-26");
        int test2 = test.lengthOfMonth();
        System.out.println("LOD: " + test2);
        System.out.println("LocalDate: "+test);
        */

    }

}
