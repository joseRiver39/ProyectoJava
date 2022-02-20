
package security;

import Controlador.ControllerUser;
import vistas.usuariosVist;


public class Security {

   
    public static void main(String[] args) {
        usuariosVist ust= new usuariosVist();
        ControllerUser con = new ControllerUser(ust);
        ust.setVisible(true);
    }
    
}
