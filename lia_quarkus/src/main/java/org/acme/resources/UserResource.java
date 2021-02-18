package org.acme.resources;

import org.acme.entities.User;
import org.acme.services.UserService;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/rest/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @POST
    @Path("/register")
    @Transactional
    public Response registerUser(User user){
        User registerdUser = userService.registerUser(user);
        if(registerdUser == null){
            return Response.status(Response.Status.CONFLICT).entity("user already exist").build();
        }
        return Response.status(Response.Status.CREATED).entity(registerdUser).build();
    }

    @POST
    @Path("/login")
    @Transactional
    public Response loginUser(User user){
        User loggedInUser = userService.loginUser(user);
        if(loggedInUser == null){
            return Response.status(Response.Status.UNAUTHORIZED).entity("wrong email or password").build();
        }
        return Response.status(Response.Status.OK).entity(loggedInUser).build();
    }

    @GET
    public Response getAllUsers(){
        return Response.status(Response.Status.OK).entity(userService.getAllUsers()).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateUser (User user, @PathParam("id") long id){
        User updatedUser = userService.updateUser(id, user);
        if(updatedUser == null){
            return Response.status(Response.Status.NOT_FOUND).entity("user not found").build();
        }
        return Response.status(Response.Status.OK).entity(updatedUser).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") long id){
        String deletedUser = userService.deleteUser(id);
        if(deletedUser == null){
            return Response.status(Response.Status.NOT_FOUND).entity("user not found").build();
        }
        return Response.status(Response.Status.OK).entity(deletedUser).build();
    }


}
