package wakefern.TaskQueue;

import java.util.ArrayList;
import java.util.List;

public class Task {
    String taskId;
    Priority priority;
    List<String> dependencies;

    public Task(String taskId, Priority priority, List<String> dependencies) {
        this.taskId = taskId;
        this.priority = priority;
        if (dependencies != null) {
            this.dependencies = new ArrayList<>(dependencies);
        } else {
            this.dependencies = new ArrayList<>();
        }
    }
}
