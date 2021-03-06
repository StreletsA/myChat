import React, { useState} from 'react';
import Cookies from "universal-cookie";
import {Button} from "bootstrap/dist/css/bootstrap.min.css";

export default function SendPanel()
{
    const [value, setValue] = useState("");
    const sender = new Cookies().get("name");

    let getDate = () => {
        var now = new Date(Date.now());
        var hours = now.getHours().toString();
        var minutes = now.getMinutes().toString();
        var day = now.getDate().toString();
        var month = (now.getMonth()+1).toString();
        var year = now.getFullYear().toString();

        var ans = day + '.' +
            month + '.' +
            year + ' ' +
            hours + ':' +
            minutes;

        return ans;
    }

    let handleChange = (event) => {
        setValue(event.target.value);
    }

    let handleSubmit = (event) => {
        event.preventDefault();
        const params = {
            date: getDate(),
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
            .then( response => response.json() );
    }

    return(
        <div>
        <form onSubmit={handleSubmit}>
            <label>
                <input onChange={handleChange} type="text" className="form-control" placeholder="Введите сообщение"/>
            </label>
            <button class="btn btn-primary" type="submit">Отправить</button>
        </form>

        </div>
    )
}