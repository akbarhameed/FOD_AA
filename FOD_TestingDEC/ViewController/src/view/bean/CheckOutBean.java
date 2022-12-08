package view.bean;

import java.io.Serializable;

import java.util.Date;

import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;

import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
import oracle.jbo.uicli.binding.JUCtrlAttrsBinding;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

public class CheckOutBean implements Serializable {
    private Number productID;
    private RichPopup newShippingPopup;
    private RichPopup editShippingPopup;
    private RichPopup newPaymentPopup;
    private RichPopup editPaymentPopUp;
    private RichCommandButton remAlBut;
    private RichCommandButton remItBut;
    private RichCommandButton subbOrdBuut;
    private RichCommandButton addItBut;
    private RichSelectOneChoice payentOptionsLOV;


    public CheckOutBean() {
    }

    public void addItemAL(ActionEvent actionEvent) {
        // Add event code here...
            System.out.println("Prodcut ID:"+getProductID());
            if(this.getProductID()!=null){
                    OperationBinding ob = BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("addItemInTransientVO");
                    ob.getParamsMap().put("productID", getProductID());
                    ob.execute();
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Please Enter Product Id to add to cart",null));
            }
            
            System.out.println("(((((((((((((((((((((((((("+this.getFromSession("OrdId"));
            
            if(this.getFromSession("OrdId")==null){
                    System.out.println("leaving from addItem()");
            if(this.getProductID()!=null){
                    OperationBinding ob = BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("createNewOrder");
                    ob.execute();
                Object object = ob.getResult();
                this.storeOnSession("OrdId", object);
                System.out.println("(((((((++++++++++++++++++++++++++++++++++++++++"+this.getFromSession("OrdId"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Please Enter Product Id to place the order",null));
            }     
            }
            
            
            
            if(this.getProductID()!=null){
                    OperationBinding ob = BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("createOrderItems");
                ob.getParamsMap().put("productID", getProductID());
                    ob.execute();
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Please Enter Product Id to place the order",null));
            }   
            this.getRemAlBut().setDisabled(false);
            this.getRemItBut().setDisabled(false);
            this.getSubbOrdBuut().setDisabled(false);
        }


        public static Object getFromSession(String key) {
            FacesContext ctx = getFacesContext();
            Map sessionState = ctx.getExternalContext().getSessionMap();
            return sessionState.get(key);
        }
        public static void storeOnSession(String key, Object object) {
            FacesContext ctx = getFacesContext();
            Map sessionState = ctx.getExternalContext().getSessionMap();
            sessionState.put(key, object);
        }



    public void removeItemFromCart(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Prodcut ID:"+getProductID());
            if(this.getProductID()!=null){
                OperationBinding ob = BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("removeItemFromCart");
                ob.getParamsMap().put("productId", getProductID());
                ob.execute();
            }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Please Enter Product Id to remove it from the Cart",null));
        }
                System.out.println("leaving from removeItemFromCart()");
    }


    public void removeAllItemsFromCart(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Prodcut ID:"+getProductID());
                OperationBinding ob = BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("removeAllItemsFromCart");
                ob.execute();
                System.out.println("leaving from removeAllItemsFromCart()");
    }



    public void setProductID(Number productID) {
        this.productID = productID;
    }

    public Number getProductID() {
        return productID;
    }

    public String submitOrder() {
        // Add event code here...

        DCBindingContainer bindings = (DCBindingContainer)resolveExpression("#{bindings}");
        
        JUCtrlAttrsBinding orderStatusCode = (JUCtrlAttrsBinding)bindings.findNamedObject("OrderStatusCode");
        orderStatusCode.setAttribute("OrderStatusCode", "PENDING");

        JUCtrlAttrsBinding orderDate = (JUCtrlAttrsBinding)bindings.findNamedObject("OrderDate");
        orderDate.setAttribute("OrderDate", new Date());

        JUCtrlAttrsBinding orderTotal = (JUCtrlAttrsBinding)bindings.findNamedObject("OrderTotal");
        JUCtrlAttrsBinding invoiceTotal = (JUCtrlAttrsBinding)bindings.findNamedObject("InvoiceTotal");
        orderTotal.setAttribute("OrderTotal", invoiceTotal.getAttribute("InvoiceTotal"));

        OperationBinding ob = (OperationBinding)bindings.getOperationBinding("Commit");
        ob.execute();
        this.getRemAlBut().setDisabled(true);
        this.getRemItBut().setDisabled(true);
        this.getSubbOrdBuut().setDisabled(true);
        this.getAddItBut().setDisabled(true);
        return null;
    }
    public static Object resolveExpression(String expression) {
            FacesContext facesContext = getFacesContext();
            Application app = facesContext.getApplication();
            ExpressionFactory elFactory = app.getExpressionFactory();
            ELContext elContext = facesContext.getELContext();
            ValueExpression valueExp = 
                elFactory.createValueExpression(elContext, expression, 
                                                Object.class);
            return valueExp.getValue(elContext);
        }
        public static FacesContext getFacesContext() {
            return FacesContext.getCurrentInstance();
        }

    public void newShipping(ActionEvent actionEvent) {
        // Add event code here...
        DCBindingContainer bindings = (DCBindingContainer)resolveExpression("#{bindings}");
        OperationBinding ob = bindings.getOperationBinding("CreateInsert");
        ob.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getNewShippingPopup());
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getNewShippingPopup().show(hints);
    }

    public void setNewShippingPopup(RichPopup newShippingPopup) {
        this.newShippingPopup = newShippingPopup;
    }

    public RichPopup getNewShippingPopup() {
        return newShippingPopup;
    }

