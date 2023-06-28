const port = 3000;

const { createApp } = require('@unleash/proxy');

const app = createApp({
    unleashUrl: 'http://host.docker.internal:4242/api/',
    unleashApiToken: 'default:development.unleash-insecure-api-token',
    clientKeys: ['proxy-client-key'],
    proxyPort: 3000,
});

app.listen(port, () =>
    console.log(`Unleash Proxy listening on http://localhost:${port}/proxy`),
);