package fr.chicowa.jsf.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.chicowa.jsf.entities.Product;
import fr.chicowa.jsf.repository.RepositoryContainer;
import lombok.Getter;

@Scope( value = "session" )
@Controller( value = "productList" )
@Join( path = "/", to = "product-list.jsf" )
@ELBeanName( value = "productList" )
public class ProductListController {

    @Autowired
    private RepositoryContainer.Container repos;

    @Getter
    private List<Product>                 products;

    // ces annotations servent à charger les données avant le rendu de la vue
    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        products = repos.productRepository.findAll();
    }

}
