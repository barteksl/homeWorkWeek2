package pl.barss.zadanie1;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.List;

@Component
@Profile("start")
public class ProductInfoStart implements ProductInfo{

    private static DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public void getInfo() {
        System.out.println("ProductInfoStart");
    }

    @Override
    public void showProducts(List<Product> productList) {

        Double total = 0.00;
        for(Product product: productList){
            total = total + product.getPrice();
            System.out.println("Product: " + product.getName());
            System.out.println("Price:   " + df.format(product.getPrice()));
            System.out.println("-----------------------------");
        }
        System.out.println("-----------------------------");
        System.out.println("Total price: " + df.format(total));
    }
}
