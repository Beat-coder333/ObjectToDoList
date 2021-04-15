package it.object.toDo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.object.toDo.model.TaskObj;

@WebServlet("/todo_list")
public class ToDoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	List<TaskObj> listTasksNew = new ArrayList<TaskObj>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String taskReq = req.getParameter("insertTask");
		session.setAttribute("listTodo", listTasksNew);
		
		List<TaskObj> listTasks = (List<TaskObj>) session.getAttribute("listTodo");
		TaskObj newTask = null;

		if (listTasks != null) {

			newTask = new TaskObj();
			newTask.setName(taskReq);
			newTask.setId(0);
			listTasks.add(newTask);
			if (listTasks != null) {
				for (int i =0; i < listTasks.size(); i++) {
					listTasks.get(i).setId(i);

				}

			}
			session.setAttribute("listTodo", listTasks);
			req.getRequestDispatcher("pages/toDoList.jsp").forward(req, resp);
			
			
		} else {
			
			
			req.getRequestDispatcher("pages/toDoList.jsp").forward(req, resp);
			
		
		}

	}

}
