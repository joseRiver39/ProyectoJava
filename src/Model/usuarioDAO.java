
package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class usuarioDAO {
    Conexion conectar = new Conexion();
    Connection cn;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public void eliminar( int id){
     String sql = "delete from usuarios where idusuarios =" +id;
     
        try {
            cn=conectar.getConnection();
            pst = cn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Usuario Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"lo sentimos su consulta no pudo ser resuelta");
            System.err.println(e);
        }
    
    }
    
    public List listar(){
        
        List<usuario>datos = new ArrayList<>();
        String sql="select * from usuarios";
        
        try {
            cn = conectar.getConnection();
            pst= cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
            usuario u = new usuario();
            u.setIdUsuario(rs.getInt(1));
            u.setUser(rs.getString(2));
            u.setPass(rs.getString(3));
            u.setTipo(rs.getString(4));
            datos.add(u);
            }
        } catch (Exception e) {
        }
    return datos;
    
    }
    
    
    public int agregar (usuario u){
      String sql="insert into usuarios(user,pass,tipo) values(?,?,?)";
        try {
            cn = conectar.getConnection();
            pst = cn.prepareStatement(sql);
            pst.setString(1,u.getUser());
            pst.setString(2,u.getPass());
            pst.setString(3,u.getTipo());
            pst.executeUpdate();
        } catch (Exception e) {
        }
    return  1;
    }
    
    public int Actualizar(usuario u){
    int r =0;
    String sql ="update usuarios set user=?, pass=?, tipo=? where idusuarios = ?";
    
     try {
            cn = conectar.getConnection();
            pst = cn.prepareStatement(sql);
            pst.setString(1,u.getUser());
            pst.setString(2,u.getPass());
            pst.setString(3,u.getTipo());
            pst.setInt(4,u.getIdUsuario());
            pst.executeUpdate();
            if(r==1){
            return 1;
            }else{
            return 0;
            }
        } catch (Exception e) {
        }
    return  r;
    
    
    }
    
    
    
}
