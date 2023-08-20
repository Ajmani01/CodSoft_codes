import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Project3{

    private JFrame frame;
    private JLabel textLabel;
    private JTextField userInput;
    private JButton countButton;
    private JButton fileButton;

    public Project3() {
        frame = new JFrame("Word Counter");
        frame.setLayout(new FlowLayout());

        textLabel = new JLabel("Enter text:");
        frame.add(textLabel);

        userInput = new JTextField(20);
        frame.add(userInput);

        countButton = new JButton("Count");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = userInput.getText();
                int wordCount = countWords(text);
                JOptionPane.showMessageDialog(frame, "Total words count: " + wordCount);
            }
        });
        frame.add(countButton);

        fileButton = new JButton("Count from file");
        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = JOptionPane.showInputDialog(frame, "Enter the file path:");
                String text = readFromFile(filePath);
                int wordCount = countWords(text);
                JOptionPane.showMessageDialog(frame, "Total words count: " + wordCount);
            }
        });
        frame.add(fileButton);

        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Project3();
    }

    private static int countWords(String text) {
        String[] words = text.split("\\s+|\\p{Punct}");
        return words.length;
    }

    private static String readFromFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            System.out.println("Error reading the file. Please check the file path.");
            return "";
        }
    }
}