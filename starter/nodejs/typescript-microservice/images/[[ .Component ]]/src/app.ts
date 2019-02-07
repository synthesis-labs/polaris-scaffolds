import express from 'express';
import { AddressInfo } from 'net';
import { apiRouter } from './[[ .Component ]]';

const app = express();
const port = 8080;

app.use('/[[ .Component ]]', apiRouter);

const server = app.listen(port, () => {
    let serverAddress = server.address() as AddressInfo;
    console.log( `Service started on http://${serverAddress.address}:${serverAddress.port}` );
})
