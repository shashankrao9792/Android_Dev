Each app runs in its own process by default.												   
Only the main thread can update the user interface.											   
Use a Handler to schedule code or post code to a different thread.									   
A device configuration change results in the activity being destroyed and recreated.							   
Your activity inherits the life cycle methods from the android.app.Activity class. If you override any of these methods, you need to call up to the method in the superclass.													     
onSaveInstanceState(Bundle) enables your activity to save its state before the activity gets destroyed. You can use the Bundle to restore state in onCreate().															     
You add values to a Bundle using bundle.put*("name", value). You retrieve values from the bundle using bundle.get*("name").		   
onCreate() and onDestroy() deal with the birth and death of the activity.								   
onRestart(), onStart(), and onStop() deal with the visibility of the activity.								   
onResume() and onPause() handle when the activity gains and loses the focus.
