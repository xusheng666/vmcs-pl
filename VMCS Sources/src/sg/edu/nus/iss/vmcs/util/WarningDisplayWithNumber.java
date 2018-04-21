/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.util;

import java.awt.*;

/**
 * This interface object class implements a generic display label&#46; It provides for setting
 * the background and foreground colors for display labels, and to set their state to on or off&#46;
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */
public class WarningDisplayWithNumber extends Panel {
	private static final Color DEFAULT_FG = Color.yellow;
	private static final Color DEFAULT_BG = Color.red;
	private static final Color DEFAULT_OFF = Color.white;

	private Color onFg = DEFAULT_FG, onBg = DEFAULT_BG;
	private Color offFg = DEFAULT_OFF, offBg = Color.black;
	private Label lb;

	/**
	 * This constructor creates an instance of WarningDisplay object&#46;
	 * @param label name of the label&#46;
	 */
	public WarningDisplayWithNumber(String label) {
		this.setLayout(new FlowLayout());
		lb = new Label(label);
		this.add(lb);
//		setState(false, get);
	}

	/**
	 * This constructor creates an instance of WarningDisplay object.
	 * @param label name of the label.
	 * @param onFg foreground color when ON.
	 * @param onBg background color when ON.
	 */
	public WarningDisplayWithNumber(String label, Color onFg, Color onBg) {
		this(label, onFg, onBg, DEFAULT_OFF, DEFAULT_OFF);
//		setState(false);
	}

	/**
	 * This constructor creates an instance of WarningDisplay object&#46;
	 * @param label name of the label&#46;
	 * @param onFg foreground color when ON&#46;
	 * @param onBg background color when ON&#46;
	 * @param offFg foreground color when OFF&#46;
	 * @param offBg background color when OFF&#46;
	 */
	public WarningDisplayWithNumber(
		String label,
		Color onFg,
		Color onBg,
		Color offFg,
		Color offBg) {

		this.onBg = onBg;
		this.onFg = onFg;
		this.offBg = offBg;
		this.offFg = offFg;
		lb = new Label(label);
		lb.setAlignment(Label.CENTER);

		this.add(lb);
		//setState(false);
	}

	/**
	 * This method sets the state of the WarningDisplay to On or Off.
	 * @param isOn TRUE to set the warning display to On, otherwse, to Off.
	 */
	public void setState(boolean isOn, int quantity) {
		if (isOn) {
			lb.setForeground(onFg);
			lb.setBackground(onBg);
                        lb.setText(getText(quantity));
		} else {
			lb.setForeground(offFg);
			lb.setBackground(offBg);
                        lb.setText(getText(quantity));
		}
	}
        
        private String getText(int number){
            if (number>0) {
                return ""+number + " Remaining";
            }else{
                return "Out of Stock  ";
            }
        }
}//End of class WarningDisplay