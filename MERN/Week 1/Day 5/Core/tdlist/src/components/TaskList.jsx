import React from 'react';

const TaskList = ({ tasks, removeTask }) => {
    return (
        <div >
            {tasks.map(task => (
                <div key={task.id} >
                    <span>{task.text}</span>
                    <button onClick={() => removeTask(task.id)}>Delete</button>
                </div>
            ))}
        </div>
    );
};

export default TaskList;
