import React, { useState, useEffect } from 'react';

const Main = () => {
  const [items, setItems] = useState([]);
  const [quant, setQuant] = useState({});

  useEffect(() => {
    const fetchItem = async () => {
      try {
        const res = await fetch('/sql.json');
        const data = await res.json();
        setItems(data);

        const initialQuantities = data.reduce((acc, item) => {
          acc[item.prod_id] = 0;
          return acc;
        }, {});
        setQuant(initialQuantities);
      } catch (err) {
        console.log(err.message);
      }
    };

    fetchItem();
  }, []);

  const incrementer = (prod_id, quantity) => {
    setQuant((prev) => {
      const currentQuant = prev[prod_id] || 0;
      if (currentQuant < quantity) {
        return { ...prev, [prod_id]: currentQuant + 1 };
      } else {
        alert("Max quantity reached");
        return prev;
      }
    });
  };

  const decrementer = (prod_id) => {
    setQuant((prev) => {
      const currentQuant = prev[prod_id] || 0;
      if (currentQuant > 0) {
        return { ...prev, [prod_id]: currentQuant - 1 };
      }
      return prev;
    });
  };

  return (
    <>
      <div className="m-3 flex flex-col gap-2">
        {items.map((prod) => {
          return (
            <div key={prod.prod_id} className="card card-body border border-t-xl border-black my-2 w-80">
              <h5 className="card-title">Item Name: {prod.item_name}</h5>
              <p className="p-0 font-semibold text-lg">Cost: {prod.cost}</p>
              <p className="p-0 font-semibold text-lg">Total Quantity: {prod.quantity}</p>
              <div className="border w-fit flex">
                <button
                  onClick={() => decrementer(prod.prod_id)}
                  type="button"
                  className="btn btn-danger"
                >
                  -
                </button>
                <span className="text-xl px-2 items-center">{quant[prod.prod_id] || 0}</span>
                <button
                  onClick={() => incrementer(prod.prod_id, prod.quantity)}
                  type="button"
                  className="btn btn-success"
                >
                  +
                </button>
              </div>
            </div>
          );
        })}
      </div>
    </>
  );
};

export default Main;