package br.com.fiap.main;
import br.com.fiap.conexoes.Conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConxao
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection cn = new Conexao().conexao();

        cn.close();
    }
}
