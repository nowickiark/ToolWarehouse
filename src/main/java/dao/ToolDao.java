package dao;

import entity.Tool;

import java.util.List;

public interface ToolDao {

    List<Tool> getAll();
    Tool getByID(long id);

}
