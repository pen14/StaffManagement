/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement.server.encryption;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *@Code from group coursework from the FOOD module
 *
 */
public class CryptUtil{
    
    private static SecretKeySpec key = null;
    
    public static String encrypt(String text){
        
        try{
        
            if(key == null){
            
                byte[] keyBytes = "ThisIs128bitSize".getBytes();
                CryptUtil.key = new SecretKeySpec(keyBytes, "AES");
            
            }
            
            Cipher ecipher = Cipher.getInstance("AES");
            ecipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] ciphertext = ecipher.doFinal(text.getBytes("UTF8"));
            
            return Base64.getEncoder().encodeToString(ciphertext);
            
        }
        catch(Exception ex){ex.printStackTrace();}
            
        return "";
        
    }
    
    public static String decrypt(String encryptedtext){
        
        try{
            
            if(key == null){
            
                byte[] keyBytes = "ThisIs128bitSize".getBytes();
                CryptUtil.key = new SecretKeySpec(keyBytes, "AES");
            
            }
            
            byte[] text = Base64.getDecoder().decode(encryptedtext);
            
            Cipher ecipher = Cipher.getInstance("AES");
            ecipher.init(Cipher.DECRYPT_MODE, key);
            
            return new String(ecipher.doFinal(text));
            
        } 
        catch(Exception ex){ex.printStackTrace();}
        
        return ""; 
        
    }
}