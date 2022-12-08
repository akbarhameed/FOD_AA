package mwgl.Bean;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.binding.OperationBinding;

public class MyOrderBean {
    public MyOrderBean() {
    }

    public void invokeCancelOrder(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding ob = BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("cancelOrdered");
        ob.execute();
    }
}
