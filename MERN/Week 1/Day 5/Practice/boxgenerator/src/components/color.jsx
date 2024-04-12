import React, { useState } from "react";
const ColorForm = (props) => {
    const [color, setColor] = useState("#ffffff");
    const handleSubmit = (e) => { e.preventDefault(); props.addColor(color); setColor("#ffffff"); };
    return (
        <div>
            <form onSubmit={handleSubmit} >
                <label htmlFor="color">chose yor colore here</label>
                <input type="color" onChange={(e) => setColor(e.target.value)} value={color} />
                <button type="submit" >+</button>
            </form>
        </div>
    );
};

export default ColorForm;