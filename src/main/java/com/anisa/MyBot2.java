package com.anisa;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot2 extends TelegramLongPollingBot {
    private ArrayList<Car> cars;

    public MyBot2(ArrayList<Car> cars) {
        this.cars = cars;
    }


    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (message_text.equals("/start")) {
                SendMessage message = new SendMessage().setChatId(chat_id).setText("Here is your keyboard");
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                List<KeyboardRow> keybord = new ArrayList<KeyboardRow>();

                KeyboardRow row = new KeyboardRow();
                row.add("search age?");
                row.add("show all");
                keybord.add(row);

                keyboardMarkup.setKeyboard(keybord);
                message.setReplyMarkup(keyboardMarkup);

                try {
                    sendMessage(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("search age?")) {
                SendMessage message = new SendMessage().setChatId(chat_id).setText("age:");
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                List<KeyboardRow> keybord = new ArrayList<KeyboardRow>();
                KeyboardRow row = new KeyboardRow();
                row.add("2016");
                row.add("2017");
                keybord.add(row);

                keyboardMarkup.setKeyboard(keybord);
                message.setReplyMarkup(keyboardMarkup);

                try {
                    sendMessage(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (message_text.equals("2016")) {
                int age = Integer.valueOf(message_text);
                try {
                    chat_id = update.getMessage().getChatId();
                    ArrayList<Car> carlist = carList(age);
                    if (carlist.isEmpty()) {
                        SendMessage message = new SendMessage().setChatId(chat_id).setText("Not available!!");
                        sendMessage(message);
                        message = new SendMessage().setChatId(chat_id).setText("Here is your keyboard");
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        List<KeyboardRow> keybord = new ArrayList<KeyboardRow>();

                        KeyboardRow row = new KeyboardRow();
                        row.add("search age?");
                        row.add("show all");
                        keybord.add(row);

                        keyboardMarkup.setKeyboard(keybord);
                        message.setReplyMarkup(keyboardMarkup);
                        sendMessage(message);
                    } else {
                        SendMessage message = new SendMessage().setChatId(chat_id).setText("Here is your keyboard");
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        List<KeyboardRow> keybord = new ArrayList<KeyboardRow>();
                        KeyboardRow row = null;
                        int end = 11;
                        if (end > carlist.size()) {
                            end = carlist.size();
                        }
                        final List<Car> newList = carlist.subList(0, end);
                        for (int i = 0; i < newList.size();) {
                            row = new KeyboardRow();
                            for (int j = 0; j < 4 && i < newList.size(); j++) {
                                row.add(newList.get(i).getName() + " " + newList.get(i).getAge());
                                i++;
                            }
                            if (i == end && end < carlist.size()) {
                                row.add("2016 page 2");
                            }
                            keybord.add(row);
                        }
                        keyboardMarkup.setKeyboard(keybord);
                        message.setReplyMarkup(keyboardMarkup);
                        sendMessage(message);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (message_text.equals("2017")) {
                int age = Integer.valueOf(message_text);
                try {
                    chat_id = update.getMessage().getChatId();
                    ArrayList<Car> carlist = carList(age);
                    if (carlist.isEmpty()) {
                        SendMessage message = new SendMessage().setChatId(chat_id).setText("Not available!!");
                        sendMessage(message);
                        message = new SendMessage().setChatId(chat_id).setText("Here is your keyboard");
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        List<KeyboardRow> keybord = new ArrayList<KeyboardRow>();

                        KeyboardRow row = new KeyboardRow();
                        row.add("search age?");
                        row.add("show all");
                        keybord.add(row);

                        keyboardMarkup.setKeyboard(keybord);
                        message.setReplyMarkup(keyboardMarkup);
                        sendMessage(message);
                    } else {
                        SendMessage message = new SendMessage().setChatId(chat_id).setText("Here is your keyboard");
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        List<KeyboardRow> keybord = new ArrayList<KeyboardRow>();
                        KeyboardRow row = null;
                        int end = 11;
                        if (end > carlist.size()) {
                            end = carlist.size();
                        }
                        final List<Car> newList = carlist.subList(0, end);
                        for (int i = 0; i < newList.size();) {
                            row = new KeyboardRow();
                            for (int j = 0; j < 4 && i < newList.size(); j++) {
                                row.add(newList.get(i).getName() + " " + newList.get(i).getAge());
                                i++;
                            }
                            if (i == end && end < carlist.size()) {
                                row.add("2016 page 2");
                            }
                            keybord.add(row);
                        }
                        keyboardMarkup.setKeyboard(keybord);
                        message.setReplyMarkup(keyboardMarkup);
                        sendMessage(message);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (message_text.equals("show all")) {
                SendMessage message = new SendMessage().setChatId(chat_id).setText("Here is your keyboard");
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                List<KeyboardRow> keybord = new ArrayList<KeyboardRow>();
                KeyboardRow row = null;
                int end = 11;
                if (end > cars.size()) {
                    end = cars.size();
                }
                final List<Car> newList = cars.subList(0, end);
                for (int i = 0; i < newList.size();) {
                    row = new KeyboardRow();
                    for (int j = 0; j < 4 && i < newList.size(); j++) {
                        row.add(newList.get(i).getName() + " " + newList.get(i).getAge());
                        i++;
                    }
                    if (i == end && end < cars.size()) {
                        row.add("page 2");
                    }
                    keybord.add(row);
                }
                keyboardMarkup.setKeyboard(keybord);
                message.setReplyMarkup(keyboardMarkup);
                try {
                    sendMessage(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {
                String mes[] = message_text.split(" ");
                if (mes.length == 3 && mes[1].equals("page")) {
                    int age = Integer.valueOf(mes[0]);
                    int page = Integer.valueOf(mes[2]);

                    SendMessage message = new SendMessage().setChatId(chat_id).setText("Here is your keyboard");
                    ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                    List<KeyboardRow> keybord = new ArrayList<KeyboardRow>();
                    KeyboardRow row = null;
                    int start = ((page - 1) * 10) + 1;
                    int end = start + 10;
                    ArrayList<Car> carlist=carList(age);
                    if (end > carlist.size()) {
                        end = carlist.size();
                    }
                    final List<Car> newList = carlist.subList(start, end);
                    for (int i = 0; i < newList.size();) {
                        row = new KeyboardRow();
                        for (int j = 0; j < 4 && i < newList.size(); j++) {
                            if (i == 0) {
                                if (page - 1 == 1) {
                                    row.add(String.valueOf(age));
                                } else {
                                    row.add(age + " page " + (page - 1));
                                }
                            }
                            row.add(newList.get(i).getName() + " " + newList.get(i).getAge());

                            i++;
                        }
                        if (i == end && end < cars.size()) {
                            row.add(age + " page " + (page + 1));
                        }
                        keybord.add(row);
                    }
                    keyboardMarkup.setKeyboard(keybord);
                    message.setReplyMarkup(keyboardMarkup);
                    try {
                        sendMessage(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                } else if (mes.length == 2 && mes[0].equals("page")) {
                    int page = Integer.valueOf(mes[1]);

                    SendMessage message = new SendMessage().setChatId(chat_id).setText("Here is your keyboard");
                    ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                    List<KeyboardRow> keybord = new ArrayList<KeyboardRow>();
                    KeyboardRow row = null;
                    int start = ((page - 1) * 10) + 1;
                    int end = start + 10;
                    if (end > cars.size()) {
                        end = cars.size();
                    }
                    final List<Car> newList = cars.subList(start, end);
                    for (int i = 0; i < newList.size();) {
                        row = new KeyboardRow();
                        for (int j = 0; j < 4 && i < newList.size(); j++) {
                            if (i == 0) {
                                if (page - 1 == 1) {
                                    row.add("show all");
                                } else {
                                    row.add("page " + (page - 1));
                                }
                            }
                            row.add(newList.get(i).getName() + " " + newList.get(i).getAge());

                            i++;
                        }
                        if (i == end && end < cars.size()) {
                            row.add("page " + (page + 1));
                        }
                        keybord.add(row);
                    }
                    keyboardMarkup.setKeyboard(keybord);
                    message.setReplyMarkup(keyboardMarkup);
                    try {
                        sendMessage(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                } else {
                    int age = 0;
                    if (mes.length - 1 != 0) {
                        age = Integer.valueOf(mes[mes.length - 1]);
                    }
                    String name = mes[0];
                    for (int i = 1; i < mes.length - 1 && mes.length - 1 != 0; i++) {
                        name += " " + mes[i];
                    }
                    Car car = searchCar(name, age);
                    if (car != null) {
                        SendPhoto msg = new SendPhoto().setChatId(chat_id).setPhoto(car.getPhoto())
                                .setCaption("name:" + car.getName() + "\nage:" + car.getAge() + "\nManufacturer:" + car.getManufacturer() + "\nprice:" + car.getPrice());
                        try {
                            sendPhoto(msg);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        SendMessage message = new SendMessage().setChatId(chat_id).setText("Here is your keyboard");
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        List<KeyboardRow> keybord = new ArrayList<KeyboardRow>();

                        KeyboardRow row = new KeyboardRow();
                        row.add("search age?");
                        row.add("show all");
                        keybord.add(row);

                        keyboardMarkup.setKeyboard(keybord);
                        message.setReplyMarkup(keyboardMarkup);

                        try {
                            sendMessage(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } else {
                        SendMessage message = new SendMessage().setChatId(chat_id).setText("Here is your keyboard");
                        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                        List<KeyboardRow> keybord = new ArrayList<KeyboardRow>();

                        KeyboardRow row = new KeyboardRow();
                        row.add("search age?");
                        row.add("show all");
                        keybord.add(row);

                        keyboardMarkup.setKeyboard(keybord);
                        message.setReplyMarkup(keyboardMarkup);

                        try {
                            sendMessage(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public String getBotUsername() {
        return "anisagroup_bot";
    }

    public String getBotToken() {
        return "390155284:AAEM-R-3P8vX41u2tzlWXWteCH5KQv19Gpg";
    }

    public ArrayList<Car> carList(int age) {
        ArrayList<Car> carlist = new ArrayList<Car>();
        for (Car car : cars) {
            if (car.getAge() == age) {
                carlist.add(car);
            }
        }
        return carlist;
    }

    public Car searchCar(String name, int age) {
        for (Car car : cars) {
            if (car.getName().equals(name)) {
                if (car.getAge() == age) {
                    return car;
                }
            }
        }
        return null;
    }
}
