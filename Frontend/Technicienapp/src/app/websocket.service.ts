import {Injectable} from "@angular/core";

var SockJs = require("sockjs-client");
var Stomp = require("stompjs");


@Injectable()
export class WebSocketService {

    constructor() { }

    connect() {
        let socket = new SockJs(`http://localhost:9005/websocket/socket`);

        let stompClient = Stomp.over(socket);

        return stompClient;
    }
}
