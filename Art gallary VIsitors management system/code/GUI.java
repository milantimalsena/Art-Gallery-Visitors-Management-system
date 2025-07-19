import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.*;

class GUI {
    // LA GUI Banaidim nata

    private JFrame frame;
    private JPanel mainPanel, buttonPanel, formPanel,aarkoformPanel, outputPanel;
    private JLabel visitoridlabel, nameLabel,gender,registrationdatLabel,tickettype,ticketpricLabel,artworknameLabel,artworkpricLabel,cancelationLabel,emailLabel,  phoneLabel;
    private JTextField visitoridField, nameField, emailField, cancelationField,  phoneField,ticketpriceField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JButton addvisitorButton, logButton, buyButton, checkupgradeButton,
            AssignpersonaladviserButton, calculatediscountButton, rewardButton, cancelButton,
            clearButton, saveButton, ReadButton,detailsButton, generatebillButton;
    
    private JComboBox<String> ticketTypeComboBox;
    
    private JTextArea outputArea;
    private String[] ticketTypes = {"Standard", "Elite"};
    private int[] ticketprices = {1000, 2000};

     private JComboBox<String> dayComboBox, monthComboBox, yearComboBox;
    private String[] months = {"Baisakh", "Jestha", "Asar", "Shrawan", "Bhadra", "Ashwin", "Kartik", "Mangsir", "Poush", "Magh", "Falgun", "Chaitra"};
   
    private String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                             "11", "12", "13", "14", "15", "16", "17", "18",
                             "19", "20", "21", "22", "23", "24", "25", "26",
                             "27", "28", "29", "30", "31","32"};


