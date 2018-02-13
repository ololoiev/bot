import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.logging.Logger;

public class MyAmazingBot extends TelegramLongPollingBot {
    private static Logger LOGGER = Logger.getLogger(MyAmazingBot.class.getName());
    public void onUpdateReceived(Update update) {

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            LOGGER.info(update.getMessage().getContact().getFirstName() + " "
                    + update.getMessage().getContact().getFirstName() + " " +
                    message_text.split("\n")[0]
            );

            if (message_text.equals("привет")) {
                message_text = "привет!";
            }

            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(message_text);
            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        // Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        return "TestBot";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return "431970883:AAGafHae8GdZLyVjBM0unetncK6uoR3vWXY";
    }
}