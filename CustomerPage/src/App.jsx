import { useState } from 'react'
import Navbar from './components/Navbar'
import Main from './components/Main'

import './App.css'

function App() {


  return (
    <>
      <div class="absolute mt-20  inset-0 -z-10 h-full w-full bg-white bg-[linear-gradient(to_right,#f0f0f0_1px,transparent_1px),linear-gradient(to_bottom,#f0f0f0_1px,transparent_1px)] bg-[size:6rem_4rem]"><div class="absolute bottom-0 left-0 right-0 top-0 bg-[radial-gradient(circle_800px_at_100%_200px,#d5c5ff,transparent)]"></div></div>
      <Navbar />
      <Main />
      <div className="absolute bottom-0 flex w-full justify-center bg-black h-10 ">
        <div className="px-2 py-1 ">
          <h3 className="text-white ">© {new Date().getFullYear ()} All rights reserved</h3>
        </div>
      </div>
    </>
  )
}

export default App
