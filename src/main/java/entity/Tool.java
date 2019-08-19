package entity;

public class Tool {

    private long id;
    private String name;
    private boolean available;
    private ToolType toolType;

    public Tool(){}

    public Tool(long id, String name, boolean available, ToolType toolType) {
        this.id = id;
        this.name = name;
        this.available = available;
        this.toolType = toolType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public void setToolType(ToolType toolType) {
        this.toolType = toolType;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", toolType=" + toolType +
                '}';
    }
}
