package app;

import conversation.Conversation;
import messages.Message;
import messages.TextMessage;
import messages.VideoMessage;
import messagingoperations.MessagingOperation;
import messagingoperations.Telegram;
import user.User;

public class Application {
    public static void main(String[] args) {
        MessagingOperation app = new Telegram();
        User user1 = new User("Artyom", "07736");
        User user2 = new User("Arthur", "07345");
        User user3 = new User("Gevorg", "07565");
        app.addUser(user1);
        app.addUser(user2);
        Conversation conversation = app.createConversation("some");
        Message message = createTextMessage(user1, conversation, "text");
        Message msgVideo = createVideoMessage(user2, conversation, "videoMessage by user: " + user2.getName());
        Message msgText = createTextMessage(user1, conversation, "TextMessage by user: " + user1.getName());
        app.sendMessage(message);
        app.sendMessage(msgVideo);
        app.sendMessage(msgText);
        app.showConversation(app.getConversation("some"));
    }

    private static Message createVideoMessage(User user, Conversation conversation, String content) {
        return new VideoMessage(user, conversation, content);
    }

    private static Message createTextMessage(User user, Conversation conversation, String content) {
        return new TextMessage(user, conversation, content);
    }
}
