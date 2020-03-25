package com.dicoding.sampletemanngoding.service;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.Multicast;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.profile.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class BotService {
    @Autowired
    private LineMessagingClient lineMessagingClient;

    public void push(PushMessage pushMessage) {
        try {
            lineMessagingClient.pushMessage(pushMessage).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void multicast(Set<String> to, Message message) {
        try {
            Multicast multicast = new Multicast(to, message);
            lineMessagingClient.multicast(multicast).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private void reply(ReplyMessage replyMessage) {
        try {
            lineMessagingClient.replyMessage(replyMessage).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void reply(String replyToken, Message message) {
        ReplyMessage replyMessage = new ReplyMessage(replyToken, message);
        reply(replyMessage);
    }

    public void reply(String replyToken, List<Message> message) {
        ReplyMessage replyMessage = new ReplyMessage(replyToken, message);
        reply(replyMessage);
    }

    public void replyText(String replyToken, String messageText){
        TextMessage textMessage = new TextMessage(messageText);
        reply(replyToken, textMessage);
    }

    public void replyText(String replyToken, String[] messageTexts){
        List<Message> textMessages = Arrays
                .stream(messageTexts)
                .map(TextMessage::new)
                .collect(Collectors.toList());
        reply(replyToken, textMessages);
    }

    public UserProfileResponse getProfile(String userId){
        try {
            return lineMessagingClient.getProfile(userId).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void leaveGroup(String groupId) {
        try {
            lineMessagingClient.leaveGroup(groupId).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void leaveRoom(String groupId) {
        try {
            lineMessagingClient.leaveGroup(groupId).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
