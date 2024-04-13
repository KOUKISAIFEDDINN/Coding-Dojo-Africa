import './App.css';
import Tabs from './components/tabel';
import Content from './components/tabel-display';
import { useState } from 'react';

function App() {
  const [content, setContent] = useState(1)
  return (
    <div >
      <Tabs tabsNumber={3} tabContent={setContent} />
      <Content content={content} />
    </div>
  );
}

export default App;
