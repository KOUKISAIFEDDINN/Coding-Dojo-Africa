import React, { useEffect, useState } from 'react'
import axios from "axios"
import { useNavigate, Link } from 'react-router-dom'

const List = () => {
    const [authers, setAuthers] = useState([])
    const nav = useNavigate()
    useEffect(() => {
        axios.get("http://localhost:8000/api/authers")
            .then(res => setAuthers(res.data))
            .catch(err => console.error(err))
    }, [])
    const deleteObj = (id) => {
        axios.delete("http://localhost:8000/api/authers/delete/" + id)
            .then(res => setAuthers(authers.filter((c => c._id !== id))))
            .catch(err => console.error(err))
    }
    return (
        <div>
            <h1>Favorite Auther</h1>
            <Link className='btn btn-primary' to={`/new`}>New author</Link>
            <table>
                <tbody>
                    {
                        authers.map(c => (
                            <tr key={c._id}>

                                <td><Link to={`/c/${c._id}`}>{c.name}</Link></td>
                                <td>
                                    <button onClick={() => nav(`/update/${c._id}`)}>Edit</button>
                                    <button onClick={() => deleteObj(c._id)}>Delete</button>
                                </td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    )
}

export default List
