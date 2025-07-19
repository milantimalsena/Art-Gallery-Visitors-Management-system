import java.awt.*;
import javax.swing.*;

class SwingLayout {

    /**
            Declare instance variables so that they can be accessed throughout the class
    */
    private JFrame frame;
    private JPanel mainPanel, buttonPanel, formPanel, outputPanel;
    private JLabel nameLabel, emailLabel, addressLabel, phoneLabel, courseLabel, dateLabel;
    private JTextField nameField, emailField, addressField, phoneField;

    private JRadioButton bbaRadioButton, bitRadioButton;
    private JComboBox<String> dayComboBox, monthComboBox, yearComboBox;

    /**
     * Initialize the months array with the names of months
     */
    private String[] months = { "Baisakh", "Jestha", "Asar" };

    /** Code written here will be executed when the class is instantiated */
    public SwingLayout() {
        frame = new JFrame("Swing Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); //  Center windows on the screen

        /*
            Initialize panels rquired for the layout
        */
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        formPanel = new JPanel();
        outputPanel = new JPanel();

        /*
            Set layout managers for each panel
        */
        mainPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout());
        formPanel.setLayout(new GridBagLayout());
        outputPanel.setLayout(new BorderLayout());

        /*
            Create a border for the panel
            To create different types of borders, refer to the BorderFactory class documentation.
            https://docs.oracle.com/javase/8/docs/api/javax/swing/BorderFactory.html
        */
        mainPanel.setBorder(BorderFactory.createTitledBorder("Main Panel"));

        /*
            Button panel is for inserting buttons. Since the layout for button panel is flow layout, component will be placed automatically as buttons are added.
        */
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Button Panel"));
        buttonPanel.add(new JButton("Add Student"));
        buttonPanel.add(new JButton("Save to File"));
        buttonPanel.add(new JButton("Display"));
        buttonPanel.add(new JButton("Deactivate"));

        /* Panel for form input is created separately. It uses gridbag layout so that component can be placed on different positions easily. */
        formPanel.setBorder(BorderFactory.createTitledBorder("Form Panel"));

        /* All components must have constraints so that they can be placed on location with constraints */
        GridBagConstraints gbc = new GridBagConstraints();

        /* Insets is used for padding between components. */
        /* The given values are in order T, L, B, R */
        gbc.insets = new Insets(50, 5, 10, 5); // T, L, B, R

        //This propery applies to all components below this declaration
        gbc.ipady = 50;

        // Anchor is used for placing content/component to certain position within container.
        // https://docs.oracle.com/javase/8/docs/api/java/awt/GridBagConstraints.html
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        gbc.anchor = GridBagConstraints.LINE_END;

        nameLabel = new JLabel("Name OF THE STUDENT:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(nameLabel, gbc);

        emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(emailLabel, gbc);

        phoneLabel = new JLabel("Phone:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(phoneLabel, gbc);

        addressLabel = new JLabel("Address:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(addressLabel, gbc);

        gbc.anchor = GridBagConstraints.LINE_END;
        nameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(nameField, gbc);

        emailField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(emailField, gbc);

        phoneField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipady = 10;
        formPanel.add(phoneField, gbc);

        addressField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        formPanel.add(addressField, gbc);

        courseLabel = new JLabel("Course:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(courseLabel, gbc);

        bbaRadioButton = new JRadioButton("BBA");
        gbc.gridx = 1;
        gbc.gridy = 4;
        formPanel.add(bbaRadioButton, gbc);

        bitRadioButton = new JRadioButton("BIT");
        gbc.gridx = 2;
        gbc.gridy = 4;
        formPanel.add(bitRadioButton, gbc);

        /* When button group is used, it ensures that only one option can be selected at a time */
        ButtonGroup courseGroup = new ButtonGroup();
        courseGroup.add(bbaRadioButton);
        courseGroup.add(bitRadioButton);

        dateLabel = new JLabel("Date:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(dateLabel, gbc);

        /* Add values for year that you want to include as option for combobox */
        yearComboBox = new JComboBox<>(new String[] { "2023", "2024", "2025" });
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        formPanel.add(yearComboBox, gbc);

        monthComboBox = new JComboBox<>(months);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 5;
        formPanel.add(monthComboBox, gbc);

        dayComboBox = new JComboBox<>(new String[] { "1", "2", "3" });
        gbc.gridx = 3;
        gbc.gridy = 5;
        formPanel.add(dayComboBox, gbc);

        /* Output panel includes textarea which can be used to display output */
        outputPanel.setBorder(BorderFactory.createTitledBorder("Output Panel"));
        outputPanel.setLayout(new BorderLayout());

        outputPanel.add(new JTextArea(5, 20), BorderLayout.CENTER);

        /* Now add all panels to frame */
        frame.add(mainPanel);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(formPanel, BorderLayout.EAST);
        mainPanel.add(outputPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Call constructor to execute above code
        new SwingLayout();
    }
}