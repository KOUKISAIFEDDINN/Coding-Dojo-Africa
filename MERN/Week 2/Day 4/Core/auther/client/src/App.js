import './App.css';
import { Route, Routes } from 'react-router-dom';
import List from './components/List';
import Create from './components/Creates';
import Edit from './components/Edit';
import Show from './components/Show';
import './assets/css/bootstrap.min.css'
function App() {
  return (
    <div className="container">
      <Routes>
        <Route path='/' element={<List />} />
        <Route path='/new' element={<Create />} />
        <Route path='/update/:id' element={<Edit />} />
        <Route path='/c/:id' element={<Show />} />


      </Routes>
    </div>
  );
}

export default App;
