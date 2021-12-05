import SendPanel from "./base/SendPanel";
import MessagePanel from "./base/MessagePanel";
import Cookies from "universal-cookie";
import LoginPanel from "./base/LoginPanel";
import React from "react";

function App() {

    const cookies = new Cookies();

    let exit = () => {
        cookies.remove("name");
        window.location.reload();
    }

    if(cookies.get("name") == null)
        return (
            <LoginPanel/>
        )
    else
        return (
            <center>
            <div>
                <MessagePanel/>
                <SendPanel />
                <button className="btn btn-danger" onClick={exit}>Выйти</button>
            </div>
            </center>
        );
}

export default App;
