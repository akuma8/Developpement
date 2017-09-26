package fr.chicowa.jsf.bean;

import javax.faces.bean.ManagedBean;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
public class LoginBean {

    @Getter
    @Setter
    private String name;
}
