import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceFrame extends JDialog { //окно выбора вывода списка

    //кнопки и переменная окна выбора факультета
    private JButton button1;
    private JButton button2;
    private FacultyFrame facultyFrame;


    public ChoiceFrame() {
        setVisible(false);//окно пока не видимо
        setSize(200, 250);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //кнопки
        button1 = new JButton("Посмотреть по факультету");
        button1.setSize(100, 50);
        button1.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        button2 = new JButton("Посмотреть всех");
        button2.setSize(100, 50);
        button2.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        //создание ссылки на окно выбора факультета
        facultyFrame = new FacultyFrame();
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                facultyFrame.setVisible(true);
            }

        });


        panel.add(button1);
        panel.add(button2);
        add(panel);

    }
}

