import { useState } from "react";
import ColorForm from "./components/color";
import Color from "./components/colordisplay";
function App() {
  const [colors, setColors] = useState([])
  const addColor = (newColor) => { setColors([...colors, newColor]); };
  return (
    <div >
      <ColorForm addColor={addColor} />
      {colors.map((color, i) => {
        return <Color key={i} boxColor={color} />
      })}
    </div>);
}
export default App;