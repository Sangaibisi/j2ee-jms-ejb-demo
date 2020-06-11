import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.Serializable;

public class JMSQueueUtility {

    public static void sendMessageToQueue(Serializable queueObject) throws Exception {

        QueueConnectionFactory connectionFactory = null;
        Connection connection = null;
        Queue queue = null;

        try {
            InitialContext initialContext = new InitialContext();
            queue = (Queue) initialContext.lookup("jms/DefaultQueueName");
            connectionFactory = (QueueConnectionFactory) initialContext.lookup("jms/DefaultConnectionFactory");
            connection = connectionFactory.createQueueConnection();

            connection.start();

            QueueSession queueSession = ((QueueConnection) connection).createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueSender queueSender = queueSession.createSender(queue);
            ObjectMessage message = queueSession.createObjectMessage();

            queueSender.setDeliveryMode(DeliveryMode.PERSISTENT);

            message.setJMSType("logMessage");
            message.setLongProperty("time", System.currentTimeMillis());
            message.setObject(queueObject);

            queueSender.send(message);

            queueSession.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }

}
