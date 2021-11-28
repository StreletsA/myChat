import SendPanel from "./base/SendPanel";
import MessagePanel from "./base/MessagePanel";
import Cookies from "universal-cookie";
import LoginPanel from "./base/LoginPanel";

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
            <div>
                <MessagePanel/>
                <SendPanel />
                <button onClick={exit}>Выйти</button>
            </div>
        );
}

export default App;
