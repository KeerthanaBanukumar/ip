# Node User Guide

Product intro:
        Node is a simple command-line chatbot designed to help users manage tasks efficiently. Users can add, delete, mark, unmark, find, and list tasks. The chatbot supports ToDo, Deadline, and Event tasks, and it stores tasks persistently in a file.

## Features
### Adding tasks
Description: Node supports three types of tasks: ToDo, Deadline, and Event. 
Tasks are stored in a list.


**(a) Adding a ToDo task**
Description: Adds a basic task without any date/time attached to it. First bracket will contain the letter "t"

Command: `todo <task description>`

Example: `todo Buy groceries`
```
Expected output:
Got it. I've added this task:
[T][ ] Buy groceries
Now you have 1 task in the list.
```

**(b) Adding a Deadline task**
Description: Adds a task that need to be done before a specific date/time. First bracket will contain the letter "d"

Command: `deadline <task description> /by <deadline>`

Example: `deadline Submit assignment /by 5/3/2025 1700`
```
Expected output:
    Got it. I've added this task:
    [D][ ] Submit assignment (by: Mar 05 2025, 5:00 pm)
    Now you have 1 tasks in the list.
```

**(c) Adding a Event task**
Description: Adds a task that start at a specific date/time and ends at a specific date/time. First bracket will contain the letter "E"

Command: `event <task description> /from <start time> /to <end time>`

Example: `event Team meeting /from 2pm /to 4pm`
```
Expected output:
    Got it. I've added this task:
    [E] [ ] Team meeting (from: 2pm to: 4pm)
    Now you have 1 tasks in the list.
```

### Listing all tasks
Description: Displays all current tasks with their status (done or not done).

Command: `list`
```
Expected output:
    Here are the tasks in your list:
    1. [T][ ] Buy groceries
    2. [D][ ] Submit assignment (by: Mar 05 2025, 5:00 pm)
    3. [E][ ] Team meeting (from: 2pm to: 4pm)
```

### Marking and unmarking tasks
**(a) Marking tasks as done**
Description: Marks a task as completed by adding "X" in second bracket.

Command: `mark <task number>`

Example: `mark 1`
```
Expected output:
    Nice! I've marked this task as done:
    [T][X] Buy groceries
```

**(b) Unmarking tasks**
Description: Marks a task as uncompleted by removing "X" in second bracket.

Command: `unmark <task number>`

Example: `unmark 1`
```
Expected output:
    OK, I've marked this task as not done yet:
        [T][] Buy groceries
```

### Deleting tasks
Description: Removes a task from the list permanently.

Command: `delete <task number>`

Example: `delete 2`
```
Expected output:
    Noted. I've removed this task:
    [D][X] Submit assignment (by: 2025-03-05)
    Now you have 2 tasks in the list.
```


### Finding tasks
Description: Find a task by searching for a keyword in the task description.

Command: `find <keyword>`

Example: `find groceries`
```
Expected output:
    Here are the matching tasks in your list:
    1. [T][ ] Buy groceries
```

### Exiting yale
Description: Closes the chatbot and exits the program.

Command: `bye`
```
Expected output:
    Bye. Hope to see you again soon!

