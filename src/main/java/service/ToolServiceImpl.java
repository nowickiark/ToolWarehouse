package service;

import dao.ToolDao;
import dao.ToolDaoImpl;
import entity.Tool;

import java.util.List;

public class ToolServiceImpl implements ToolService {

    private ToolDao toolDao;

    public ToolServiceImpl(){
        toolDao = new ToolDaoImpl();
    }


    @Override
    public List<Tool> getAllTools() {
        return toolDao.getAll();
    }

    @Override
    public Tool getByID(long id) {
        return toolDao.getByID(id);
    }

    @Override
    public void setAvibility(long id ,boolean isAvailable) {
       toolDao.getByID(id).setAvailable(isAvailable);
    }
}
