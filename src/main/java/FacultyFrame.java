import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacultyFrame extends JFrame {//окно с выбором факультета

    //кнопка ок и окнос выводом списка
    private JButton buttonOk;
    private ListFrame listFrame;

    private DefaultListModel<String> faculty = new DefaultListModel<String>();//спец переменная для вывода списка факультетов
    private final String[] data = { "ФМФ","ФКиС","ИФФ","ЕГФ"};

    public FacultyFrame() {
        setVisible(false);
        setSize(200, 250);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        //добавление названий факультетов в переменную-список
        for (String string : data) {
            faculty.add(0, string);
        }

        JList<String> list = new JList<String>(faculty);

        buttonOk = new JButton("OK");
        buttonOk.setSize(100, 50);
        buttonOk.setAlignmentX(JComponent.CENTER_ALIGNMENT);


        listFrame = new ListFrame();
        buttonOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                listFrame.setVisible(true);
            }

        });


        panel.add(new JScrollPane(list));
        panel.add(buttonOk);
        add(panel);
    }
}
