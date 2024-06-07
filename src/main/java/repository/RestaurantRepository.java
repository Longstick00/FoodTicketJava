package repository;

import domain.Restaurant;
import util.JsonConverter;

import java.util.List;

public class RestaurantRepository {

    private static final List<Restaurant> restaurants =
            JsonConverter.jsonToEntity(Restaurant.class, "restaurant.json");

    static {
        for (Restaurant restaurant : restaurants) {
            restaurant.setDefaultTimeSet();
        }
    }

    public static List<Restaurant> get() {
        return restaurants;
    }

    public static Restaurant getByName(final String name) {
        return restaurants.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 식당이 없습니다. 다시 입력해주세요."));
    }

}
