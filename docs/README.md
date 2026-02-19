# Lala User Guide

Lala is a simple command-line task manager that helps you track todos, deadlines,
and events. This guide lists the supported commands and their formats.

## Add a todo

Adds a todo task to the list.

Example: `todo read book`

## Add a deadline

Adds a deadline task with a due date and time.

Format: `deadline <task description> /by <DD-MM-YYYY HH:MM>`

Example: `deadline submit report /by 12-03-2026 23:59`

## Add an event

Adds an event task with a start and end date/time.

Format: `event <task description> /from <DD-MM-YYYY HH:MM> /to <DD-MM-YYYY HH:MM>`

Example: `event project meeting /from 15-03-2026 14:00 /to 15-03-2026 16:00`

## Mark or unmark a task

Marks a task as done or marks it as not done.

Format: `mark <task number>` or `unmark <task number>`

Example: `mark 2`

## List tasks

Displays all tasks currently on hand.

Example: `list`

## Find tasks by keyword

Displays all tasks that contain the given keyword.

Format: `find <keyword>`

Example: `find report`

## Tag or remove a tag

Adds or removes a tag on a task.

Format: `tag <task number> <tag>` or `tag <task number> remove`

Example: `tag 3 urgent`

## Delete a task

Deletes a task by its number in the list.

Format: `delete <task number>`

Example: `delete 4`

## Exit

Closes the chatbot and exits the GUI.

Example: `bye`
