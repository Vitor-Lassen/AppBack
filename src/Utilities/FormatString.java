/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author Vitor
 */
public class FormatString {
    public String cpfORcnpj(String cpfCnpj){
        if (cpfCnpj.length() == 11){
            return cpfCnpj.substring(0,3)+"."+cpfCnpj.substring(3,6)+"."+cpfCnpj.substring(6,9)+"-"+cpfCnpj.substring(9,11);
            
        }
        else if (cpfCnpj.length() == 14)
        {
            return cpfCnpj.substring(0,2)+"."+cpfCnpj.substring(2,5)+"."+cpfCnpj.substring(5,8)+"/"+cpfCnpj.substring(8,12)+"-"+cpfCnpj.substring(12,14);
        }   
        else{
            return cpfCnpj;
        }
    }
}
