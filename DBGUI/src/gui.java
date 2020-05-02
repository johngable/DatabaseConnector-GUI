import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author John Gable
 *
 *         Contains the GUI for Display One
 * 
 *         Connects and interacts with the SQL database
 */
@SuppressWarnings("serial")
public class gui extends JFrame implements ActionListener {
  private static int factoryCount = 0;
  private static int mineCount = 0;
  private static int rcCount = 0;
  private static int shipCount = 0;

  /**
   * Will need to update the cost of each building and use procedures to retrieve
   * the currentMoney, etc
   */
  private static int factoryCost = 0;
  private static int mineCost = 0;
  private static int rcCost = 0;
  private static int shipCost = 0;
  private static int totalCost = 0;
  private static int currentMoney = 0;
  private static String p_name = "";

  /**
   * will need to add currentCost panel + text area
   */
  private static JFrame mainFrame = new JFrame("Building Manager");
  private static JPanel mainPanel = new JPanel();

  private static JPanel factory = new JPanel();
  private static JLabel facLabel = new JLabel("Factory");
  private static JTextField factoryTextField = new JTextField("");
  private static JButton factorySub = new JButton("-");
  private static JTextArea facCountText = new JTextArea("" + factoryCount);
  private static JButton factoryAdd = new JButton("+");

  private static JPanel mine = new JPanel();
  private static JLabel mineLabel = new JLabel("Mine");
  private static JTextField mineTextField = new JTextField("");
  private static JButton mineSub = new JButton("-");
  private static JTextArea mineCountText = new JTextArea("" + mineCount);
  private static JButton mineAdd = new JButton("+");

  private static JPanel rc = new JPanel();
  private static JLabel rcLabel = new JLabel("Research Center");
  private static JTextField rcTextField = new JTextField("");
  private static JButton rcSub = new JButton("-");
  private static JTextArea rcCountText = new JTextArea("" + rcCount);
  private static JButton rcAdd = new JButton("+");

  private static JPanel ship = new JPanel();
  private static JLabel shipLabel = new JLabel("Shipyard");
  private static JTextField shipTextField = new JTextField("");
  private static JButton shipSub = new JButton("-");
  private static JTextArea shipCountText = new JTextArea("" + shipCount);
  private static JButton shipAdd = new JButton("+");

  private static JButton purchase = new JButton("Purchase");
  private static JTextArea currentMoneyText = new JTextArea("Current Money: " + currentMoney);

  private static JPanel loginPanel = new JPanel();
  private static JLabel loginLabel = new JLabel("Enter Your Username: ");
  private static JTextField loginName = new JTextField(12);
  private static JButton loginButton = new JButton("Login");
  private static JDBC_CSC db;

  /**
   * Calls the GUI constructor
   * 
   * @param args
   * @throws SQLException
   */
  public static void main(String[] args) throws SQLException {
    gui disp = new gui();
    disp.guiInitializer();

  }

  public gui() throws SQLException {
    db = new JDBC_CSC();
  }

  /**
   * Creates the Display 1 GUI
   */
  public void guiInitializer() {
    mainFrame.setSize(700, 400);
    mainPanel.setLayout(new GridLayout(4, 3));

    factory.add(facLabel);
    factory.add(factoryTextField);
    factorySub.addActionListener(this);
    factory.add(factorySub);
    factory.add(facCountText);
    factoryAdd.addActionListener(this);
    factory.add(factoryAdd);

    mine.add(mineLabel);
    mine.add(mineTextField);
    mineSub.addActionListener(this);
    mine.add(mineSub);
    mine.add(mineCountText);
    mineAdd.addActionListener(this);
    mine.add(mineAdd);

    rc.add(rcLabel);
    rc.add(rcTextField);
    rcSub.addActionListener(this);
    rc.add(rcSub);
    rc.add(rcCountText);
    rcAdd.addActionListener(this);
    rc.add(rcAdd);

    ship.add(shipLabel);
    ship.add(shipTextField);
    shipSub.addActionListener(this);
    ship.add(shipSub);
    ship.add(shipCountText);
    shipAdd.addActionListener(this);
    ship.add(shipAdd);

    mainPanel.add(factory);
    mainPanel.add(mine);
    mainPanel.add(rc);
    mainPanel.add(ship);

    JPanel money = new JPanel(new GridBagLayout());
    money.add(currentMoneyText);
    // money.add(new JTextArea("$$$$"));
    // money.add(new JButton("Purchase"));

    loginPanel.add(loginLabel);
    loginPanel.add(loginName);
    loginButton.addActionListener(this);
    loginPanel.add(loginButton);

    // mainPanel.add(money);

    mainFrame.add("Center", money);
    mainFrame.add("South", loginPanel);
    mainFrame.add("West", mainPanel);
    purchase.addActionListener(this);
    mainFrame.add("East", purchase);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setVisible(true);

  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == factorySub) {
      if (factoryCount > 0) {
        factoryCount -= 1;
        facCountText.setText("" + factoryCount);
        updateCost();
      }
    }

