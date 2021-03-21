package com.mycompany.prueba2.controllers;

import com.mycompany.prueba2.entities.FacturaDetalle;
import com.mycompany.prueba2.utilities.JsfUtil;
import com.mycompany.prueba2.utilities.JsfUtil.PersistAction;
import com.mycompany.prueba2.daos.FacturaDetalleDao;

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

@Named("facturaDetalleController")
@SessionScoped
public class FacturaDetalleController implements Serializable {

    @EJB
    private FacturaDetalleDao facturaDetalleDao;
    private List<FacturaDetalle> items = null;
    private FacturaDetalle selected;

    public FacturaDetalleController() {
    }

    public FacturaDetalle getSelected() {
        return selected;
    }

    public void setSelected(FacturaDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FacturaDetalleDao getFacturaDetalleDao() {
        return facturaDetalleDao;
    }

    public FacturaDetalle prepareCreate() {
        selected = new FacturaDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FacturaDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FacturaDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FacturaDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<FacturaDetalle> getItems() {
        if (items == null) {
            items = getFacturaDetalleDao().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacturaDetalleDao().edit(selected);
                } else {
                    getFacturaDetalleDao().remove(selected);
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

    public FacturaDetalle getFacturaDetalle(java.lang.Integer id) {
        return getFacturaDetalleDao().find(id);
    }

    public List<FacturaDetalle> getItemsAvailableSelectMany() {
        return getFacturaDetalleDao().findAll();
    }

    public List<FacturaDetalle> getItemsAvailableSelectOne() {
        return getFacturaDetalleDao().findAll();
    }

    @FacesConverter(forClass = FacturaDetalle.class)
    public static class FacturaDetalleControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FacturaDetalleController controller = (FacturaDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "facturaDetalleController");
            return controller.getFacturaDetalle(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof FacturaDetalle) {
                FacturaDetalle o = (FacturaDetalle) object;
                return getStringKey(o.getIdFacturaDetalle());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FacturaDetalle.class.getName()});
                return null;
            }
        }

    }

}
