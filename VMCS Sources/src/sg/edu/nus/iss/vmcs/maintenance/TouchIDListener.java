/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.maintenance;

import java.awt.event.*;
import java.awt.*;

/**
 * This control object monitors the events in the Password Box and performs actions in
 * response to data being entered into the text field.
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */
public class TouchIDListener implements ActionListener {
	AccessManager actrl;

	/**
	 * This constructor creates an instance of the PasswordListener.
	 * @param ac the AccessManager.
	 */
	public TouchIDListener(AccessManager ac) {
		actrl = ac;
	}
	
	/**
	 * This method performs actions in response to the password text field being entered.
	 */
	public void actionPerformed(ActionEvent e) {
		
		actrl.processPassword("1");
                actrl.displayInvalidCardState(false);
                actrl.displayValidCardState(true);
	}
}//End of class PasswordListener