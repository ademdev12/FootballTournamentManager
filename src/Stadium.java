public class Stadium {
    
    private String name;
    private int capacity;
    private String location;
    private boolean available;

    public Stadium(String name, int capacity, String location) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
        this.available = true;
    }

    public void book() {
        available = false;
    }

    public void unbook() {
        available = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
