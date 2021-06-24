import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class Database { // класс для подключения к бд
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/accounting_system", "postgres", "171615");
//сверху переменная, через которую осуществляется подключение через хост, порт и название бд
//снизу функция отключения программы от бд по закрытию программы
        connection.close();
        try { //функция на случай того, что бд с нужным названием не найдется
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
    }
//метод запроса insert into для ввода данных о студенте
    public static void queryInsertInto(String name, String faculty, String course, String group, String date) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/accounting_system", "postgres", "171615");
        Statement st = connection.createStatement(); //спец переменная для запроса
        st.executeUpdate("INSERT Into students" + "VALUES (name, faculty, course, group, date)"); //функция, переделывающая строку в запрос
    }

//метод запроса на выборку
    public static void querySelect() {
        ArrayList selectList = new ArrayList(); //переменная для списка

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/accounting_system", "postgres", "171615");
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM students")) { //переменная для функии, запрашивающей выборку всех записей в таблице

            if (rs.next()) {
                selectList.add(rs.getString(1)); //функция, добавляющая след строку из таблицы в список
            }

        } catch (SQLException ex) { //обработка ошибок и прерываний

        }
    }
}
