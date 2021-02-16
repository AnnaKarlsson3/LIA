package org.acme.resources;

import org.acme.entities.User;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/rest/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @POST
    @Transactional
    public Response registerUser(@Valid User user){
        user.persist();
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @GET
    public List<User> getAllUsers(){
        return User.listAll();
    }

    @PATCH
    @Path("/{username}")
    @Transactional
    public User updateUsername (@Valid User user, @PathParam("username") String username){
        User entity = User.findByName(username);
        return null;
    }


}
