package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Student;
import implement.StudentImp;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.getRequestDispatcher("views/create.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg_success, msg_err;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		StudentImp imp = new StudentImp();
		boolean check_insert = imp.addNew(new Student(0, name, address, email, phone, status));

		if (check_insert == true) {
			msg_success = "Thêm mới thành công!!";
			request.setAttribute("success", msg_success);
		} else {
			msg_err = "Thêm mới thất bại!!";
			request.setAttribute("err", msg_err);
		}
		request.getRequestDispatcher("views/create.jsp").forward(request, response);
	}

}