//Index ganera kina hairan garnu final-initial+1 garda aaihalxa ni (saugat sir le vannu vako lazy harle naya kuro khojxan re)

   int years[]= new int[2082-1990+1];{

for (int i = 1990; i <= 2082; i++) {
    years[i - 1990] = i;
}

   }

   public  GUI(){
    
   frame= new JFrame("Art Gallery");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(1400, 800);
   frame.setIconImage(Toolkit.getDefaultToolkit().getImage("me.png")); // Set the icon image
    frame.setResizable(false); // Disable resizing
    frame.setLocationRelativeTo(null); 
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBorder(BorderFactory.createTitledBorder("Art Gallery Management System"));
    frame.add(mainPanel);

    buttonPanel = new JPanel();
    // buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10)); // 4 rows, 4 columns with gaps
    buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

    buttonPanel.setPreferredSize(new Dimension(800, 200));
    buttonPanel.setBackground(Color.LIGHT_GRAY);
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    buttonPanel.setBorder(BorderFactory.createTitledBorder("Buttons"));
    addvisitorButton = new JButton("Add Visitor");
    logButton = new JButton("Log Visit");
    buyButton = new JButton("Buy Product");
    checkupgradeButton = new JButton("Check Upgrade");
    AssignpersonaladviserButton = new JButton("Assign Personal Adviser");
    calculatediscountButton = new JButton("Calculate Discount");
    rewardButton = new JButton("Reward points");
    cancelButton = new JButton("Cancel product");
    clearButton = new JButton("Clear All");
    saveButton = new JButton("Save to file");
    ReadButton = new JButton("Read from file");
    detailsButton = new JButton("Visitor Details");
    generatebillButton = new JButton("Generate Bill");
    



    // Button add garako screen ma dekhine
    buttonPanel.add(addvisitorButton);
    buttonPanel.add(logButton);
    buttonPanel.add(buyButton);
    buttonPanel.add(checkupgradeButton);
    buttonPanel.add(AssignpersonaladviserButton);
    buttonPanel.add(calculatediscountButton);
    buttonPanel.add(rewardButton);
    buttonPanel.add(cancelButton);
    buttonPanel.add(clearButton);
    buttonPanel.add(saveButton);
    buttonPanel.add(ReadButton);
    buttonPanel.add(detailsButton);
    buttonPanel.add(generatebillButton);


      // Form panel for input fields
    formPanel = new JPanel();
    formPanel.setLayout(new GridBagLayout());
    formPanel.setBorder(BorderFactory.createTitledBorder("Form Panel"));
 
    formPanel = new JPanel();
    formPanel.setLayout(new GridBagLayout());
    formPanel.setBorder(BorderFactory.createTitledBorder("Visitor Information"));
   


       GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(15, 10, 20, 10); //
    gbc.ipady = 10; //padding deko
   
    
    //Visiitor IDko lagi label ra text field
    // visitoridlabel = new JLabel("Visitor ID:");
    // gbc.gridx = 0;
    // gbc.gridy = 0;
    

     //registration date ko lagi.
    registrationdatLabel  = new JLabel("Registration Date:");
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.LINE_START;
    gbc.fill = GridBagConstraints.NONE;
    formPanel.add(registrationdatLabel, gbc);
    // Date ko lagi combo boxes
    dayComboBox = new JComboBox<>(days);
    dayComboBox.setSelectedIndex(0);
    monthComboBox = new JComboBox<>(months);
    monthComboBox.setSelectedIndex(0); // Default to first month
    yearComboBox = new JComboBox<>();
    for (int year : years) {
        yearComboBox.addItem(String.valueOf(year));
    }
    yearComboBox.setSelectedIndex(92); // Default to 2082
    gbc.gridx = 3;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.LINE_START;
    gbc.fill = GridBagConstraints.NONE;

    formPanel.add(dayComboBox, gbc);
    gbc.gridx = 2;  
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL; // Month combo box lai horizontal fill garne
    gbc.anchor = GridBagConstraints.LINE_START; // Month combo box lai left align garne
    formPanel.add(monthComboBox, gbc);
    gbc.gridx = 1;
    gbc.gridy = 0;
    formPanel.add(yearComboBox, gbc);


    // formPanel.add(visitoridlabel, gbc);
    visitoridlabel = new JLabel("Visitor Id:");
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(visitoridlabel, gbc);

    visitoridField = new JTextField(15);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.LINE_START;// Text field lai left align garne (suru bata)

    gbc.fill = GridBagConstraints.HORIZONTAL; // Text field lai horizontal fill garne
    gbc.weightx = 1.0; // Text field lai extra space dinchha
    formPanel.add(visitoridField, gbc);


    // Name ko lagi label ra text field
    nameLabel = new JLabel("Name:");
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(nameLabel, gbc);
    nameField = new JTextField(15);
    gbc.gridx = 1;
    gbc.gridy = 2;
    
    formPanel.add(nameField, gbc);

   

    //contact no ko lagi
    phoneLabel= new JLabel("Contact number:");
    gbc.gridx=3;
    gbc.gridy=3;
    gbc.anchor = GridBagConstraints.LINE_START;
   formPanel.add(phoneLabel,gbc);

   phoneField = new JTextField(15);
   gbc.gridx=4;
   gbc.gridy=3;
   gbc.anchor = GridBagConstraints.LINE_START;
   formPanel.add(phoneField,gbc);

    //Email ko lagi label ra text field
    emailLabel = new JLabel("Email:");
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(emailLabel, gbc);
    emailField = new JTextField(15);
    gbc.gridx = 1;
    gbc.gridy = 3;
    formPanel.add(emailField, gbc);

    //Gender ko lagi label ra radio buttons
    gender = new JLabel("Gender");
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(gender, gbc);

    ButtonGroup genderGroup = new ButtonGroup();
    JRadioButton maleRadioButton = new JRadioButton("Male");
    JRadioButton femaleRadioButton = new JRadioButton("Female");
    genderGroup.add(maleRadioButton);
    genderGroup.add(femaleRadioButton);
    gbc.gridx = 1;
    gbc.gridy = 4;

    gbc.anchor = GridBagConstraints.LINE_START; // Radio buttons lai left align garne
    formPanel.add(maleRadioButton, gbc);
    
    gbc.fill = GridBagConstraints.HORIZONTAL; // Radio buttons lai horizontal fill garne
    gbc.gridx = 2;
    gbc.gridy = 4;
    formPanel.add(femaleRadioButton, gbc);

    maleRadioButton.setBackground(Color.lightGray);
    femaleRadioButton.setBackground(Color.lightGray);


    //ticket type ko lagi label ra combo box
    tickettype = new JLabel("Ticket Type:");
    gbc.gridx = 3;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(tickettype, gbc);
    ticketTypeComboBox = new JComboBox<>(ticketTypes);
    ticketTypeComboBox.setSelectedIndex(0); // Default to "Standard"
    gbc.gridx = 4;
    gbc.gridy = 1;
    formPanel.add(ticketTypeComboBox, gbc);

    


    
    //Ticket price ko lagi label
    ticketpricLabel = new JLabel("Ticket price:");
    gbc.gridx = 3;
    gbc.gridy = 2;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(ticketpricLabel, gbc);

    ticketpriceField =new JTextField(15);
    gbc.gridx =4;
    gbc.gridy =2;
     gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(ticketpriceField, gbc);

    //Artwork name ko lagi label ra text field
    artworknameLabel = new JLabel("Artwork Name:");
    gbc.gridx =0;
    gbc.gridy = 5;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(artworknameLabel, gbc);
    JTextField artworkNameField = new JTextField(15);
    gbc.gridx = 1;
    gbc.gridy = 5;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(artworkNameField, gbc);

    //Artwork price ko lagi label ra text field
    artworkpricLabel = new JLabel("Artwork Price:");
    gbc.gridx = 3;
    gbc.gridy = 5;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(artworkpricLabel, gbc);
    JTextField artworkPriceField = new JTextField(15);
    gbc.gridx = 4;
    gbc.gridy = 5;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(artworkPriceField, gbc);




    // //registration date ko lagi.
    // registrationdatLabel  = new JLabel("Registration Date:");
    // gbc.gridx = 4;
    // gbc.gridy = 3;
    // gbc.anchor = GridBagConstraints.LINE_START;
    // formPanel.add(registrationdatLabel, gbc);
    // // Date ko lagi combo boxes
    // dayComboBox = new JComboBox<>(days);
    // dayComboBox.setSelectedIndex(0); // Default to first day
    // monthComboBox = new JComboBox<>(months);
    // monthComboBox.setSelectedIndex(0); // Default to first month
    // yearComboBox = new JComboBox<>();
    // for (int year : years) {
    //     yearComboBox.addItem(String.valueOf(year));
    // }
    // yearComboBox.setSelectedIndex(92); // Default to first year
    // gbc.gridx = 5;
    // gbc.gridy = 3;
    // gbc.anchor = GridBagConstraints.LINE_START;
    // formPanel.add(dayComboBox, gbc);
    // gbc.gridx = 6;  
    // gbc.gridy = 3;
    // formPanel.add(monthComboBox, gbc);
    // gbc.gridx = 7;
    // gbc.gridy = 3;
    // formPanel.add(yearComboBox, gbc);


    aarkoformPanel = new JPanel();
    aarkoformPanel.setLayout(new GridBagLayout());
    
     cancelationLabel = new JLabel("Cancelation Reason:");
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.LINE_START;
    aarkoformPanel.add(cancelationLabel, gbc);
    cancelationField = new JTextField(15);
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.LINE_START; // Text field lai left align garne
    gbc.fill = GridBagConstraints.HORIZONTAL; // Text field lai horizontal fill garne
    aarkoformPanel.add(cancelationField, gbc);

    // Cancelation reason ko lagi label ra text field
    cancelationLabel = new JLabel("Cancelation Reason");
    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(cancelationLabel, gbc);

    cancelationField = new JTextField();
    gbc.gridx = 1;
    gbc.gridy = 6;
    gbc.anchor = GridBagConstraints.LINE_START; // Text field lai left align garne
    gbc.fill = GridBagConstraints.HORIZONTAL; // Text field lai horizontal fill garne
    formPanel.add(cancelationField, gbc);


   


    










// Output panel
    outputPanel = new JPanel();
    outputPanel.setLayout(new BorderLayout());
    outputPanel.setBorder(BorderFactory.createTitledBorder("Display "));
    outputArea = new JTextArea(20, 50);

    //css deko 
    outputArea.setBackground(Color.WHITE);
    outputArea.setForeground(Color.BLACK);
    outputArea.setFont(new Font("Arial", Font.PLAIN, 17));
   
 
    JScrollPane scrollPane = new JScrollPane(outputArea);
    outputPanel.add(scrollPane, BorderLayout.CENTER);
    outputPanel.setPreferredSize(new Dimension(650, 640));
    outputPanel.setBackground(Color.gray);

   


     // mainPanel vitra aru panel lai arrange garya
    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

    mainPanel.add(formPanel, BorderLayout.WEST);
    //  formPanel.setPreferredSize(new Dimension(540, 640));
    formPanel.setBackground(Color.lightGray);
    

    // formPanel.add(aarkoformPanel, BorderLayout.SOUTH);
 

    mainPanel.add(outputPanel, BorderLayout.EAST);







  



   
 frame.setVisible(true);
}

public static void main(String[] args) {
        // Call constructor to execute above code
        new GUI();
    }
}


