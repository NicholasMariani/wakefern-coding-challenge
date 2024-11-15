package wakefern.TaskQueue;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task a, Task b) {
        return Integer.compare(b.priority.ordinal(), a.priority.ordinal());
    }
}
