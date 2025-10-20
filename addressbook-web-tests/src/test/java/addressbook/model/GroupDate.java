package addressbook.model;

import java.util.Objects;

public final class GroupDate {
    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private final String name;
    private final String header;
    private final String footer;

    public GroupDate(String name, String header, String footer) {
        this.id = 0;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public GroupDate(int id, String name, String header, String footer) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    @Override
    public String toString() {
        return "GroupDate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GroupDate groupDate = (GroupDate) o;
        return id == groupDate.id && Objects.equals(name, groupDate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public String name() {
        return name;
    }

    public String header() {
        return header;
    }

    public String footer() {
        return footer;
    }

}