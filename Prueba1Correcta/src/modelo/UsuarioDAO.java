
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {
    Conexion con;
    
    
    public UsuarioDAO(){
        con = new Conexion();
        
    }
   
    public ArrayList<Usuario> getUsuarios() throws SQLException{
        ArrayList <Usuario> usuarios = new ArrayList();
        Connection accesoBD = con.getConexion();
        
        
        try{
            String sql = "SELECT * FROM usuario";
            
             Statement st = accesoBD.createStatement();
             ResultSet resultados = st.executeQuery(sql);
           
        
        
           while ( resultados.next() ) {
                int id= Integer.parseInt(resultados.getString("id_usuario"));
                String nombre = resultados.getString("nombre");
                
                
                usuarios.add(new Usuario(id, nombre));
            }
            accesoBD.close();
            return usuarios;
           
        }catch(Exception e){
            System.out.println("Error al obtener usuarios en DAO");
            accesoBD.close();
            
        
        return null;
        
    }    
    }
}
