package servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/shop/read")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("Get");
		//������ �б�
		String fruit = request.getParameter("fruit");
		out.print("<html><body>");
		out.print("<h2>���� �����ϴ� ������ "+fruit+"�Դϴ�</h2>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("Post");
		request.setCharacterEncoding("UTF-8");
		String message = request.getParameter("message");
		out.print("<html><body>");
		out.print("<h2>�޼���: "+message+"�Դϴ�</h2>");
		out.print("</body></html>");
		
	}

}
