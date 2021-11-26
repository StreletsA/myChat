import React, { useState, useEffect, Component } from 'react';

export default function SendPanel()
{

    const [value, setValue] = useState("");
    const [sender, setSender] = useState("Andrew");

    let handleChange = (event) => {
        setValue(event.target.value);
    }

    let handleSubmit = (event) => {
        alert('Отправленное сообщение: ' + value);
        event.preventDefault();

        const params = {
            sender: sender,
            content: value
        };
        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify( params )
        };
        fetch( 'http://localhost:80/api/messages', options )
            .then( response => response.json() )
            .then( response => {
                // Update
            } );
    }

    return(
        <form onSubmit={handleSubmit}>
            <label>
                <input type="text" value={value} onChange={handleChange} />
            </label>
            <input type="submit" value="Отправить" />
        </form>
    )
}