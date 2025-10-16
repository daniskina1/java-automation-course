package addressbook.model;

import java.util.Objects;

public final class GroupDate {
    private final String id;
    private final String name;
    private final String header;
    private final String footer;

    public GroupDate(String name, String header, String footer) {
        this.id = null;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }
    public GroupDate(String id, String name, String header, String footer) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GroupDate groupDate = (GroupDate) o;
        return Objects.equals(id, groupDate.id) && Objects.equals(name, groupDate.name);
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

    public String getId() {
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