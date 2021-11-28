export default function Message(props)
{

    var date = props.date;
    var sender = props.sender;
    var content = props.content;

    return(
        <tr>
            <td>{date}</td>
            <td>{sender}</td>
            <td>{content}</td>
        </tr>
    )
}