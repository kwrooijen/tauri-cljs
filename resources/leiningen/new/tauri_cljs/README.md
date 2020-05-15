# {{name}}

## Requirements

* [Latest version of Node](https://nodejs.org/)
* [Yarn package manager](https://yarnpkg.com/) (alternatively, [npm](https://www.npmjs.com/))

## Setup

```sh
yarn deps
```

## Development

In order to run Tauri in development, you need to start a webserver that serves
HTML. In our case we will use shadow-cljs. Open a terminal window and run the
following command to start shadow-cljs.

```sh
yarn watch
```

Next we want to open a Tauri window. Tauri and Shadow-cljs are configured to
port 3449 by default. Shadow-cljs will server assets from that port, and Tauri
will listen. Open another terminal and run the following command to start Tauri.

```sh
yarn tauri dev
```sh
