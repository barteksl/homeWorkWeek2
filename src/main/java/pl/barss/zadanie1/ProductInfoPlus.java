package pl.barss.zadanie1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.List;

@Component
@Profile("plus")
public class ProductInfoPlus implements ProductInfo {

    @Value("${shop.vat}")
    private Double vat;

    private static DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public void getInfo() {
        System.out.println("ProductInfoPlus");
    }

    @Override
    public void showProducts(List<Product> productList) {


        Double priceVat;
        Double priceDiscount;
        Double total = 0.00;

        for(Product product: productList){
            total = total + product.getPrice();
            priceVat = product.getPrice() * vat / 100;
            System.out.println("Product: " + product.getName());
            System.out.println("Price:   " + df.format(product.getPrice()) + " vat: " + df.format(priceVat ));
            System.out.println("-----------------------------");
        }
        System.out.println("-----------------------------");
        System.out.println("Total price: " + df.format(total));
    }
}
