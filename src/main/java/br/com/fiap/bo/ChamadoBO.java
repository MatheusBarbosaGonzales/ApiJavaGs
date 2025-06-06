package br.com.fiap.bo;

import br.com.fiap.beans.Chamado;
import br.com.fiap.dao.ChamadoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ChamadoBO
{
    private ChamadoDAO  chamadoDAO;

    public ChamadoBO() throws SQLException, ClassNotFoundException {
        chamadoDAO = new ChamadoDAO();
    }

    public void apagarChamado(int id) throws SQLException {
        chamadoDAO.deletar(id);
    }

    public void criarChamado(Chamado chamadoInput) throws SQLException {
        chamadoDAO.inserir(chamadoInput);
    }

    public void atenderChamado(int id) throws SQLException {
        chamadoDAO.atualizarStatus(id);
    }

    public ArrayList<Chamado> listarChamados() throws SQLException {
        return (ArrayList<Chamado>) chamadoDAO.selecionar();
    }
}
