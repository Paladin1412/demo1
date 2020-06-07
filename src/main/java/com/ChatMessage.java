package com;

import java.util.Map;

public class ChatMessage {
    int msgType;
    Map<String,Object> msgBody;

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public Map<String, Object> getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(Map<String, Object> msgBody) {
        this.msgBody = msgBody;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "msgType=" + msgType +
                ", msgBody=" + msgBody +
                '}';
    }
}
