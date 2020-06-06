
import java.io.ObjectOutputStream;

import java.net.HttpURLConnection;
import java.net.URL;

import java.sql.Timestamp;

import javax.ejb.MessageDriven;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(mappedName = "jms/DefaultQueueName")
public class DefaultEJBBean implements MessageListener {

    public DefaultEJBBean() {
        System.out.println("ProcessBulkSaleEJBBean initialized....");
    }

    public void onMessage(Message message) {
            ObjectMessage objectMessage = null;
            try {
                objectMessage = (ObjectMessage) message;
                System.out.println(objectMessage.getStringProperty("name"));
                System.out.println("Hello babe");

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}