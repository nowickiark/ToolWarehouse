package controller;

import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserSerlvet", value = "/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* super.doGet(req,resp);*/

        String action = req.getParameter("action");

        switch (action) {
            case "login":
                logIn(req, resp);
                break;
            case "logout":
                logout(req, resp);
                break;
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }


    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect(getServletContext().getContextPath() + "/login");
    }

    private void logIn(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        UserService userService = new UserServiceImpl();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        userService.checkIfValid(login, password);

        if (userService.checkIfValid(login, password)) {
            req.getSession().setAttribute("login", login);

            resp.sendRedirect(getServletContext().getContextPath() + "/");

        } else {
            req.setAttribute("loginInvalid", true);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}

