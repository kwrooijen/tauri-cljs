# DEPRECATED

This project will no longer receive any updates. Instead you should use the `yarn create tauri-app` command and select Clojurescript. This will use the following template: https://github.com/filipesilva/create-cljs-app

# Tauri Clojurescript

Clojurescript template for using [Tauri](https://github.com/tauri-apps/tauri), a
tool for building desktop application using web technology.

This template currently includes re-frame. It also has a small example on how
you can open a file selector dialog, and read a file from your file system using
the [Tauri API](https://github.com/tauri-apps/tauri/wiki/11.-API).

## Requirements

* [Read the Tauri setup guide](https://tauri.studio/en/docs/getting-started/intro/#setting-up-your-environment)
* [Latest version of Node](https://nodejs.org/)
* [Yarn package manager](https://yarnpkg.com/) (alternatively, [npm](https://www.npmjs.com/))

## Setup

```sh
lein new tauri-cljs my-awesome-app
cd my-awesome-app
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
port 3449 by default. Shadow-cljs will serve assets from that port, and Tauri
will listen. Open another terminal and run the following command to start Tauri.

```sh
yarn tauri dev
```


## Troubleshooting

Make sure you have the latest version of Node, Tauri requires a very recent
version.
