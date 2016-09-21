

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IWorkWithJSPServlet
 */
@WebServlet("/helloServletNew")
public class IWorkWithJSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IWorkWithJSPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String counter = (String)request.getSession().getAttribute("counter");
		if (counter == null) {
			counter = "1";
		} else {
			int c = Integer.parseInt(counter);
			counter = String.valueOf(c + 1);
		}
		request.getSession().setAttribute("counter", counter);
		if (name != null) {
			String greeting = "Hello " + name + "!" 
					+ "\nYou visited " + counter + " time(s)!!";
			request.setAttribute("personalizedGreeting", greeting);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/NewGreetingsJSP.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
