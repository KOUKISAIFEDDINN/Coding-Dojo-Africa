import React, { useState, useEffect } from 'react';
import axios from "axios";
import { useNavigate, useParams } from 'react-router-dom';



function Show() {
    const { id } = useParams();
    const [auther, setAuther] = useState({});

    useEffect(() => {
        axios.get(`http://localhost:8000/api/authers/${id}`)
            .then(res => {
                setAuther(res.data);
            })
            .catch(err => console.error(err));
    }, [id]);

    return (
        <div>
            <p>Name: {auther.name}</p>

        </div>
    );
}

export default Show;
