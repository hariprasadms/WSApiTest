package pojo;

// This is the pojo class for Capabilities endpoint attributes
public class Capabilities {
    @Override
    public String toString() {
        return "Capabilities{" +
                "capabilityname='" + capabilityname + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getCapabilityname() {
        return capabilityname;
    }

    public void setCapabilityname(String capabilityname) {
        this.capabilityname = capabilityname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  String capabilityname;
    public  String  id;
}
