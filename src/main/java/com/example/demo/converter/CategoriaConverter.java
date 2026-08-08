package com.example.demo.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;

@Component
@ApplicationScope
@FacesConverter(value = "categoriaConverter" , forClass = Categoria.class)
public class CategoriaConverter implements Converter {

     //Cria uma instancia do service para ter acesso ao metodo porId
    @Autowired
    private CategoriaService categoriaService;


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && ! value.trim().isEmpty()){
            try {
                return categoriaService.buscarPorId(Long.valueOf(value));
            } catch (NumberFormatException  e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão", "Não é uma categoria válida."));
            }
            
        }else{
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null){
            Categoria categ = (Categoria) value;
            return categ.getId() == null ? null : categ.getId().toString();
        }
        return null;
    }
    
}
