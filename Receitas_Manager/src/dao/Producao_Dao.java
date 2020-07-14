package dao;

import com.jfoenix.controls.JFXDatePicker;
import connection.Cand_connection;
import model.shard.Ingrediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.shard.Produção;
import model.shard.Receita;

public class Producao_Dao{
    public Cand_connection cand = null;
    public Connection con= null;
    
    public Producao_Dao(){
        cand = new Cand_connection();
        con = cand.getConnection();
    }
    
    public void InserirReceita(Integer id_receita, Integer remecas, String data ){
        String script = "Insert into producao (id_receita, quantia_remecas, data_producao) values(?,?,?);";
        try{
            PreparedStatement declaracao = con.prepareStatement(script);
            declaracao.setInt(1, id_receita);
            declaracao.setFloat(2, remecas);
            declaracao.setString(3, data );
            declaracao.executeUpdate();
            declaracao.execute();
            declaracao.close();
            con.close();
            System.out.println("Receita salva com sucesso na produção");
        }catch(SQLException e){
            System.err.println("Erro ao salvar produção : "+e.getMessage());
        }    
    }   
    public List<Produção> listarReceita(String data){
        String script = "SELECT receita.id_receita receita.nome, receita.custo_total, receita.custo_venda, producao.remecas"
                    + "FROM receita"
                    + "INNER JOIN producao"
                    + "ON receita.idreceita = producao.fk_idreceita AND producao.data_producao = ?";
        List<Produção> listaReceitaProdução = new ArrayList<>(); 
        
        try {
            PreparedStatement declaracao = con.prepareStatement(script);
            ResultSet rs = declaracao.executeQuery();
            while(rs.next()){
                declaracao.setString(1, data);
                Produção producao = new Produção();
                producao.setNome_receita(rs.getString("nome_receita"));
                producao.setCustoTotal_receita(rs.getFloat("custoTotal_receita"));
                producao.setPreçoVenda_receita(rs.getFloat("preçoVenda_receita"));
                producao.setId_receita(rs.getInt("id_producao"));
                listaReceitaProdução.add(producao);
                declaracao.executeUpdate();
                declaracao.close();
                con.close();
            }    
        } catch (SQLException ex) {
            System.out.println("Erro:"+ex);
        }
        return listaReceitaProdução;
    }
    
     public void deletarReceitaNaProdução(int id_receita, String data){
        String script = "DELETE FROM producao WHERE data_producao = ? and fk_id_receita = ?";
        try{
            PreparedStatement declaracao = con.prepareStatement(script);
            declaracao.setString(1 ,data);
            declaracao.setInt(2 ,id_receita);
            declaracao.executeUpdate();
            declaracao.close();
            con.close();
            System.out.println("Excluido com sucesso");
        }catch(SQLException e){
            System.err.println("Erro ao deletar: "+e.getMessage());
        }    
    } 
}
