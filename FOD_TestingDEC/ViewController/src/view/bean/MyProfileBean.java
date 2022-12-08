package view.bean;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.DialogEvent.Outcome;

import oracle.binding.BindingContainer;

import oracle.binding.ControlBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.uicli.binding.JUCtrlHierBinding;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class MyProfileBean implements Serializable {
    private RichTable table;
    private RichTable paymentTable;
    private RichPopup addPaymentPopup;

    public MyProfileBean() {
    }

    public void addressRemoveDL(DialogEvent dialogEvent) {
        // Add event code here...

        deleteOnTable(getTable());

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTable());
    }
    public void deleteOnTable(RichTable myTable) {
            RowKeySet rowKeySet = (RowKeySet) myTable.getSelectedRowKeys();
            CollectionModel cm = (CollectionModel) myTable.getValue();
            for (Object facesTreeRowKey : rowKeySet) {
                cm.setRowKey(facesTreeRowKey);
                JUCtrlHierNodeBinding rowData = (JUCtrlHierNodeBinding)
                    cm.getRowData();
                rowData.getRow().remove();
            }
        }

    public void setTable(RichTable table) {
        this.table = table;
    }

    public RichTable getTable() {
        return table;
    }

    public void removePaymentDL(DialogEvent dialogEvent) {
        deleteOnTable(this.getPaymentTable());

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPaymentTable());
    }

    public void setPaymentTable(RichTable paymentTable) {
        this.paymentTable = paymentTable;
    }

    public RichTable getPaymentTable() {
        return paymentTable;
    }

    public void addPaymentsAL(ActionEvent actionEvent) {
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcitr = 
            (DCIteratorBinding)bindings.get("PaymentOptionsForUserIterator");
        RowSetIterator rowSetItr = dcitr.getRowSetIterator();
        Row currentRow = rowSetItr.createRow();
        rowSetItr.insertRow(currentRow);
        String rowKey = currentRow.getKey().toStringFormat(true);
        dcitr.setCurrentRowWithKey(currentRow.getKey().toStringFormat(true));
        dcitr.refreshIfNeeded();
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getAddPaymentPopup().show(hints);
    }

    public void setAddPaymentPopup(RichPopup addPaymentPopup) {
        this.addPaymentPopup = addPaymentPopup;
    }

    public RichPopup getAddPaymentPopup() {
        return addPaymentPopup;
    }

    public void addPaymentsDL(DialogEvent dialogEvent) {
        DialogEvent.Outcome result = dialogEvent.getOutcome();

        if (result == DialogEvent.Outcome.no) {
            deleteOnTable(this.getPaymentTable());               
           
        }
    }
}
