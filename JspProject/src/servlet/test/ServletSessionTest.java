package servlet.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletSessionTest
 */
@WebServlet("/savesession")
public class ServletSessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSessionTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 생성
		// true: 기존 세션이 있으면 그대로 사용, 없으면 새로 생성
		//HttpSession session = request.getSession();
		request.setCharacterEncoding("ms-949");
		HttpSession session = request.getSession(true);
		
		// 입력한 데이터 읽어서 세션에 저장
		String id = request.getParameter("id");
		String hp = request.getParameter("hp");
		
		session.setAttribute("id", id);
		session.setAttribute("hp", hp);
		
		// forward
		//RequestDispatcher rd = request.getRequestDispatcher("day1104/ex3_result.jsp");
		//rd.forward(request, response);
		
		// redirect
		response.sendRedirect("day1104/ex3_result.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
