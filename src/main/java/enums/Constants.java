package enums;

public enum Constants {
    INTRO("The global coordination of the DNS Root, IP addressing, and other Internet protocol resources " +
            "is performed as the Internet Assigned Numbers Authority (IANA) functions. Learn more."),
    SITE_TITLE("Internet Assigned Numbers Authority"),
    SITE_URL("https://iana.org"),
    ADD_CONTACT("Add Contact");

    public String value;

    Constants(String value) {
        this.value = value;
    }
}
