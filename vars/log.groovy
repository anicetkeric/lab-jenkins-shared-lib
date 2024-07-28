#!/usr/bin/env groovy

def info(msg) {
    ansiColor('xterm') {
        echo "\u001B[36mINFO: $msg"
    }

}

def warning(msg) {
    ansiColor('xterm') {
        echo "\u001B[35mWARNING: ${msg}\u001B[0m"
    }
}

def debug(msg) {
    ansiColor('xterm') {
        echo "\u001B[36mDEBUG: ${msg}\u001B[0m"
    }
}

def error(msg) {
    ansiColor('xterm') {
        echo "\u001B[31mERROR: ${msg}\u001B[0m"
    }
}