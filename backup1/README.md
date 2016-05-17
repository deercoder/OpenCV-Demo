README
=====

First ready version of **watershed** segmentation algorithm in Android.

##Android
OpenCV-3.10,
Android

##How to build
we manually select the OpenCV-3.10 sdk's java files, merge them into our project, and then modify the `build.gradle` of OpenCV-3.10

In this way, it's built as a module of our application.

Back to our app, we then add the dependance of `OpenCV-3.10`, so that our app depends on this module.

Build, fix the buggy issues of gradle, import, old sdk version, misc...

And one last buggy issue is the `No implementation found for long org.opencv.core.Mat.n_Mat()`, we can check the link [here](http://stackoverflow.com/questions/11939192/unsatisfied-link-error-opencv-for-android-non-native)
But I think the post is not complete, I also find the missing `libopencv_java3.so` problem, that caused the above no implementation problem, copy the file under `armabi-v7a` from the android sdk.

some nasty code format is for debugging and we destroy our original design and style(split class and clear commment), maybe later I will improve it.

Build, run, Enjoy!


-- Chang Liu
