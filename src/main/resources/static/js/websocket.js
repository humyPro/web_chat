function sendMessage(socket,msg) {
    socket.send(msg);
}
function getMessage(socket) {
    var msg='';
   socket.onmessage=function (ev) {
       msg=ev.data;
   }
   return msg;

}
function connect(url) {

    return new WebSocket(url);
}
