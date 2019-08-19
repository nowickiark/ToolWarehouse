package controller;

import entity.Tool;
import service.ToolService;
import service.ToolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ToolsServlet",value = "/")
public class ToolsController extends HttpServlet {

    ToolService toolService = new ToolServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Tool> tools = toolService.getAllTools();

        req.setAttribute("tools",tools);

        getServletContext().getRequestDispatcher("/tools.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        long id = Long.parseLong(req.getParameter("id"));



            switch (action) {
                case "take":
                    toolService.setAvibility(id, false);
                    break;
                case "return":
                    toolService.setAvibility(id, true);
                    break;
            }

            List<Tool> tools = toolService.getAllTools();

            req.setAttribute("tools", tools);

            getServletContext().getRequestDispatcher("/tools.jsp").forward(req, resp);


    }

}
