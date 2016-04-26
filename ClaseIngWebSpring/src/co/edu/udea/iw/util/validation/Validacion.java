/**
 * 
 */
package co.edu.udea.iw.util.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author asus
 *
 */
public class Validacion {
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	/** 
	*@param email
     *@return true si es correcta o false si no lo es.
     */
    public static boolean esEmailCorrecto(String email) {    
        boolean valido = false;
        Pattern patronEmail = Pattern.compile(PATTERN_EMAIL);
        Matcher mEmail = patronEmail.matcher(email.toLowerCase());
        if (mEmail.matches()){
           valido = true;  
        }
        return valido;
    }
}
