
package appback;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import DB.SQLConnection;
import java.sql.ResultSet;

import java.text.DecimalFormat;


public class AppBack {

public static void main(String[] args) throws ClassNotFoundException,SQLException,InstantiationException,IllegalAccessException {
   
        SQLConnection sqlcon = new SQLConnection();
        sqlcon.connect();
        String sql = "INSERT INTO TB_CUSTOMER_ACCOUNT VALUES('3','46254966832','VITOR',1,1000)";
        PreparedStatement stmt = sqlcon.con.prepareStatement(sql);
        
        stmt.execute();
        stmt.close();
       
        System.err.println("Gravado!!!");
        
        stmt = sqlcon.con.prepareStatement("SELECT * FROM TB_CUSTOMER_ACCOUNT WHERE VL_TOTAL > 560 AND ID_CUSTOMER BETWEEN 1500 AND 2700 ORDER BY VL_TOTAL DESC");
        
        ResultSet rs = stmt.executeQuery();
        double salario=0,count = 0;

        String id_customer, cpf_cnpj, nm_customer, is_active, vl_total;
        DecimalFormat nf = new DecimalFormat("R$ ###,###,##0.00");

        while (rs.next()){
            id_customer = rs.getString("ID_CUSTOMER");
            cpf_cnpj = rs.getString("CPF_CNPJ");
            nm_customer = rs.getString("NM_CUSTOMMER");
            is_active = rs.getString("IS_ACTIVE");
            vl_total = nf.format(rs.getDouble("VL_TOTAL"));
            salario += rs.getDouble("VL_TOTAL");
           count ++;
            
            System.out.println("ID: "+id_customer+", CPF/CNPJ: "+ cpf_cnpj+", Nome: " + nm_customer+", Cadastro: "+is_active+", Valor: "+vl_total);
        }
        System.out.print("A média dos registros com salários maiores que 560 e com identificadores entre 1500 e 2700 é: "+ salario / count );

       
       
        rs.close();
        stmt.close();
   
        
    }
}


    

