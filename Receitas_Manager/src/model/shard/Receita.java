package model.shard;

import java.util.ArrayList;

public class Receita {
    
    private int id_receita;// TABEL
    private String nome;// TABEL
    private int tempo; // TABEL
    private float margem;
    private float custo_total;// TABEL
    private float custo_venda;// TABEL
    private float rendimento;// TABEL
    private ArrayList<Integer> quant_ing;
    private ArrayList<Float> custo_ing;

    public Receita(){
        this.custo_ing = new ArrayList();
        this.quant_ing = new ArrayList();
    }
    
    public void calculoTotalx(int cont){
        float a, b, c, d;
     /*   for(int cc = 0; cc < cont; cc += 1){
            a = this.ingredientes.get(cc).getFardo();
            b = this.ingredientes.get(cc).getCusto_fardo();
            c = this.quant_ing.get(cc);
            d = ((b*c)/a);
            this.custo_ing.add(d);
            System.out.println(d);
        }*/
         
        for(int cc = 0; cc < cont; cc += 1){
            this.custo_total += this.custo_ing.get(cc);
            System.out.println(this.custo_ing.get(cc));
        }
    }
    
    //Getter and Setter
    
    public float getMargem() {
        return margem;
    }
    public void setMargem(float margem) {
        this.margem = margem;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempo() {
        return tempo;
    }
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public float getCusto_total() {
        return custo_total;
    }
    public void setCusto_total(float ct) {
        this.custo_total = ct;
    }
   
    public float getCusto_venda() {
        return custo_venda;
    }
    public void setCusto_venda(){
        this.custo_venda = ((this.margem/100)*this.custo_total) + this.custo_total;
    }

    public float getRendimento() {
        return rendimento;
    }
    public void setRendimento(float rendimento) {
        this.rendimento = rendimento;
    }

    public void setCusto_ing(float a){
        this.custo_ing.add(a);
    }    
    
    public void setQuant_ing(Integer quant_ing) {
        this.quant_ing.add(quant_ing);
    }

    public int getId_receita() {
        return id_receita;
    }

    public void setId_receita(int id_receita) {
        this.id_receita = id_receita;
    }
}
    
