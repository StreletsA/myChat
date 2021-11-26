import logo from './logo.svg';
import './App.css';
import Message from "./base/Message";
import {useEffect, useState} from "react";
import SendPanel from "./base/SendPanel";
import MessagePanel from "./base/MessagePanel";

function App() {

    return (
        <div>
            <MessagePanel/>
            <SendPanel />
        </div>

    );
}

export default App;
