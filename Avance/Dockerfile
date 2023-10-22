FROM node:alpine
# We don't need the standalone Chromium
ENV PUPPETEER_SKIP_CHROMIUM_DOWNLOAD true

WORKDIR /usr/app
COPY package.json package-lock.json ./
RUN npm install
COPY . /usr/app
EXPOSE 3000
CMD  node app.js