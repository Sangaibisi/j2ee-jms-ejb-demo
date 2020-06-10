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
                Book theBook =(Book) ((ObjectMessage) message).getObject();
                System.out.println(theBook.getName() +" "+theBook.getAuthor());
                System.out.println("Hello babe");

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}