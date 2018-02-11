A task is two or more activities chained together.											   
The <EditText> element defines an editable text field for entering text. It inherits from the Android View class.			   
You can add a new activity in Android Studio by choosing File → New... → Activity.							   
Each activity you create must have an entry in AndroidManifest.xml.
An intent is a type of message that Android components use to communicate with one another.
An explicit intent specifies the component the intent is targeted at. You create an explicit intent using: Intent intent = new Intent(this, Target.class);.
To start an activity, call startActivity(intent). If no activities are found, it throws an ActivityNotFoundException.
Use the putExtra() method to add extra information to an intent.
Use the getIntent() method to retrieve the intent that started the activity.
Use the get*Extra() methods to retrieve extra information associated with the intent.
getStringExtra() retrieves a String, getIntExtra() retrieves an int, and so on.
An activity action describes a standard operational action an activity can perform. For example, to send a message, use Intent.ACTION_SEND.
To create an implicit intent that specifies an action, use Intent intent = new Intent(action);
To describe the type of data in an intent, use the setType() method.
Android resolves intents based on the named component, action, type of data, and categories specified in the intent. It compares the contents of the intent with the intent filters in each app’s AndroidManifest.xml. An activity must have a category of DEFAULT if it is to receive an implicit intent.
The createChooser() method allows you to override the default Android activity chooser dialog. It lets you specify a title for the dialog, and doesn’t give the user the option of setting a default activity. If no activities can receive the intent it is passed, it displays a message. The createChooser() method returns an Intent.
You retrieve the value of a String resource using getString(R.string.stringname);.
