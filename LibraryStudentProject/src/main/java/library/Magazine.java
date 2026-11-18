package library;

import java.util.Objects;

public final class Magazine implements LibraryItem {
    private final ItemId id;
    private final String name;
    private final int issue;
    private Status status;

    public Magazine(ItemId id, String name, int issue) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.issue = issue;
        this.status = Status.FREE;
    }

    public int getIssue() {
        return issue;
    }

    @Override
    public ItemId getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = Objects.requireNonNull(status);
    }

    @Override
    public int calcPenalty(int days) {
        return days * 10; // за журнал штраф 10 руб в день
    }
}
