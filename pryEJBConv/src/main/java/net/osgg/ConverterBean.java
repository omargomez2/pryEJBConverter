package net.osgg;

import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


@Stateless
@LocalBean
public class ConverterBean implements ConverterBeanRemote{
    
    public float convertToFahrenheit(int celsius) {
        return (celsius * 9 / 5) + 32;
    }
    
    
    public String saludar() {
    	final Properties jndiProperties = new Properties();
    	jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
    	String aux="";
    	// create the context
    	try {
			final Context context = new InitialContext(jndiProperties);
			HelloBeanRemote hello = (HelloBeanRemote) context.lookup("ejb:/pryEJBHello/HelloBean!net.osgg.HelloBeanRemote");
			aux = hello.getMessage();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
    	return aux;
    }
    
    
}