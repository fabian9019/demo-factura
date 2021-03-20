package com.mycompany.prueba2.controllers;

import com.mycompany.prueba2.entities.Factura;
import com.mycompany.prueba2.entities.Producto;
import com.mycompany.prueba2.entities.FacturaPK;
import com.mycompany.prueba2.utilities.JsfUtil;
import com.mycompany.prueba2.utilities.JsfUtil.PersistAction;
import com.mycompany.prueba2.daos.FacturaDao;
import com.mycompany.prueba2.daos.ProductoDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ValueChangeEvent;

@Named("facturaController")
@SessionScoped
public class FacturaController implements Serializable {

    @EJB
    private FacturaDao facturaDao;

    @EJB
    private ProductoDao productoDao;

    private List<Factura> items = null;
    private Factura selected;

    private Producto productSelected;
    private int productoCantidad = -1;
    private int productoCantidadSelected = 0;
    private List<Producto> productos = new ArrayList<>();
    private List<Producto> productosTemporales = new ArrayList<>();

    @PostConstruct
    public void init() {
        productosTemporales = productoDao.findAll();
    }

    public FacturaController() {
    }

    public Producto getProductSelected() {
        return productSelected;
    }

    public void setProductSelected(Producto productSelected) {
        this.productSelected = productSelected;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductosTemporales() {
        return productosTemporales;
    }

    public void setProductosTemporales(List<Producto> productosTemporales) {
        this.productosTemporales = productosTemporales;
    }

    public int getProductoCantidad() {
        if (productSelected != null) {
            productoCantidad = productSelected.getCantidad();
        } else if (productoCantidad == -1) {
            /*List<Producto> listTemp = productoDao.findAll();*/
            List<Producto> listTemp = productosTemporales;
            if (listTemp.size() > 0) {
                productoCantidad = listTemp.get(0).getCantidad();
                productSelected = listTemp.get(0);
            } else {
                productoCantidad = 0;
            }
        }
        return productoCantidad;
    }

    public void setProductoCantidad(int productoCantidad) {
        this.productoCantidad = productoCantidad;
    }

    public int getProductoCantidadSelected() {
        return productoCantidadSelected;
    }

    public void setProductoCantidadSelected(int productoCantidadSelected) {
        this.productoCantidadSelected = productoCantidadSelected;
    }

    public void productoHandleChange(ValueChangeEvent event) {
        Producto selectedProducto = (Producto) event.getNewValue();
        productoCantidad = selectedProducto.getCantidad();
    }

    public void addProducto() {
        System.out.println("AddProducto");
        Producto productoLista = productosTemporales.get(productosTemporales.indexOf(productSelected));
        int cantidadReal = productoLista.getCantidad() - productoCantidadSelected;
        productoLista.setCantidad(cantidadReal);
        productoCantidad = cantidadReal;
        productSelected.setCantidad(cantidadReal);

        if (productos.indexOf(productoLista) == -1) {
            Producto p = new Producto();
            p.setIdProducto(productoLista.getIdProducto());
            p.setDescripcion(productoLista.getDescripcion());
            p.setCantidad(productoCantidadSelected);
            p.setValor(productoLista.getValor());
            productos.add(p);
        } else {
            Producto p1 = productos.get(productos.indexOf(productoLista));
            p1.setCantidad(p1.getCantidad() + productoCantidadSelected);
        }

        productoCantidadSelected = 0;
        System.out.println("productoCantidad: " + productoCantidad);
    }

    public Factura getSelected() {
        return selected;
    }

    public void setSelected(Factura selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getFacturaPK().setClienteidCliente(selected.getCliente().getIdCliente());
    }

    protected void initializeEmbeddableKey() {
        selected.setFacturaPK(new FacturaPK());
    }

    private FacturaDao getFacturaDao() {
        return facturaDao;
    }

    public ProductoDao getProductoDao() {
        return productoDao;
    }

    public Factura prepareCreate() {
        selected = new Factura();
        initializeEmbeddableKey();

        selected.setFechaCreacion(new Date());
        return selected;
    }

    public void create() {
        //selected.set
        //selected.setProductoList(productos);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FacturaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FacturaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FacturaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Factura> getItems() {
        if (items == null) {
            items = getFacturaDao().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.CREATE) {
                    getFacturaDao().create(selected);
                } else if (persistAction != PersistAction.DELETE) {
                    getFacturaDao().edit(selected);
                } else {
                    getFacturaDao().remove(selected);
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

    public Factura getFactura(FacturaPK id) {
        return getFacturaDao().find(id);
    }

    public List<Factura> getItemsAvailableSelectMany() {
        return getFacturaDao().findAll();
    }

    public List<Factura> getItemsAvailableSelectOne() {
        return getFacturaDao().findAll();
    }

    @FacesConverter(forClass = Factura.class)
    public static class FacturaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FacturaController controller = (FacturaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "facturaController");
            return controller.getFactura(getKey(value));
        }

        FacturaPK getKey(String value) {
            FacturaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new FacturaPK();
            key.setIdFactura(Integer.parseInt(values[0]));
            key.setClienteidCliente(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(FacturaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdFactura());
            sb.append(SEPARATOR);
            sb.append(value.getClienteidCliente());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Factura) {
                Factura o = (Factura) object;
                return getStringKey(o.getFacturaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Factura.class.getName()});
                return null;
            }
        }

    }

}
