import { useState } from 'react';
import './App.css';
import axios from "axios"

function App() {
  const [Pokemons, setPokemons] = useState([])

  const AxiosHeroes = () => {
    axios.get("https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0")
      .then((res) => {
        console.log(res.data)
        setPokemons(res.data.results)
      }).catch((err) => {
        console.log(err)
      })
  }
  return (
    <div className="App">
      <button onClick={AxiosHeroes}>Axios SupperHeroes</button>
      <hr />
      {
        Pokemons.map((pokemons) => {
          return (
            <p>{pokemons.name}</p>
          )
        })
      }
    </div>
  );
}
export default App;