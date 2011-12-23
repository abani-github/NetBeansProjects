/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.rest;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author beheraab
 */
@Path("generic")
@RequestScoped
public class GenericResource {

    private Map<String, String> names = new HashMap<String, String>();
    @Context
    private UriInfo context;

    /** Creates a new instance of GenericResource */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of com.services.rest.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getXml() {
       return "abani";
    }
    @GET
    @Path(value="/in")
    @Produces("application/json")
    public Map<String, String> getJson() {
       names.put("name", "abani");
       names.put("id", "202");
       return names;
    }
    @GET
    @Path("/sub/{id}")
    @Produces("application/json")
    public String postResult (@PathParam(value="id") String id){
        return "hallo your id is " + id;
    }
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
