package com.anisa;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.util.ArrayList;


public class MyBot extends TelegramLongPollingBot {
    private ArrayList<Car> cars;

    public MyBot(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            try{
                int age = Integer.valueOf(message_text);
                try {
                    long chat_id = update.getMessage().getChatId();
                    ArrayList<Car> carlist=carList(age);
                    if(carlist.isEmpty()){
                        SendMessage message = new SendMessage().setChatId(chat_id).setText("Not available!!");
                        sendMessage(message);
                    }else{
                        String str=showlist(carlist);
                        SendMessage message=new SendMessage().setChatId(chat_id).setText(str);
                        sendMessage(message);
                    }
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }catch (NumberFormatException ex){
                long chat_id = update.getMessage().getChatId();
                SendMessage message = new SendMessage().setChatId(chat_id).setText("age?");
                try{
                    sendMessage(message);
                }catch (Exception e){
                    e.printStackTrace();
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

    public ArrayList<Car> carList(int age){
        ArrayList<Car> carlist=new ArrayList<Car>();
        for (Car car:cars) {
            if (car.getAge()==age){
                carlist.add(car);
            }
        }
        return carlist;
    }

    public String showlist(ArrayList<Car> carlist){
        String str="";
        for (Car car:carlist) {
            str+=car.toString()+"\n";
        }
        return str;
    }

}
