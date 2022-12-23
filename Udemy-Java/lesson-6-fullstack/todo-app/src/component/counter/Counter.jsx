import { useState } from "react"

export default function Counter(){
    const [count, setCount] = useState(0);

    const increment = () => {
        setCount(count+  1)
    }

    return(
        <div className="Counter">
            <span className="count">{count}</span>
            <button className="counterButton" onClick={increment}>increment</button>
        </div>

    )
}