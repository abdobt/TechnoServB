import { Component, OnInit,ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { PickedtechService } from 'src/app/pickedtech.service';
import {WebSocketService} from '../../services/websocket.service'
declare function run():any ;
@Component({
  selector: 'app-techgeneration',
  templateUrl: './techgeneration.component.html',
  styleUrls: ['./techgeneration.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class TechgenerationComponent implements OnInit {

  constructor(private webSocketService: WebSocketService,private ts:PickedtechService,private router:Router) {
    let stompClient = this.webSocketService.connect();
    stompClient.connect({}, frame => {
      stompClient.subscribe('/topic/notification', data => {
        console.log(data);
           this.ts.techdata= JSON.parse(data.body);
           this.router.navigateByUrl('/pickedtech');
          run();
      })
  });
  }
  ngOnInit(): void {
  }

}
