package examples.javafx.addressbook;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class AddressBookFxGui extends TabPane {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(AddressBookFxGui.class);
  private final AddressBook book;

  public AddressBookFxGui(final AddressBook book) {
    this.book = book;
    Tab searchTab = new Tab("Search the Entries");
    Tab newEntryTab = new Tab("Enter New Details");
    Tab listTab = new Tab("List the Entries");
    getTabs().add(searchTab);
    addSearch(searchTab);
    getTabs().add(newEntryTab);
    getTabs().add(listTab);
  }

  private void addSearch(final Tab searchTab) {
    VBox searchBox = new VBox();
    HBox searchLine = new HBox();
    searchLine.getChildren().add(new Label("Search"));
    TextField searchInput = new TextField();
    searchLine.getChildren().add(searchInput);
    searchBox.getChildren().add(searchLine);
    searchTab.setContent(searchBox);
  }


}
