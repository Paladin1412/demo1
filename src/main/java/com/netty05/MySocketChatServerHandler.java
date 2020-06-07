package com.netty05;

import com.ChatMessage;
import com.User;
import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MySocketChatServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    private static ConcurrentHashMap<String, List<User>> channelGroups = new ConcurrentHashMap<>();
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private String room_id;
    private String user_name;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        ChatMessage backMsg = new ChatMessage();
        Channel channel = ctx.channel();
        ChatMessage chatMessage = JSON.toJavaObject((JSON) JSON.parse(msg.text()), ChatMessage.class);
        Map<String, Object> msgBody = chatMessage.getMsgBody();
        if (chatMessage.getMsgType() == 1) {
            String roomid = (String) msgBody.get("roomid");
            String username = (String) msgBody.get("username");
            User user = new User(username, channel);
            //不存在该房间号
            if (!channelGroups.containsKey(roomid)) {
                this.room_id = roomid;
                this.user_name = username;
                List<User> list = new ArrayList<>();
                list.add(user);
                channelGroups.put(roomid, list);
                backMsg.setMsgType(1);
                Map<String, Object> map = new HashMap<>();
                map.put("status", "success");
                map.put("person", username);
                map.put("users", getUsers(roomid));
                backMsg.setMsgBody(map);
                ctx.channel().writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(backMsg)));
            } else {
                //存在该房间号
                List<User> users = channelGroups.get(roomid);
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getUsername().equals(username)) {
                        //存在该用户
                        backMsg.setMsgType(1);
                        Map<String, Object> map = new HashMap<>();
                        map.put("status", "error");
                        backMsg.setMsgBody(map);
                        ctx.channel().writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(backMsg)));
                        return;
                    }
                }
//              不存在该用户
                users.add(user);
                channelGroups.put(roomid, users);
                this.room_id = roomid;
                this.user_name = username;
                users.forEach(user1 -> {
                    backMsg.setMsgType(1);
                    Map<String, Object> map1 = new HashMap<>();
                    map1.put("status", "success");
                    map1.put("users", getUsers(roomid));
                    map1.put("person", username);
                    backMsg.setMsgBody(map1);
                    user1.getChannel().writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(backMsg)));
                });
            }
        } else if (chatMessage.getMsgType() == 0) {
            String content = (String) msgBody.get("content");
            List<User> users = channelGroups.get(this.room_id);
            users.forEach(user -> {
                backMsg.setMsgType(0);
                Map<String, Object> map1 = new HashMap<>();
                map1.put("time", getTime());
                map1.put("content", content);
                map1.put("person", this.user_name);
                backMsg.setMsgBody(map1);
                user.getChannel().writeAndFlush(new TextWebSocketFrame((JSON.toJSONString(backMsg))));
            });
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("11111111111111111");
        //判断
        channelGroup.add(ctx.channel());
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMsgType(2);
        Map<String,Object> map = new HashMap<>();
        map.put("status","add");
        map.put("num",channelGroup.size());
        chatMessage.setMsgBody(map);
        channelGroup.forEach(channel -> {
            channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(chatMessage)));
        });

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("roomid->" + this.room_id + "; username->" + this.user_name);
        removeUser(this.room_id,this.user_name);
        List<User> users = channelGroups.get(this.room_id);
        if(users == null || users.size()==0) {channelGroups.remove(this.room_id);return;}
        channelGroups.put(this.room_id, users);
        users.forEach(u -> {
                ChatMessage backMsg = new ChatMessage();
                backMsg.setMsgType(1);
                Map<String, Object> map = new HashMap<>();
                map.put("status", "out");
                map.put("users", getUsers(this.room_id));
                map.put("person", this.user_name);
                backMsg.setMsgBody(map);
                u.getChannel().writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(backMsg)));
        });
    }

    private List<String> getUsers(String roomid){
        List<String> userList = new ArrayList<>();
        List<User> users = channelGroups.get(roomid);
        users.forEach(user -> {
            userList.add(user.getUsername());
        });
        return userList;
    }

    private void removeUser(String roomid,String username){
        List<User> users = channelGroups.get(roomid);
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                users.remove(users.get(i));
                break;
            }
        }
        if(users.size()==0){
            channelGroups.remove(roomid);
        }else {
            channelGroups.put(roomid,users);
        }
    }

    private String getTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}

