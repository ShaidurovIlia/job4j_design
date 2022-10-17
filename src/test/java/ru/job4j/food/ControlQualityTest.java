package ru.job4j.food;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {
    private  LocalDate expiryDate;
    private LocalDate createDate;
    private Warehouse warehouse;
    private Shop shop;
    private Trash trash;
    private ControlQuality controlQuality;

    @BeforeEach
    public void init() {
        warehouse = new Warehouse();
        shop = new Shop();
        trash = new Trash();
        controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
    }

    @Test
    public void whenDispatchShop() {
        expiryDate = LocalDate.now().plusDays(3);
        createDate = LocalDate.now().minusDays(7);
        Food meat = new Meat("Meat", expiryDate, createDate, 100.0, 10);
        controlQuality.distribution(meat);
        assertThat(shop.getFoods().contains(meat)).isTrue();
    }

    @Test
    public void whenDispatchTrash() {
        expiryDate = LocalDate.now().plusDays(0);
        createDate = LocalDate.now().minusDays(14);
        Food cheese = new Cheese("Cheese", expiryDate, createDate, 100.0, 10);
        controlQuality.distribution(cheese);
        assertThat(trash.getFoods().contains(cheese)).isTrue();
    }

    @Test
    public void whenDispatchWarehouse() {
        expiryDate = LocalDate.now().plusDays(28);
        createDate = LocalDate.now().minusDays(3);
        Food fish = new Fish("Fish", expiryDate, createDate, 100.0, 10);
        controlQuality.distribution(fish);
        assertThat(warehouse.getFoods().contains(fish)).isTrue();
    }

    @Test
    public void whenDispatchWithShopDiscount() {
        expiryDate = LocalDate.now().plusDays(5);
        createDate = LocalDate.now().minusDays(20);
        Food fish = new Fish("Fish", expiryDate, createDate, 150.0, 50);
        controlQuality.distribution(fish);
        assertThat(shop.getFoods().contains(fish)).isTrue();
        assertThat(fish.getPrice()).isEqualTo(75);
    }

    @Test
    public void whenTwoProductInShopButOneDiscount() {
        Food fish = new Fish("Fish", LocalDate.now().plusDays(20),
                LocalDate.now().minusDays(30), 120.0, 50);
        Food cheese = new Cheese("Cheese", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(25), 150.0, 30);
        controlQuality.distribution(fish);
        controlQuality.distribution(cheese);
        assertThat(shop.getFoods().contains(fish)).isTrue();
        assertThat(shop.getFoods().contains(cheese)).isTrue();
        assertThat(fish.getPrice()).isEqualTo(120);
        assertThat(cheese.getPrice()).isEqualTo(105);
    }
}