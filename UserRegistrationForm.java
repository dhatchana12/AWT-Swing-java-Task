import java.awt.*;
import java.awt.event.*;

public class UserRegistrationForm extends Frame implements ActionListener {
    TextField firstNameField, lastNameField, dobField, placeField, contactField;
    Checkbox male, female;
    CheckboxGroup genderGroup;
    Button submitButton;
    TextArea resultArea;

    public UserRegistrationForm() {
        // Set up the frame
        setTitle("User Registration Form");
        setSize(400, 400);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Add form components
        add(new Label("First Name:"));
        firstNameField = new TextField(25);
        add(firstNameField);

        add(new Label("Last Name:"));
        lastNameField = new TextField(25);
        add(lastNameField);

        add(new Label("Date of Birth (dd/mm/yyyy):"));
        dobField = new TextField(17);
        add(dobField);

        add(new Label("Gender:"));
        genderGroup = new CheckboxGroup();
        male = new Checkbox("Male", genderGroup, true);
        female = new Checkbox("Female", genderGroup, false);
        add(male);
        add(female);

        add(new Label("Place:"));
        placeField = new TextField(10);
        add(placeField);

        add(new Label("Contact Number:"));
        contactField = new TextField(15);
        add(contactField);

        submitButton = new Button("Submit");
        add(submitButton);
        submitButton.addActionListener(this);

        resultArea = new TextArea(10, 35);
        add(resultArea);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String dob = dobField.getText();
        String gender = genderGroup.getSelectedCheckbox().getLabel();
        String place = placeField.getText();
        String contactNumber = contactField.getText();

        resultArea.setText("User Details:\n");
        resultArea.append("First Name: " + firstName + "\n");
        resultArea.append("Last Name: " + lastName + "\n");
        resultArea.append("Date of Birth: " + dob + "\n");
        resultArea.append("Gender: " + gender + "\n");
        resultArea.append("Place: " + place + "\n");
        resultArea.append("Contact Number: " + contactNumber + "\n");
    }

    public static void main(String[] args) {
        new UserRegistrationForm();
    }
}
