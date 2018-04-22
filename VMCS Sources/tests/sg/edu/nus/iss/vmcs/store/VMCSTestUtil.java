/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vmcs.store;

/**
 *
 * @author xusheng
 */
public class VMCSTestUtil {
    public static void setPropertyFileName (){
        String propertyFilename = System.getProperty("propertyFilename");
        if (propertyFilename==null || propertyFilename.isEmpty()) {
            System.setProperty("propertyFilename", "Vmcs.properties");
        }
    }
}
