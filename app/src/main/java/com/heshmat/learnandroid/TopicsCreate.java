package com.heshmat.learnandroid;

import com.heshmat.learnandroid.models.Question;
import com.heshmat.learnandroid.models.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopicsCreate {
    static Topic topic1 = new Topic("What is Android", "Android is a software package and linux based operating system for mobile devices such as tablet computers and smartphones.\n" +
            "\n" +
            "It is developed by Google and later the OHA (Open Handset Alliance). Java language is mainly used to write the android code even though other languages can be used." +
            "The goal of android project is to create a successful real-world product that improves the mobile experience for end users.\n" +
            "\n" +
            "There are many code names of android such as Lollipop, Kitkat, Jelly Bean, Ice cream Sandwich, Froyo, Ecliar, Donut etc which is covered in next page." +
            "After learning what is android, let's see the features of android. The important features of android are given below:\n" +
            "\n" +
            "1) It is open-source.\n" +
            "\n" +
            "2) Anyone can customize the Android Platform.\n" +
            "\n" +
            "3) There are a lot of mobile applications that can be chosen by the consumer.\n" +
            "\n" +
            "4) It provides many interesting features like weather details, opening screen, live RSS (Really Simple Syndication) feeds etc.\n" +
            "\n" +
            "It provides support for messaging services(SMS and MMS), web browser, storage (SQLite), connectivity (GSM, CDMA, Blue Tooth, Wi-Fi etc.), media, handset layout etc.", StaticFields.LEVEL_EASY, 0);
    static Topic topic2 = new Topic("History of Android", "The history and versions of android are interesting to know. The code names of android ranges from A to J currently, such as Aestro, Blender, Cupcake, Donut, Eclair, Froyo, Gingerbread, Honeycomb, Ice Cream Sandwitch, Jelly Bean, KitKat and Lollipop. Let's understand the android history in a sequence.\n" +
            "\n" +
            "1) Initially, Andy Rubin founded Android Incorporation in Palo Alto, California, United States in October, 2003.\n" +
            "\n" +
            "2) In 17th August 2005, Google acquired android Incorporation. Since then, it is in the subsidiary of Google Incorporation.3) The key employees of Android Incorporation are Andy Rubin, Rich Miner, Chris White and Nick Sears.\n" +
            "\n" +
            "4) Originally intended for camera but shifted to smart phones later because of low market for camera only.\n" +
            "\n" +
            "5) Android is the nick name of Andy Rubin given by coworkers because of his love to robots.\n" +
            "\n" +
            "6) In 2007, Google announces the development of android OS.\n" +
            "\n" +
            "7) In 2008, HTC launched the first android mobile.", StaticFields.LEVEL_EASY, 0);
    static Topic topic3 = new Topic("Android Architecture", "android architecture or Android software stack is categorized into five parts:\n" +
            "\n" +
            "1) linux kernel\n" +
            "2) native libraries (middleware),\n" +
            "3) Android Runtime\n" +
            "4) Application Framework\n" +
            "5) Applications\n" +
            "1) Linux kernel\n" +
            "\n" +

            "Android Architecture\n" +
            "android architecture or Android software stack is categorized into five parts:\n" +
            "\n" +
            "linux kernel\n" +
            "native libraries (middleware),\n" +
            "Android Runtime\n" +
            "Application Framework\n" +
            "Applications\n" +
            "Let's see the android architecture first.\n" +
            "\n" +
            "android software stack, architecture  \n" +
            "\n" +
            " \n" +
            "1) Linux kernel\n" +
            "It is the heart of android architecture that exists at the root of android architecture. Linux kernel is responsible for device drivers, power management, memory management, device management and resource access.\n" +
            "\n" +
            "2) Native Libraries \n" +
            "On the top of linux kernel, their are Native libraries such as WebKit, OpenGL, FreeType, SQLite, Media, C runtime library (libc) etc.\n" +
            "\n" +
            "The WebKit library is responsible for browser support, SQLite is for database, FreeType for font support, Media for playing and recording audio and video formats.\n" +
            "\n" +
            "3) Android Runtime\n" +
            "In android runtime, there are core libraries and DVM (Dalvik Virtual Machine) which is responsible to run android application. DVM is like JVM but it is optimized for mobile devices. It consumes less memory and provides fast performance.\n" +
            "4) Android Framework\n" +
            "On the top of Native libraries and android runtime, there is android framework. Android framework includes Android API's such as UI (User Interface), telephony, resources, locations, Content Providers (data) and package managers. It provides a lot of classes and interfaces for android application development.\n" +
            "\n" +
            "5) Applications\n" +
            "On the top of android framework, there are applications. All applications such as home, contact, settings, games, browsers are using android framework that uses android runtime and libraries. Android runtime and native libraries are using linux kernal.", StaticFields.LEVEL_EASY, 0);
    //  static Topic topic4 = new Topic("Android Core Building Blocks\n", "", StaticFields.LEVEL_EASY, 0);
    static Topic topic4 = new Topic("Android Core Building Blocks\n", "An android component is simply a piece of code that has a well defined life cycle e.g. Activity, Receiver, Service etc.\n" +
            "\n" +
            "The core building blocks or fundamental components of android are activities, views, intents, services, content providers, fragments and AndroidManifest.xml.\n" +
            "\n" +
            "Activity\n" +
            "An activity is a class that represents a single screen. It is like a Frame in AWT.\n" +
            "\n" +
            "\n" +
            "View\n" +
            "A view is the UI element such as button, label, text field etc. Anything that you see is a view.\n" +
            "\n" +
            "Intent\n" +
            "Intent is used to invoke components. It is mainly used to:\n" +
            "\n" +
            "Start the service\n" +
            "Launch an activity\n" +
            "Display a web page\n" +
            "Display a list of contacts\n" +
            "Broadcast a message\n" +
            "Dial a phone call etc.\n" +
            "For example, you may write the following code to view the webpage.\n" +
            "\n" +
            "Intent intent=new Intent(Intent.ACTION_VIEW);  \n" +
            "intent.setData(Uri.parse(\"http://www.javatpoint.com\"));  \n" +
            "startActivity(intent);  \n" +
            "\n" +
            " \n" +
            "Service\n" +
            "Service is a background process that can run for a long time.\n" +
            "\n" +
            "There are two types of services local and remote. Local service is accessed from within the application whereas remote service is accessed remotely from other applications running on the same device.\n" +
            "\n" +
            "Content Provider\n" +
            "Content Providers are used to share data between the applications.\n" +
            "\n" +
            "Fragment\n" +
            "Fragments are like parts of activity. An activity can display one or more fragments on the screen at the same time.\n" +
            "\n" +
            "AndroidManifest.xml\n" +
            "It contains informations about activities, content providers, permissions etc. It is like the web.xml file in Java EE.\n" +
            "\n" +
            "Android Virtual Device (AVD)\n" +
            "It is used to test the android application without the need for mobile or tablet etc. It can be created in different configurations to emulate different types of real devices.", StaticFields.LEVEL_EASY, 0);
    static Topic topic5 = new Topic("AndroidManifest.xml file in android", "The AndroidManifest.xml file contains information of your package, including components of the application such as activities, services, broadcast receivers, content providers etc.\n" +
            "\n" +
            "It performs some other tasks also:\n" +
            "\n" +
            "It is responsible to protect the application to access any protected parts by providing the permissions.\n" +
            "It also declares the android api that the application is going to use.\n" +
            "It lists the instrumentation classes. The instrumentation classes provides profiling and other informations. These informations are removed just before the application is published etc.\n" +
            "This is the required xml file for all the android application and located inside the root directory.\n" +
            "\n" +
            "\n" +
            "A simple AndroidManifest.xml file looks like this:\n" +
            "\n" +
            "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\"  \n" +
            "    package=\"com.javatpoint.hello\"  \n" +
            "    android:versionCode=\"1\"  \n" +
            "    android:versionName=\"1.0\" >  \n" +
            "  \n" +
            "    <uses-sdk  \n" +
            "        android:minSdkVersion=\"8\"  \n" +
            "        android:targetSdkVersion=\"15\" />  \n" +
            "  \n" +
            "    <application  \n" +
            "        android:icon=\"@drawable/ic_launcher\"  \n" +
            "        android:label=\"@string/app_name\"  \n" +
            "        android:theme=\"@style/AppTheme\" >  \n" +
            "        <activity  \n" +
            "            android:name=\".MainActivity\"  \n" +
            "            android:label=\"@string/title_activity_main\" >  \n" +
            "            <intent-filter>  \n" +
            "                <action android:name=\"android.intent.action.MAIN\" />  \n" +
            "  \n" +
            "                <category android:name=\"android.intent.category.LAUNCHER\" />  \n" +
            "            </intent-filter>  \n" +
            "        </activity>  \n" +
            "    </application>  \n" +
            "  \n" +
            "</manifest>  \n" +
            "\n" +
            " \n" +
            "Elements of the AndroidManifest.xml file\n" +
            "The elements used in the above xml file are described below.\n" +
            "\n" +
            "<manifest>\n" +
            "manifest is the root element of the AndroidManifest.xml file. It has package attribute that describes the package name of the activity class.\n" +
            "\n" +
            "<application>\n" +
            "application is the subelement of the manifest. It includes the namespace declaration. This element contains several subelements that declares the application component such as activity etc.\n" +
            "\n" +
            "The commonly used attributes are of this element are icon, label, theme etc.\n" +
            "\n" +
            "android:icon represents the icon for all the android application components.\n" +
            "\n" +
            "android:label works as the default label for all the application components.\n" +
            "\n" +
            "android:theme represents a common theme for all the android activities.\n" +
            "\n" +
            "<activity>\n" +
            "activity is the subelement of application and represents an activity that must be defined in the AndroidManifest.xml file. It has many attributes such as label, name, theme, launchMode etc.\n" +
            "\n" +
            "android:label represents a label i.e. displayed on the screen.\n" +
            "\n" +
            "android:name represents a name for the activity class. It is required attribute.\n" +
            "\n" +
            "<intent-filter>\n" +
            "intent-filter is the sub-element of activity that describes the type of intent to which activity, service or broadcast receiver can respond to.\n" +
            "\n" +
            "<action>\n" +
            "It adds an action for the intent-filter. The intent-filter must have at least one action element.\n" +
            "\n" +
            "<category>\n" +
            "It adds a category name to an intent-filter.", StaticFields.LEVEL_EASY, 0);
    static Topic topic6 = new Topic("Android R.java file\n", "\n" +
            "Android R.java file\n" +
            "Android R.java is an auto-generated file by aapt (Android Asset Packaging Tool) that contains resource IDs for all the resources of res/ directory.\n" +
            "\n" +
            "If you create any component in the activity_main.xml file, id for the corresponding component is automatically created in this file. This id can be used in the activity source file to perform any action on the component.\n" +
            "\n" +
            "Note: If you delete R.jar file, android creates it automatically.\n" +
            "Let's see the android R.java file. It includes a lot of static nested classes such as menu, id, layout, attr, drawable, string etc.\n" +
            "\n" +
            "\n" +
            "/* AUTO-GENERATED FILE.  DO NOT MODIFY. \n" +
            " * \n" +
            " * This class was automatically generated by the \n" +
            " * aapt tool from the resource data it found.  It \n" +
            " * should not be modified by hand. \n" +
            " */  \n" +
            "  \n" +
            "package com.example.helloandroid;  \n" +
            "  \n" +
            "public final class R {  \n" +
            "    public static final class attr {  \n" +
            "    }  \n" +
            "    public static final class drawable {  \n" +
            "        public static final int ic_launcher=0x7f020000;  \n" +
            "    }  \n" +
            "    public static final class id {  \n" +
            "        public static final int menu_settings=0x7f070000;  \n" +
            "    }  \n" +
            "    public static final class layout {  \n" +
            "        public static final int activity_main=0x7f030000;  \n" +
            "    }  \n" +
            "    public static final class menu {  \n" +
            "        public static final int activity_main=0x7f060000;  \n" +
            "    }  \n" +
            "    public static final class string {  \n" +
            "        public static final int app_name=0x7f040000;  \n" +
            "        public static final int hello_world=0x7f040001;  \n" +
            "        public static final int menu_settings=0x7f040002;  \n" +
            "    }  \n" +
            "    public static final class style {  \n" +
            "        /**  \n" +
            "        Base application theme, dependent on API level. This theme is replaced \n" +
            "        by AppBaseTheme from res/values-vXX/styles.xml on newer devices. \n" +
            "     \n" +
            " \n" +
            "            Theme customizations available in newer API levels can go in \n" +
            "            res/values-vXX/styles.xml, while customizations related to \n" +
            "            backward-compatibility can go here. \n" +
            "         \n" +
            " \n" +
            "        Base application theme for API 11+. This theme completely replaces \n" +
            "        AppBaseTheme from res/values/styles.xml on API 11+ devices. \n" +
            "     \n" +
            " API 11 theme customizations can go here.  \n" +
            " \n" +
            "        Base application theme for API 14+. This theme completely replaces \n" +
            "        AppBaseTheme from BOTH res/values/styles.xml and \n" +
            "        res/values-v11/styles.xml on API 14+ devices. \n" +
            "     \n" +
            " API 14 theme customizations can go here.  \n" +
            "         */  \n" +
            "        public static final int AppBaseTheme=0x7f050000;  \n" +
            "        /**  Application theme.  \n" +
            " All customizations that are NOT specific to a particular API-level can go here.  \n" +
            "         */  \n" +
            "        public static final int AppTheme=0x7f050001;  \n" +
            "    }  \n" +
            "}  ", StaticFields.LEVEL_EASY, 0);

    static Topic topic7 = new Topic("Android - Services\n", "A service is a component that runs in the background to perform long-running operations without needing to interact with the user and it works even if application is destroyed. A service can essentially take two states \n" +
            "1) Started\n" +
            "A service is started when an application component, such as an activity, starts it by calling startService(). Once started, a service can run in the background indefinitely, even if the component that started it is destroyed." +
            "2) Bound\n" +
            "A service is bound when an application component binds to it by calling bindService(). A bound service offers a client-server interface that allows components to interact with the service, send requests, get results, and even do so across processes with interprocess communication (IPC). \n" +
            "A service has life cycle callback methods that you can implement to monitor changes in the service's state and you can perform work at the appropriate stage. The following diagram on the left shows the life cycle when the service is created with startService() " +
            "\nTo create an service, you create a Java class that extends the Service base class or one of its existing subclasses. The Service base class defines various callback methods and the most important are given below. You don't need to implement all the callbacks methods. However, it's important that you understand each one and implement those that ensure your app behaves the way users expect. \n" +
            "1) onStartCommand()\n" +
            "The system calls this method when another component, such as an activity, requests that the service be started, by calling startService(). If you implement this method, it is your responsibility to stop the service when its work is done, by calling stopSelf() or stopService() methods." +
            "\n2) onBind()\n" +
            "The system calls this method when another component wants to bind with the service by calling bindService(). If you implement this method, you must provide an interface that clients use to communicate with the service, by returning an IBinder object. You must always implement this method, but if you don't want to allow binding, then you should return null." +
            "\n3) onUnbind()\n" +
            "The system calls this method when all clients have disconnected from a particular interface published by the service." +
            "\n4) onRebind()\n" +
            "The system calls this method when new clients have connected to the service, after it had previously been notified that all had disconnected in its onUnbind(Intent)." +
            "\n5) onCreate()\n" +
            "The system calls this method when the service is first created using onStartCommand() or onBind(). This call is required to perform one-time set-up." +
            "\n6) onDestroy()\n" +
            "The system calls this method when the service is no longer used and is being destroyed. Your service should implement this to clean up any resources such as threads, registered listeners, receivers, etc.", StaticFields.LEVEL_MEDIUM, 0);
    static Question q1 = new Question("What is the name of the program that converts Java byte code into Dalvik byte code?", "Android Interpretive Compiler (AIC),Dalvik Converter,Dex compiler,Mobile Interpretive Compiler (MIC)", "Dex compiler");
    static Question q2 = new Question("Android is based on Linux for the following reason.", "Security,Security,Networking,All of these", "All of these");
    static Question q3 = new Question("Which among the following are part of \"Application\" layer of Android Architecture", "Contacts,Browser,Phone,All of these", "All of these");
    static Question q4 = new Question("Which company developed android?", "Apple,Google,Android Inc,Nokia", "Android Inc");
    static Question q5 = new Question("What was the first phone released that ran the Android OS?", "Google gPhone,T-Mobile G1,Motorola Droid,HTC Hero", "T-Mobile G1");
    static Question q6 = new Question("Which one is NOT related to fragment class?", "DialogFragment,ListFragment,PreferenceFragment,CursorFragment", "CursorFragment");
    static Question q7 = new Question("A ___________ makes a specific set of the application data available to other applications", "Webkit,Dalvik,OpenGL,SQLite", "Dalvik");
    static Question q8 = new Question("During an Activity life-cycle, what is the first callback method invoked by the system?", "onStop(),onStart(),onCreate(),onRestore()", "onCreate()");
    static Question q9 = new Question("What does the src folder contain?", "Image and icon files, XML resource files,The application manifest file,Java source code files", "Java source code files");
    static Question q10 = new Question("Android releases since 1.5 have been given nicknames derived from how?", "Adjective and strange animal,Food,Something that starts w/ ‘A’ -> Something that starts w/ ‘B’…,American states", "Food");
    static Question q11 = new Question("What are the indirect Direct subclasses of Services", "Adjective and strange animal,Food,Something that starts w/ ‘A’ -> Something that starts w/ ‘B’…,American states", "Food");
    static Question q12 = new Question("The android library that provides access to UI pre-built elements such as buttons, lists, views etc. is", "android.text,android.os,android.view,android.webkit", "android.webkit");
    static Question q13 = new Question("Which one is not a nickname of a version of Andriod?", "cupcake,Gingerbread,Honeycomb,Muffin", "Muffin");
    static Question q14 = new Question("When developing for the Android OS, Java bytecode is compiled into what?", "Java source code,Dalvik application code,Dalvik byte code, C source code", " C source code");
    static Question q15 = new Question("An activity can be thought of as corresponding to what?", "A Java project,A Java class,A method call,An object field", "A Java class");
    static Question q16 = new Question("DVM is developed by", "Linus Torvald,Dennis Ritchie,Dan Bornstein,None of these", "Dan Bornstein");
    static Question q18 = new Question("When contentProvider would be activated", "Using Intent,Using SQLite,Using ContentResolver,None", "Using ContentResolver");
    static Question q19 = new Question("What is the system image that the virtual device was set up to support?", "JellyBean,Ice-cream sandwich,KitKat,Marshmallow", "Marshmallow");
    static Question q20 = new Question("Which folder do you copy and paste an image into?", "Resources,Layout,Java,Drawable", "Drawable");
    static Question q21 = new Question("Which Android Studio file is most of the app coding done in?", "MainActivity.java,Activity_main_xml,AndroidManifest.xml,App.class", "MainActivity.java");
    static Question q22 = new Question("Which file do you alter the image displayed by the ImageView in?", "AndroidManifest.xml,Activity_main_xml,MainActivity,Drawable", "Activity_main_xml");
    static Question q23 = new Question("Which component property should be changed to a name that is specific of the components use?", "Content Description,Text,ID,Editable", "ID");

    public static List<Topic> topics() {
        List<Question> group1 = Arrays.asList(q1, q2, q3, q4);
        List<Question> group2 = Arrays.asList(q5, q6, q7, q8);
        List<Question> group3 = Arrays.asList(q9, q10, q11, q12);
        List<Question> group4 = Arrays.asList(q13, q14, q15, q16);
        List<Question> group5 = Arrays.asList(q18, q19, q20, q21);
        List<Question> group6 = Arrays.asList(q22, q23, q15, q13);
        List<Question> group7 = Arrays.asList(q8, q20, q11, q9);
        topic1.setExercise(group1);
        topic2.setExercise(group2);
        topic3.setExercise(group3);
        topic4.setExercise(group4);
        topic5.setExercise(group5);
        topic6.setExercise(group6);
        topic7.setExercise(group7);
        return Arrays.asList(topic1, topic2, topic3, topic4, topic5, topic6, topic7);
    }

}
