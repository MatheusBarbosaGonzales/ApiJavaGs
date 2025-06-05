package br.com.fiap.dao;

import br.com.fiap.beans.Chamado;
import br.com.fiap.conexoes.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChamadoDAO
{
    public Connection minhaConexao;
    public ChamadoDAO()  throws SQLException, ClassNotFoundException{

        this.minhaConexao = new Conexao().conexao();
    }

    public void inserir(Chamado chamado) throws SQLException
    {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO chamadoSocorro (cordX, cordY, status) VALUES (?, ?, ?)");

        stmt.setDouble(1, chamado.getCordX());
        stmt.setDouble(2, chamado.getCordY());
        stmt.setString(3, chamado.getStatus());
        stmt.execute();
        stmt.close();
    }

    public void deletar(int id) throws SQLException
    {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete from chamadoSocorro where id_chamado = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }

    public void atualizarStatus(int idChamado) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Update chamadoSocorro set status = 'Atendido' where id_chamado = ?");
        stmt.setInt(1, idChamado);
        stmt.executeUpdate();
        stmt.close();
    }

    public List<Chamado> selecionar() throws SQLException {
        List<Chamado> listaChamados = new ArrayList<Chamado>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from chamadoSocorro");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Chamado chamado = new Chamado();
            chamado.setId(rs.getInt(1));
            chamado.setCordX(rs.getDouble(2));
            chamado.setCordY(rs.getDouble((3)));
            chamado.setStatus(rs.getString(4));
            chamado.setData(rs.getString(5));
            listaChamados.add(chamado);
        }
        return listaChamados;
    }







}
