package sia.tacocloud;

import com.algorithms.PeakFinder;
import com.datastructures.DynamicArray;

import com.datastructures.Stack;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
@EnableSwagger2
public class TacoCloudApplication<T> {

    public static void main(String[] args) {
        //SpringApplication.run(TacoCloudApplication.class, args);
        int[][] table = new int[2][3];
        List<List<Integer>> list = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(2,3,4));
        List<Integer> collect = list.stream().flatMap(List::stream).collect(Collectors.toList());
        collect.stream().filter(s -> s==0).count();


    }

}
