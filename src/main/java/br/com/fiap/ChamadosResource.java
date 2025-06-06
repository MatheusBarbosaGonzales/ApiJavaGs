package br.com.fiap;

import br.com.fiap.beans.Chamado;
import br.com.fiap.bo.ChamadoBO;
import br.com.fiap.dto.CordenadasDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;


@Path("/chamados")
public class ChamadosResource {

    private ChamadoBO chamadoBO;

    public ChamadosResource(){
        try {
            chamadoBO = new ChamadoBO();
        } catch (Exception e)
        {
            System.out.println("Erro ao instanciar UsuarioBO: " + e.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Chamado> listarChamados() throws SQLException {
        try {
            return chamadoBO.listarChamados();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PATCH
    @Path("/finalizar/{id}")
    public Response atenderChamado(@PathParam("id") int id)
    {
        try
        {
            chamadoBO.atenderChamado(id);
            return Response.ok("Chamado atendido com sucesso").build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Path("/criarChamado")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarChamado(CordenadasDTO cordenadas) throws SQLException, ClassNotFoundException {
        try {
            chamadoBO.criarChamado(new Chamado(cordenadas.latitude, cordenadas.longitude));
            return Response.ok("Chamado criado com sucesso!").build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Map.of("erro" + e.getMessage(),"Não foi possível criar seu chamado, tente novamente mais tarde")).build();
        }
    }

    @DELETE
    @Path("/apagar/{id}")
    public Response apagarChamado(@PathParam("id") int id) throws SQLException {
        try{
        chamadoBO.apagarChamado(id);
        return Response.ok("Chamado apagado com sucesso!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Map.of("erro " + e.getMessage(), "Não foi possível apagar seu chamado, tente novamente mais tarde")).build();
        }
    }




}