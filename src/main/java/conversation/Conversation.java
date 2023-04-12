package conversation;

import messages.Message;
import user.User;

import java.util.LinkedList;
import java.util.List;

public class Conversation {
    private String name;
    private List<User> users = new LinkedList<>();
    private List<Message> messages = new LinkedList<>();

    public Conversation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void removeMessage(Message message) {
        messages.remove(message);
    }

    public void showConversation() {
        System.out.println(name);
        for (var message : messages) {
            message.show();
        }
    }
}
