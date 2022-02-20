package Controlador;

import Model.usuario;
import Model.usuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vistas.usuariosVist;

public class ControllerUser implements ActionListener {

    usuarioDAO usDao = new usuarioDAO();
    usuario user = new usuario();
    usuariosVist uservist = new usuariosVist();
    DefaultTableModel model = new DefaultTableModel();

    public ControllerUser(usuariosVist u) {

        this.uservist = u;
        this.uservist.btnList.addActionListener(this);
        this.uservist.btnAgregar.addActionListener(this);
        this.uservist.btnEditar.addActionListener(this);
        // listar(uservist.jTableUser);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uservist.btnList) {
            listar(uservist.jTableUser);
        }
        if (e.getSource() == uservist.btnAgregar) {
            agregar();
        }
        if (e.getSource() == uservist.btnEditar) {
            int fila = uservist.jTableUser.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(uservist, "seleciona  una fila  de  tabla");
            } else {
                int id = Integer.parseInt((String) uservist.jTableUser.getValueAt(fila, 0).toString());
                String user = (String) uservist.jTableUser.getValueAt(fila, 1);
                String pass = (String) uservist.jTableUser.getValueAt(fila, 2);
                String tipo = (String) uservist.jTableUser.getValueAt(fila, 3);
                uservist.xtId.setText("" + id);
                uservist.txtUserName.setText(user);
                uservist.txtPass.setText(pass);
                uservist.jcomTipo.setSelectedItem(tipo.toString());
            }
        }
        if (e.getSource() == uservist.btnActualizar) {
            actualizar();
        }

    }

    public void limpiartablas() {
        for (int i = 0; i < uservist.jTableUser.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }

    public void limpiarFormulario() {
        uservist.xtId.setText("");
        uservist.txtUserName.setText(" ");
        uservist.txtPass.setText(" ");
        uservist.jcomTipo.setSelectedItem("Usuario");

    }

    public void listar(JTable tabla) {
        model = (DefaultTableModel) tabla.getModel();
        List<usuario> lista = usDao.listar();
        Object[] object = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getIdUsuario();
            object[1] = lista.get(i).getUser();
            object[2] = lista.get(i).getPass();
            object[3] = lista.get(i).getTipo();
            model.addRow(object);

        }
        uservist.jTableUser.setModel(model);

    }

    public void agregar() {
        String user = uservist.txtUserName.getText();
        String pass = String.valueOf(uservist.txtPass.getPassword());
        String tipo = (String) uservist.jcomTipo.getSelectedItem();
        this.user.setUser(user);
        this.user.setPass(pass);
        this.user.setTipo(tipo);
        int r = usDao.agregar(this.user);
        if (r == 1) {
            JOptionPane.showMessageDialog(null, " Usuario agregado con exito");
        } else {

            JOptionPane.showMessageDialog(null, " error  al  agreagar ususrio");
        }

    }

    public void actualizar() {
        String user = uservist.txtUserName.getText();
        String pass = String.valueOf(uservist.txtPass.getPassword());
        String tipo = (String) uservist.jcomTipo.getSelectedItem();
        this.user.setUser(user);
        this.user.setPass(pass);
        this.user.setTipo(tipo);
        int r = usDao.Actualizar(this.user);
        if (r == 1) {
            JOptionPane.showMessageDialog(null, " Usuario Actualizado");
        } else {

            JOptionPane.showMessageDialog(null, " error  al  Actualizar");
        }

}
}
