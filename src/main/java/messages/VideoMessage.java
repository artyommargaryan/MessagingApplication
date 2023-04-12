package messages;

import conversation.Conversation;
import user.User;

public class VideoMessage extends Message {
    public VideoMessage(User user, Conversation conversation, String content) {
        super(user, conversation, content);
    }

    @Override
    public String getType() {
        return VideoMessage.class.toString();
    }

    @Override
    public void show() {
        System.out.println(getUser().getName() + ": ");
        System.out.println(getContent());
    }
}
