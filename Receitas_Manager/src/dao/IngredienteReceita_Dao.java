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
import model.shard.Ingrediente_Receita;
/**
 *
 * @author Carvalho
 */
public class IngredienteReceita_Dao {
    public Cand_connection cand = null;
    public Connection con= null;
    
    public IngredienteReceita_Dao(){
        cand = new Cand_connection();
        con = cand.getConnection();
    }
    
    public void inserirIngredienteNaReceita(Integer id_receita, Integer id_ingrediente, Integer quant, String nome_ing){
        String script = "INSERT INTO Ingrediente_Receita VALUES( ?, ?, ?, ?)";
        try{
            PreparedStatement declaracao = con.prepareStatement(script);
            declaracao.setInt(1,id_receita);
            declaracao.setInt(2,id_ingrediente);
            declaracao.setInt(3,quant);
            declaracao.setString(4, nome_ing);
            declaracao.executeUpdate();
            declaracao.close();
            con.close();
            System.out.println("Inserido com sucesso");
        }catch(SQLException e){
            System.err.println("Erro ao inserir: "+e.getMessage());
        }    
    } 
    
    public void deletarIngredienteNaReceita(int id_receita, int id_ingrediente){
        String script = "DELETE FROM Ingrediente_Receita WHERE id_receita = ? and id_ingrediente = ?;";
        try{
            PreparedStatement declaracao = con.prepareStatement(script);
            declaracao.setInt(1 ,id_receita);
            declaracao.setInt(2 ,id_ingrediente);
            declaracao.executeUpdate();
            declaracao.close();
            con.close();
            System.out.println("Excluido com sucesso");
        }catch(SQLException e){
            System.err.println("Erro ao deletar: "+e.getMessage());
        }    
    } 
    
    public List<Ingrediente_Receita> listarIngredientesReceita(int idreceita){
        String script = "SELECT Ingrediente_Receita.*" +
                    " FROM Ingrediente_Receita" +
                    " INNER JOIN receita " +
                    " ON Ingrediente_Receita.fk_Id_Receita = ?;";
        List<Ingrediente_Receita> listaIngrediente = new ArrayList();
        try{
            Ingrediente_Receita ingrediente_receita = new Ingrediente_Receita();
            PreparedStatement stmt = con.prepareStatement(script);
            stmt.setInt(1, idreceita);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ingrediente_receita.setId_ingrediente(rs.getInt("id_ingrediente"));
                ingrediente_receita.setId_receita(rs.getInt("id_receita"));
                ingrediente_receita.setIngrediente_nome(rs.getString("nome_ing"));
                ingrediente_receita.setQuantia_ing(rs.getInt("quant_ing"));
                listaIngrediente.add(ingrediente_receita);
            }    
        }catch (SQLException ex) {
            System.out.println("Erro dentro do LISTAR INGREDIENTES :"+ex);
        }
        return listaIngrediente;
    }
    
    
}
