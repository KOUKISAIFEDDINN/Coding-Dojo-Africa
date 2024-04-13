import React, { useState } from 'react';

const TaskForm = ({ addTask }) => {
    const [newTaskText, setNewTask] = useState('');

    const handleAddTask = () => {
        if (newTaskText.trim() !== '') {
            const newTask = { id: Date.now(), text: newTaskText, };
            addTask(newTask); setNewTask('');
        }
    };
    return (
        <div >
            <input value={newTaskText} onChange={(e) => setNewTask(e.target.value)} />
            <button onClick={handleAddTask}>Add</button>
        </div>
    );
};

export default TaskForm;
