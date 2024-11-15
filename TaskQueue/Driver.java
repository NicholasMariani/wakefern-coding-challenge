package wakefern.TaskQueue;

import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
        TaskQueue queue = new TaskQueue();

        queue.addTask("A", Priority.HIGH, Arrays.asList());
        queue.addTask("B", Priority.MED, Arrays.asList("A"));
        queue.addTask("C", Priority.LOW, Arrays.asList("A"));
        queue.addTask("D", Priority.HIGH, Arrays.asList("B", "C"));

        System.out.println("Execution Order: " + queue.getExecutionOrder());

        queue.assignTasksToNodes();
        queue.printTaskAssignments();

        queue.handleNodeFailure("Node1");
        System.out.println("After Node1 Failure:");
        queue.printTaskAssignments();
    }
}