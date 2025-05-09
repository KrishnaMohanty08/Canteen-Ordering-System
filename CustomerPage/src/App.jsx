import { useState } from 'react'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Navbar/>
      Main Page
      <Footer/>
    </>
  )
}

export default App