    public void editShipping(ActionEvent actionEvent) {
        edit("ExecuteWithParamsFindAddressesById", "ShipToAddressId", "id", "AddressId");
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getEditShippingPopup());
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getEditShippingPopup().show(hints);
    }
    
    private Object edit(String opName, String listBindingName, String varName, String colName) {
        DCBindingContainer bindings = (DCBindingContainer)resolveExpression("#{bindings}");
        OperationBinding ob = 
            (OperationBinding)bindings.get(opName);
        JUCtrlListBinding  listBinding = (JUCtrlListBinding)bindings.get(listBindingName) ;
        Row row = (Row)listBinding.getSelectedValue();
        ob.getParamsMap().put( varName, row.getAttribute(colName) );
        return ob.execute();             
    }

    public void setEditShippingPopup(RichPopup editShippingPopup) {
        this.editShippingPopup = editShippingPopup;
    }

    public RichPopup getEditShippingPopup() {
        return editShippingPopup;
    }

    public void ediShippingAL(ActionEvent actionEvent) {
        // Add event code here...
        DCBindingContainer bindings = (DCBindingContainer)resolveExpression("#{bindings}");
        OperationBinding ob = (OperationBinding)bindings.getOperationBinding("Commit");
        ob.execute();
    }

    public void newShippingAL(ActionEvent actionEvent) {
        DCBindingContainer bindings = (DCBindingContainer)resolveExpression("#{bindings}");
        OperationBinding ob = (OperationBinding)bindings.getOperationBinding("Commit");
        ob.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPayentOptionsLOV());
    }

    public void cancelShippingAL(ActionEvent actionEvent) {
        cancelAdd("AddressAndUsageVO1Iterator");
    }
    private void cancelAdd(String itrName){
        DCBindingContainer bindings = (DCBindingContainer)resolveExpression("#{bindings}");
        DCIteratorBinding itr = (DCIteratorBinding)bindings.get(itrName);
        itr.removeCurrentRow();
    }

    public void newPaymentAL(ActionEvent actionEvent) {
        DCBindingContainer bindings = (DCBindingContainer)resolveExpression("#{bindings}");
        OperationBinding ob = (OperationBinding)bindings.getOperationBinding("CreateInsert1");
        ob.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getNewPaymentPopup());
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getNewPaymentPopup().show(hints);
    }

    public void editPaymentAL(ActionEvent actionEvent) {
//        edit("FindPaymentOptionsByIdExecuteWithParams", "PaymentOptionId", "paymentId", "PaymentOptionId");
        DCBindingContainer bc = (DCBindingContainer)resolveExpression("#{bindings}");
        JUCtrlListBinding lb = (JUCtrlListBinding)bc.get("PaymentOptionId");
                  Number ob = (Number)lb.getAttributeValue(); 
                  System.out.println("*****************"+ob);
        DCIteratorBinding iter = bc.findIteratorBinding("FindPaymentOptionsByIdIterator");
        ViewObject vo = iter.getViewObject();
        Row[] rows = vo.findByKey( new Key(new Object[]{ob}) ,1);
        Row r = rows[0];
        vo.setCurrentRow(r);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getEditPaymentPopUp());
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
       this.getEditPaymentPopUp().show(hints);
    }

    public void setNewPaymentPopup(RichPopup newPaymentPopup) {
        this.newPaymentPopup = newPaymentPopup;
    }

    public RichPopup getNewPaymentPopup() {
        return newPaymentPopup;
    }

    public void paymentOKAL(ActionEvent actionEvent) {
        DCBindingContainer bindings = (DCBindingContainer)resolveExpression("#{bindings}");
        OperationBinding ob = (OperationBinding)bindings.getOperationBinding("Commit");
        ob.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPayentOptionsLOV());
    }

    public void paymentCancelAL(ActionEvent actionEvent) {
        cancelPayments("PaymentOptionsForUserIterator");
    }
    private void cancelPayments(String itrName){
        DCBindingContainer bindings = (DCBindingContainer)resolveExpression("#{bindings}");
        DCIteratorBinding itr = (DCIteratorBinding)bindings.get(itrName);
        itr.removeCurrentRow();
    }


    public void setEditPaymentPopUp(RichPopup editPaymentPopUp) {
        this.editPaymentPopUp = editPaymentPopUp;
    }

    public RichPopup getEditPaymentPopUp() {
        return editPaymentPopUp;
    }

    public void paymentVL(ValueChangeEvent valueChangeEvent) {
        Object newValue = valueChangeEvent.getNewValue();
        System.out.println("--------"+newValue);
       
        
    }

    public void setRemAlBut(RichCommandButton remAlBut) {
        this.remAlBut = remAlBut;
    }

    public RichCommandButton getRemAlBut() {
        return remAlBut;
    }

    public void setRemItBut(RichCommandButton remItBut) {
        this.remItBut = remItBut;
    }

    public RichCommandButton getRemItBut() {
        return remItBut;
    }

    public void setSubbOrdBuut(RichCommandButton subbOrdBuut) {
        this.subbOrdBuut = subbOrdBuut;
    }

    public RichCommandButton getSubbOrdBuut() {
        return subbOrdBuut;
    }

    public void setAddItBut(RichCommandButton addItBut) {
        this.addItBut = addItBut;
    }

    public RichCommandButton getAddItBut() {
        return addItBut;
    }

    public void setPayentOptionsLOV(RichSelectOneChoice payentOptionsLOV) {
        this.payentOptionsLOV = payentOptionsLOV;
    }

    public RichSelectOneChoice getPayentOptionsLOV() {
        return payentOptionsLOV;
    }


}
