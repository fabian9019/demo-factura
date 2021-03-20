package com.mycompany.prueba2.controllers;

import com.mycompany.prueba2.entities.FacturahasProducto;
import controllers.util.JsfUtil;
import controllers.util.JsfUtil.PersistAction;
import com.mycompany.prueba2.daos.FacturahasProductoDao;
import com.mycompany.prueba2.entities.FacturahasProductoPK;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("facturahasProductoController")
@SessionScoped
public class FacturahasProductoController implements Serializable {

    @EJB
    private FacturahasProductoDao facturahasProductoDao;
    private List<FacturahasProducto> items = null;
    private FacturahasProducto selected;

    public FacturahasProductoController() {
    }

    public FacturahasProducto getSelected() {
        return selected;
    }

    public void setSelected(FacturahasProducto selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getFacturahasProductoPK().setFacturaidFactura(selected.getFactura().getFacturaPK().getIdFactura());
        selected.getFacturahasProductoPK().setProductoidProducto(selected.getProducto().getIdProducto());
    }

    protected void initializeEmbeddableKey() {
        selected.setFacturahasProductoPK(new FacturahasProductoPK());
    }

    private FacturahasProductoDao getDao() {
        return facturahasProductoDao;
    }

    public FacturahasProducto prepareCreate() {
        selected = new FacturahasProducto();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FacturahasProductoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FacturahasProductoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FacturahasProductoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<FacturahasProducto> getItems() {
        if (items == null) {
            items = getDao().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getDao().edit(selected);
                } else {
                    getDao().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public FacturahasProducto getFacturahasProducto(FacturahasProductoPK id) {
        return getDao().find(id);
    }

    public List<FacturahasProducto> getItemsAvailableSelectMany() {
        return getDao().findAll();
    }

    public List<FacturahasProducto> getItemsAvailableSelectOne() {
        return getDao().findAll();
    }

    @FacesConverter(forClass = FacturahasProducto.class)
    public static class FacturahasProductoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FacturahasProductoController controller = (FacturahasProductoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "facturahasProductoController");
            return controller.getFacturahasProducto(getKey(value));
        }

        FacturahasProductoPK getKey(String value) {
            FacturahasProductoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new FacturahasProductoPK();
            key.setFacturaidFactura(Integer.parseInt(values[0]));
            key.setProductoidProducto(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(FacturahasProductoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getFacturaidFactura());
            sb.append(SEPARATOR);
            sb.append(value.getProductoidProducto());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof FacturahasProducto) {
                FacturahasProducto o = (FacturahasProducto) object;
                return getStringKey(o.getFacturahasProductoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FacturahasProducto.class.getName()});
                return null;
            }
        }

    }

}
