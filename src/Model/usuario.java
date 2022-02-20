package Model;

public class usuario {

    int idUsuario;
    String user;
    String pass;
    String tipo;

    public usuario() {
    }

    public usuario(int idUsuario, String user, String pass, String tipo) {
        this.idUsuario = idUsuario;
        this.user = user;
        this.pass = pass;
        this.tipo = tipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
