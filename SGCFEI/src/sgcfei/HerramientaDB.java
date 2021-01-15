package sgcfei;

import database.ControladorCredenciales;
import database.DBCredenciales;

public class HerramientaDB {
    public static void main(String[] args) {
        //Crear nuevo archivo db.conf
        DBCredenciales cred = new DBCredenciales("maisonbleue2020.ddns.net", "3306", "pruebas", "seth", "Sndd1026");
        ControladorCredenciales.escribir(cred);
        
        //Leer datos de db.conf
        DBCredenciales cred2 = ControladorCredenciales.leer();
        
        System.out.println(cred2);

    }
}

