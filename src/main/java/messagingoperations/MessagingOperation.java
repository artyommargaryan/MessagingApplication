package messagingoperations;

import conversation.Conversation;
import messages.Message;
import user.User;

public interface MessagingOperation {
    void addUser(User user);
    void addUserToConversation(Conversation conversation, User user);
    void removeUser(Conversation conversation, User user);
    Conversation createConversation(String name);
    Conversation getConversation(String name);
    void deleteConversation(Conversation conversation);
    void showConversation(Conversation conversation);

    void sendMessage(Message message);
}
