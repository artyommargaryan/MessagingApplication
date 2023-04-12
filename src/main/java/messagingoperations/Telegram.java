package messagingoperations;

import conversation.Conversation;
import messages.Message;
import user.User;

import java.util.LinkedList;
import java.util.List;

public class Telegram implements MessagingOperation {
    private final List<User> users = new LinkedList<>();
    private final List<Conversation> conversations = new LinkedList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void addUserToConversation(Conversation conversation, User user) {
        validateConversation(conversation);
        validateUser(user);
        conversation.addUser(user);
    }

    private boolean isValidUser(User user) {
        return users.contains(user);
    }

    private void validateUser(User user) {
        if (!isValidUser(user)) {
            throw new IllegalArgumentException("No such user");
        }
    }

    private void validateConversation(Conversation conversation) {
        if (!isValidConversation(conversation)) {
            throw new IllegalArgumentException("No such conversation");
        }
    }

    private boolean isValidConversation(Conversation conversation) {
        return conversations.contains(conversation);
    }

    @Override
    public void removeUser(Conversation conversation, User user) {
        validateUser(user);
        validateConversation(conversation);
        conversation.removeUser(user);
    }

    @Override
    public Conversation createConversation(String name) {
        Conversation conversation = new Conversation(name);
        conversations.add(conversation);
        return conversation;
    }

    @Override
    public Conversation getConversation(String name) {
        return  conversations
                .stream()
                .filter(x -> x.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No such conversation"));


//        for (var conv : conversations) {
//            if (conv.getName().equals(name)) {
//                return conv;
//            }
//        }
//
//        throw new IllegalArgumentException("No such conversation");
    }

    @Override
    public void deleteConversation(Conversation conversation) {
        validateConversation(conversation);

        conversations.remove(conversation);
    }

    @Override
    public void showConversation(Conversation conversation) {
        validateConversation(conversation);
        conversation.showConversation();
    }

    @Override
    public void sendMessage(Message message) {
        var user = message.getUser();
        var conv = message.getConversation();
        validateUser(user);
        validateConversation(conv);
        conv.addMessage(message);
    }
}