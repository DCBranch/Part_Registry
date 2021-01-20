# Part Registry - Manufacturing Part List Editor
A part list editing program made in Java and utilizing the OpenFX's JavaFX libraries for the GUI. The application showcases a JavaFX/FXML based GUI with tabs and multiple windows, file writing and rewriting, line-by-line sorting, lambda expressions with streams and collection.

## Table of Contents
* [General Info](#general-info)
 * [Program Description](#program-description)
 * [Design](#design)
* [Technologies](#technologies)
* [Possible Updates](#possible-updates)

## General Info
### Program Description
Using a from database-like system made from scratch to showcase, Part Registry utilizes text-based files and writers to enable its users to create a listing of part, add parts to the list, delete parts, view the entire sorted listing, and view filtered lists based on user-inputted search terms and part type. Every part can have a:

* Name
* Part number
* NCAGE (5 numbers in ##### format)
* ID (13 numbers with dash separations in ####-##-###-#### format).

However, parts also fall into one of two types and both have their own unique pieces of data:

* Consumable parts: These parts are only usable a finite number of times. Each has spaces for replacement cost and the number of uses left.
* Expendable parts: These parts are used until failure. Each has spaces for failure rate (avg. number of failure per operational hour), lead time (number of days for a new part), and the tools required to have the expendable part be functional.

### Design
The program's capabilities are divided into two tabs on the same window.

Adding a new part is done on the "New Entry" tab of the Part Registry on which the four generic part text fields are shown and the type-unique fields toggle on or off based on the part type radio buttons at the top. Clicking "Enter" uses the info inputted to create a new part listing in the form of 'Name| P/N: ...| CAGE: ...| NIIN: ...| FAIL RATE: ...| LEAD TIME: ...| TOOL LIST: ... #EXPENDABLE' or 'Name| P/N: ...| CAGE: ...| NIIN: ...| COST: ...| USES LEFT: ... #CONSUMABLE' with "Name" replaced with the part's name and the ...'s replaced with valid entries from the other text fields, if any.

Viewing the list is done on the "View" tab. Part type or "All" is selectable via a combo box at the top. Below that, there are text fields for the four generic part datums and search button. Clicking the search button causes the program to use any and all user selected or inputted data to be used to filter the part listing and display the list in the list view in the bottom half of the window. After selecting a part in the list view and clicking the delete button in the bottom-right next to the "Cancel"/exit button, a small new window pops up to confirm the deletion of the item. Clicking any option on the confirmation window results in its closure, but clicking "Yes" also deletes the item.

## Technologies
Used to create the Part Registry:

* JDK 14.0.2
* OpenJFX 14.0.2.1
* SceneBuilder 11.0.1

## Possible Updates
Here is a list of bug fixes, changes, or new additions that may come:

* Part Editing (IN-PROGRESS)
* Add general invalid text label to view tab and enable it to give a message for clicking delete without an item selected
* Use some message(s) or label(s) to confirm to the player that an item has been successfully deleted or created
* Automatic List view clearing or refreshing upon clicking a different tab or making a change to the list
* Allow for alphanumeric CAGE inputs
* Add a real-time iteration aspect of the program to simulate a system using and replacing part. One possible method of doing this is having the program iterate in real-time and, during each iteration, each consumable part gets their number of uses decremented and expendable parts are randomly determined to pass the iteration or fail during the iteration, resulting in a part failure. The replacements, if any, could be handled automatically with a message left behind for the part or via a another pop-up interface giving users the option to decommission the part and continue or put in a order for a replacement, note the cost, and continue running.
* Add start dates and times for all parts
* Add failure dates and times for all expendable parts
* Consolidate methods by extracting broadly applicable methods or processes placing them in the main class
 * exit(ActionEvent event)
* Update toString() methods in parts
 * Possibly usable in part editing as a method of storing and converting data in a consistent manner
* Have a setter for the delete window's focal part name and have it get inserted into its label
* JDBC/RDBMS implementation
* ElasticSearch implemention