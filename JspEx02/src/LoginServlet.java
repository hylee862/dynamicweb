

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("04_loginForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id="pinksung";
		String pwd="1234";
		String name="성윤정";
		
		String target = request.getParameter("target");
		
		
		request.setCharacterEncoding("UTF-8");
		if(id.equals(request.getParameter("id")) &&
			pwd.equals(request.getParameter("pwd"))){
//			로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			if(target.isEmpty()) {
				response.sendRedirect("04_main.jsp");
			}else {
				response.sendRedirect(target);
			}
			
		}else{
			request.setAttribute("target", target);	// 타켓 복원	
			request.setAttribute("error", "id 또는 비밀번호가 일치하지 않습니다.");
			doGet(request, response);
		}
	}

}
