package model.shard;

public class Ingrediente_Receita {
    
    private int id_ingrediente;
    private int id_receita;
    private String nome_ing;
    private int quantia_ing;

    public int getId_ingrediente() {
        return id_ingrediente;
    }
    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public int getId_receita() {
        return id_receita;
    }
    public void setId_receita(int id_receita) {
        this.id_receita = id_receita;
    }

    public String getIngrediente_nome() {
        return nome_ing;
    }
    public void setIngrediente_nome(String ingrediente_nome) {
        this.nome_ing = ingrediente_nome;
    }

    public int getQuantia_ing() {
        return quantia_ing;
    }
    public void setQuantia_ing(int quantia_ing) {
        this.quantia_ing = quantia_ing;
    }
    
}
