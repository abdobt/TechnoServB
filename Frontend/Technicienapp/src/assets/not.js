function run()
{
  let permission = Notification.permission;
  if(permission === "granted") {
     showNotification();
  } else if(permission === "default"){
     requestAndShowPermission();
  } else {
    alert("Use normal alert");
  }
}
function showNotification() {
   if(document.visibilityState === "visible") {
       return;
   }
   var title = "JavaScript Jeep";
   icon = "assets/technician.png";
   var body = "On a trouvé un technicien pour vous ";
   var notification = new Notification('TechnoServ', { body, icon });
   notification.onclick = () => {
          notification.close();
          window.parent.focus();
   }
}
function requestAndShowPermission() {
   Notification.requestPermission(function (permission) {
      if (permission === "granted") {
            showNotification();
      }
   });
}
