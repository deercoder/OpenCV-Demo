//
// Created by changliu on 5/12/16.
//

#include "OpenCVDemo.h"

#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_google_sample_helloandroidjni_MainActivity_getMsgFromJni(JNIEnv *env, jobject instance) {

    // TODO

    return (*env)->NewStringUTF(env, "Hello From Jni");
}