/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.machinery;

import java.awt.event.*;
import java.awt.*;

/**
 * This control object monitors data entered into a StoreViewer, when the Controller uses
 * the MachinerySimulatorPanel&#46; When data is entered, it initiates the process to store the data.
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.util.LabelledDisplay;

public class AutoDectectListener implements ActionListener {
	private int type;
	private int item;
	private StoreController storeCtrl;
	private LabelledDisplay viewItem;
        private StoreViewer sv;

	/**
	 * This constructor creates an instance of StoreViewerListener object.
	 * @param type the type of store.
	 * @param item the store item.
	 * @param sctrl the StoreController.
	 */
	public AutoDectectListener(int type, int item, StoreController sctrl, LabelledDisplay inviewitem, StoreViewer storeViewer) {
		this.type = type;
		this.item = item;
		storeCtrl = sctrl;
                viewItem = inviewitem;
                sv = storeViewer;
	}
	
	/**
	 * This method performs actions in response to the data being entered to the store viewer.
	 */
	public void actionPerformed(ActionEvent e) {
		int qty;
		String sqty;

		sqty = viewItem.getValue();
		qty = Integer.parseInt(sqty)+1;
		storeCtrl.changeStoreQty(type, item, qty);
                sv.update();
	}
}//End of class StoreViewerListener