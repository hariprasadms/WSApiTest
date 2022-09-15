package pojo;

// This is the pojo class for Teams endpoint attributes
public class Teams {

    public String teamname;
    public String teamcapability;
    public String teamsize;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String id;

    @Override
    public String toString() {
        return "Teams{" +
                "teamname='" + teamname + '\'' +
                ", teamcapability='" + teamcapability + '\'' +
                ", teamsize='" + teamsize + '\'' +
                '}';
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getTeamcapability() {
        return teamcapability;
    }

    public void setTeamcapability(String teamcapability) {
        this.teamcapability = teamcapability;
    }

    public String getTeamsize() {
        return teamsize;
    }

    public void setTeamsize(String teamsize) {
        this.teamsize = teamsize;
    }
}
