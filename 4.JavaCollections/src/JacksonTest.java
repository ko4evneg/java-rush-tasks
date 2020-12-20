import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;

public class JacksonTest {
    public static void main(String[] args) throws IOException, IOException {
        //создание объекта для сериализации в JSON
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        //писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //это объект Jackson, который выполняет сериализацию
        ObjectMapper mapper = new ObjectMapper();

        // сама сериализация: 1-куда, 2-что
        mapper.writeValue(writer, cat);

        //преобразовываем все записанное во StringWriter в строку
        String result = writer.toString();
        System.out.println(result);
    }
}
@JsonAutoDetect
class Cat implements Serializable {
    @JsonProperty("alias")
    public String name;
    public int age;
    @JsonIgnore
    public int weight;

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
