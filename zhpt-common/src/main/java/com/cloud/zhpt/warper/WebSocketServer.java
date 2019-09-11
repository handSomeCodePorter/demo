package com.cloud.zhpt.warper;

import com.cloud.zhpt.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName WebSocketServer
 * @Description
 * @Author SW
 * @Date 2019/9/8 14:08
 **/
@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {
    private static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    //与某个客户端的会话
    private Session session;

    //接收sid
    private String sid="";

    @OnOpen
    public Notification onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        webSocketSet.add(this);   //加入set中
        //在线认数+1
        WebSocketServer.addOnlineCount();
        logger.info("【websocket】开始监听窗口:"+sid+",当前在线人数为" + getOnlineCount());
        this.sid = sid;
        return new Notification(Notification.SUCCESS,"连接成功…");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public Notification onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount(); //在线数减1
        logger.info("【websocket】连接："+sid+"关闭，当前在线人数为" + getOnlineCount());
        return new Notification(Notification.SUCCESS, "连接：【"+sid + "】已关闭…");
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("【websocket】收到"+sid+"的信息:"+message);
    }

    /**
     * 发生异常后调用的方法
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("【websocket】系统异常，发生错误");
        error.printStackTrace();
    }


    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 发送消息
     * @param message
     * @param sid
     * @throws IOException
     */
    public static void sendInfo(String message,@PathParam("sid") String sid) throws IOException {
        logger.info("【websocket】推送消息至窗口："+sid+"，推送内容:"+message);
        for (WebSocketServer item : webSocketSet) {
            try {
                //这里可以设定只推送给这个sid的，为null则全部推送
                if(sid==null) {
                    item.sendMessage(message);
                }else if(item.sid.equals(sid)){
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }

    /**
     *
     * 获取在线人数
     *
     */
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    /**
     * 在线人数加1
     */
    public static synchronized void addOnlineCount() {
        logger.info("【websocket】【在线人数】：加1……" );
        WebSocketServer.onlineCount++;
    }

    /**
     * 在线认数减1
     */
    public static synchronized void subOnlineCount() {
        logger.info("【websocket】【在线人数】：减1……" );
        WebSocketServer.onlineCount--;
    }
}
