package addressbook.model;

import java.util.Objects;

public final class ContactDate {
    private final String firstname;
    private final String middlename;
    private final String mobile;
    private final String email;
    private final String group;

    public ContactDate(String firstname, String middlename, String mobile, String email, String group) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }

    public String firstname() {
        return firstname;
    }

    public String middlename() {
        return middlename;
    }

    public String mobile() {
        return mobile;
    }

    public String email() {
        return email;
    }

    public String group() {
        return group;
    }


    @Override
    public String toString() {
        return "ContactDate[" +
                "firstname=" + firstname + ", " +
                "middlename=" + middlename + ", " +
                "mobile=" + mobile + ", " +
                "email=" + email + ", " +
                "group=" + group + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContactDate that = (ContactDate) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(middlename, that.middlename) && Objects.equals(mobile, that.mobile) && Objects.equals(email, that.email) && Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, middlename, mobile, email, group);
    }
}