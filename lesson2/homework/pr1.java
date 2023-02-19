// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

package lesson2.homework;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class pr1 {
    private static String request = "select * from students where ";
    private static String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

    public static void main(String[] args) {
        System.out.println(request + getParams(json));
    }

    private static String getParams(String json) {
        var result = new ArrayList<String>();
        var find = Pattern
                .compile("\"[^,]+\":\"[^,]+\"")
                .matcher(json)
                .results()
                .map(MatchResult::group);
        find.forEach(s -> {
            var data = s.replace("\"", "").split(":");
            if (!Objects.equals(data[1], "null")) result.add(data[0] + "=\"" + data[1] + "\"");
        });
        return String.join(" AND ", result);
    }
}