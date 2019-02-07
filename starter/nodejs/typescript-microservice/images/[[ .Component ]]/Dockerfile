FROM node:8.15.0-alpine
WORKDIR app
COPY . .
RUN npm install && npm run tsc
EXPOSE 80
CMD ["node", "."]