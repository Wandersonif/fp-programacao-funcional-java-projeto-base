package exercicios;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamNumericas {
    void main(){
//         var list = IntStream.iterate(0, i -> i + 2)
//                .limit(10)
//                .mapToObj(i -> new Sensor(i, i * 2))
//                .toList();
//        System.out.println(list);
        new Random().ints()
                    .takeWhile(i -> i < 20 )
                    .forEach(System.out::println);

    }
}
