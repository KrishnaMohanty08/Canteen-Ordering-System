import React from 'react';
import 'K:/GitHub/Canteen-Ordering-System/CustomerPage/src/App.css'

const Navbar = () => {
  return (
    <div className="navbar top-0 bg-black h-20 p-2 items-center justify-center">
      <div className='flex bg-gray-900 sticky rounded-full p-3 items-center'>
        <h2 className="text-white">Master Canteen</h2>
        <a
          className="ml-auto"
          href="https://github.com/KrishnaMohanty08/Canteen-Ordering-System"
        >
          <lord-icon
            src="https://cdn.lordicon.com/jjxzcivr.json"
            trigger="hover"
          ></lord-icon>
        </a>
      </div>

    </div>
  );
};

export default Navbar;