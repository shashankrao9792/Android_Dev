#Notes
The <Button> element is used to add a button.                                                                                               
The <Spinner> element is used to add a spinner, which is a drop-down list of values.                                                       
All GUI components are types of view. They inherit from the Android View class.                                                             
strings.xml is a String resource file. It’s used to separate out text values from the layouts and activities, and supports localization.   
Add a String to strings.xml using: <string name="name">Value</string>                                                                       
Reference a String in the layout using: "@string/name"                                                                                     
Add an array of String values to strings.xml using: <string-array name="array"><item>string1</item>...</string-array>                       
Reference a string-array in the layout using: "@array/array_name"                                                                           
Make a button call a method when clicked by adding the following to the layout: android:onClick="clickMethod"; There needs to be a corresponding method in the activity: public void clickMethod(View view){}                                                                 
R.java is generated for you. It enables you to get references for layouts, GUI components, Strings, and other resources in your Java code. 
Use findViewById() to get a reference to a view.                                                                                           
Use setText() to set the text in a view.                                                                                                   
Use getSelectedItem() to get the selected item in a spinner.                                                                               
Add a custom class to an Android project by going to File menu→New...→Java Class.
