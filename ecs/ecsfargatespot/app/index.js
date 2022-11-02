const express = require('express');
const bodyParser = require('body-parser');

// printing service is running each 2 seconds
var interval = setInterval(function () {
    console.log('service is running...');
}, 2000);

setTimeout(function () {
    clearInterval(interval);
}, 10000);

// when aws sends a SIGTERM event, the service will handle it
process.on('SIGTERM', () => {
    console.log('the service is about to shut down!');
    process.exit(0);
});

const app = express();

const port = process.env.PORT || 3070;

app.use(bodyParser.json());

app.listen(port, (err) => {
    if (err)
        logger.error('Error', err);
    console.log(`running server on from port ${port}`);
});

app.get('/healthcheck', (req, res) => {
    console.log('running /healthcheck');
    res.send();
});