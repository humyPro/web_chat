package com.humy.springboot.websocket;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.humy.springboot.pojo.WebSocketVo;
import jdk.nashorn.internal.scripts.JS;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Auther: Hu Min
 * @Date: 2018/11/9 14:35
 * @Description:
 */


@ServerEndpoint(value = "/echo/{user_name}")
@Component
public class WebSocketServer {
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();
    private static ConcurrentHashMap<String,WebSocketServer> sessionsAndName=new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;
    private ObjectMapper mapper = new ObjectMapper();
    private boolean flag=false;
    private String name;
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(@PathParam("user_name")String username, Session session) {
        this.session = session;

        //加入set中
        webSocketSet.add(this);
        this.name=username;
        sessionsAndName.put(username,this);

        //在线数加1
        addOnlineCount();
        System.out.println("有新连接加入！昵称是:"+username+",当前在线人数为" + getOnlineCount());
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            System.out.println("websocket IO异常");
        }
    }
    //	//连接打开时执行{"name":"zhangsna","age":"12"}
    //	@OnOpen
    //	public void onOpen(@PathParam("user") String user, Session session) {
    //		currentUser = user;
    //		System.out.println("Connected ... " + session.getId());
    //	}

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        //从set中删除
        webSocketSet.remove(this);
        sessionsAndName.remove(name);
        //在线数减1
        subOnlineCount();
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {


        try {
            WebSocketVo  vo=mapper.readValue(message, WebSocketVo.class);

            System.out.println("来自"+vo.getSender()+"发送给"+vo.getAddr()+"的消息:" + vo.getMsg());
            System.out.println("当前在线：");
            sessionsAndName.keySet().forEach(s -> System.out.print(s+"、"));
            System.out.println("\n");

            if(sessionsAndName.containsKey(vo.getAddr())){


                sessionsAndName.get(vo.getAddr()).sendMessage(message);
                System.out.println("服务器转发消息成功");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


//        //群发消息
//        for (WebSocketServer item : webSocketSet) {
//            try {
//                item.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     * */
    public static void sendInfo(String message) throws IOException {
        System.out.println(message);
        for (WebSocketServer item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }



}
