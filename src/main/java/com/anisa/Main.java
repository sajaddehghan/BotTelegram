package com.anisa;


import com.anisa.rest.Rest;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<Car>();
        addcars(cars);
        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
//            Rest rest=new Rest();
//            rest.SearchCarpet();
            botsApi.registerBot(new MyBot2(cars));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void addcars(ArrayList<Car> cars) {
        cars.add(new Car("Prius", "toyota", 2017, "http://uupload.ir/files/fi2r_prius2017.jpg", 150000000));
        cars.add(new Car("Prius", "toyota", 2016, "http://uupload.ir/files/ui5s_prius2016.jpg", 139500000));
        cars.add(new Car("Hybrid Camry", "toyota", 2016, "http://uupload.ir/files/aa29_hybrid_camry2016.jpg", 245000000));
        cars.add(new Car("Yaris is the cashier", "toyota", 2016, "http://uupload.ir/files/jp1_yaris_is_the_cashier2016.jpg", 117000000));
        cars.add(new Car("Yaris Hatchback", "toyota", 2016, "http://uupload.ir/files/7pym_yaris_hatchback2016.jpg", 118000000));
        cars.add(new Car("Dusters", "renault", 2017, "http://uupload.ir/files/4qpu_dusters2017.jpg", 119000000));
        cars.add(new Car("Scala", "renault", 2016, "http://uupload.ir/files/xpji_scala2016.jpg", 129500000));
        cars.add(new Car("Sonata LF", "hyundai", 2016, "http://uupload.ir/files/xp8b_sonata_lf2016.jpg", 189000000));
        cars.add(new Car("Altare MD", "hyundai", 2016, "http://uupload.ir/files/q46e_altare_md2016.jpg", 135000000));
        cars.add(new Car("Altare MD", "hyundai", 2017, "http://uupload.ir/files/edu_altare_md2017.jpg", 149000000));
        cars.add(new Car("SantaFe DM", "hyundai", 2016, "http://uupload.ir/files/9lq0_santafe_dm2016.jpg", 228000000));
        cars.add(new Car("SantaFe DM", "hyundai", 2017, "http://uupload.ir/files/39mz_santafe_dm2017.jpg", 242000000));
    }
}
