import {useEffect, useState} from "react";
import Message from "./Message";

export default function MessagePanel() {

    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);

    let getMessages = () => {
        fetch("http://localhost:80/api/messages/")
            .then(result => result.json().then( data => {
                setItems(Object.values(data).map(function(val) {
                    var ans = <Message date={val.date} sender={val.sender} content={val.content}/>;
                    return ans;
                }));
                setIsLoaded(true);
            }));
    }

    useEffect(() => {
        getMessages();
        setInterval(() => {
            setIsLoaded(false);
            getMessages();
        }, 1000);
    }, []);

    if (error)
        return <p>Error {error.message}</p>
    else
        return (
            <div>
                <table>
                    {items}
                </table>
            </div>
        );
}