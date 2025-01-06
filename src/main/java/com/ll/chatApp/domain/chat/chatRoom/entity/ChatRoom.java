package com.ll.chatApp.domain.chat.chatRoom.entity;

import com.ll.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Setter
@Getter
@SuperBuilder
@ToString(callSuper = true)
public class ChatRoom  extends BaseEntity {
    public ChatRoom () {

    }
    private String name;

    @OneToMany
    private List<ChatMessage> chatMessages;
}
