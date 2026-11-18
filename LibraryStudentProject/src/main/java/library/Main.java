package library;

public class Main {
    public static void main(String[] args) {
        var lib = new Library();

        var b1 = new Book(new ItemId(1), "Гарри Поттер", "Дж. Роулинг");
        var b2 = new Book(new ItemId(2), "Преступление и наказание", "Ф. Достоевский");
        var m1 = new Magazine(new ItemId(3), "Игромания", 12);

        lib.add(b1);
        lib.add(b2);
        lib.add(m1);

        System.out.println("--- Все что есть в библиотеке ---");
        for (var item : lib.getAll()) {
            // Современный switch (Java 21)
            String info = switch (item) {
                case Book b -> "Книга: " + b.getName() + " (" + b.getAuthor() + ")";
                case Magazine m -> "Журнал: " + m.getName() + ", выпуск №" + m.getIssue();
            };
            System.out.println(info + " | Статус: " + item.getStatus().getTitle());
        }

        System.out.println("
--- Считаем штраф за 4 дня просрочки (полиморфизм) ---");
        for (var item : lib.getAll()) {
            System.out.println(item.getName() + " -> штраф " + item.calcPenalty(4) + " руб.");
        }

        System.out.println("
--- Пробуем выдать книги ---");
        try {
            lib.giveToReader(new ItemId(1));
            System.out.println("Успешно выдали: " + b1.getName());

            // Пробуем выдать ту же самую книгу второй раз, чтобы поймать ошибку
            lib.giveToReader(new ItemId(1));
        } catch (MyLibraryException e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }
    }
}
