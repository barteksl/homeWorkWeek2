package pl.barss.zadanie1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.tags.EvalTag;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Service
public class ProductService {

    private Product product;
    private ProductInfo productInfo;

    private List<Product> productList;

    private static DecimalFormat df = new DecimalFormat("0.00");

    private Double randomValue(){
        int min = 50;
        int max = 300;

        Double price = Math.random() * (max - min + 1) + min;
        price = (double) Math.round(price*100)/100;
        return price;
    }

    @Autowired
    public ProductService(Product product, ProductInfo productInfo) {

        this.product = product;
        this.productInfo = productInfo;


        Product product1 = new Product("Graphics Card",randomValue());
        Product product2 = new Product("Mouse",randomValue());
        Product product3 = new Product("Monitor",randomValue());
        Product product4 = new Product("SSD Disk",randomValue());
        Product product5 = new Product("RAM Memory",randomValue());
        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void info(){
       productInfo.showProducts(productList);
    }
}
