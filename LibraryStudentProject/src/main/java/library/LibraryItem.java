package library;

// Закрытый интерфейс (sealed) — разрешаем наследоваться только Book и Magazine
public sealed interface LibraryItem permits Book, Magazine {
    ItemId getId();
    String getName();
    Status getStatus();
    void setStatus(Status status);

    // Полиморфный метод подсчета штрафа за просрочку
    int calcPenalty(int days);
}
