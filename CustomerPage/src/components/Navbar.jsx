import React from 'react';
import '../App.css'

const Navbar = () => {
  return (
    <div className="navbar top-0 bg-black h-20 p-2 items-center justify-center">
      <div className='flex top-0 w-full bg-gray-900 sticky rounded-full m-2 p-2 items-center'>
        <h3 className="text-white">Master Canteen</h3>
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