package sia.tacocloud;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
@EnableSwagger2
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);

        Scanner s = new Scanner(System.in);
        int input = Integer.valueOf(s.nextLine());


    }








}
