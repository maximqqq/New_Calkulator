import javax.swing.*;

public class App {

    private JFrame window;
    public App()
    {
        window = new JFrame("КАЛЬКУЛЯТОР");
        window.setSize(250,337);
        window.add(new Panel());
        window.setLocationRelativeTo(null);//Расположение по центу
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Выход на кркстик
        window.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });


    }

}
