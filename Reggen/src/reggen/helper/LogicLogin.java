package reggen.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Jorge
 */
public class LogicLogin {
    
    public static String [] login;
    public static String [] pass;
    public static char[] p;
    public static boolean ban=false;
    
    public static void cargaUsers() {
       login = new String [5];
        pass = new String [5];
        
        String ruta="Miembros.csv";
        BufferedReader a=cargaAr(ruta);
        int opc=0;
        int i=0;
        String l=leeAr(a);
        String[] datosLee;
        while(l!=null) {
            datosLee=l.split(",");
            l=leeAr(a);
            login[i]= datosLee[0];
            pass[i] = datosLee[1];
            i++;
            opc++;
        } 
    }
    
    public static boolean agregaUser() {
        return true;   
    }
    
    public static int contiene(Object[] array, Object objBuscar) {
        int pos = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(objBuscar)) {
                pos = i;
            }
        }
        return pos;
    }
    
    public static boolean validadUser(String user,String pas) {
        ban = false;
        int pos = contiene(login, user);
        if(pos >-1) {
            if( Md5.encriptaEnMD5(pas) == pass[pos]) {
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
