package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager productManager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Two captains", 1450, "Veniamin Kaverin");
    private Book secondBook = new Book(2, "Purple ball", 950, "Kir Bulychev");
    private Book thirdBook = new Book(3, "Shadow play", 950, "Kir Bulychev");
    private Smartphone firstSmatrphone = new Smartphone(1, "Redmi Note 10", 26990, "Xiaomi");
    private Smartphone secondSmatrphone = new Smartphone(2, "Galaxy S10 8", 24888, "Samsung");
    private Smartphone thirdSmatrphone = new Smartphone(3, "Redmi 9A", 7990, "Xiaomi");

    @BeforeEach
    void setUp() {
        productManager.add(firstBook);
        productManager.add(secondBook);
        productManager.add(thirdBook);
        productManager.add(firstSmatrphone);
        productManager.add(secondSmatrphone);
        productManager.add(thirdSmatrphone);
    }

    @Test
    public void shouldSearchByBookAuthor() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = productManager.searchBy("Veniamin Kaverin");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookName() {
        Product[] expected = new Product[]{secondBook};
        Product[] actual = productManager.searchBy("Purple ball");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneManufacturer() {
        Product[] expected = new Product[]{secondSmatrphone};
        Product[] actual = productManager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneName() {
        Product[] expected = new Product[]{secondSmatrphone};
        Product[] actual = productManager.searchBy("Galaxy S10 8");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundBook() {
        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy("Nokia");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTheSameBookAuthor() {
        Product[] expected = new Product[]{secondBook,thirdBook};
        Product[] actual = productManager.searchBy("Kir Bulychev");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTheSameSmartphoneManufacturer() {
        Product[] expected = new Product[]{firstSmatrphone,thirdSmatrphone};
        Product[] actual = productManager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }
}