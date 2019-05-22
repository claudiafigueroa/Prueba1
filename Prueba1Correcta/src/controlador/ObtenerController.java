/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;

import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.NuevoMensaje;

/**
 *
 * @author Claudia
 */
public class ObtenerController  {
    NuevoMensaje nmensaje;

    public ObtenerController(NuevoMensaje nmensaje) {
        this.nmensaje = nmensaje;
        
    }
    

 
    
    public void getDestinatarios() {
        UsuarioDAO udao = new UsuarioDAO();
        ArrayList<Usuario> usuariocombo  = new ArrayList<>();
        
        try{
            usuariocombo = udao.getUsuarios(); 
            JComboBox nuevocombo = nmensaje.getDestinatarioCB();
        
            nuevocombo.removeAllItems();
            for (int i = 0; i < usuariocombo.size(); i++) {
 
                nuevocombo.addItem(usuariocombo.get(i));
            }

            nmensaje.setDestinatarioCB(nuevocombo);
        }catch(Exception e){
            System.out.println("Hubo un error al cargar los usuarios");
            e.printStackTrace();
        }
        
        
        
    }
    }
    
    
        
        
    