import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "GreetingServlet",
        description = "Example Servlet Using Annotations",
        urlPatterns = {"/GreetingServlet"}
)
public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book b1 = new Book();
        b1.setAuthor("Emrullah");
        b1.setName("JMS Example");

        try {
            JMSQueueUtility.sendMessageToQueue(b1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
