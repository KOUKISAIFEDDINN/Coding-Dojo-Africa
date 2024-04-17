import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const Search = () => {

    const [info, setinfo] = useState(0);
    const [category, setCategory] = useState("people");
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        navigate("/" + category + "/" + info);
    };
    return (
        <div className="search">
            <form onSubmit={handleSubmit} className="searchForm">
                <div><label>Search for :</label></div>
                <div>

                    <select onChange={(e) => setCategory(e.target.value)}>
                        <option value="people">People</option>
                        <option value="planets">Planets</option>
                    </select>
                </div>
                <div>
                    <label>ID</label>
                    <input onChange={(e) => setinfo(e.target.value)} />
                </div>
                <div>
                    <button >Search</button>
                </div>
            </form>
        </div>
    );
};

export default Search;