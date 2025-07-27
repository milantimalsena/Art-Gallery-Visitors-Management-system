/**
 * A graphical user interface (GUI) for managing art gallery visitors and their activities.
 * Provides input fields, buttons, and an output area for interacting with visitor data.
 * @author Milan Timalsena
 */

 import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class ArtGalleryGUI {
    // LA GUI Banaidim nata

    private JFrame frame;
    private JPanel mainPanel, buttonPanel, formPanel,aarkoformPanel, outputPanel;
    private JLabel visitoridlabel, nameLabel,gender,registrationdatLabel,tickettype,ticketpricLabel,artworknameLabel,artworkpricLabel,cancelationLabel,  phoneLabel;
    private JTextField visitoridField, nameField,  phoneField,ticketpriceField;
    private JTextArea cancelationField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JButton addvisitorButton, logButton, buyButton, checkupgradeButton,
            AssignpersonaladviserButton, calculatediscountButton, rewardButton, cancelButton,
            clearButton, saveButton, ReadButton,detailsButton, generatebillButton;
    
    private JComboBox<String> ticketTypeComboBox;
    
    private JTextArea outputArea;
    private String[] ticketTypes = {"Standard", "Elite"};
    private int[] ticketprices = {1000, 2000};

    private List<ArtGalleryVisitor> visitorList = new ArrayList<>(); // Added visitorList

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


   /**
     * Constructs the Art Gallery GUI, setting up the frame, panels, and components.
     */
   public  ArtGalleryGUI(){

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
   
    
    


     //registration date ko lagi.
        registrationdatLabel = new JLabel("Registration Date:");
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(registrationdatLabel, gbc);


     JPanel DatePanel = new JPanel();
     DatePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
     DatePanel.setBackground(Color.lightGray);
    // Date ko lagi combo boxes
    
    //  DatePanel.add(dayComboBox);
    // DatePanel.add(monthComboBox);
    // DatePanel.add(yearComboBox);
    dayComboBox = new JComboBox<>(days);
    dayComboBox.setSelectedIndex(0); 
    monthComboBox = new JComboBox<>(months);
    monthComboBox.setSelectedIndex(0); 
    yearComboBox = new JComboBox<>();
    for (int year : years) {
        yearComboBox.addItem(String.valueOf(year));
    }
    yearComboBox.setSelectedIndex(92); 
    DatePanel.add(dayComboBox);
    DatePanel.add(monthComboBox);
    DatePanel.add(yearComboBox);
   
    gbc.gridx = 5;
    gbc.gridy = 0;
    formPanel.add(DatePanel, gbc);


    // registrationdatLabel  = new JLabel("Registration Date:");
    // gbc.gridx = 0;
    // gbc.gridy = 0;
    // gbc.anchor = GridBagConstraints.LINE_START;
    // gbc.fill = GridBagConstraints.NONE;
    // formPanel.add(registrationdatLabel, gbc);
    // // Date ko lagi combo boxes
    // dayComboBox = new JComboBox<>(days);
    // dayComboBox.setSelectedIndex(0);
    // monthComboBox = new JComboBox<>(months);
    // monthComboBox.setSelectedIndex(0); // Default to first month
    // yearComboBox = new JComboBox<>();
    // for (int year : years) {
    //     yearComboBox.addItem(String.valueOf(year));
    // }
    // yearComboBox.setSelectedIndex(92); // Default to 2082
    // gbc.gridx = 3;
    // gbc.gridy = 0;
    // gbc.anchor = GridBagConstraints.LINE_START;
    // gbc.fill = GridBagConstraints.NONE;

    // formPanel.add(dayComboBox, gbc);
    // gbc.gridx = 2;  
    // gbc.gridy = 0;
    // gbc.fill = GridBagConstraints.HORIZONTAL; // Month combo box lai horizontal fill garne
    // gbc.anchor = GridBagConstraints.LINE_START; // Month combo box lai left align garne
    // formPanel.add(monthComboBox, gbc);
    // gbc.gridx = 1;
    // gbc.gridy = 0;
    // formPanel.add(yearComboBox, gbc);


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
    gbc.gridx=4;
    gbc.gridy=3;
    gbc.anchor = GridBagConstraints.LINE_START;
   formPanel.add(phoneLabel,gbc);

   phoneField = new JTextField(15);
   gbc.gridx=5;
   gbc.gridy=3;
   gbc.anchor = GridBagConstraints.LINE_START;
   formPanel.add(phoneField,gbc);

    

    //Gender ko lagi label ra radio buttons
    JLabel genderLabel = new JLabel("Gender:");
       gbc.gridx=0;
       gbc.gridy= 3;

       formPanel.add(genderLabel, gbc);


    JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));


        
       

        genderPanel.setBackground(Color.lightGray);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        maleRadioButton.setBackground(Color.lightGray);
        femaleRadioButton.setBackground(Color.lightGray);
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Span two columns to accommodate both radio buttons
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(genderPanel, gbc);






    //  JPanel genderPanel = new JPanel();
    //  genderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    //  genderPanel.setBackground(Color.lightGray);
    //    formPanel.add(genderPanel, gbc);

     
    // //    maleRadioButton.setBackground(Color.lightGray);
    // //    femaleRadioButton.setBackground(Color.lightGray);
    // //    genderPanel.add(maleRadioButton);
    // //    genderPanel.add(femaleRadioButton);

    // //    maleRadioButton = new JRadioButton();
    // //    femaleRadioButton = new JRadioButton();

    // //    gbc.gridx=1;
    // //    gbc.gridy=3;
    // //    formPanel.add(genderPanel, gbc);



    

       

    // ButtonGroup genderGroup = new ButtonGroup();
    // genderLabel =new JLabel("Gender");
    // gbc.gridx=0;
    // gbc.gridy= 3;
    // formPanel.add(genderLabel, gbc);
    // JRadioButton maleRadioButton = new JRadioButton("Male");
    // JRadioButton femaleRadioButton = new JRadioButton("Female");
    // genderGroup.add(maleRadioButton);
    // genderGroup.add(femaleRadioButton);
    // gbc.gridx = 1;
    // gbc.gridy = 3;

    // gbc.anchor = GridBagConstraints.LINE_START; // Radio buttons lai left align garne
    // formPanel.add(maleRadioButton, gbc);
    
    // gbc.fill = GridBagConstraints.HORIZONTAL; // Radio buttons lai horizontal fill garne
    // gbc.gridx = 2;
    // gbc.gridy = 3;
    // formPanel.add(femaleRadioButton, gbc);

    // maleRadioButton.setBackground(Color.lightGray);
    // femaleRadioButton.setBackground(Color.lightGray);


    //ticket type ko lagi label ra combo box
    tickettype = new JLabel("Ticket Type:");
    gbc.gridx = 4;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(tickettype, gbc);
    ticketTypeComboBox = new JComboBox<>(ticketTypes);
    ticketTypeComboBox.setSelectedIndex(0); // Default to "Standard"
    gbc.gridx = 5;
    gbc.gridy = 1;
    formPanel.add(ticketTypeComboBox, gbc);



    


    
    //Ticket price ko lagi label
    ticketpricLabel = new JLabel("Ticket price:");
    gbc.gridx = 4;
    gbc.gridy = 2;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(ticketpricLabel, gbc);


    ticketpriceField =new JTextField(15);
    ticketpriceField.setText("Rs 1000"); 
    gbc.gridx =5;
    gbc.gridy =2;
     gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(ticketpriceField, gbc);
    ticketpriceField.setEditable(false);
    
     /**
             * Updates ticket price field based on selected ticket type.
             * @param e Action event triggered by combo box selection
             */


    ticketTypeComboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedType = (String) ticketTypeComboBox.getSelectedItem();
            if (selectedType != null) {
                if (selectedType.equals("Standard")) {
                    ticketpriceField.setText("Rs 1000");
                } else if (selectedType.equals("Elite")) {
                    ticketpriceField.setText("Rs 2000");
                }
            }
        }
    });

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
    gbc.gridx = 4;
    gbc.gridy = 5;
    gbc.anchor = GridBagConstraints.LINE_START;
    formPanel.add(artworkpricLabel, gbc);
    JTextField artworkPriceField = new JTextField(15);
    gbc.gridx = 5;
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
    
     

    // Cancelation reason ko lagi label ra text field
    cancelationLabel = new JLabel("Cancelation Reason");
    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.anchor = GridBagConstraints.LINE_START;
    
    formPanel.add(cancelationLabel, gbc);

    cancelationField = new JTextArea(4, 15);
    cancelationField.setLineWrap(true); // Line wrap for better readability
    cancelationField.setWrapStyleWord(true); // Wrap at word boundaries
    cancelationField.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Add border for better visibility
    gbc.gridx = 1;
    gbc.gridy = 6;
  
    gbc.anchor = GridBagConstraints.LINE_START; // Text field lai left align garne
    gbc.fill = GridBagConstraints.HORIZONTAL; // Text field lai horizontal fill garne
    formPanel.add(cancelationField, gbc);





    // //adding event listner

    // addvisitorButton.addActionListener(new ActionListener() {

    //     @Override
    //     public void actionPerformed(java.awt.event.ActionEvent e) {
    //         // Code to handle adding visitor
    //         outputArea.append("Visitor added: " + nameField.getText() + "\n");
    //     }

        
    // });



    // logButton.addActionListener(new ActionListener() {

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         String idstring = visitoridField.getText();
    //         int id = Integer.parseInt(idstring);

            

    //         String name = nameField.getText();
    //         String Contact = phoneField.getText();
    //         String email = emailField.getText();
    //         String artworkName = artworkNameField.getText();
    //         String artworkPrice = artworkPriceField.getText();
    //         String registrationdate = yearComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-" + dayComboBox.getSelectedItem(); 


    //        // String ticket_type = ticketTypeComboBox.getSelectedItem(); //error aako xa kina ho

           

        





    //         // Code to handle logging visit
    //         outputArea.append("Visit logged for: " + nameField.getText() + "\n");
    //     }

        
    // });





   
    // AssignpersonaladviserButton.addActionListener(new ActionListener() {

    //     @Override
    //     public void actionPerformed(java.awt.event.ActionEvent e) {
    //         // Code to handle assigning personal adviser
    //         outputArea.append("Personal adviser assigned to: " + nameField.getText() + "\n");
    //     }

        
    // });

    // buyButton.addActionListener(new ActionListener() {

    //     @Override
    //     public void actionPerformed(java.awt.event.ActionEvent e) {
    //         // Code to handle buying product
    //         outputArea.append(artworkNameField.getText() + " bought by: " + nameField.getText() + " at RS" + artworkPriceField.getText() + "\n");
    //     }

        
    // });


    /**
             * Adds a new visitor to the visitor list based on input fields.
             * @param e Action event triggered by button click
             */
        addvisitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Retrieve input values
                    String idString = visitoridField.getText().trim();
                    int visitorId = Integer.parseInt(idString);
                    String fullName = nameField.getText().trim();
                    String contactNumber = phoneField.getText().trim();
                    String ticketType = (String) ticketTypeComboBox.getSelectedItem();
                    String ticketPriceText = ticketpriceField.getText().trim().replace("Rs ", "");
                    double ticketCost = Double.parseDouble(ticketPriceText);
                    String registrationDate = yearComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-" + dayComboBox.getSelectedItem();
                    String gender = maleRadioButton.isSelected() ? "Male" : femaleRadioButton.isSelected() ? "Female" : "";

                    // Validate inputs
                    if (fullName.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Error: Full Name is required.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (gender.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Error: Please select a gender.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (contactNumber.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Error: Contact Number is required.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Check for Visitor ID duplication
                    for (ArtGalleryVisitor visitor : visitorList) {
                        if (visitor.getVisitorId() == visitorId) {
                            JOptionPane.showMessageDialog(frame, "Error: Visitor ID " + visitorId + " already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    // Create visitor object based on ticket type
                    ArtGalleryVisitor visitor;
                    if (ticketType.equals("Standard")) {
                        visitor = new StandardVisitor(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost, ticketType);
                    } else {
                        visitor = new EliteVisitor(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost, ticketType);
                    }

                    // Add to visitorList
                    visitorList.add(visitor);
                    JOptionPane.showMessageDialog(frame, ticketType + " Visitor added successfully: " + fullName + " with ID: " + visitorId, "Success", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Please enter a valid Visitor ID or Ticket Price (numeric).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });









        /**
             * Logs a visit for the specified visitor ID and updates the output area.
             * @param e Action event triggered by button click
             */

      logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = visitoridField.getText().trim();
                try {
                    int visitorId = Integer.parseInt(idString);
                    boolean visitorFound = false;
                    for (ArtGalleryVisitor visitor : visitorList) {
                        if (visitor.getVisitorId() == visitorId) {
                            visitor.logVisit();
                            visitorFound = true;
                            // Display in output panel
                            outputArea.setText("");
                            outputArea.append("Visit logged for:\n");
                            outputArea.append("Visitor ID: " + visitorId + "\n");
                            outputArea.append("Visit Count: " + visitor.getVisitCount() + "\n");
                            JOptionPane.showMessageDialog(frame, 
                                "Visit logged for Visitor ID: " + visitorId + ", Name: " + visitor.getFullName(), 
                                "Success", 
                                JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
                    if (!visitorFound) {
                        outputArea.setText("Error: Visitor ID " + visitorId + " not found.\n");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Visitor ID " + visitorId + " not found.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    outputArea.setText("Error: Please enter a valid Visitor ID (numeric).\n");
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a valid Visitor ID (numeric).", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });


/**
             * Cancels a purchased product for the specified visitor ID.
             * @param e Action event triggered by button click
             */
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = visitoridField.getText().trim();
                String artworkName = artworkNameField.getText().trim();
                String cancellationReason = cancelationField.getText().trim();

                if (idString.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a Visitor ID.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (artworkName.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Artwork Name is required.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int visitorId = Integer.parseInt(idString);
                    if (visitorList.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, 
                            "Error: No visitors registered. Please add a visitor first.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    boolean visitorFound = false;
                    for (ArtGalleryVisitor visitor : visitorList) {
                        if (visitor.getVisitorId() == visitorId) {
                            String result = visitor.cancelProduct(artworkName, cancellationReason);
                            visitorFound = true;
                            if (result.startsWith("Error")) {
                                JOptionPane.showMessageDialog(frame, 
                                    result, 
                                    "Error", 
                                    JOptionPane.ERROR_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(frame, 
                                    result, 
                                    "Success", 
                                    JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        }
                    }
                    if (!visitorFound) {
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Visitor ID " + visitorId + " not found.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a valid Visitor ID (numeric).", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });




  /**
             * Processes a product purchase for the specified visitor ID.
             * @param e Action event triggered by button click
             */
         buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = visitoridField.getText().trim();
                String artworkName = artworkNameField.getText().trim();
                String artworkPriceString = artworkPriceField.getText().trim();

                try {
                    int visitorId = Integer.parseInt(idString);
                    if (artworkName.isEmpty()) {
                        outputArea.setText("Error: Artwork Name is required.\n");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Artwork Name is required.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    double artworkPrice = Double.parseDouble(artworkPriceString);
                    if (artworkPrice <= 0) {
                        outputArea.setText("Error: Artwork Price must be a positive number.\n");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Artwork Price must be a positive number.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    boolean visitorFound = false;
                    for (ArtGalleryVisitor visitor : visitorList) {
                        if (visitor.getVisitorId() == visitorId) {
                            String result = visitor.buyProduct(artworkName, artworkPrice);
                            visitorFound = true;
                            if (result.startsWith("Error")) {
                                outputArea.setText(result + "\n");
                                JOptionPane.showMessageDialog(frame, 
                                    result, 
                                    "Error", 
                                    JOptionPane.ERROR_MESSAGE);
                            } else {
                                // Clear output area and display purchase details
                                outputArea.setText("");
                                outputArea.append("Purchase Details:\n");
                                outputArea.append("Visitor ID: " + visitorId + "\n");
                                outputArea.append("Visitor Name: " + visitor.getFullName() + "\n");
                                outputArea.append("Artwork Name: " + artworkName + "\n");
                                outputArea.append("Artwork Price: Rs " + artworkPrice + "\n");
                                
                                // Show thank you message with visitor's name
                                JOptionPane.showMessageDialog(frame, 
                                    "Thank you " + visitor.getFullName() + " for your purchase", 
                                    "Success", 
                                    JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        }
                    }
                    if (!visitorFound) {
                        outputArea.setText("Error: Visitor ID " + visitorId + " not found.\n");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Visitor ID " + visitorId + " not found.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    outputArea.setText("Error: Please enter a valid Visitor ID or Artwork Price (numeric).\n");
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a valid Visitor ID or Artwork Price (numeric).", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });



/**
             * Displays details for the specified visitor ID in the output area.
             * @param e Action event triggered by button click
             */

        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = visitoridField.getText().trim();
                if (idString.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a Visitor ID.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    int visitorId = Integer.parseInt(idString);
                    if (visitorList.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, 
                            "Error: No visitors registered. Please add a visitor first.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    boolean visitorFound = false;
                    for (ArtGalleryVisitor visitor : visitorList) {
                        if (visitor.getVisitorId() == visitorId) {
                            // Clear the output area before displaying new details
                            outputArea.setText("");
                            // Manually construct visitor details
                            StringBuilder details = new StringBuilder();
                            details.append("Visitor Details:\n");
                            details.append("-------------------\n");
                            details.append("Visitor ID: ").append(visitor.getVisitorId()).append("\n");
                            details.append("Name: ").append(visitor.getFullName()).append("\n");
                            details.append("Gender: ").append(visitor.getgender()).append("\n");
                            details.append("Contact Number: ").append(visitor.getContactNumber()).append("\n");
                            details.append("Registration Date: ").append(visitor.getRegistrationDate()).append("\n");
                            details.append("Ticket Type: ").append(visitor.getTicketType()).append("\n");
                            details.append("Ticket Price: Rs ").append(visitor.getTicketCost()).append("\n");
                            // Add additional fields if available (e.g., purchased artworks, visit count)
                            if (visitor instanceof StandardVisitor) {
                                details.append("Visitor Type: Standard\n");
                            } else if (visitor instanceof EliteVisitor) {
                                details.append("Visitor Type: Elite\n");
                            }
                            outputArea.append(details.toString());
                            visitorFound = true;
                            JOptionPane.showMessageDialog(frame, 
                                "Visitor details displayed in the output area for ID: " + visitorId, 
                                "Success", 
                                JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
                    if (!visitorFound) {
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Visitor ID " + visitorId + " not found.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a valid Visitor ID (numeric).", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });








        /**
             * Clears all input fields and resets selections upon user confirmation.
             * @param e Action event triggered by button click
             */
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(frame, 
                    "Do you really want to clear all fields?", 
                    "Confirm Clear", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    // Clear text fields
                    visitoridField.setText("");
                    nameField.setText("");
                    phoneField.setText("");
                    artworkNameField.setText("");
                    artworkPriceField.setText("");
                    cancelationField.setText("");
                    
                    // Clear radio buttons
                    maleRadioButton.setSelected(false);
                    femaleRadioButton.setSelected(false);
                    
                    // Reset combo boxes to default
                    dayComboBox.setSelectedIndex(0);
                    monthComboBox.setSelectedIndex(0);
                    yearComboBox.setSelectedIndex(92); // Default to 2082
                    ticketTypeComboBox.setSelectedIndex(0); // Default to Standard
                    
                    // Ticket price updates automatically via ticketTypeComboBox listener
                    System.out.println("All input fields cleared.");
                    JOptionPane.showMessageDialog(frame, 
                        "All fields cleared successfully.", 
                        "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    System.out.println("Clear operation cancelled by user.");
                }
            }
        });
        


            /**
             * Generates a bill for the specified visitor ID and displays it in the output area.
             * @param e Action event triggered by button click
             */

      generatebillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = visitoridField.getText().trim();
                if (idString.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a Visitor ID.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    int visitorId = Integer.parseInt(idString);
                    if (visitorList.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, 
                            "Error: No visitors registered. Please add a visitor first.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    boolean visitorFound = false;
                    for (ArtGalleryVisitor visitor : visitorList) {
                        if (visitor.getVisitorId() == visitorId) {
                            outputArea.setText("");
                            if (!visitor.isBought() || visitor.getArtworkName() == null) {
                                outputArea.append("No purchase made to generate a bill.\n");
                                JOptionPane.showMessageDialog(frame, 
                                    "Error: No purchase made for Visitor ID: " + visitorId, 
                                    "Error", 
                                    JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            StringBuilder bill = new StringBuilder();
                            bill.append("Bill Details:\n");
                            bill.append("-------------\n");
                            if (visitor instanceof EliteVisitor) {
                                bill.append("Thank you ").append(visitor.getFullName()).append(" for visiting hamro art gallery\n");
                            }
                            bill.append("Visitor ID: ").append(visitor.getVisitorId()).append("\n");
                            bill.append("Visitor Name: ").append(visitor.getFullName()).append("\n");
                            bill.append("Artwork Name: ").append(visitor.getArtworkName()).append("\n");
                            bill.append("Artwork Price: Rs ").append(visitor.getArtworkPrice()).append("\n");
                            bill.append("Discount Amount: Rs ").append(visitor.getDiscountAmount()).append("\n");
                            bill.append("Final Price: Rs ").append(visitor.getFinalPrice()).append("\n");
                            bill.append("-------------\n");
                            outputArea.append(bill.toString());
                            visitorFound = true;
                            JOptionPane.showMessageDialog(frame, 
                                "Bill generated for Visitor ID: " + visitorId + " in the output area.", 
                                "Success", 
                                JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
                    if (!visitorFound) {
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Visitor ID " + visitorId + " not found.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, 
                        "Error: Please enter a valid Visitor ID (numeric).", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });



   /**
             * Calculates and displays the discount for the specified visitor ID.
             * @param e Action event triggered by button click
             */
        calculatediscountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idText = visitoridField.getText().trim();
                    if (idText.isEmpty()) {
                        outputArea.setText("Error: Please enter a Visitor ID.");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Please enter a Visitor ID.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    int visitorId;
                    try {
                        visitorId = Integer.parseInt(idText);
                    } catch (NumberFormatException ex) {
                        outputArea.setText("Error: Invalid Visitor ID. Please enter a numeric ID.");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Invalid Visitor ID. Please enter a numeric ID.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    ArtGalleryVisitor visitor = null;
                    for (ArtGalleryVisitor v : visitorList) {
                        if (v.getVisitorId() == visitorId) {
                            visitor = v;
                            break;
                        }
                    }
                    
                    if (visitor == null) {
                        outputArea.setText("Error: Visitor ID " + visitorId + " not found.");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: Visitor ID " + visitorId + " not found.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if (!visitor.isBought() || visitor.getArtworkName() == null) {
                        outputArea.setText("Error: No purchase made for Visitor ID " + visitorId + ". Please make a purchase first.");
                        JOptionPane.showMessageDialog(frame, 
                            "Error: No purchase made for Visitor ID " + visitorId + ". Please make a purchase first.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    double discount = visitor.calculateDiscount();
                    StringBuilder details = new StringBuilder();
                    details.append("Discount calculated for Visitor ID: ").append(visitorId).append("\n");
                    details.append("Visitor Type: ").append(visitor.getClass().getSimpleName()).append("\n");
                    details.append("Full Name: ").append(visitor.getFullName()).append("\n");
                    details.append("Artwork Name: ").append(visitor.getArtworkName()).append("\n");
                    details.append("Artwork Price: ").append(visitor.getArtworkPrice()).append("\n");
                    details.append("Discount Amount: ").append(discount).append("\n");
                    details.append("Final Price: ").append(visitor.getFinalPrice()).append("\n");
                    
                    if (visitor instanceof StandardVisitor) {
                        StandardVisitor standard = (StandardVisitor) visitor;
                        details.append("Eligible for Discount Upgrade: ").append(standard.isEligibleForDiscountUpgrade()).append("\n");
                        details.append("Discount Percent: ").append(standard.getDiscountPercent() * 100).append("%\n");
                    } else if (visitor instanceof EliteVisitor) {
                        EliteVisitor elite = (EliteVisitor) visitor;
                        details.append("Assigned Personal Art Advisor: ").append(elite.getAssignedPersonalArtAdvisor()).append("\n");
                        details.append("Exclusive Event Access: ").append(elite.getExclusiveEventAccess()).append("\n");
                    }

                    outputArea.setText(details.toString());
                    JOptionPane.showMessageDialog(frame, 
                        "You have received a discount of " + discount, 
                        "Discount Applied", 
                        JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    outputArea.setText("Error calculating discount: " + ex.getMessage());
                    JOptionPane.showMessageDialog(frame, 
                        "Error calculating discount: " + ex.getMessage(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });



        
    



    



   


    










// Output panel
    outputPanel = new JPanel();
    outputPanel.setLayout(new BorderLayout());
    outputPanel.setBorder(BorderFactory.createTitledBorder("Display "));
    outputArea = new JTextArea(20, 50);
    outputArea.setEditable(false); 

    //css deko 
    outputArea.setBackground(Color.WHITE);
    outputArea.setForeground(Color.BLACK);
    outputArea.setFont(new Font("Arial", Font.PLAIN, 17));
   
 
    JScrollPane scrollPane = new JScrollPane(outputArea);
    outputPanel.add(scrollPane, BorderLayout.CENTER);
    outputPanel.setPreferredSize(new Dimension(640, 640));
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
        new ArtGalleryGUI();
    }
}


