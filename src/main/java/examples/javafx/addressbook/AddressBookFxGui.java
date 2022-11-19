package examples.javafx.addressbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
  private TextField searchInput;
  private ObservableList<ContactDetails> contactDetailsObservableList;

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
    searchInput = new TextField();
    searchInput.textProperty().addListener((e) -> updateSearch());
    searchLine.getChildren().add(searchInput);
    searchBox.getChildren().add(searchLine);
    searchTab.setContent(searchBox);
    contactDetailsObservableList = FXCollections.observableArrayList();
    ListView<ContactDetails> contactListView = new ListView<ContactDetails>();
    contactListView.setItems(contactDetailsObservableList);
    searchBox.getChildren().add(contactListView);
  }

  void updateSearch() {
    ContactDetails[] result = book.search(searchInput.getText());
    contactDetailsObservableList.clear();
    contactDetailsObservableList.addAll(result);
  }


}
