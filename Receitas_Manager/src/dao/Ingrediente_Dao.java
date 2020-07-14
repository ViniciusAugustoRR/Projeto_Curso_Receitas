package dao;

import connection.Cand_connection;
import model.shard.Ingrediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ingrediente_Dao{
    public Cand_connection cand = null;
    public Connection con= null;
    
    public Ingrediente_Dao(){
        cand = new Cand_connection();
        con = cand.getConnection();
    }
    
    public void InserirIngrediente(Ingrediente ingrediente){
        String script = "Insert into ingrediente (nome,custo_fardo,fardo) values(?,?,?);";
        try{
            PreparedStatement declaracao = con.prepareStatement(script);
            declaracao.setString(1,ingrediente.getNome());
            declaracao.setFloat(2,ingrediente.getCusto_fardo());
            declaracao.setFloat(3,ingrediente.getFardo());
            declaracao.executeUpdate();
            
            declaracao.close();
            con.close();
            System.out.println("Ingrediente salvo com sucesso");
        }catch(SQLException e){
            System.err.println("Erro ao salvar ingrediente : "+e.getMessage());
        }    
    }   
    
    public int puxarIDIngrediente(String ingredienteNome){
        int idFinal = 0;
        String script = "SELECT id FROM ingrediente WHERE nome = ?;";
        try{
            PreparedStatement declaracao = con.prepareStatement(script);
            ResultSet rs = declaracao.executeQuery();
            declaracao.setString(1,ingredienteNome);
            idFinal = rs.getInt("id");
        }catch(SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
        return idFinal;
    }
    
    public List<Ingrediente> listarIngrediente(){
        String script = "Select * from Ingrediente;";
        PreparedStatement stmt= null;
        ResultSet result = null ; 
        List<Ingrediente> listaIngrediente = new ArrayList<>();
        try{
            stmt = con.prepareStatement(script);
            result = stmt.executeQuery();
            while(result.next()){
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setNome(result.getString("nome"));
                ingrediente.setCusto_fardo(result.getFloat("custo_fardo"));
                ingrediente.setFardo(result.getInt("fardo"));
                listaIngrediente.add(ingrediente);
            }    
        } 
        catch (SQLException ex) {
            System.out.println("Erro:"+ex);
        }
        return listaIngrediente;
    }
    
    public List<String> listarNomes(){
        String script = "SELECT nome FROM Ingrediente;";
        List<String> listaNome = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(script);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Ingrediente ingrediente = new Ingrediente();
                listaNome.add(rs.getString("nome"));
            }    
        }catch(SQLException ex){
            System.out.println("Erro:"+ex);
        }
        return listaNome;
    }
    public Ingrediente SelectIngrediente(){
        String script = "SELECT * FROM ingrediente;";
        Ingrediente ingrediente = new Ingrediente();
        try{
            PreparedStatement declaracao = con.prepareStatement(script);
            ResultSet result = null ; 
            ingrediente.setNome(result.getString("nome"));
            ingrediente.setId_ingrediente(result.getInt("id"));
            ingrediente.setCusto_fardo(result.getFloat("custo_fardo"));
            ingrediente.setFardo(result.getInt("fardo"));
            declaracao.executeUpdate();
            declaracao.close();
            con.close();
        }catch(SQLException e){
            System.err.println("Erro ao salvar ingrediente : "+e.getMessage());
        }    
        return ingrediente;
    }
    
    public void deletarIngrediente(Ingrediente ingrediente){
        String script = "DELETE FROM Ingrediente WHERE nome = ?;";
        try{
            PreparedStatement declaracao = con.prepareStatement(script);
            declaracao.setString(1,ingrediente.getNome());
            declaracao.executeUpdate();
            
            declaracao.close();
            con.close();
            System.out.println("Excluido com sucesso");
        }catch(SQLException e){
            System.err.println("Erro ao deletar: "+e.getMessage());
        }    
    } 
    
    
    
    
    
    
    
    
    
    
}
