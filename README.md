# OpenCV-Demo
Use Android Studio to build a Demo OpenCV project running on Android.

##Background
Use android studio to build an OpenCV application is hard, sometimes it requires many set up for environment.

This repo aims to build the baseline project for further extension. We can use it to build many useful OpenCV applications without worrying about the setup process.


## A complete guide
Ref:
http://stackoverflow.com/questions/17767557/how-to-use-opencv-in-android-studio-using-gradle-build-tool/27356635#27356635

We adopted the methods as follows:

```
As per OpenCV docs(1), below steps using OpenCV manager is the recommended way to use OpenCV for production runs. But, OpenCV manager(2) is an additional install from Google play store. So, if you prefer a self contained apk(not using OpenCV manager) or is currently in development/testing phase, I suggest answer at http://stackoverflow.com/a/27421494/1180117.

Recommended steps for using OpenCV in Android Studio with OpenCV manager.

Unzip OpenCV Android sdk downloaded from OpenCV.org(3)
From File -> Import Module, choose sdk/java folder in the unzipped opencv archive.
Update build.gradle under imported OpenCV module to update 4 fields to match your project's build.gradle a) compileSdkVersion b) buildToolsVersion c) minSdkVersion and 4) targetSdkVersion.
Add module dependency by Application -> Module Settings, and select the Dependencies tab. Click + icon at bottom(or right), choose Module Dependency and select the imported OpenCV module.
```


##Reference

There are many useful materials that we can refer to:


1. fix the `camera2` not found issue:
http://stackoverflow.com/questions/36204781/error-package-android-hardware-camera2-does-not-exist-opencv

2. fix the build process:
1) modify the minVersinosdk and compileVersionsdk:
2) add the dependance module: in File - Project structure - Dependance - App - xxx
