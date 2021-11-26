import logo from './logo.svg';
import './App.css';
import Message from "./base/Message";
import {useEffect, useState} from "react";

function App() {

  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [items, setItems] = useState([]);

  let getMessages = () => {
    fetch("http://localhost:80/api/messages/")
        .then(result => result.json().then( data => {
            setItems(Object.values(data).map(function(val) {
                var ans = <Message sender={val.sender} content={val.content}/>;
                return ans;
            }));

            setIsLoaded(true);
        }));
  }

  useEffect(() => {
    getMessages();
  }, []);

  if (error)
    return <p>Error {error.message}</p>
  else if (!isLoaded)
    return <p>Loading...</p>
  else
    return (
      <table>
        {items}
      </table>
    );
}

export default App;
