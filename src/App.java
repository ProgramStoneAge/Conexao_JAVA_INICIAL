import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ConexaoBD cn = new ConexaoBD();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite 1 Para Conectar");
        if(scanner.hasNextInt()){
            cn.conectar(Cntx());
        }
    }

    public static String Cntx(){
        String sql = "CREATE TABLE usuarios (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY, " +
                     "nome VARCHAR(100) NOT NULL, " +
                     "email VARCHAR(100) UNIQUE NOT NULL)";
                     return sql;
    }
}
class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado com sucesso!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
    public static Connection conectar(String criar_tabela) {
        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conexao.createStatement();
            stmt.executeUpdate(criar_tabela);
            stmt.close();
            System.out.println("Conectado com sucesso!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}