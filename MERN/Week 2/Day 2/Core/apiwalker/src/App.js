import { Route, Routes } from 'react-router-dom';
import Search from './components/Search';
import Infos from './components/Infos';
import "./App.css";

function App() {
  return (
    <div className="App container">
      <Search />
      <Routes>

        <Route path="/:category/:id" element={<Infos />} />
        <Route path="*" element={<div className='text-center'></div>} />
      </Routes>
    </div>
  );
}
export default App;