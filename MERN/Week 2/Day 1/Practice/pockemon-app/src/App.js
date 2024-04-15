import { useState } from 'react';
import './App.css';

function App() {
  const [Pokemons, setPokemons] = useState([])

  // Vanilla Javascript
  const FetchPokemons = () => {
    fetch("https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0")
      .then(response => {
        return response.json()
        //do something
      }).then((JsonResponse) => {
        console.log(JsonResponse)
        setPokemons(JsonResponse.results)
      })
      .catch(err => {
        console.log(err);
      })
  }
  return (
    <div className="App">
      <button onClick={FetchPokemons}>Fetch Pokemons</button>
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