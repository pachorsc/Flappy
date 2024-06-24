package BD;
import UI.ZonaJuego;
import static UI.ZonaJuego.jug;
import java.sql.*;

public class BaseD {
    //Conectar base de datos
    private static Connection con = null;
    
    static public void Conectar() throws ClassNotFoundException, SQLException{
        String url = "jdbc:oracle:thin:@//localhost:1521/xe";
        String username = "Pacho";
        String pass = "123";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection(url, username, pass);
    }
    
    //Ejecutar Querys
    static public void basedatos(String n) throws ClassNotFoundException, SQLException {
        Conectar();
        Statement st = con.createStatement();

        String consulta  = n;
         
        //System.out.println("Conexion establecida");
        ResultSet rs = st.executeQuery(consulta);
        
        con.close();
    }
    static public String HSllenar() throws ClassNotFoundException, SQLException {
        Conectar();
        Statement st = con.createStatement();

        String consulta  = "Select * from highScore order by puntaje desc";
         
        ResultSet rs = st.executeQuery(consulta);
        String a = "";
        while(rs.next()){
            a += rs.getString(1);
            int b = 6- rs.getString(1).length();
            for (int i = 0; i < b; i++) {
                a += " ";
            }
            a += "               Puntaje                   "+rs.getString(2)+ "\n";
        }
        
        return a;
    }   
    static public void isTop() throws ClassNotFoundException, SQLException {
        Conectar();
        Statement st = con.createStatement();
        String consulta  = "Select puntaje from highScore";
        ResultSet rs = st.executeQuery(consulta);
        int a = ZonaJuego.getPuntaje();
        
        while(rs.next()){
            if (rs.getInt(1) < a) {                 
                ResultSet act = st.executeQuery("update highscore set puntaje = "+a
                                                +" , jugador = '"+jug+"' where puntaje = "+rs.getInt(1));
                break;
            }
        }
    }
}
