import { Routes, Route } from "react-router-dom";
import "./App.css";
import Homepage from "./components/Home";
import Param from "./components/Param";
import WordColor from "./components/WordColor";

function App() {
    return (
        <div className="App">
            <Routes>
                <Route path="/home" element={<Homepage />} />
                <Route path="/:element" element={<Param />} />
                <Route
                    path="/:word/:txtColor/:bgColor"
                    element={<WordColor />}
                />
            </Routes>
        </div>
    );
}

export default App;
