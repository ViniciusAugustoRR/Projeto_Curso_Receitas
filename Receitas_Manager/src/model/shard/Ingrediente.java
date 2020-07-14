package model.shard;

public class Ingrediente {
    
    private int id_ingrediente;
    private String nome;
    private float custo_fardo;
    private int fardo;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFardo() {
        return fardo;
    }
    public void setFardo(int fardo) {
        this.fardo = fardo;
    }

    public float getCusto_fardo() {
        return custo_fardo;
    }
    public void setCusto_fardo(float custo_fardo) {
        this.custo_fardo = custo_fardo;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }
    
    
}
