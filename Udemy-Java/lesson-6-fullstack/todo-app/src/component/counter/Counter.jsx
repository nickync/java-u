import { useState } from "react"

export default function Counter({num}){
    const [count, setCount] = useState(0);

    const increment = () => {
        setCount(count+  num)
    }

    return(
        <div className="Counter">
            <span className="count">{count}</span>
            <button className="counterButton" onClick={increment}>increment</button>
        </div>

    )
}