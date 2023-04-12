package messages;

import conversation.Conversation;
import user.User;

public class TextMessage extends Message {
    public TextMessage(User user, Conversation conversation, String content) {
        super(user, conversation, content);
    }

    @Override
    public String getType() {
        return TextMessage.class.toString();
    }

    @Override
    public void show() {
            System.out.println(getUser().getName() + ": ");
            System.out.println(getContent());
    }
}
