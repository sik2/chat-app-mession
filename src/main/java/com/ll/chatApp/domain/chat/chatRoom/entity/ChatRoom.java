package com.ll.chatApp.domain.chat.chatRoom.entity;

import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@SuperBuilder
@ToString(callSuper = true)
public class ChatRoom  extends BaseEntity {
    public ChatRoom () {

    }
}
