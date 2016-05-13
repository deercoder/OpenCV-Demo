#include <jni.h>

JNIEXPORT jstring JNICALL
Java_deercoder_uml_com_opencvdemo_MainActivity_getMsgFromJni(JNIEnv *env, jobject instance) {

    // TODO


    return (*env)->NewStringUTF(env, "Hello From Jni");
}