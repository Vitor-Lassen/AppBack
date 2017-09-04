/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import Utilities.FormatString;


/**
 *
 * @author Vitor
 */
public class TBCustumerAccount {
    SQLConnection sqlcon = new SQLConnection();
    public void insert(int id,String cpfCnpj,String nome, boolean active, double vlTotal) throws ClassNotFoundException,IllegalAccessException,SQLException,InstantiationException{
   
        sqlcon.connect();
        String sql = "INSERT INTO TB_CUSTOMER_ACCOUNT VALUES(?,?,?,?,?)";
        PreparedStatement stmt = sqlcon.con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, cpfCnpj);
        stmt.setString(3, nome);
        stmt.setBoolean(4, active);
        stmt.setDouble(5, vlTotal);
        
        stmt.execute();
        stmt.close();
       
        System.out.println("Registro Armazenado!");
        
       
    }
    public void select()throws ClassNotFoundException,IllegalAccessException,InstantiationException,SQLException{
        sqlcon.connect();
        PreparedStatement stmt = sqlcon.con.prepareStatement("SELECT * FROM TB_CUSTOMER_ACCOUNT WHERE VL_TOTAL > 560 AND ID_CUSTOMER BETWEEN 1500 AND 2700 ORDER BY VL_TOTAL DESC");
        ResultSet rs = stmt.executeQuery();
        
        double salario=0,count = 0;
        String id_customer, cpf_cnpj, nm_customer, is_active, vl_total;
        DecimalFormat maskMoney = new DecimalFormat("R$ ###,###,##0.00");
        FormatString formataString = new FormatString();
        while (rs.next()){
            id_customer = rs.getString("ID_CUSTOMER");
            cpf_cnpj = formataString.cpfORcnpj(rs.getString("CPF_CNPJ"));
            nm_customer = rs.getString("NM_CUSTOMER");
            is_active = rs.getString("IS_ACTIVE");
            vl_total = maskMoney.format(rs.getDouble("VL_TOTAL"));
            salario += rs.getDouble("VL_TOTAL");
            count ++;
            
            System.out.println("ID: "+id_customer+", CPF/CNPJ: "+ cpf_cnpj+", Nome: " + nm_customer+", Cadastro: "+is_active+", Valor: "+vl_total);
           
        }
        System.out.print("\nA média dos registros com salários maiores que 560 e com identificadores entre 1500 e 2700 é: "+ salario / count+ "\n\n" );
        stmt.close();
        rs.close();
    }
}
