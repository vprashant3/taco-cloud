package sia.tacocloud;

import com.algorithms.PeakFinder;
import com.datastructures.DynamicArray;

import com.datastructures.Stack;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@SpringBootApplication
@EnableSwagger2
public class TacoCloudApplication<T> {

    public static void main(String[] args) {
        //SpringApplication.run(TacoCloudApplication.class, args);

        Stack<String> stringStack = new Stack<>();
        stringStack.push("first");
        stringStack.push("second");
        stringStack.pop();
        System.out.println(stringStack.size());


    }

}
