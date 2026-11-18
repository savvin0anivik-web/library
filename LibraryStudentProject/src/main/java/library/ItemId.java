package library;

// Record автоматически делает equals, hashCode и toString
public record ItemId(int number) {
    public ItemId {
        if (number <= 0) {
            throw new IllegalArgumentException("Номер должен быть больше нуля!");
        }
    }
}
