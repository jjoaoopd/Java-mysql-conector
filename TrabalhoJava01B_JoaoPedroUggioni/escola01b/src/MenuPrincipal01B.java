import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipal01B {
    public static void main(String[] args) throws SQLException{
        ControleDados01B obj = new ControleDados01B();
        int opc=0;
        Scanner tc = new Scanner(System.in);
        Conexao01B bd = new Conexao01B();
        bd.criarConexao();
        while(opc!=3){
            System.out.print("\n\n--- MENU ESCOLA ---");
            System.out.print("\n1- Cadastrar Alunos");
            System.out.print("\n2- Listar Alunos");
            System.out.print("\n3- SAIR");
            System.out.print("\nEscolha uma opção: ");
            opc =tc.nextInt();

            switch (opc){
                case 1:
                    obj.Cadastro();
                    break;
                case 2:
                    obj.listagem();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("opção inválida");
            }
        }
    }

}
