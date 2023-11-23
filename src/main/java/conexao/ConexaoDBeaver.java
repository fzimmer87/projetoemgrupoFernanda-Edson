package conexao;

import java.sql.*;

public class ConexaoDBeaver {
    private static final String url = "jdbc:postgresql://lv-dev.betternow.com.br:8002/Treinamento";

    private static final String user = "postgres";
    private static final String password = "postgres";
    private static Connection conn;

    public static void main(String[] args) {


        try {
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM registroedsonefernanda";

            Statement stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(sql);

            while (resultado.next()) {
                System.out.println(resultado.getInt("codregistro"));
                System.out.println(" - " + resultado.getString("firstname"));
                System.out.println(" - " + resultado.getString("lastname"));
                System.out.println(" - " + resultado.getString("username"));
                System.out.println(" - " + resultado.getString("password"));


            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

    }

}
