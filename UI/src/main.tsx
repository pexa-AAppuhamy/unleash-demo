import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import FlagProvider from '@unleash/proxy-client-react';

const config = {
  url: 'http://localhost:3000/proxy', // Your front-end API URL or the Unleash proxy's URL (https://<proxy-url>/proxy)
  clientKey: 'proxy-client-key', // A client-side API token OR one of your proxy's designated client keys (previously known as proxy secrets)
  refreshInterval: 3, // How often (in seconds) the client should poll the proxy for updates
  appName: 'unleash-ui', // The name of your application. It's only used for identifying your application
};

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <FlagProvider config={config}>
    <App />
    </FlagProvider>
  </React.StrictMode>,
)
