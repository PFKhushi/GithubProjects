import java.time.LocalDate;
import java.util.*;

class PlanilhaPagamento{

    public static enum Pagamento{
        DINHEIRO, DEBITO, CREDITO, TK_ALIMENTACAO;
    }
    public class DadosGasto{

        private String tipo_gasto;
        private float valor_gasto;
        private LocalDate dt_pagamento;
        private List<Pagamento> tipo_pagamento;

        public void init(String tipo_gasto, float valor_gasto, LocalDate dt_pagamento, List<Pagamento> tipo_pagamento){

            this.tipo_gasto = tipo_gasto;
            this.valor_gasto = valor_gasto;
            this.dt_pagamento = dt_pagamento;
            this.tipo_pagamento = tipo_pagamento;
        }
        public String getTipoGasto(){
            return this.tipo_gasto;
        }
        public float getValor(){
            return this.valor_gasto;
        }
        public LocalDate getDtPagamento(){
            return this.dt_pagamento;
        }
        public List<Pagamento> getTipoPagamento(){
            return this.tipo_pagamento;
        }

    }
    public static class GastosMes{
        private ArrayList<DadosGasto> gastos;

        public void init(ArrayList<DadosGasto> gastos){
            this.gastos = gastos;
        }

        public ArrayList<DadosGasto> getGastos(){
            return this.gastos;
        }

        public ArrayList<DadosGasto> getListGroup(Pagamento tipo){

            ArrayList<DadosGasto> list_group = new ArrayList<>();
            for(DadosGasto i : this.gastos){

                for(Pagamento j : i.getTipoPagamento()){
                    if (j == tipo){
                        list_group.add(i);
                    }
                }

            }
            return list_group;

        }

    }

    public static void main (String[] args) {

        GastosMes planilha = new GastosMes();


    }
}
