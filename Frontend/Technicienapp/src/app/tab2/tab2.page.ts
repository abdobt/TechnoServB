import { Component } from '@angular/core';
import { LocalNotifications } from '@ionic-native/local-notifications/ngx';
import { WebSocketService } from '../websocket.service';
@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {
 username:string='';
 adresse:string='';
 phone:number;
 found:boolean=false;
  constructor(private localNotifications: LocalNotifications,private webSocketService:WebSocketService) {
    let stompClient = this.webSocketService.connect();
    stompClient.connect({}, frame => {
      stompClient.subscribe('/topic/notificationtech', data => {
        data= JSON.parse(data.body);
        this.found=true;
        this.username=data['username'];
        this.adresse=data['adresse'];
        this.phone=data['phone'];
      })
  });
  }
shownotif()
{
  this.localNotifications.schedule({
    id: 1,
    text: 'Single ILocalNotification'
  });
}
}
