package dao;

import entity.Tool;

import java.util.ArrayList;
import java.util.List;

import static entity.ToolType.*;

public class ToolDaoImpl implements ToolDao {

    private List<Tool> tools = new ArrayList<>();


    public ToolDaoImpl(){
        tools.add(new Tool(1,"HammerA",true,HAMMER));
        tools.add(new Tool(2,"ScrawA",true,SCREWDRIVER));
        tools.add(new Tool(3,"HammerB",false,HAMMER));
        tools.add(new Tool(4,"Car",true,OTHER));
    }


    @Override
    public List<Tool> getAll() {
        return tools;
    }

    @Override
    public Tool getByID(long id) {

        return tools.stream().filter(a -> a.getId() == id).findFirst().get();
    }
}
