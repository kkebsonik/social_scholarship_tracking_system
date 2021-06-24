import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InsertIntoFrame extends JFrame{//окно с формой заполнения информации о студенте

    //переменные для полей
    JTextField nameField, facultyField, courseField, groupField, dateField;
    //переменные, вводимые пользователем
    public String nameBD, facultyBD, courseBD, groupBD, dateBD;

    public InsertIntoFrame() {
        setVisible(false);
        setSize(400, 500);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //первое поле - ФИО
        Box box1 = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("ФИО:");
        nameField = new JTextField(50); //ограничение в 50 знаков
        box1.add(nameLabel);
        box1.add(Box.createHorizontalStrut(6));//отступ
        box1.add(nameField);

        //считываемая строка, ФИО
        nameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameBD =  nameField.getText();
            }
        });

        //второе поле - факультет
        Box box2 = Box.createHorizontalBox();
        JLabel facultyLabel = new JLabel("Факультет:");
        box2.add(facultyLabel);
        box2.add(Box.createHorizontalStrut(6));
        //добавление плавающего списка для удобства и выбора
        String[] falultyElements = new String[] {"ЕГФ", "ИПФ", "ИФФ", "ПиМНО", "ППФ", "ФИЯ", "ФКиС", "ФМФ"};
        JComboBox facultyCombo = new JComboBox(falultyElements);
        box2.add(facultyCombo);

//        facultyField.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
////                facultyBD =  facultyField.getText();
//            }
//        });

        //третье поле - курс, аналогично факультету
        Box box3 = Box.createHorizontalBox();
        JLabel courseLabel = new JLabel("Курс:");
        box3.add(courseLabel);
        box3.add(Box.createHorizontalStrut(6));
        String[] courseElements = new String[] {"1", "2", "3", "4", "5"};
        JComboBox courseCombo = new JComboBox(courseElements);
        box3.add(courseCombo);

//        courseField.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                courseBD =  courseField.getText();
//            }
//        });

        //четвертое поле - группа, аналогично ФИО, ограничение в 10 знаков
        Box box4 = Box.createHorizontalBox();
        JLabel groupLabel = new JLabel("Группа:");
        groupField = new JTextField(10);
        box4.add(groupLabel);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(groupField);

        groupField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

//                groupBD =  groupField.getText();
            }
        });


        //пятое поле - дата, аналогично ФИО и группе, ограничение в 10 знаков
        Box box5 = Box.createHorizontalBox();
        JLabel dateLabel = new JLabel("Дата:");
        dateField = new JTextField(10);
        box5.add(dateLabel);
        box5.add(Box.createHorizontalStrut(6));
        box5.add(dateField);

        dateField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dateBD =  dateField.getText();
            }
        });

        //шестое поле - кнопки ок и отмена
        Box box6 = Box.createHorizontalBox();
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Отмена");
        box6.add(Box.createHorizontalGlue());
        box6.add(ok);
        box6.add(Box.createHorizontalStrut(12));
        box6.add(cancel);

        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Database.queryInsertInto(nameBD, //ссылка на метод insert into в классе подключения к бд
                            facultyBD,
                            courseBD,
                            groupBD,
                            dateBD);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });



        //установление одинакового размера, по самому большому полю - ФИО
        nameLabel.setPreferredSize(facultyLabel.getPreferredSize());
        courseLabel.setPreferredSize(facultyLabel.getPreferredSize());
        groupLabel.setPreferredSize(facultyLabel.getPreferredSize());
        dateLabel.setPreferredSize(facultyLabel.getPreferredSize());


        //создание бокса для того, чтобы все поля соединить и вывести на окне
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));

        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(10));

        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(10));

        mainBox.add(box3);
        mainBox.add(Box.createVerticalStrut(10));

        mainBox.add(box4);
        mainBox.add(Box.createVerticalStrut(10));

        mainBox.add(box5);
        mainBox.add(Box.createVerticalStrut(10));

        mainBox.add(box6);

        setContentPane(mainBox);
        pack();
        setResizable(false);


        add(panel);
    }

}
