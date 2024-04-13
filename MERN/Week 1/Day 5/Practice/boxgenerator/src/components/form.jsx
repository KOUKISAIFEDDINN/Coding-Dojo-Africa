import React, { useState } from "react";
const ColorForm = (props) => {
    const [color, setColor] = useState("");
    const handleSubmit = (e) => { e.preventDefault(); props.addColor(color); setColor(""); };
    return (
        <div>
            <form onSubmit={handleSubmit} >
                <label htmlFor="color">tap your fav color</label>
                <input type="text" onChange={(e) => setColor(e.target.value)} value={color} />
                <button type="submit" >+</button>
            </form>
        </div>
    );
};

export default ColorForm;