package sia.tacocloud;

import com.datastructures.DynamicArray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@SpringBootApplication
@EnableSwagger2
public class TacoCloudApplication<T> {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);

        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.add("hi");



    }

}
