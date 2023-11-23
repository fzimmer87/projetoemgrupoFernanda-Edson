package metodos;
import conexao.ConexaoForwardMySQL;
import io.restassured.response.Response;
import org.example.AppTest;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RealizaCadastroLogin {

    public static List<Response> dadosUsuarios  = new ArrayList<>();
    public static List<String> firstname = new ArrayList<>();
    public static List<String> lastname = new ArrayList<>();
    public static List<String> username = new ArrayList<>();
    public static List <String> password = new ArrayList<>();


    public void cadastrarUsuario(){

        ConexaoForwardMySQL conexao = new ConexaoForwardMySQL();
        Connection conn = conexao.getConexao();
        try {
            String sql = "SELECT * FROM registro";

            Statement stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(sql);

            while (resultado.next()){
                firstname.add(resultado.getString("FirstName"));
                lastname.add(resultado.getString("LastName"));
                username.add(resultado.getString("Username"));
                password.add(resultado.getString("Password"));
            }
        }  catch (SQLException ex)  {
        }
    }
    public ArrayList<Response> cadastroDeUsuario() throws IOException {
        for (int i = 0; i < password.size(); i++) {
        String corpoRegistro = AppTest.gerarCorpoCadastro(firstname.get(i),lastname.get(i),
                                                          username.get(i),password.get(i));

        dadosUsuarios.add(AppTest.novoCadastro(corpoRegistro));
    }
        return (ArrayList<Response>) dadosUsuarios;
    }
    public ArrayList<Response> LoginDeUsuario() throws IOException {
        for (int i = 0; i < password.size(); i++) {
            String corpoRegistro = AppTest.gerarCorpoLogin(username.get(0),password.get(0));

            dadosUsuarios.add(AppTest.novoLogin(corpoRegistro));
        }
        return (ArrayList<Response>) dadosUsuarios;
    }
}

