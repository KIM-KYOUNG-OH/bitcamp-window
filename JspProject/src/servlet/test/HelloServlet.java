package servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/kakao/my/hello.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// ������ �ѱ� ���ڵ�
		response.setContentType("text/html; charset=UTF-8");
		// �������� ����ϱ����� ���� ����
		PrintWriter out = response.getWriter();
		// �������� Ư�� �±� ����ϱ�
		out.print("<html><head><title>Servlet Test</title></head>");
		out.print("<body>");
		out.print("<h2>Method ���:" +request.getMethod()+ "</h2>");
		out.print("<h2 style='color:red'>Have a Nice Day!!!</h2>");
		out.print("<h2 style='color:green'>���� �׽�Ʈ���Դϴ�!!!</h2>");
		out.print("<img src='../../image/1.JPG'>");
		out.print("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
