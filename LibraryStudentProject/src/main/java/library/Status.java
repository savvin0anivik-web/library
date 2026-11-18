package library;

public enum Status {
    FREE("Свободна"),
    TAKEN("На руках у читателя");

    private final String title;

    Status(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
