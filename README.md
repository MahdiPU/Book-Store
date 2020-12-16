# Book-Store
The functionality for this phase is the most important one for the system. Which is adding/retrieving items into/from database. 
User will be able to add items using “Add Item” Button, which displays a new window that has Barcode, item name, price, and quantity fields.
 
Now, all what user should do is fill the fields with the needed information, then press save button to add the item to the database.

If Item name or barcode already added to the database, an error message will be displayed.
 
Next, the user should be able to retrieve the items added to the database before, using the “Find Item” Search box. Which displays a list of suggestions based on the text that user typed. 
Some characteristics of the suggestion list are:
•	Suggestions will only show when the user types at least 4 characters. (Client demand)
•	User can search for an item by name, which would display suggestions, or by typing the exact barcode(No suggestions for barcode, only exact value. Since user will not try to reach an item by typing a barcode, he will use barcode reader instead)
•	Suggestions for item name will be any item name that includes the provided string.
•	User can use up and down arrows to switch between suggestions.
•	User can use enter key to retrieve the selected item or the provided barcode in the search box(If exists).

After hitting enter key for a valid name or barcode, a window will pop up showing all the information about the item, which are not editable. 
 
An edit button will be added in the future which allow the user to update item name, price, and quantity.
