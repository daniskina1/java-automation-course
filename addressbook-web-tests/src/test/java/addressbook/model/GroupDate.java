package addressbook.model;

import java.util.Objects;

public final class GroupDate {

    private int id = Integer.MAX_VALUE;
    private String name;
    private String header;
    private String footer;

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

    @Override
    public String toString() {
        return "GroupDate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
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
    public GroupDate withId(int id) {
        this.id = id;
        return this;
    }

    public GroupDate withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public GroupDate withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupDate withName(String name) {
        this.name = name;
        return this;
    }

}