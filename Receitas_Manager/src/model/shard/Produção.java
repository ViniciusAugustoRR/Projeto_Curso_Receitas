package model.shard;

import java.util.Date;

/**
 *
 * @author Carvalho
 */
public class Produção{
    private String data_producao; 
    private int fk_id_receita;
    private String nome_receita;
    private float custoTotal_receita;
    private float preçoVenda_receita;
    private int remecas;

    public String getData_producao() {
        return data_producao;
    }

    public void setData_producao(String data_producao) {
        this.data_producao = data_producao;
    }

    public int getId_receita() {
        return fk_id_receita;
    }
    public void setId_receita(int id_receita) {
        this.fk_id_receita = id_receita;
    }

    public String getNome_receita() {
        return nome_receita;
    }
    public void setNome_receita(String nome_receita) {
        this.nome_receita = nome_receita;
    }

    public float getCustoTotal_receita() {
        return custoTotal_receita;
    }
    public void setCustoTotal_receita(float custoTotal_receita) {
        this.custoTotal_receita = custoTotal_receita;
    }

    public float getPreçoVenda_receita() {
        return preçoVenda_receita;
    }
    public void setPreçoVenda_receita(float preçoVenda_receita) {
        this.preçoVenda_receita = preçoVenda_receita;
    }

    public int getRemecas() {
        return remecas;
    }
    public void setRemecas(int remecas) {
        this.remecas = remecas;
    }
    
}
