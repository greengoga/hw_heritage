package ru.netology.hw_heritage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentTypes() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void simpleContainsQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void EpicContainsQuery() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void MeetingContainsQuery() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();


        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayIfNoSubtasks() {

        Todos todos = new Todos();

        Task[] expected = {};
        Task[] actual = todos.search("abc");
        Assertions.assertArrayEquals(expected, actual);
        }

        @Test
    public void shouldReturnEmptyArrayIfNoMatches() {
            SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

            String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
            Epic epic = new Epic(55, subtasks);

            Meeting meeting = new Meeting(
                    555,
                    "Выкатка 3й версии приложения",
                    "Приложение НетоБанка",
                    "Во вторник после обеда"
            );

            Todos todos = new Todos();

            todos.add(simpleTask);
            todos.add(epic);
            todos.add(meeting);

            Task[] expected = {};
            Task[] actual = todos.search("abc");
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldReturnAllIfMultipleMatches() {
            SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

            Meeting meeting = new Meeting(
                    555,
                    "Выкатка 3й версии приложения",
                    "Позвонить НетоБанка",
                    "Во вторник после обеда"
            );

            Todos todos = new Todos();

            todos.add(simpleTask);
            todos.add(meeting);

            Task[] expected = {simpleTask, meeting};
            Task[] actual = todos.search("Позвонить");
            Assertions.assertArrayEquals(expected, actual);
        }
}