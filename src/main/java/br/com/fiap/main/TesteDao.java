package br.com.fiap.main;

import br.com.fiap.beans.Chamado;
import br.com.fiap.dao.ChamadoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteDao
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        //Chamado chamdo = new Chamado(-23.7199405, -46.6125048);
        //ChamadoDAO chamadoDao = new ChamadoDAO();
        //chamadoDao.inserir(chamdo);
        ChamadoDAO chamadoDao = new ChamadoDAO();
        //chamadoDao.atualizarStatus(1);
        List<Chamado> chamados = chamadoDao.selecionar();
        for(Chamado chamado : chamados)
        {
            System.out.println(chamado);
        }


    }


}
