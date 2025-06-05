package br.com.fiap;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/estacoes")
public class EstacoesResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test(){
        return "Hello World";
    }
}
