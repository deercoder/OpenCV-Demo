REFERENCE
====

1. OpenCV and watershed for android problem: 
http://stackoverflow.com/questions/19273161/watershed-in-opencv-android

2. Build problem:
http://stackoverflow.com/questions/17767557/how-to-use-opencv-in-android-studio-using-gradle-build-tool/27356635#27356635
http://www.sitepoint.com/using-c-and-c-code-in-an-android-app-with-the-ndk/
http://stackoverflow.com/questions/33855518/could-not-identify-launch-activity-default-activity-not-found


3. How to use NDK(or support JNI) in Android Studio:
     1) should install the ndk plugin(now by default android studio provide this option to download).
     2) However, still need to configure the `gradle`, otherwise there are strange errors even though we have get the correct `.c` and `.h` files as well as interface in `.java` files.
     3) In order to update gradle we need the newest android studio(v2.1), then follows some steps to configurate(upgrading to v2.1 requires ~2.1G downloads and stand-by installing as it takes too much resources)
https://codelabs.developers.google.com/codelabs/android-studio-jni/index.html?index=..%2F..%2Findex#2
