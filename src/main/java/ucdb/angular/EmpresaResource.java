package ucdb.angular;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/empresa")
public class EmpresaResource {

	@Inject
    EmpresaBO empresaBO;

    //lista todas as empresas
    @GET
    @Path("/lista")
    @Produces("application/json")
    public Response lista(){
        return Response.status(200).entity(empresaBO.lista()).build();
    }

    //lista todas as categorias
    @GET
    @Path("/listaCategoria")
    @Produces("application/json")
    public Response listaCategoria(){
        return Response.status(200).entity(empresaBO.listaCategoria()).build();
    }

    //lista todas as regiões
    @GET
    @Path("/listaRegiao")
    @Produces("application/json")
    public Response listaRegiao(){
        return Response.status(200).entity(empresaBO.listaRegiao()).build();
    }

    //lista todas as Bairro
    @GET
    @Path("/listaBairro")
    @Produces("application/json")
    public Response listaBairro(){
        return Response.status(200).entity(empresaBO.listaBairro()).build();
    }

    //lista por cateria
    @GET
    @Path("/categoria/{indice}")
    @Produces("application/json")
    public Response categoria(@PathParam("indice") Integer indice){
        return Response.status(200).entity(empresaBO.buscarPorCategoria(indice)).build();
    }

    //Busca detalhada
    @GET
    @Path("/buscaDetalhada/{categoria}/{bairro}/{endereco}")
    @Produces("application/json")
    public Response buscaDetalhada(@PathParam("categoria") String categoria,@PathParam("bairro") String bairro,@PathParam("endereco") String endereco){
        return Response.status(200).entity(empresaBO.buscaDetalhada(categoria, bairro, endereco)).build();
    }

    //lista por cateria
    @GET
    @Path("/buscarPorId/{indice}")
    @Produces("application/json")
    public Response buscarPorId(@PathParam("indice") Integer indice){
        return Response.status(200).entity(empresaBO.buscarPorId(indice)).build();
    }

    //lista pelo filtro do buscar
    @GET
    @Path("/buscar/{texto}")
    @Produces("application/json")
    public Response buscar(@PathParam("texto") String texto){
        return Response.status(200).entity(empresaBO.buscarPorFiltro(texto)).build();
    }
}
