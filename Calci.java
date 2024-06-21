import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calci implements ActionListener {
    JFrame frame;
    JTextField screen;
    JButton nbtn[] = new JButton[10];
    JButton btnPlus, btnMinuis, btnMult, btnZero, btn2Zero, btnEq, btnDec, btnAC, btnDel, btnDiv, btnRem;
    Font ff1 = new Font("Ink.free", Font.BOLD, 35);
    Font ff2 = new Font("Ink.free", Font.BOLD, 20);
    JPanel panel;
    char opr;
    Double num1, num2, result;

    public Calci() {
        frame = new JFrame();
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Calculator");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(100, 100, 100));

        screen = new JTextField("0");
        screen.setBounds(25, 25, 330, 60);
        screen.setFont(ff1);
        screen.setEditable(false);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(screen);

        panel = new JPanel();
        panel.setBounds(25, 100, 335, 350);
        panel.setLayout(new GridLayout(5, 4));
        frame.add(panel);

        for (int i = 0; i < 10; i++) {
            nbtn[i] = new JButton(String.valueOf(i));
            panel.add(nbtn[i]);
            nbtn[i].setFont(ff2);
            nbtn[i].setBackground(new Color(40, 40, 40));
            nbtn[i].setForeground(Color.white);
            nbtn[i].addActionListener(this);
        }
        // * button plus */
        btnPlus = new JButton("+");
        btnPlus.setFont(ff2);
        btnPlus.setBackground(new Color(40, 40, 40));
        btnPlus.setForeground(Color.green);
        // * button Minus */
        btnMinuis = new JButton("-");
        btnMinuis.setFont(ff2);
        btnMinuis.setBackground(new Color(40, 40, 40));
        btnMinuis.setForeground(Color.green);
        // * button Dec*/
        btnDec = new JButton(".");
        btnDec.setFont(ff2);
        btnDec.setBackground(new Color(40, 40, 40));
        btnDec.setForeground(Color.green);
        // * button Mult*/
        btnMult = new JButton("*");
        btnMult.setFont(ff2);
        btnMult.setBackground(new Color(40, 40, 40));
        btnMult.setForeground(Color.green);
        // * button Zero */
        btnZero = new JButton("0");
        btnZero.setFont(ff2);
        btnZero.setBackground(new Color(40, 40, 40));
        btnZero.setForeground(Color.WHITE);
        // * button 2Zero*/
        btn2Zero = new JButton("00");
        btn2Zero.setFont(ff2);
        btn2Zero.setBackground(new Color(40, 40, 40));
        btn2Zero.setForeground(Color.WHITE);

        // * button AC */
        btnAC = new JButton("AC");
        btnAC.setFont(ff2);
        btnAC.setBackground(new Color(40, 40, 40));
        btnAC.setForeground(Color.green);
        // * button Del */
        btnDel = new JButton("DL");
        btnDel.setFont(ff2);
        btnDel.setBackground(new Color(40, 40, 40));
        btnDel.setForeground(Color.green);
        // * button Div */
        btnDiv = new JButton("/");
        btnDiv.setFont(ff2);
        btnDiv.setBackground(new Color(40, 40, 40));
        btnDiv.setForeground(Color.green);
        // * button Eq */
        btnEq = new JButton("=");
        btnEq.setFont(ff2);
        btnEq.setBackground(Color.orange);
        btnEq.setForeground(Color.WHITE);
        // * button Rem */
        btnRem = new JButton("%");
        btnRem.setFont(ff2);
        btnRem.setBackground(new Color(40, 40, 40));
        btnRem.setForeground(Color.green);

        panel.add(btnAC);
        panel.add(btnDel);
        panel.add(btnRem);
        panel.add(btnDiv);
        panel.add(nbtn[9]);
        panel.add(nbtn[8]);
        panel.add(nbtn[7]);
        panel.add(nbtn[6]);
        panel.add(nbtn[5]);
        panel.add(nbtn[4]);
        panel.add(nbtn[3]);
        panel.add(nbtn[2]);
        panel.add(nbtn[1]);
        panel.add(btn2Zero);
        panel.add(btnMult);
        panel.add(btnMinuis);
        panel.add(btnPlus);
        panel.add(btnDec);
        panel.add(btnEq);

        btnZero.addActionListener(this);
        btn2Zero.addActionListener(this);
        btnDec.addActionListener(this);
        btnAC.addActionListener(this);
        btnDel.addActionListener(this);
        btnPlus.addActionListener(this);
        btnMult.addActionListener(this);
        btnMinuis.addActionListener(this);
        btnDiv.addActionListener(this);
        btnRem.addActionListener(this);
        btnEq.addActionListener(this);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 1; i < 10; i++) {
            if (e.getSource() == nbtn[i]) {
                screen.setText(String.valueOf(screen.getText().concat(String.valueOf(i))));
            }
        }
        if (e.getSource() == btnZero) {
            screen.setText(screen.getText().concat("0"));
        }
        if (e.getSource() == btn2Zero) {
            screen.setText(screen.getText().concat("00"));
        }
        if (e.getSource() == btnDec) {
            screen.setText(screen.getText().concat("."));
        }
        if (e.getSource() == btnAC) {
            screen.setText("");
        }
        if (e.getSource() == btnDel) {
            String backSpace = null;
            if (screen.getText().length() > 0) {
                StringBuilder str = new StringBuilder(screen.getText());
                str.deleteCharAt(screen.getText().length() - 1);
                backSpace = str.toString();
                screen.setText(backSpace);
            }
        }
        if (e.getSource() == btnPlus) {
            num1 = Double.parseDouble(screen.getText());
            opr = '+';
            screen.setText("");
        }
        if (e.getSource() == btnMinuis) {
            num1 = Double.parseDouble(screen.getText());
            opr = '-';
            screen.setText("");
        }
        if (e.getSource() == btnMult) {
            num1 = Double.parseDouble(screen.getText());
            opr = '*';
            screen.setText("");
        }
        if (e.getSource() == btnDiv) {
            num1 = Double.parseDouble(screen.getText());
            opr = '/';
            screen.setText("");
        }
        if (e.getSource() == btnRem) {
            num1 = Double.parseDouble(screen.getText());
            opr = '%';
            screen.setText("");
        }
        if (e.getSource() == btnEq) {
            num2 = Double.parseDouble(screen.getText());
            try {
                switch (opr) {
                    case '+':
                        result = num1 + num2;
                        screen.setText(String.valueOf(result));
                        break;
                    case '-':
                        result = num1 - num2;
                        screen.setText(String.valueOf(result));
                        break;
                    case '/':
                        result = num1 / num2;
                        screen.setText(String.valueOf(result));
                        break;
                    case '*':
                        result = num1 * num2;
                        screen.setText(String.valueOf(result));
                        break;

                    case '%':
                        result = num1 % num2;
                        screen.setText(String.valueOf(result));
                        break;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "SYNTAX ERROR >>>");
                screen.setText("");
            }

        }
    }

    public static void main(String[] args) {
        new Calci();
    }
};
