import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { useFlag } from '@unleash/proxy-client-react';

function App() {
  const [count, setCount] = useState(0)
  const [logo, setLogo] = useState(false);
  const logosFeatureEnabled = useFlag('logo');
  useEffect(() => {
    
    if (logosFeatureEnabled){
      setLogo(true)
    }

    else {
      setLogo(false)
    }
    
  },[logo,logosFeatureEnabled])
  
  return (
    <>
      <p>
        Logo Feature toggle status: {(logo) ? "enabled":"disabled"}
      </p>
      {
      (logo) && 
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      }
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.tsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default App
