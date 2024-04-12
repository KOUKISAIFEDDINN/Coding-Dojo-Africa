import './App.css';
import Tabs from './components/tabel';
import Content from './components/tabel-display';
import { useState } from 'react';

function App() {
  const [content, setContent] = useState(1)
  const getTabContent = (value) => {
    setContent(value);
  }
  return (
    <div className="App">
      <Tabs tabsNumber={8} tabContent={v => getTabContent(v)} />
      <Content content={content} />
    </div>
  );
}

export default App;