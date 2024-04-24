import axios from "axios";
import React, { useEffect, useState } from "react";
import ProductForm from "../components/ProductFrom";
import ProductsList from "../components/ProductsList";

const Main = () => {
    const [products, setProducts] = useState([]);
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios
            .get("http://localhost:8000/api/products")
            .then((res) => {
                setProducts(res.data);
                setLoaded(true);
            })
            .catch((err) => console.log(err));
    }, []);

    return (
        <div>
            <h1 className="text-center">Product Manager</h1>
            <ProductForm />
            <hr />
            <h1 className="text-center">Products List</h1>
            {loaded && <ProductsList products={products} />}
        </div>
    );
};

export default Main;