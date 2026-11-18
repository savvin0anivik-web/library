package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private final List<LibraryItem> items = new ArrayList<>();

    public void add(LibraryItem item) {
        Objects.requireNonNull(item);
        items.add(item);
    }

    // Возвращаем копию списка, чтобы извне нельзя было сделать library.getAll().clear()
    public List<LibraryItem> getAll() {
        return List.copyOf(items);
    }

    public void giveToReader(ItemId id) throws MyLibraryException {
        for (var item : items) {
            if (item.getId().equals(id)) {
                if (item.getStatus() == Status.TAKEN) {
                    throw new MyLibraryException("Ошибка: '" + item.getName() + "' уже кто-то взял!");
                }
                item.setStatus(Status.TAKEN);
                return;
            }
        }
        throw new MyLibraryException("Не нашли предмет с номером " + id.number());
    }
}
