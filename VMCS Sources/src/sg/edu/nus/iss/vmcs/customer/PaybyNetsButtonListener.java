/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.system.MainController;

/**
 * This control object monitors the Terminate Button on the Customer Panel and informs the Transaction
 * Controller when it is pressed.
 * @author Team SE16T5E
 * @version 1.0 2008-10-01
 */
public class PaybyNetsButtonListener implements ActionListener{
	private TransactionController txCtrl;
	
	/**
	 * This constructor creates an instance of the Terminate Button Listener.
	 * @param txCtrl the Transaction Controller.
	 */
	public PaybyNetsButtonListener(TransactionController txCtrl){
		this.txCtrl=txCtrl;
	}
	
	/**
	 * This method performs actions in response to the terminate button being pressed.
	 */
	public void actionPerformed(ActionEvent ev){
                String command = ev.getActionCommand();
                int drinkIndex = txCtrl.getSelection();
                if("Simulate Inserting NETS Card".equalsIgnoreCase(command)){
                    txCtrl.completeNetsTransaction(txCtrl, drinkIndex);
                }else if("Simulate Invalid NETS Card".equalsIgnoreCase(command)){
                    txCtrl.getCustomerPanel().displayInvalidCard(true);
                    txCtrl.getCustomerPanel().displayNoBalanceCard(false);
                }else{
                    txCtrl.getCustomerPanel().displayNoBalanceCard(true);
                    txCtrl.getCustomerPanel().displayInvalidCard(false);
                }
                txCtrl.refreshCustomerPanel();
	}
}//End of class TerminateButtonListener