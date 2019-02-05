import { Router, Request, Response } from 'express';

const apiRouter = Router();

apiRouter.get('/', (req: Request, resp: Response) => {
    resp.send("Hello from [[ .Component ]] service (GET)");
})

export {
    apiRouter
};