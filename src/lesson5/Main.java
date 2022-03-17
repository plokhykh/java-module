package lesson5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "A1qwerty");

//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT student (name, subject) VALUES ('Igor','java'),"+
//                    "('Mariya', 'java script'), " +
//                    "('Anton', 'python')," +
//                    "('Nikolay', 'java')," +
//                    "('Galina', 'python')," +
//                    "('Nikita', 'java script')");
//
//            preparedStatement.executeUpdate();

            PreparedStatement selectPreparedStatement = connection.prepareStatement("select * from student");
            ResultSet resultSet = selectPreparedStatement.executeQuery();

            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                if(resultSet.getString("subject").equals("java")){
                    students.add(new Student(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("subject")
                    ));
                }
            }
            connection.close();
            System.out.println(students);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

