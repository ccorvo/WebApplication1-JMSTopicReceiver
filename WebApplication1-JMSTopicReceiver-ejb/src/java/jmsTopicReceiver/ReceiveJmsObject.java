/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmsTopicReceiver;

import CommonJmsMessages.NotificationMessage;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author ccorvo
 */
@MessageDriven(mappedName = "jms/NotificationObjectTopic", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "ReceiveJmsObject"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "ReceiveJmsObject")
})
public class ReceiveJmsObject implements MessageListener {
    
    public ReceiveJmsObject() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        ObjectMessage objectMsg = (ObjectMessage) message;  //Cast to access object type
        
        try{
        NotificationMessage receivedMsg =   (NotificationMessage) objectMsg.getObject();
            System.out.println("CORVO: onMessage of ReceiveJMSObject MDB");
            
            System.out.println("Notification Type: " + receivedMsg.getType());
            System.out.println("Notification Description: "+ receivedMsg.getDescription());
            System.out.println("Notification Date: " + receivedMsg.getDate());
            
            
        }
        catch (Exception ex)
        {
            System.out.println("Corvo: Caught Exception in ReceiveJMSObject");
        }
    }
}
