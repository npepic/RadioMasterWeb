/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.controller;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author pepy
 */
@javax.ws.rs.ApplicationPath("radiomaster")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(radiomaster.controller.CategoriesController.class);
        resources.add(radiomaster.controller.CategoriesSubController.class);
        resources.add(radiomaster.controller.CommentsController.class);
        resources.add(radiomaster.controller.CountriesController.class);
        resources.add(radiomaster.controller.RadiomasterResource.class);
        resources.add(radiomaster.controller.RegisterController2.class);
        resources.add(radiomaster.controller.StationsController.class);
        resources.add(radiomaster.controller.UserAuthorizationCheck.class);
        resources.add(radiomaster.controller.UserController.class);
        resources.add(radiomaster.controller.UserRemoveController.class);
        resources.add(radiomaster.controller.UserUpdateController.class);
    }
    
}
