package messages;

import conversation.Conversation;
import user.User;

public abstract class Message {
    private User user;
    private Conversation conversation;
    private String content;

    public Message(User user, Conversation conversation, String content) {
        this.user = user;
        this.conversation = conversation;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public abstract String getType();

    public abstract void show();
}
