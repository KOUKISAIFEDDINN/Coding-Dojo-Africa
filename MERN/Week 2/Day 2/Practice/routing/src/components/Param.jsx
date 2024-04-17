import React from "react";
import { useParams } from "react-router-dom";

const Param = () => {
    const { element } = useParams();
    return (
        <div>The word is: {element}</div>


    );
};

export default Param;