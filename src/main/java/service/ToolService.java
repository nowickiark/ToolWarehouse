package service;

import entity.Tool;

import java.util.List;

public interface ToolService {

    List<Tool> getAllTools();

    Tool getByID(long id);

    void setAvibility(long id,boolean isAvailable);

}
