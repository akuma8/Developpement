package fr.chicowa.jsf.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import fr.chicowa.jsf.entities.Product;
import fr.chicowa.jsf.repository.RepositoryContainer;
import lombok.Getter;

@SessionScope
@Controller
@ELBeanName( value = "productController" )
@Join( path = "/product", to = "/product-form.jsf" )
public class ProductController {

    @Autowired
    private RepositoryContainer.Container repos;

    @Getter
    private Product                       product;

    public ProductController() {
        this.product = new Product();
    }

    public String save() {
        repos.productRepository.save( product );
        product = new Product();

        return "/product-list.xhtml?faces-redirect=true";
    }

}
