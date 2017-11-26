import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class Panel extends JPanel {

    private JButton numbers[] = new JButton[10];
    private Font font = new Font("SanSerif",Font.BOLD,20);//Параметры текста
    private JTextField output = new JTextField();
    private JButton bacspace = new JButton("<"), equ = new JButton("=");
    private JButton plus = new JButton("+"),mius = new JButton("-"),multi = new JButton("*"),div = new JButton("/");

        public Panel()
        {
            setLayout(null);
            setFocusable(true);
            //grabFocus();

            bacspace.setBounds(10,250,50,50);
            bacspace.setFont(font);
            add(bacspace);

            equ.setBounds(130,250,50,50);
            equ.setFont(font);
            add(equ);

            plus.setBounds(190,70,50,50);
            plus.setFont(font);
            add(plus);

            mius.setBounds(190,130,50,50);
            mius.setFont(font);
            add(mius);

            multi.setBounds(190,190,50,50);
            multi.setFont(font);
            add(multi);

            div.setBounds(190,250,50,50);
            div.setFont(font);
            add(div);

            numbers[0] = new JButton("0");
            numbers[0].setBounds(70,250,50,50);
            numbers[0].setFont(font);//подкл стиль текста
            add(numbers[0]);

            for(int x=0;x<3;x++)//Делаем кнопки через цикл
            {
                for(int y=0;y<3;y++)
                {
                    numbers[x*3+y+1]= new JButton((x*3+y+1)+"");
                    numbers[x*3+y+1].setBounds(x*(50+10)+10,y*(50+10)+70,50,50);
                    numbers[x*3+y+1].setFont(font);
                    add(numbers[x*3+y+1]);

                }
            }

            output.setBounds(10,10,230,50);
            output.setFont(font);
            output.setEnabled(false);//В окне нельзя изменять
            add(output);

            ActionListener l = (ActionEvent e ) ->
            {
                JButton b = (JButton)e.getSource();
                output.setText(output.getText()+b.getText());
            };

            for(JButton b : numbers)
            {
                b.addActionListener(l);
            }

            addKeyListener(new KeyAdapter()
            {
                @Override
                 public void keyPressed(KeyEvent e)
                {
                    char symvol = e.getKeyChar();

                    if(!Character.isDigit(symvol))
                    {
                        return;
                    }
                    output.setText(output.getText()+symvol);
                }
            });

        }

}
