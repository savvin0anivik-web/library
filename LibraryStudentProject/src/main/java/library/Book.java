package library;

import java.util.Objects;

public final class Book implements LibraryItem {
    private final ItemId id;
    private final String name;
    private final String author;
    private Status status;

    public Book(ItemId id, String name, String author) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.author = Objects.requireNonNull(author);
        this.status = Status.FREE;
    }

    public String getAuthor() {
        return author;
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
        return days * 20; // за книгу штраф 20 руб в день
    }
}
