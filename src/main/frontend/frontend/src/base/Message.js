import React, { useState, useEffect, Component } from 'react';

export default function Message(props)
{

    var sender = props.sender;
    var content = props.content;

    return(
        <tr>
            <td>{sender}</td>
            <td>{content}</td>
        </tr>
    )
}