/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmsTopicReceiver;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author ccorvo
 */
@MessageDriven(mappedName = "jms/NotificationServiceTopic", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "ReceiveAlertNotification"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "ReceiveAlertNotification")
})
public class ReceiveAlertNotification implements MessageListener {
    
    public ReceiveAlertNotification() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        TextMessage textMessage = (TextMessage)message;  //CAst message from base class to Type Text Message
        
        try{
           String messageContents = textMessage.getText();
           System.out.println("CORVO AlertNotification MDB Received message: " + messageContents); 
        }
        catch(JMSException ex){
            
            
        }
        
        
        
        
        
        
        
    }
}
