package addressbook.model;

import java.util.Objects;

public final class ContactDate {
    private int id;
    private  String firstname;
    private  String lastname;
    private  String mobilePhone;
    private String homePhone;
    private String workPhone;
    private  String email;
    private String email2;
    private String email3;
    private  String group;
    private String allPhones;
    private String allEmails;
    private String allAddress;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContactDate that = (ContactDate) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    @Override
    public String toString() {
        return "ContactDate{" +
                "id=" + id +
                " firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mobile='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public ContactDate withId(int id) {
        this.id = id;
        return this;
    }

    public ContactDate withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactDate withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactDate withMobile(String mobile) {
        this.mobilePhone = mobile;
        return this;
    }

    public ContactDate withEmail(String email) {
        this.email = email;

        return this;
    }

    public ContactDate withGroup(String group) {
        this.group = group;
        return this;
    }



    public ContactDate withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactDate withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactDate withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactDate withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactDate withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactDate withAllAddress(String allAddress) {
        this.allAddress = allAddress;
        return this;
    }

    public ContactDate withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactDate withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String firstname() {
        return firstname;
    }

    public String lastname() {
        return lastname;
    }

    public String mobilePhone() {
        return mobilePhone;
    }

    public String email() {
        return email;
    }

    public String group() {
        return group;
    }

    public String getAllAddress() {
        return allAddress;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getEmail3() {
        return email3;
    }

    public String getEmail2() {
        return email2;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}