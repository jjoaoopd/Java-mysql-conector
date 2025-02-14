import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ControleDados01B {

    public void Cadastro() throws SQLException{
        Conexao01B cn = new Conexao01B();
        cn.criarConexao();
        String SQL="INSERT INTO aluno01b (nome_aluno,email_aluno,datanasc_aluno,cidade_aluno) VALUES(?,?,?,?)";
        PreparedStatement inclusao = cn.conexao.prepareStatement(SQL);

        boolean cont=true;
        String nome, email, cidade, datanasc;
        int ndata;
        char op;
        Scanner tc = new Scanner(System.in);
        System.out.print("\n\n-- CADASTRO ALUNOS --\n");
        while (cont){
            System.out.print("\nNome do aluno: ");
            nome=tc.nextLine();
            System.out.print("Email: ");
            email=tc.nextLine();
            System.out.print("data de nascimento (DD/MM/AAAA): ");
            datanasc=tc.nextLine();
            ndata= Integer.parseInt(datanasc.substring(6,10)+datanasc.substring(3,5)+datanasc.substring(0,2));
            System.out.print("Cidade: ");
            cidade=tc.nextLine();

            System.out.print("Deseja continuar?(S/N) ");
            inclusao.setString(1,nome);
            inclusao.setString(2,email);
            inclusao.setInt(3,ndata);
            inclusao.setString(4,cidade);
            inclusao.execute();
            op=tc.next().toUpperCase().charAt(0);
            if(op=='N'){
                cont=false;
            }
            tc.nextLine();
        }
    }

    public void listagem() throws SQLException {
        Conexao01B cn = new Conexao01B();
        cn.criarConexao();
        String sql="SELECT * FROM aluno01b";
        PreparedStatement pesquisa = cn.conexao.prepareStatement(sql);
        ResultSet aluno01b = pesquisa.executeQuery();
        while(aluno01b.next()){
            String data=aluno01b.getString("datanasc_aluno");
            String datac =data.substring(8,10)+"/"+data.substring(5,7)+"/"+data.substring(0,4);
            System.out.print("NOME " + aluno01b.getString("nome_aluno"));
            System.out.print("         | EMAIL " + aluno01b.getString("email_aluno"));
            System.out.print("         | DATA DE NASCIMENTO " + datac);
            System.out.print("         | CIDADE " + aluno01b.getString("cidade_aluno"));
            System.out.println();
        }
    }
}
