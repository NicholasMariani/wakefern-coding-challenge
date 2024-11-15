1.	Reverse a Singly Linked List
Implement a basic singly linked list, including operations like:
•	Insert: add a node at the beginning, end or specified position.
•	Delete: remove a node from the beginning, end or specified position.
•	Traversal: print all elements in the list. 
•	Search: find the provided value in the list. 

2.	Task Queue
Design and implement a task queue in Java that can handle task scheduling, execution, and errors. 
Requirements:
1.	Task Definition:
o	Each task has a unique identifier (e.g., Task ID).
o	Each task can have a priority level (e.g., high, medium, low).
o	Each task can have dependencies (other tasks that must be completed before this task can be executed).
2.	Process Requirements:
o	The system should be able to distribute tasks across multiple nodes.
o	The system should ensure that tasks are executed in the correct order based on their dependencies and priority.
o	The system should handle node failures gracefully and reassign tasks if a node fails.
o	The system should support adding, updating, and removing tasks dynamically.
3.	Input:
o	A list of tasks with their priorities and dependencies. For example:
Task A: Priority High, Dependencies []
Task B: Priority Medium, Dependencies [A]
Task C: Priority Low, Dependencies [A]
Task D: Priority High, Dependencies [B, C]
4.	Output:
o	A valid execution order of tasks that respects the dependencies and priorities. For the example above, a valid order could be: A -> B -> C -> D.
5.	Required Methods:
o	addTask(String taskId, int priority, List<String> dependencies): Adds a task with its priority and dependencies to the queue.
o	removeTask(String taskId): Removes a task from the queue.
o	updateTask(String taskId, int priority, List<String> dependencies): Updates a task's priority and dependencies.
o	List<String> getExecutionOrder(): Returns a list of task IDs in the order they should be executed.
o	assignTasksToNodes(): Distributes tasks across available nodes.
o	handleNodeFailure(String nodeId): Handles the failure of a node and reassigns its tasks.
6.	Error Handling:
o	Handle cases where tasks have missing dependencies gracefully.
o	Handle node failures and ensure tasks are reassigned correctly.
