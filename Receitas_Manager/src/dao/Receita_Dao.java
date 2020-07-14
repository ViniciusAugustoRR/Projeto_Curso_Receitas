package dao;

import model.shard.Receita;
import connection.Cand_connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.shard.Ingrediente;

public class Receita_Dao {
    public Cand_connection cand = null;
    public Connection con= null;
    
    public Receita_Dao(){
        cand = new Cand_connection();
        con = cand.getConnection();
    }
    public void InserirReceita(Receita receita){
        String script = "Insert into receita (nome,tempo,margem,rendimento) values(?,?,?,?);";
        try{
            PreparedStatement declaracao = con.prepareStatement(script);
            declaracao.setString(1,receita.getNome());
            declaracao.setInt(2,receita.getTempo());
            declaracao.setFloat(3,receita.getMargem());
            declaracao.setFloat(4,receita.getRendimento());
            declaracao.executeUpdate();
            declaracao.close();
            con.close();
            System.out.println("Salvo com sucesso");
        }catch(SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }    
    } 
    
   /* public void deletarReceita(Integer idreceita){
        String script = "DELETE FROM receita WHERE id_receita = ?;";
        try{
            PreparedStatement declaracao = con.prepareStatement(script);
            declaracao.setInt(1, idreceita);
            declaracao.executeUpdate();
            declaracao.close();
            con.close();
            System.out.println("Atualizado com sucesso");
        }catch(SQLException e){
            System.err.println("Erro ao atualizar: "+e.getMessage());
        }    
    }*/   
    
    public List<Receita> listarReceita(){
        String script = "Select * from Receita;";
        List<Receita> listaReceita = new ArrayList<>(); 
        try {
           PreparedStatement declaracao = con.prepareStatement(script);
           ResultSet rs = declaracao.executeQuery();
            while(rs.next()){
                Receita receita = new Receita();
                receita.setNome(rs.getString("nome"));
                receita.setTempo(rs.getInt("tempo"));
                receita.setRendimento(rs.getFloat("rendimento"));
                receita.setCusto_total(rs.getFloat("custo_total"));
                listaReceita.add(receita);
                declaracao.executeUpdate();
                declaracao.close();
                con.close();
            }    
        } catch (SQLException ex) {
            System.out.println("Erro:"+ex);
        }
        return listaReceita;
    }
    
    public int puxarIDReceita(String receitaNome){
        int idFinal = 0 ;
        String script = "SELECT id_receita FROM receita WHERE nome = ?;";
        try{
            PreparedStatement declaracao = con.prepareStatement(script);
            declaracao.setString(1,receitaNome);
            ResultSet rs = declaracao.executeQuery();
            while(rs.next()){
                Receita receita = new Receita();
                receita.setId_receita(rs.getInt("id_receita"));
                idFinal = receita.getId_receita();
            }
            
        }catch(SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
        return idFinal;
    }
    
    public List<String> listarNomes(){
        String script = "Select nome from Receita;";
        List<String> listaNome = new ArrayList<>();
        try {
            PreparedStatement declaracao = con.prepareStatement(script);
            ResultSet rs = declaracao.executeQuery();
            while(rs.next()){
                Receita receita = new Receita();
                listaNome.add(rs.getString("nome"));
                declaracao.executeUpdate();
                declaracao.close();
                con.close();
            }    
        }catch (SQLException ex) {
            System.out.println("Erro:"+ex);
        }
        return listaNome;
    }
    
    
    
   
}
