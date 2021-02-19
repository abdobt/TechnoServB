package ma.technoserv.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@RestController
public class NotificationController {
   @Autowired
   private SimpMessagingTemplate template;
    @PostMapping("/notifyclient")
    public String sendtoclient(@RequestBody Object te) throws Exception {
       template.convertAndSend("/topic/notification",te);
        return "Notifications successfully sent to Angular !";
    }
    @PostMapping("/notifytechnicien")
    public String sendtotechnicien(@RequestBody Object te) throws Exception {
       template.convertAndSend("/topic/notificationtech",te);
        return "Notifications successfully sent to ionic !";
    }
}
