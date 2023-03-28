package ru.netology.tasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void findIfMatchSimpleTask() {
        Task simpleTask = new SimpleTask(1, "Подготовить презу");
        String query = "презу";

        boolean expected = true;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notFindIfMismatchSimpleTask() {
        Task simpleTask = new SimpleTask(2, "Назначить встречу");
        String query = "презу";

        boolean expected = false;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findIfMatchEpic() {
        String[] subtasks = { "Планирование" , "Запуск" , "Тест" , "Обратная связь"};
        Task epic = new Epic(3, subtasks);
        String query = "Тест";

        boolean expected = true;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notFindIfMismatchEpic() {
        String[] subtasks = { "Планирование" , "Запуск" , "Тест" , "Обратная связь"};
        Task epic = new Epic(4, subtasks);
        String query = "Ревью";

        boolean expected = false;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public  void findIfMatchTopicMeeting() {
        Task meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "Выкатка";

        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public  void findIfMatchProjectMeeting() {
        Task meeting = new Meeting(
                6,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "НетоБанк";

        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public  void notFindIfMismatchMeeting() {
        Task meeting = new Meeting(
                7,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "Планирование";

        boolean expected = false;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }
}
