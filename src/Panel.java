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
//    String op = "";
    double temp = 0;

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

            ActionListener l = (ActionEvent e ) ->//Лямдо вырожение Для сокрощ кода тоже что и итреф
            {
                JButton b = (JButton)e.getSource();//getSource() возвращает ссылку на объект, от которого пришло событие пруф
                output.setText(output.getText()+b.getText());
            };




// //===========КНОПКИ с ЧИСЛАМИ====================
//
//
// //--------ДЕЙСТВИЕ С ОПЕРАЦИЯМИ-----------
//            //------------------
//            plus.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    char op = '+';
//                    double temp = Double.valueOf(output.getText());
//
//                    output.setText("");
//                }});
//
//            mius.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    char op = '-';
//                    double temp = Double.valueOf(output.getText());
//                    output.setText("");
//                }});
//
//            multi.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    char op = '*';
//                    double temp = Double.valueOf(output.getText());
//                    output.setText("");
//                }});
//
//            div.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    char op = '/';
//                    double temp = Double.valueOf(output.getText());
//                    output.setText("");
//                }});

//            equ.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    char op;
//                    op = '+';
//                    op = '-';
//                    op = '*';
//                    op = '/';
//                    switch (op)
//                    {
//                        case '+':output.setText(String.valueOf(temp+Double.valueOf(output.getText()))); break;
//                        case '-':output.setText(String.valueOf(temp-Double.valueOf(output.getText()))); break;
//                        case '*':output.setText(String.valueOf(temp*Double.valueOf(output.getText()))); break;
//                        case '/':output.setText(String.valueOf(temp/Double.valueOf(output.getText()))); break;
//                    }
//                }});


                //-----------FINE---------------

            for(JButton b : numbers)
            {
                b.addActionListener(l);
            }


//ВОЗВРАТ НА НАЖАТИЕ кНОПКИ
            addKeyListener(new KeyAdapter()
            {
                @Override
                 public void keyPressed(KeyEvent e)
                {
                    char symvol = e.getKeyChar();
                    if(e.getKeyChar() == '+' ||  //Исключение ввода знаков
                            e.getKeyChar() == '-' ||
                               e.getKeyChar() == '*' ||
                                  e.getKeyChar() == '/'){output.setText("");}
                    if(!Character.isDigit(symvol))//запрет на все символы кроме числовых
                    {
                        return;
                    }

                    output.setText(output.getText()+symvol);
                }
            });







        }

}
