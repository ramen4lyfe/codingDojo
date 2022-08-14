import React, {useState, useEffect} from 'react';
import PokemonList from './PokemonList';
import Pagination from './Pagination';
import axios from 'axios';

function App() {
  const [pokemon, setPokemon] = useState([])
  const [currentPageUrl, setCurrentPageUrl] = useState("https://pokeapi.co/api/v2/pokemon")
  const [nextPageUrl, setNextPageURL] = useState("https://pokeapi.co/api/v2/pokemon/?offset=20&limit=20")
  const [prevPageUrl, setPrevPageURL] = useState("https://pokeapi.co/api/v2/pokemon")
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    setLoading(true)
    let cancel
    axios.get(currentPageUrl, {
      cancelToken: new axios.CancelToken (c => cancel = c)
    }).then(res => {
      setLoading(false)
      setNextPageURL(res.data.next)
      setPrevPageURL(res.data.previous)
      setPokemon(res.data.results.map(p => p.name))
    })

    return () => cancel()
  }, [currentPageUrl])

  function gotoNextPage() {
    setCurrentPageUrl (nextPageUrl)
  }

  function gotoPrevPage() {
    setCurrentPageUrl (prevPageUrl)
  }

  if(loading) return "Loading..."

  return (
    <>
    <PokemonList pokemon = {pokemon} />
    <Pagination
      gotoPrevPage={prevPageUrl ? gotoPrevPage : null}
      gotoNextPage={nextPageUrl ? gotoNextPage : null}
      />
    </>
  );
}

export default App;
