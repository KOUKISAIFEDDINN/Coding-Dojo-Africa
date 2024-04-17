import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const Infos = () => {
    const { category, id } = useParams();
    const [infos, setInfos] = useState({});
    const nav = useNavigate();
    useEffect(() => {
        axios
            .get(`https://swapi.dev/api/${category}/${id}`)
            .then((res) => {
                setInfos(res.data);
            })
            .catch((err) => {
                nav("*");
            });
    }, [category, id]);
    if (category === "people") {
        return (
            <div className="infoDisplay">
                <h1>{infos.name}</h1>
                Height: {infos.height}
                Mass :{infos.mass}
                Hair Color :{infos.hair_color}
                Skin Color :{infos.skin_color}
            </div>
        );
    } else
        return (
            <div className="infoDisplay">
                <h1>{infos.name}</h1>
                Climate: {infos.climate}
                Terrain: {infos.terrain}
                Surface Water:{infos.surface_water}
                Population:{infos.population}
            </div>
        );
};

export default Infos;