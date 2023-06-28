const port = 3000;

const { createApp } = require('@unleash/proxy');
const proxyUrl = process.env.PROXY_URL || 'http://localhost:4242/api/';
const app = createApp({
    unleashUrl: proxyUrl,
    unleashApiToken: 'default:development.unleash-insecure-api-token',
    clientKeys: ['proxy-client-key'],
    proxyPort: 3000,
});

app.listen(port, () =>
    console.log(`Unleash Proxy listening on http://localhost:${port}/proxy`),
);