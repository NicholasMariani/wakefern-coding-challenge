package wakefern.TaskQueue;

import java.util.*;

public class TaskQueue {
    private final Map<String, Task> taskMap = new HashMap<>();
    private final Map<String, List<String>> dependencies = new HashMap<>();
    private final List<String> nodes = Arrays.asList("Node1", "Node2", "Node3"); 
    private final Map<String, String> taskNodeMap = new HashMap<>(); 

    public void addTask(String taskId, Priority priority, List<String> dependencies) {
        Task task = new Task(taskId, priority, dependencies);
        taskMap.put(taskId, task);

        this.dependencies.putIfAbsent(taskId, new ArrayList<>());
        if (dependencies != null) {
            for (String dep : dependencies) {
                this.dependencies.putIfAbsent(dep, new ArrayList<>());
                this.dependencies.get(dep).add(taskId);
            }
        }
    }

    public void removeTask(String taskId) {
        taskMap.remove(taskId);
        dependencies.remove(taskId);

        for (List<String> dependents : dependencies.values()) {
            dependents.remove(taskId);
        }
    }

    public void updateTask(String taskId, Priority priority, List<String> dependencies) {
        removeTask(taskId);
        addTask(taskId, priority, dependencies);
    }

    public List<String> getExecutionOrder() {
        Set<String> completedTasks = new HashSet<>();
        List<String> executionOrder = new ArrayList<>();

        while (executionOrder.size() < taskMap.size()) {
            List<Task> readyTasks = new ArrayList<>();
            for (Task task : taskMap.values()) {
                if (!completedTasks.contains(task.taskId) 
                        && allDependenciesCompleted(task.taskId, completedTasks)) {
                    readyTasks.add(task);
                }
            }

            readyTasks.sort(new TaskComparator());

            if (!readyTasks.isEmpty()) {
                Task nextTask = readyTasks.get(0);
                executionOrder.add(nextTask.taskId);
                completedTasks.add(nextTask.taskId);
            } else {
                return new ArrayList<>();
            }
        }

        return executionOrder;
    }

    private boolean allDependenciesCompleted(String taskId, Set<String> completedTasks) {
        Task task = taskMap.get(taskId);
        if (task == null) return false;

        for (String dependency : task.dependencies) {
            if (!completedTasks.contains(dependency)) {
                return false;
            }
        }
        return true;
    }

    public void assignTasksToNodes() {
        List<String> executionOrder = getExecutionOrder();
        int i = 0;

        for (String taskId : executionOrder) {
            String node = nodes.get(i % nodes.size());
            taskNodeMap.put(taskId, node);
            i++;
        }
    }

    public void handleNodeFailure(String nodeId) {
        List<String> tasksToReassign = new ArrayList<>();
        for (Map.Entry<String, String> entry : taskNodeMap.entrySet()) {
            if (entry.getValue().equals(nodeId)) {
                tasksToReassign.add(entry.getKey());
            }
        }

        int i = 0;
        for (String taskId : tasksToReassign) {
            String newNode = nodes.get(i % nodes.size());
            taskNodeMap.put(taskId, newNode);
            i++;
        }
    }

    public void printTaskAssignments() {
        System.out.println("Task Assignments:");
        for (Map.Entry<String, String> entry : taskNodeMap.entrySet()) {
            System.out.println("Task " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}