package repository;

import domain.Restaurant;
import util.JsonConverter;

import java.util.List;

public class RestaurantRepository {

    private static final List<Restaurant> restaurants = JsonConverter.convertTo(Restaurant.class, "info.json");

    public void checkExist(String restaurantName) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(restaurantName)) {
                return;
            }
        }
    }

    public static List<Restaurant> get() {
        return restaurants;
    }

}
