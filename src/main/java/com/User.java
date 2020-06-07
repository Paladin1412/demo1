package com;

import io.netty.channel.Channel;

public class User {
    String username;
    Channel channel;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public User(String username, Channel channel) {
        this.username = username;
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", channel=" + channel +
                '}';
    }
}
