package reggen.helper;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Jorge
 */
public class LogicLogin {
    
    public static Hashtable login;
    public static char[] p;
    public static boolean ban=false;
    
    public static void cargaUsers() {
        login = new Hashtable();
        
        String ruta="Miembros.csv";
        BufferedReader a=cargaAr(ruta);
        int opc=0;
        int i=0;
        String l=leeAr(a);
        String[] datosLee;
        while(l!=null) {
            datosLee=l.split(",");
            l=leeAr(a);
            
            login.put(datosLee[0], datosLee[1]);
           i++;
            opc++;
        } 
    }
    
    public static boolean agregaUser() {
        //FuncionalidadPenndiente
        return true;   
    }
    
    public static int contiene(Object[] arr, Object objBuscar) {
        int pos = -1;
        Object[] array = arr;
        System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[0].toString());
            if(array[i].equals(objBuscar)) {
                pos = i;
            }
        }
        return pos;
    }
    
    public static boolean validadUser(String user,String pas) {
        ban = false;
        cargaUsers();
        //int pos = contiene(login, user);
        if(login.containsKey(user)) {
            if( Md5.encriptaEnMD5(pas).equals(login.get(user)) ) {
                ban = true;
            }
        }
        return ban;
    }
    
    public static BufferedReader cargaAr(String nombre) {   
        BufferedReader a=null;	 
        try {   
            a = new BufferedReader(new FileReader(nombre));
        } catch (FileNotFoundException e) {   
            System.out.println("el archivo no existe");
            System.exit(0);
        }
        return a;
    } 
 
    public static  String leeAr(BufferedReader d) {
        String linea = "";
        try {   
            linea =d.readLine();
        } catch (IOException e) {
          System.out.println("I/O Error");
            System.exit(0);
        }
        String data; 
        if((linea != null)) {
            data = linea;
            return data; 
        } else {
            return null;
        }
    }
}
