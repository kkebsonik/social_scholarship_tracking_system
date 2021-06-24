import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    public class MainFrame extends JFrame { //главное окно, самое первое
        private JButton button1; //кнопки
        private JButton button2;
        private ChoiceFrame choiceFrame; //переменная следующего окна - с выбором вывода списка
        private InsertIntoFrame insertIntoFrame; //переменная след окна - с формой для внесения информации о студенте


        public MainFrame() {
            setSize(200, 200);//размер окна
            JPanel panel = new JPanel(); //панель окна, на которую добавляются элементы
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));//расположение по середине

            button1 = new JButton("Посмотреть список");//кнопка
            button1.setSize(100, 50);//размер
            button1.setAlignmentX(JComponent.CENTER_ALIGNMENT);//расположение

            button2 = new JButton("Добавить студента");
            button2.setSize(100, 50);
            button2.setAlignmentX(JComponent.CENTER_ALIGNMENT);



            choiceFrame = new ChoiceFrame();//создание ссылки на след окно по клику первой кнопки
            button1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    //след окно становится видимым
                    choiceFrame.setVisible(true);
                }

            });


            insertIntoFrame = new InsertIntoFrame();//аналогично, что сверху
            button2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // Делаем видимым второе окно
                    insertIntoFrame.setVisible(true);
                }

            });

//добавление кнопок на панель, панель становится видимой
            panel.add(button1);
            panel.add(button2);
            add(panel);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() { //запуск программы
                    new MainFrame();
                }
            });
        }
    }