    if (e.getSource() == factoryAdd) {
      factoryCount += 1;
      facCountText.setText("" + factoryCount);
      updateCost();
    }

    if (e.getSource() == mineSub) {
      if (mineCount > 0) {
        mineCount -= 1;
        mineCountText.setText("" + mineCount);
        updateCost();
      }
    }

    if (e.getSource() == mineAdd) {
      mineCount += 1;
      mineCountText.setText("" + mineCount);
      updateCost();
    }

    if (e.getSource() == rcSub) {
      if (rcCount > 0) {
        rcCount -= 1;
        rcCountText.setText("" + rcCount);
        updateCost();
      }
    }

    if (e.getSource() == rcAdd) {
      rcCount += 1;
      rcCountText.setText("" + rcCount);
      updateCost();
    }

    if (e.getSource() == shipSub) {
      if (shipCount > 0) {
        shipCount -= 1;
        shipCountText.setText("" + shipCount);
        updateCost();
      }
    }

    if (e.getSource() == shipAdd) {
      shipCount += 1;
      shipCountText.setText("" + shipCount);
      updateCost();
    }

    if (e.getSource() == purchase) {

      if (totalCost <= currentMoney) {
        currentMoney -= totalCost;
        try {
          updateDBCounts();
        } catch (SQLException e2) {
          e2.printStackTrace();
        }
        resetCounts();
        updateCountText();
        currentMoneyText.setText("Current Money: " + currentMoney);
        resetTotalCost();
        try {
          db.setCurrentMoney(p_name, currentMoney);
        } catch (SQLException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }

      }
    }

    if (e.getSource() == loginButton) {
      p_name = loginName.getText();
      try {
        currentMoney = db.getPlayerMoney(p_name);
        currentMoneyText.setText("Current Money: " + currentMoney);
        initializeCost();
      } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }

    }
  }

  /**
   * Updates the totalCost
   */
  public static void updateCost() {
    totalCost = (shipCount * shipCost) + (factoryCount * factoryCost) + (mineCount * mineCost)
        + (rcCount * rcCost);
    // System.out.println(totalCost);
  }

  /**
   * Resets all building counts
   */
  public static void resetCounts() {
    factoryCount = 0;
    mineCount = 0;
    rcCount = 0;
    shipCount = 0;
  }

  /**
   * Updates all building JTextArea with current counts
   */
  public static void updateCountText() {
    facCountText.setText("" + factoryCount);
    mineCountText.setText("" + mineCount);
    rcCountText.setText("" + rcCount);
    shipCountText.setText("" + shipCount);

  }

  /**
   * Reset the total cost
   */
  public static void resetTotalCost() {
    totalCost = 0;
  }

  /**
   * Initializes variable for cost per building to logged in player's current
   * building cost
   * 
   * @throws SQLException
   */
  public static void initializeCost() throws SQLException {
    factoryCost = db.getFactoryCost(p_name);
    mineCost = db.getMineCost(p_name);
    shipCost = db.getShipyardCost(p_name);
    rcCost = db.getRcCost(p_name);
    setCostTextFields();
  }

  /**
   * Sets the GUI cost fields to the initialized cost variables
   */
  public static void setCostTextFields() {
    factoryTextField.setText("" + factoryCost);
    mineTextField.setText("" + mineCost);
    shipTextField.setText("" + shipCost);
    rcTextField.setText("" + rcCost);
  }

  /**
   * Updates the current building counts in the DB, to the new building counts.
   * 
   * @throws SQLException
   */
  public static void updateDBCounts() throws SQLException {
    db.updateCurrentFactoryCount(p_name, factoryCount);
    db.updateCurrentMineCount(p_name, mineCount);
    db.updateCurrentRCCount(p_name, rcCount);
    db.updateCurrentShipyardCount(p_name, shipCount);
  }

}