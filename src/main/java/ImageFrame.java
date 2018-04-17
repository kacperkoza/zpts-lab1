import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ImageFrame {

    public ImageFrame(String fileName) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(new JLabel(new ImageIcon(fileName)));
        jFrame.show();
    }

}
