
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class JDBC_CSC {
  public static final String DB_LOCATION = "jdbc:mysql://db.cs.ship.edu:3306/csc371_23";
  public static final String LOGIN_NAME = "csc371_23";
  public static final String PASSWORD = "Password23";
  protected static Connection m_dbConn = null;
  public static String[] nameList = new String[10];

  /**
   * Creates a connection to the database that you can then send commands to.
   * 
   * All functions to create, fill and select from the database are called from
   * main.
   */
  public static void main(String[] args) throws SQLException {

    JDBC_CSC db = new JDBC_CSC();

    // DatabaseMetaData meta = m_dbConn.getMetaData();

    /*
     * the following 3 comments were the methods used to complete Part 1 of the
     * assignment. For part one I used the following 3 methods - dropTable -
     * createTable -fillTable
     */
    // db.dropTable();

    // db.createAdminTable();
    // db.createPlayerTable();
    // db.createCartelTable();
    // db.alterPlayerTable();
    // db.createManagesTable();
    // db.createMessagesTable();
    // db.createPlanetTable();
    // db.createCurrentResearchTable();
    // db.createFleetTable();
    // db.createOrderTable();
    // db.createShipTable();
    //
    // db.fillAdminTable();
    // db.fillPlayerTable();
    // db.fillCartelTable();
    // db.fillManagesTable();
    // db.fillMessagesTable();
    // db.fillPlanetTable();
    // db.fillCurrentResearchTable();
    // db.fillFleetTable();
    // db.fillOrderTable();
    // db.fillShipTable();
    // db.getPlayerNames();

  }

  public void updateCurrentFactoryCount(String name, int facCount) throws SQLException {
    int count = 0;

    Statement statement = m_dbConn.createStatement();
    String sqlName = "'" + name + "';";
    String sql = new String("SELECT Num_Factory FROM PLANET WHERE P_Username =" + sqlName);

    try {
      ResultSet temp = statement.executeQuery(sql);
      while (temp.next()) {
        count = temp.getInt("Num_Factory");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    int totalCount = count + facCount;
    String sqlCount = "" + totalCount;

    sql = new String(
        "UPDATE PLANET SET Num_Factory= " + sqlCount + " WHERE P_Username =" + sqlName);

    try {
      statement.executeUpdate(sql);

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void updateCurrentMineCount(String name, int mineCount) throws SQLException {
    int count = 0;

    Statement statement = m_dbConn.createStatement();
    String sqlName = "'" + name + "';";
    String sql = new String("SELECT Num_Mine FROM PLANET WHERE P_Username =" + sqlName);

    try {
      ResultSet temp = statement.executeQuery(sql);
      while (temp.next()) {
        count = temp.getInt("Num_Mine");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    int totalCount = count + mineCount;
    String sqlCount = "" + totalCount;

    sql = new String("UPDATE PLANET SET Num_Mine= " + sqlCount + " WHERE P_Username =" + sqlName);

    try {
      statement.executeUpdate(sql);

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void updateCurrentRCCount(String name, int rcCount) throws SQLException {
    int count = 0;

    Statement statement = m_dbConn.createStatement();
    String sqlName = "'" + name + "';";
    String sql = new String("SELECT Num_RC FROM PLANET WHERE P_Username =" + sqlName);

    try {
      ResultSet temp = statement.executeQuery(sql);
      while (temp.next()) {
        count = temp.getInt("Num_RC");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    int totalCount = count + rcCount;
    String sqlCount = "" + totalCount;

    sql = new String("UPDATE PLANET SET Num_RC= " + sqlCount + " WHERE P_Username =" + sqlName);

    try {
      statement.executeUpdate(sql);

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void updateCurrentShipyardCount(String name, int shipyardCount) throws SQLException {
    int count = 0;

    Statement statement = m_dbConn.createStatement();
    String sqlName = "'" + name + "';";
    String sql = new String("SELECT Num_Shipyard FROM PLANET WHERE P_Username =" + sqlName);

    try {
      ResultSet temp = statement.executeQuery(sql);
      while (temp.next()) {
        count = temp.getInt("Num_Shipyard");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    int totalCount = count + shipyardCount;
    String sqlCount = "" + totalCount;

    sql = new String(
        "UPDATE PLANET SET Num_Shipyard= " + sqlCount + " WHERE P_Username =" + sqlName);

    try {
      statement.executeUpdate(sql);

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void setCurrentMoney(String name, int money) throws SQLException {
    Statement statement = m_dbConn.createStatement();
    String sqlName = "'" + name + "';";
    String sqlMoney = "" + money;
    String sql = new String(
        "UPDATE PLAYER SET Money = " + sqlMoney + " WHERE P_Username =" + sqlName);

    try {
      statement.executeUpdate(sql);

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public int getFactoryCost(String name) throws SQLException {
    int cost = 0;

    Statement statement = m_dbConn.createStatement();
    String sqlName = "'" + name + "';";
    String sql = new String("SELECT Factory_Init_Cost FROM PLANET WHERE P_Username =" + sqlName);

    try {
      ResultSet temp = statement.executeQuery(sql);
      while (temp.next()) {
        cost = temp.getInt("Factory_Init_Cost");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return cost;
  }

  public int getMineCost(String name) throws SQLException {
    int cost = 0;

    Statement statement = m_dbConn.createStatement();
    String sqlName = "'" + name + "';";
    String sql = new String("SELECT Mine_Init_Cost FROM PLANET WHERE P_Username =" + sqlName);

    try {
      ResultSet temp = statement.executeQuery(sql);
      while (temp.next()) {
        cost = temp.getInt("Mine_Init_Cost");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return cost;
  }

  public int getRcCost(String name) throws SQLException {
    int cost = 0;

    Statement statement = m_dbConn.createStatement();
    String sqlName = "'" + name + "';";
    String sql = new String("SELECT RC_Init_Cost FROM PLANET WHERE P_Username =" + sqlName);

    try {
      ResultSet temp = statement.executeQuery(sql);
      while (temp.next()) {
        cost = temp.getInt("RC_Init_Cost");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return cost;
  }

  public int getShipyardCost(String name) throws SQLException {
    int cost = 0;

    Statement statement = m_dbConn.createStatement();
    String sqlName = "'" + name + "';";
    String sql = new String("SELECT Shipyard_Init_Cost FROM PLANET WHERE P_Username =" + sqlName);

    try {
      ResultSet temp = statement.executeQuery(sql);
      while (temp.next()) {
        cost = temp.getInt("Shipyard_Init_Cost");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return cost;
  }

  public int getPlayerMoney(String name) throws SQLException {
    Statement statement = m_dbConn.createStatement();

    String sql = new String("call getPlayerBalance1('" + name + "');");

    int money = 0;

    try {
      ResultSet temp = statement.executeQuery(sql);
      while (temp.next()) {
        money = temp.getInt("Money");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return money;
  }

  public JDBC_CSC() throws SQLException {
    activateJDBC();
    m_dbConn = DriverManager.getConnection(DB_LOCATION, LOGIN_NAME, PASSWORD);
  }

  /**
   * This is the recommended way to activate the JDBC drivers, but is only setup
   * to work with one specific driver. Setup to work with a MySQL JDBC driver.
   *
   * If the JDBC Jar file is not in your build path this will not work. I have the
   * Jar file posted in D2L.
   * 
   * @return Returns true if it successfully sets up the driver.
   */
  public boolean activateJDBC() {
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }

    return true;
  }

  /**
   * Can drop all tables in the DB or can be modified to drop specific tables
   * 
   * @throws SQLException
   */
  public void dropTable() throws SQLException {
    Statement statement = m_dbConn.createStatement();
    String sql1 = "DROP TABLE ORDER";
    String sql2 = "DROP TABLE SHIP";
    String sql3 = "DROP TABLE FLEET";
    String sql4 = "DROP TABLE CURRENT_RESEARCH";
    String sql5 = "DROP TABLE PLANET";
    String sql6 = "DROP TABLE MESSAGES";
    String sql7 = "DROP TABLE MANAGES";
    String sql8 = "DROP TABLE CARTEL";
    String sql9 = "DROP TABLE PLAYER";
    String sql10 = "DROP TABLE ADMINISTRATOR";

    try {
      statement.executeUpdate(sql1);
      statement.executeUpdate(sql2);
      statement.executeUpdate(sql3);
      statement.executeUpdate(sql4);
      statement.executeUpdate(sql5);
      statement.executeUpdate(sql6);
      statement.executeUpdate(sql7);
      statement.executeUpdate(sql8);
      statement.executeUpdate(sql9);
      statement.executeUpdate(sql10);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * 
   * The Following methods create the tables in the DB, establish column names,
   * and types each column will store
   * 
   * @throws SQLException
   */
  public void createAdminTable() throws SQLException {
    Statement statement = m_dbConn.createStatement();

    String sql = new String("CREATE TABLE ADMINISTRATOR" + "(A_Username VARCHAR(15) NOT NULL,"
        + "Password VARCHAR(30) NOT NULL," + "PRIMARY KEY(A_Username));");

    try {
      statement.executeUpdate(sql);
      System.out.println("Table created");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void createPlayerTable() throws SQLException {
    Statement statement = m_dbConn.createStatement();

    String sql = new String("CREATE TABLE PLAYER" + "(P_Username VARCHAR(15) NOT NULL, "
        + "Password VARCHAR(15) NOT NULL, " + "Money INT NOT NULL DEFAULT 0, " + "isBanned BIT,"
        + "C_Name CHAR(30) NOT NULL, " + "PRIMARY KEY(P_Username));");

    try {
      statement.executeUpdate(sql);
      System.out.println("Table created");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void createCartelTable() throws SQLException {
    Statement statement = m_dbConn.createStatement();

    String sql = new String("CREATE TABLE CARTEL" + "(C_Name CHAR(30) NOT NULL,"
        + "Raw_Resources INT NOT NULL DEFAULT 0," + "Message_Board LONGTEXT,"
        + "Private_Chat LONGTEXT," + "Leader_Username VARCHAR(15) NOT NULL,"
        + "PRIMARY KEY(C_Name)," + "FOREIGN KEY (Leader_Username) REFERENCES PLAYER(P_Username));");

    try {
      statement.executeUpdate(sql);
      System.out.println("Table created");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void alterPlayerTable() throws SQLException {
    Statement statement = m_dbConn.createStatement();

    String sql = new String("ALTER TABLE PLAYER " + "ADD CONSTRAINT FK_Cartel "
        + "FOREIGN KEY (C_Name) REFERENCES CARTEL(C_Name) "
        + "ON DELETE CASCADE ON UPDATE CASCADE;");

    try {
      statement.executeUpdate(sql);
      System.out.println("Table altered");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void createManagesTable() throws SQLException {
    Statement statement = m_dbConn.createStatement();

    String sql = new String("CREATE TABLE MANAGES" + " (A_Username VARCHAR(15) NOT NULL,"
        + " P_Username VARCHAR(15) NOT NULL," + " PRIMARY KEY (A_Username, P_Username),"
        + " FOREIGN KEY(A_Username) REFERENCES ADMINISTRATOR(A_Username)"
        + " ON DELETE CASCADE ON UPDATE CASCADE,"
        + " FOREIGN KEY(P_Username) REFERENCES PLAYER(P_Username)"
        + " ON DELETE CASCADE ON UPDATE CASCADE);");

    try {
      statement.executeUpdate(sql);
      System.out.println("Table created");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void createMessagesTable() throws SQLException {
    Statement statement = m_dbConn.createStatement();

    String sql = new String("CREATE TABLE MESSAGES" + " (P_Username VARCHAR(15) NOT NULL,"
        + " Message VARCHAR(100), PRIMARY KEY(P_Username),"
        + " FOREIGN KEY(P_Username) REFERENCES PLAYER(P_Username)"
        + " ON DELETE CASCADE ON UPDATE CASCADE);");

    try {
      statement.executeUpdate(sql);
      System.out.println("Table created");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void createPlanetTable() throws SQLException {
    Statement statement = m_dbConn.createStatement();

    String sql = new String("CREATE TABLE PLANET"
        + " (P_Username VARCHAR(15) NOT NULL, createShipTable()Planet_ID CHAR(10) NOT NULL, Raw_Resources INT NOT NULL DEFAULT 0,"
        + " Base_Resources INT NOT NULL DEFAULT 0," + " Max_Resources INT NOT NULL DEFAULT 1000000,"
        + " Bauble INT NOT NULL DEFAULT 0," + " Factory_Technology INT NOT NULL DEFAULT 0,"
        + " Hull_Technology INT NOT NULL DEFAULT 0," + " Mining_Technology INT NOT NULL DEFAULT 0,"
        + " Engine_Technology INT NOT NULL DEFAULT 0,"
        + " Weapon_Technology INT NOT NULL DEFAULT 0," + " Num_Factory INT NOT NULL DEFAULT 0,"
        + " Num_Mine INT NOT NULL DEFAULT 0," + " Num_Shipyard INT NOT NULL DEFAULT 0,"
        + " Num_RC INT NOT NULL DEFAULT 0," + " Factory_Init_Cost INT NOT NULL DEFAULT 100,"
        + " Mine_Init_Cost INT NOT NULL DEFAULT 100,"
        + " Shipyard_Init_Cost INT NOT NULL DEFAULT 100,"
        + " RC_Init_Cost INT NOT NULL DEFAULT 100,"
        + " Factory_Maintenance_Cost INT NOT NULL DEFAULT 50,"
        + " Mine_Maintenance_Cost INT NOT NULL DEFAULT 50,"
        + " Shipyard_Maintenance_Cost INT NOT NULL DEFAULT 50,"
        + " RC_Maintenance_Cost INT NOT NULL DEFAULT 50," + " PRIMARY KEY(Planet_ID),"
        + " FOREIGN KEY(P_Username) REFERENCES PLAYER(P_Username)"
        + " ON DELETE CASCADE ON UPDATE CASCADE);");

    try {
      statement.executeUpdate(sql);
      System.out.println("Table created");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void createCurrentResearchTable() throws SQLException {
    Statement statement = m_dbConn.createStatement();

    String sql = new String("CREATE TABLE CURRENT_RESEARCH" + "(Planet_ID CHAR(10) NOT NULL, "
        + "Research_Type VARCHAR(7), " + "Research_Progress INT NOT NULL DEFAULT 0,"
        + "PRIMARY KEY(Planet_ID), " + "FOREIGN KEY(Planet_ID) REFERENCES PLANET(Planet_ID) "
        + "ON DELETE CASCADE ON UPDATE CASCADE);");

    try {
      statement.executeUpdate(sql);
      System.out.println("Table created");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void createFleetTable() throws SQLException {
    Statement statement = m_dbConn.createStatement();

    String sql = new String("CREATE TABLE FLEET" + " (Fleet_ID CHAR(30) NOT NULL,"
        + " P_Username VARCHAR(15) NOT NULL, " + " X_Coordinate FLOAT," + " Y_Coordinate FLOAT,"
        + " Z_Coordinate FLOAT," + " PRIMARY KEY(Fleet_ID),"
        + " FOREIGN KEY(P_Username) REFERENCES PLAYER(P_Username)"
        + " ON DELETE CASCADE ON UPDATE CASCADE);");

    try {
      statement.executeUpdate(sql);
      System.out.println("Table created");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void createOrderTable() throws SQLException {
    Statement statement = m_dbConn.createStatement();

    String sql = new String("CREATE TABLE ORDERS" + " (Fleet_ID CHAR(30) NOT NULL,"
        + " Move_Location BIT," + " Load_Resources BIT," + " Unload_Resources BIT,"
        + " PRIMARY KEY(Fleet_ID)," + " FOREIGN KEY(Fleet_ID) REFERENCES FLEET(Fleet_ID)"
        + " ON DELETE CASCADE ON UPDATE CASCADE);");

    try {
      statement.executeUpdate(sql);
      System.out.println("Table created");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void createShipTable() throws SQLException {
    Statement statement = m_dbConn.createStatement();

    String sql = new String("CREATE TABLE SHIP" + " (Ship_ID CHAR(30) NOT NULL,"
        + " Raw_Resources INT NOT NULL DEFAULT 0," + " Cargo_Capacity INT NOT NULL DEFAULT 1000,"
        + " Weapon_Capacity INT NOT NULL DEFAULT 1000," + " Current_Health INT NOT NULL DEFAULT 0,"
        + " Base_Health INT NOT NULL DEFAULT 0," + " Total_Health INT NOT NULL DEFAULT 100,"
        + " Current_Speed INT NOT NULL DEFAULT 0," + " Base_Speed INT NOT NULL DEFAULT 0,"
        + " Top_Speed INT NOT NULL DEFAULT 100," + " Planet_ID CHAR(10) NOT NULL,"
        + " Fleet_ID  CHAR(30) NOT NULL," + " PRIMARY KEY(Ship_ID, Fleet_ID),"
        + " FOREIGN KEY(Planet_ID) REFERENCES PLANET(Planet_ID)"
        + " ON DELETE CASCADE ON UPDATE CASCADE,"
        + " FOREIGN KEY(Fleet_ID) REFERENCES FLEET(Fleet_ID)"
        + " ON DELETE CASCADE ON UPDATE CASCADE);");

    try {
      statement.executeUpdate(sql);
      System.out.println("Table created");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Once all tables have been created using the methods above, the following
   * methods are used to populate the tables each with 5 rows of data
   * 
   * @throws SQLException
   */
  public void fillAdminTable() throws SQLException {
    PreparedStatement insert = m_dbConn
        .prepareStatement("INSERT INTO ADMINISTRATOR (A_Username, Password) VALUES( ?, ?);");

    try {
      insert.setString(1, "Michael");
      insert.setString(2, "password1");
      insert.executeUpdate();
      insert.setString(1, "John");
      insert.setString(2, "password2");
      insert.executeUpdate();
      insert.setString(1, "Ryan");
      insert.setString(2, "password3");
      insert.executeUpdate();
      insert.setString(1, "Evan");
      insert.setString(2, "password4");
      insert.executeUpdate();
      insert.setString(1, "Tim");
      insert.setString(2, "password5");
      insert.executeUpdate();
      System.out.println("Table filled");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void fillPlayerTable() throws SQLException {
    PreparedStatement insert = m_dbConn.prepareStatement(
        "INSERT INTO PLAYER (P_Username, Password, Money, isBanned, C_Name) VALUES (?, ?, ?, ?, ?);");

    try {
      insert.setString(1, "michaelPerm");
      insert.setString(2, "password1");
      insert.setInt(3, 100);
      insert.setBoolean(4, false);
      insert.setString(5, "Kings");
      insert.executeUpdate();

      insert.setString(1, "johnGable");
      insert.setString(2, "password1");
      insert.setInt(3, 100);
      insert.setBoolean(4, false);
      insert.setString(5, "Queens");
      insert.executeUpdate();

      insert.setString(1, "ryanHipp");
      insert.setString(2, "password1");
      insert.setInt(3, 100);
      insert.setBoolean(4, false);
      insert.setString(5, "Ninjas");
      insert.executeUpdate();

      insert.setString(1, "evanRee");
      insert.setString(2, "password1");
      insert.setInt(3, 100);
      insert.setBoolean(4, false);
      insert.setString(5, "Pirates");
      insert.executeUpdate();

      insert.setString(1, "johnDoe");
      insert.setString(2, "password1");
      insert.setInt(3, 100);
      insert.setBoolean(4, false);
      insert.setString(5, "Raiders");
      insert.executeUpdate();

      System.out.println("Table filled");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void fillCartelTable() throws SQLException {
    PreparedStatement insert = m_dbConn.prepareStatement(
        "INSERT INTO CARTEL (C_Name, Raw_Resources, Message_Board, Private_Chat, Leader_Username) VALUES  (?, ?, ?, ?, ?);");

    try {
      insert.setString(1, "Kings");
      insert.setInt(2, 100);
      insert.setString(3, "King Messages");
      insert.setString(4, "King Private");
      insert.setString(5, "michaelPerm");
      insert.executeUpdate();

      insert.setString(1, "Queens");
      insert.setInt(2, 100);
      insert.setString(3, "Queens Messages");
      insert.setString(4, "Queens Private");
      insert.setString(5, "johnGable");
      insert.executeUpdate();

      insert.setString(1, "Ninjas");
      insert.setInt(2, 100);
      insert.setString(3, "Ninjas Messages");
      insert.setString(4, "Ninjas Private");
      insert.setString(5, "ryanHipp");
      insert.executeUpdate();

      insert.setString(1, "Pirates");
      insert.setInt(2, 100);
      insert.setString(3, "Pirates Messages");
      insert.setString(4, "Pirates Private");
      insert.setString(5, "evanRee");
      insert.executeUpdate();

      insert.setString(1, "Raiders");
      insert.setInt(2, 100);
      insert.setString(3, "Raiders Messages");
      insert.setString(4, "Raiders Private");
      insert.setString(5, "johnDoe");
      insert.executeUpdate();

      System.out.println("Table filled");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Fills the Planet, Fleet and Ship tables with a bunch of data
   * 
   * @throws SQLException
   */
  public void fillPlanetTable() throws SQLException {
    PreparedStatement insert = m_dbConn.prepareStatement(
        "INSERT INTO PLANET (P_Username, Planet_ID, Raw_Resources, Base_Resources, Max_Resources, Bauble, Factory_Technology, Hull_Technology, Mining_Technology, Engine_Technology, Weapon_Technology, "
            + "Num_Factory, Num_Mine, Num_Shipyard, Num_RC, Factory_Init_Cost, Mine_Init_Cost, Shipyard_Init_Cost, RC_Init_Cost, Factory_Maintenance_Cost, "
            + "Mine_Maintenance_Cost, Shipyard_Maintenance_Cost, RC_Maintenance_Cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );");

    try {
      insert.setString(1, "michaelPerm");
      insert.setString(2, "PermP");
      insert.setInt(3, 1000);
      insert.setInt(4, 100);
      insert.setInt(5, 10000);
      insert.setInt(6, 100);
      insert.setInt(7, 1);
      insert.setInt(8, 1);
      insert.setInt(9, 1);
      insert.setInt(10, 1);
      insert.setInt(11, 1);
      insert.setInt(12, 1);
      insert.setInt(13, 1);
      insert.setInt(14, 1);
      insert.setInt(15, 1);
      insert.setInt(16, 10);
      insert.setInt(17, 10);
      insert.setInt(18, 10);
      insert.setInt(19, 10);
      insert.setInt(20, 5);
      insert.setInt(21, 5);
      insert.setInt(22, 5);
      insert.setInt(23, 5);
      insert.executeUpdate();

      insert.setString(1, "johnGable");
      insert.setString(2, "GableP");
      insert.setInt(3, 1000);
      insert.setInt(4, 100);
      insert.setInt(5, 10000);
      insert.setInt(6, 100);
      insert.setInt(7, 2);
      insert.setInt(8, 2);
      insert.setInt(9, 2);
      insert.setInt(10, 2);
      insert.setInt(11, 2);
      insert.setInt(12, 2);
      insert.setInt(13, 2);
      insert.setInt(14, 2);
      insert.setInt(15, 2);
      insert.setInt(16, 10);
      insert.setInt(17, 10);
      insert.setInt(18, 10);
      insert.setInt(19, 10);
      insert.setInt(20, 5);
      insert.setInt(21, 5);
      insert.setInt(22, 5);
      insert.setInt(23, 5);
      insert.executeUpdate();

      insert.setString(1, "ryanHipp");
      insert.setString(2, "HippP");
      insert.setInt(3, 1000);
      insert.setInt(4, 100);
      insert.setInt(5, 10000);
      insert.setInt(6, 100);
      insert.setInt(7, 3);
      insert.setInt(8, 3);
      insert.setInt(9, 3);
      insert.setInt(10, 3);
      insert.setInt(11, 3);
      insert.setInt(12, 3);
      insert.setInt(13, 3);
      insert.setInt(14, 3);
      insert.setInt(15, 3);
      insert.setInt(16, 10);
      insert.setInt(17, 10);
      insert.setInt(18, 10);
      insert.setInt(19, 10);
      insert.setInt(20, 5);
      insert.setInt(21, 5);
      insert.setInt(22, 5);
      insert.setInt(23, 5);
      insert.executeUpdate();

      insert.setString(1, "evenRee");
      insert.setString(2, "ReeseP");
      insert.setInt(3, 1000);
      insert.setInt(4, 100);
      insert.setInt(5, 10000);
      insert.setInt(6, 100);
      insert.setInt(7, 4);
      insert.setInt(8, 4);
      insert.setInt(9, 4);
      insert.setInt(10, 4);
      insert.setInt(11, 4);
      insert.setInt(12, 4);
      insert.setInt(13, 4);
      insert.setInt(14, 4);
      insert.setInt(15, 4);
      insert.setInt(16, 10);
      insert.setInt(17, 10);
      insert.setInt(18, 10);
      insert.setInt(19, 10);
      insert.setInt(20, 5);
      insert.setInt(21, 5);
      insert.setInt(22, 5);
      insert.setInt(23, 5);
      insert.executeUpdate();

      insert.setString(1, "johnDoe");
      insert.setString(2, "DoeP");
      insert.setInt(3, 1000);
      insert.setInt(4, 100);
      insert.setInt(5, 10000);
      insert.setInt(6, 100);
      insert.setInt(7, 5);
      insert.setInt(8, 5);
      insert.setInt(9, 5);
      insert.setInt(10, 5);
      insert.setInt(11, 5);
      insert.setInt(12, 5);
      insert.setInt(13, 5);
      insert.setInt(14, 5);
      insert.setInt(15, 5);
      insert.setInt(16, 10);
      insert.setInt(17, 10);
      insert.setInt(18, 10);
      insert.setInt(19, 10);
      insert.setInt(20, 5);
      insert.setInt(21, 5);
      insert.setInt(22, 5);
      insert.setInt(23, 5);
      insert.executeUpdate();

      System.out.println("Table filled");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void fillFleetTable() throws SQLException {
    PreparedStatement insert = m_dbConn.prepareStatement(
        "INSERT INTO FLEET (Fleet_ID, P_Username, X_Coordinate, Y_Coordinate, Z_Coordinate) VALUES (?, ?, ?, ?, ?);");

    try {
      insert.setString(1, "PFleet");
      insert.setString(2, "michaelPerm");
      insert.setFloat(3, 10.0f);
      insert.setFloat(4, 0.0f);
      insert.setFloat(5, 10.0f);
      insert.executeUpdate();

      insert.setString(1, "GFleet");
      insert.setString(2, "johnGable");
      insert.setFloat(3, 20.0f);
      insert.setFloat(4, 0.0f);
      insert.setFloat(5, 20.0f);
      insert.executeUpdate();

      insert.setString(1, "HFleet");
      insert.setString(2, "ryanHipp");
      insert.setFloat(3, 30.0f);
      insert.setFloat(4, 0.0f);
      insert.setFloat(5, 30.0f);
      insert.executeUpdate();

      insert.setString(1, "RFleet");
      insert.setString(2, "evenRee");
      insert.setFloat(3, 40.0f);
      insert.setFloat(4, 0.0f);
      insert.setFloat(5, 40.0f);
      insert.executeUpdate();

      insert.setString(1, "DFleet");
      insert.setString(2, "johnDoe");
      insert.setFloat(3, 50.0f);
      insert.setFloat(4, 0.0f);
      insert.setFloat(5, 50.0f);
      insert.executeUpdate();

      System.out.println("Table filled");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void fillShipTable() throws SQLException {
    PreparedStatement insert = m_dbConn.prepareStatement(
        "INSERT INTO SHIP (Ship_ID, Raw_Resources, Cargo_Capacity, Weapon_Capacity, Current_Health, Base_Health, Total_Health, Current_Speed, "
            + "Base_Speed, Top_Speed, Planet_ID, Fleet_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

    try {
      insert.setString(1, "Nina");
      insert.setInt(2, 100);
      insert.setInt(3, 500);
      insert.setInt(4, 50);
      insert.setInt(5, 50);
      insert.setInt(6, 100);
      insert.setInt(7, 100);
      insert.setInt(8, 40);
      insert.setInt(9, 20);
      insert.setInt(10, 100);
      insert.setString(11, "PermP");
      insert.setString(12, "PFleet");
      insert.executeUpdate();

      insert.setString(1, "Pinta");
      insert.setInt(2, 100);
      insert.setInt(3, 500);
      insert.setInt(4, 50);
      insert.setInt(5, 50);
      insert.setInt(6, 100);
      insert.setInt(7, 100);
      insert.setInt(8, 40);
      insert.setInt(9, 20);
      insert.setInt(10, 100);
      insert.setString(11, "GableP");
      insert.setString(12, "GFleet");
      insert.executeUpdate();

      insert.setString(1, "SantaMaria");
      insert.setInt(2, 100);
      insert.setInt(3, 500);
      insert.setInt(4, 50);
      insert.setInt(5, 50);
      insert.setInt(6, 100);
      insert.setInt(7, 100);
      insert.setInt(8, 40);
      insert.setInt(9, 20);
      insert.setInt(10, 100);
      insert.setString(11, "HippP");
      insert.setString(12, "HFleet");
      insert.executeUpdate();

      insert.setString(1, "Mayflower");
      insert.setInt(2, 100);
      insert.setInt(3, 500);
      insert.setInt(4, 50);
      insert.setInt(5, 50);
      insert.setInt(6, 100);
      insert.setInt(7, 100);
      insert.setInt(8, 40);
      insert.setInt(9, 20);
      insert.setInt(10, 100);
      insert.setString(11, "ReeseP");
      insert.setString(12, "RFleet");
      insert.executeUpdate();

      insert.setString(1, "Titanic");
      insert.setInt(2, 100);
      insert.setInt(3, 500);
      insert.setInt(4, 50);
      insert.setInt(5, 50);
      insert.setInt(6, 100);
      insert.setInt(7, 100);
      insert.setInt(8, 40);
      insert.setInt(9, 20);
      insert.setInt(10, 100);
      insert.setString(11, "DoeP");
      insert.setString(12, "DFleet");
      insert.executeUpdate();

      System.out.println("Table filled");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Fills Messages with Player usernames
   * 
   * Messages will be stored in the tables once messages are recieved in the
   * messaging application
   * 
   * @throws SQLException
   */
  public void fillMessagesTable() throws SQLException {
    PreparedStatement insert = m_dbConn
        .prepareStatement("INSERT INTO MESSAGES (P_Username) VALUES (?);");

    try {
      insert.setString(1, "michaelPerm");
      insert.executeUpdate();

      insert.setString(1, "johnGable");
      insert.executeUpdate();

      insert.setString(1, "ryanHipp");
      insert.executeUpdate();

      insert.setString(1, "evanRee");
      insert.executeUpdate();

      insert.setString(1, "johnDoe");
      insert.executeUpdate();

      System.out.println("Table filled");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * METHODS USED BY MESSAGING APP this method gets all player user names stored
   * in the database and returns an array of strings containing all the names
   * 
   * I used this method to provide the user of the messaging application a menu
   * list which displays all the players they can choose to message
   * 
   * @return string array of names
   * @throws SQLException
   */
  public void getPlayerNames() throws SQLException {
    Statement statement = m_dbConn.createStatement();

    String sql = new String("SELECT P_Username FROM PLAYER;");

    try {
      ResultSet rs = statement.executeQuery(sql);
      int i = 0;
      while (rs.next()) {
        nameList[i] = rs.getString("P_Username");
        i++;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void appendMessagesToTable(String pUsername, String toPlayer, String messages)
      throws SQLException {
    PreparedStatement insert = m_dbConn.prepareStatement("UPDATE MESSAGES SET Message = '"
        + messages + "', to_Username = '" + toPlayer + "' WHERE P_Username = '" + pUsername + "';");

    try {
      insert.executeUpdate();

      System.out.println("Messages Updated");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * METHODS USED BY BUTTON MENU
   * 
   * these methods get info for number of resources, amount of factories, and
   * amount of shipyards. when making baubles or building a ship, the
   * corresponding amount of resources will be subtracted from the total.
   * 
   * @return amount of resources
   * @throws SQLException
   */

  public void displayStats() throws SQLException {

  }

  public void makeCargo() throws SQLException {

  }

  public void makeCruiser() throws SQLException {

  }

  public void makeBaubles() throws SQLException {

  }

}
