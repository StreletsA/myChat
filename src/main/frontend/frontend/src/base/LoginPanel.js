import React, {useState} from "react";
import Cookies from 'universal-cookie';

export default function LoginPanel() {

    const [value, setValue] = useState("");
    const cookies = new Cookies();

    let handleChange = (event) => {
        setValue(event.target.value);
    }

    let handleSubmit = (event) => {
        event.preventDefault();
        alert(value);
        cookies.set("name", value);
        window.location.reload();
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <label>
                    Ваше имя:
                    <input type="text" onChange={handleChange}/>
                </label>
                <input type="submit" value="Отправить" />
            </form>
        </div>
    );
}