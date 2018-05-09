enum Task {
    Task_1, Task_2
}

public class Grade {
    public Grade(Task task, Student student, int valoare) {
        if (task.compareTo(Task.Task_1) == 0)
            student.noteazaProba1(valoare);
        else if (task.compareTo(Task.Task_2) == 0)
            student.noteazaProba2(valoare);
    }
}
